package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OTPSendController {

    @Autowired
    private OTPRepository otpRepository;

    private static final String ACCOUNT_SID = "your_account_sid";
    private static final String AUTH_TOKEN = "your_auth_token";


    @PostMapping("/send_otp")
    public String sendOTP(@RequestBody OTP otp) {
        // Generate a random OTP

        String generatedOTP = generateOTP();

        // Save the OTP in the database
        otp.setOtp(generatedOTP);
        otpRepository.save(otp);


        // Code to send the OTP to the specified phone number (e.g., via SMS, email, etc.)
        sendOTPToPhoneNumber(otp.getPhone(), generatedOTP);

        return "OTP sent successfully";
    }

    private String generateOTP() {
        // Generate a 6-digit OTP
        return String.format("%06d", (int) (Math.random() * 999999));
    }

    private void sendOTPToPhoneNumber(String phoneNumber, String otp) {

        try {
            // Send the OTP message using Twilio
            Message message = Message.creator(
                            new PhoneNumber(phoneNumber),
                            "Your OTP is: " + otp)
                    .create();

            System.out.println("OTP sent successfully! SID: " + message.getSid());
        } catch (Exception e) {
            System.err.println("Error sending OTP: " + e.getMessage());
        }
    }
}

