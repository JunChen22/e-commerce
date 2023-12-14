package com.itsthatjun.ecommerce;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static void main(String[] args) {
        System.out.println("This is a stand alone password encoder for if you want to insert password in database directly.");
        BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("not encoded password");
        System.out.println(encodedPassword);
    }
}