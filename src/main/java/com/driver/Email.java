package com.driver;

import java.sql.SQLOutput;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        if(password==oldPassword){
            int len = newPassword.length();
            if(len>=8){
                boolean upperCase = false;
                boolean lowerCase = false;
                boolean digit = false;
                boolean splchar = false;

                for(int i = 0 ; i < len ; i++){
                    char c = newPassword.charAt(i);

                    if(c>='a' && c<='z') lowerCase=true;
                    else if(c>='A' && c<='Z') upperCase=true;
                    else if(c>='0' && c<='9') digit=true;
                    else splchar=true;
                }


                if(lowerCase==true && upperCase==true && digit==true && splchar==true){
                    this.password=newPassword;
                }
            }
        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }
}