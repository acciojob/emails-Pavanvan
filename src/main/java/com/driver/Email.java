package com.driver;

import java.util.regex.Pattern;

public class Email {
    private String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!oldPassword.equals(this.password)) {
            return;
        }

        // check if newPassword meets all the required conditions
        if (!Pattern.matches(".*[A-Z].*", newPassword) ||
                !Pattern.matches(".*[a-z].*", newPassword) ||
                !Pattern.matches(".*[0-9].*", newPassword) ||
                !Pattern.matches(".*[^A-Za-z0-9].*", newPassword) ||
                newPassword.length() < 8) {
            return;
        }

        this.password = newPassword;
    }
}
