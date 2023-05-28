# TestProject
SpringProject using rest
Please make sure you have the necessary dependencies and configurations for Oracle database connectivity in your Spring Boot project.

Here's a step-by-step guide to creating the OTP send and validate APIs with Oracle database support:

Step 1: Set Up the Project
Created a new Spring Boot project using your preferred IDE or the Spring Initializr (https://start.spring.io/). Included the following dependencies:
Spring Web
Spring Data JPA
Oracle Database Driver (e.g., ojdbc8 or ojdbc14)
Step 2: Configured the Database
In the application.properties file, configured the Oracle database connection properties. 
Step 3: Defined the OTP Entity
Created a new Java class called OTP to represent the OTP entity.
Step 4: Created the Repository
Created a new Java interface called OTPRepository that extends JpaRepository<OTP, Long>. This interface will provide database operations for the OTP entity.
Step 5: Implemented the OTP Send API
Created a new Java class called OTPSendController to handle the OTP send API. 
Step 6: Implemented the OTP Validate API
Created a new Java class called OTPValidateController to handle the OTP validation API.
Step 7: Implemented the User Profile API
Created a new Java class called UserProfileController to handle the user profile API.
Step 8: Implemented JWT Authentication and Authorization
Created a new Java class called JwtTokenUtil to handle JWT token generation, validation, and parsing.
Step 9: Implemented UserDetailsService
Created a new Java class called JwtUserDetailsService to implement the Spring Security UserDetailsService interface. This class will be responsible for loading user details from the database. Add the following code:
Step 10: Implemented Security Configuration
Created a new Java class called SecurityConfig to configure Spring Security.
Step 11: Implemented JWT Authentication Controller
Created a new Java class called JwtAuthenticationController to handle the authentication API.
Step 12: Run the Application
Finally, run the Spring Boot application. used tools like Maven or Gradle to build and run the application. Make sure to have an Oracle database server running and provide the correct database connection details in the application.properties file.

Now, we can test the following APIs using a REST client or tools like Postman:

POST /api/send_otp - Send an OTP to a phone number. Pass the phone number in the request body as JSON.
POST /api/validate_otp?phone={phone}&otp={otp} - Validate an OTP for a phone number. Pass the phone number and OTP as query parameters.
POST /api/authenticate - Authenticate a user and obtain a JWT token. Pass the username and password in the request body as JSON.
GET /api/profile - Retrieve the user profile. Include the JWT token in the request headers as Authorization: Bearer {token}.
Remember to include the JWT token in the request headers for the authenticated APIs.

That's it! we have successfully developed the OTP send API, OTP validate API, user profile API, and implemented JWT token-based session and API authorization using Spring Boot with Oracle database support.
That's it! we now have the OTP send API (OTPSendController) and the OTP validate API (OTPValidateController) using Spring Boot with Oracle database support.
