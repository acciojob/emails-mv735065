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

          if(this.password.equals(oldPassword)){
              boolean num=false , smallLetter=false, bigLetter= false , length=false , special=false;
              if(newPassword.length()>=8) length=true;
              else return ;

              for(char ch : newPassword.toCharArray()){
                  if(ch>='a' && ch<='z') smallLetter=true;
                  if(ch>='A' && ch<='Z') bigLetter=true;
                  if(ch>='0' && ch<='9') num=true;
                  if(!Character.isLetterOrDigit(ch)) special=true;
              }

              if(num && smallLetter && bigLetter && length && special) {
                  this.password=newPassword;
              }

          }
          else return ;
    }




}
