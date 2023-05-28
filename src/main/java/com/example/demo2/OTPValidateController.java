package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OTPValidateController {

    @Autowired
    private OTPRepository otpRepository;

    @PostMapping("/validate_otp")
    public String validateOTP(@RequestParam("phone") String phone, @RequestParam("otp") String otp) {
        OTP storedOTP = otpRepository.findByPhone(phone);

        if (storedOTP != null && storedOTP.getOtp().equals(otp)) {
            // OTP is valid
            return "OTP validation successful";
        } else {
            // OTP is invalid
            return "OTP validation failed";
        }
    }
}

