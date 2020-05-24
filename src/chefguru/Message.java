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
    
    private String id;
    private String email;
    private String heading;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendReplyEmail()
    {
        boolean status = false;
        
        //email sending part
        
        /*if(status){
            
            conn = obj.connect();
            
            try {
                cs = conn.prepareCall("{CALL updateMessageDetails(?)}");
                cs.setString("mId", getId());

            } catch (SQLException e) {
                new ErrorMsg().showErr(e.getMessage());
            }

            conn = null;
            
            new ErrorMsg().showErr("Email sent successfully...");
            
        } else {
            new ErrorMsg().showErr("Failed to send email...");
        }*/
    }
}
