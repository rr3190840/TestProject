package com.example.demo2;


    import org.springframework.data.jpa.repository.JpaRepository;

    public interface OTPRepository extends JpaRepository<OTP, Long> {
        OTP findByPhone(String phone);
    }

