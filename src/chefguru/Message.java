/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chefguru;

import dbconnection.DBConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sanda
 */
public class Message {
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    DBConnection obj = DBConnection.getDb();
    
    private int id;
    private String email;
    private String heading;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendReplyEmail()
    {
        emailSender.EmailSenderAPI emailSenderAPI = new emailSender.EmailSenderAPI();
        
        try {
            String emaiContent = "<h3>"+getHeading()+"</h3><br>Dear Sir/Madam,<br><br><p>"+getMessage()+"</p><br>Thank You!<br><br><pre>ChefGuru Hotel,<br>Sri Sangharaja Piriwena Road,<br>Lower Kahattewela,<br>Bandarawela 90100,<br>Sri Lanka<br>Tel: +94 57 22 30 500<br>Email: mevangurusinghe2@gmail.com</pre>";
            emailSenderAPI.sendEmail(getEmail(), "ChefGuru | Bandarawela", emaiContent);
        } catch (Exception e) {
        }
        
        if(emailSenderAPI.email_status){
            
            conn = obj.connect();
            
            try {
                cs = conn.prepareCall("{CALL updateMessageDetails(?)}");
                cs.setInt("mId", getId());
                
                new ErrorMsg().showErr("Email sent successfully...");

            } catch (SQLException e) {
                new ErrorMsg().showErr(e.getMessage());
            }

            conn = null;
        } else {
            new ErrorMsg().showErr("Failed to send email...");
        }
    }
}
