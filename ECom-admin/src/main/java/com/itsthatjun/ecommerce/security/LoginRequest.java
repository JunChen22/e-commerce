package com.itsthatjun.ecommerce.security;


public class LoginRequest {

    //@NotEmpty(message = "username can not be empty")
    String username;

    //@NotEmpty(message = "password can not be empty")
    String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
