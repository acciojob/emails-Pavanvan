package com.driver;

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
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        boolean l = false;
        boolean uC = false;
        boolean lC = false;
        boolean d = false;
        boolean sC = false;
        if(oldPassword.equals(getPassword())){
            if(newPassword.length()>=8) l=true;
            for(int i =0;i<newPassword.length();i++){
                if(Character.isUpperCase(newPassword.charAt(i))){
                    uC=true;
                    break;
                }
            }

            for(int i =0;i<newPassword.length();i++){
                if(Character.isLowerCase(newPassword.charAt(i))){
                    lC=true;
                    break;
                }
            }

            for(int i =0;i<newPassword.length();i++){
                if(Character.isDigit(newPassword.charAt(i))){
                    d=true;
                    break;
                }
            }

            for(int i =0;i<newPassword.length();i++){
                if(!Character.isLetter(newPassword.charAt(i)) && !Character.isDigit(newPassword.charAt(i))){
                    sC=true;
                    break;
                }
            }
            if(l==true && uC==true && lC==true && d==true && sC==true){
                this.password = newPassword;
            }
        }

    }
}