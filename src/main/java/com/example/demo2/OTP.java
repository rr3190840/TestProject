package com.example.demo2;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OTP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    private String otp;

    // constructors
    public OTP(Long id, String phone, String otp) {
        this.id = id;
        this.phone = phone;
        this.otp = otp;
    }

    // getters and setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getOtp() {
        return otp;
    }



}

