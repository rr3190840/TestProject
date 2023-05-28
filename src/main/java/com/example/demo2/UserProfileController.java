package com.example.demo2;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class UserProfileController {

    @GetMapping("/profile")
    public String getUserProfile() {
        // Fetch the user profile based on the authenticated user
        // You can retrieve the authenticated user details from the security context
        // Retrieve the authentication object from the security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            // Retrieve the principal object which contains the authenticated user details
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                // The principal object is an instance of UserDetails, which represents the authenticated user
                String username =  (UserDetails) principal;
            }
        }
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish a database connection
            connection = DriverManager.getConnection("jdbc:oracle:thin:@hostname:port/service_name", "username", "password");

            // Prepare the SQL statement
            String sql = "SELECT * FROM user_profile WHERE username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            // Execute the query
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the user profile data from the result set
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                // Retrieve other profile attributes as needed

                // Create and return the user profile object
                UserProfile userProfile =  new UserProfile(username, name, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Return the user profile as a JSON response
        return userProfile.toString();
    }
}
