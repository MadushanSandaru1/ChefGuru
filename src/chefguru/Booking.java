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
public class Booking {
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    DBConnection obj = DBConnection.getDb();
    
    private String id;
    private String name;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    public void checkingBooking()
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call cancelBookingDetails(?)}");
            cs.setString("bId", getId());

            if(cs.executeUpdate()>0){
                new ErrorMsg().showErr("Record updated successfully...");
            } else {
                new ErrorMsg().showErr("Record not updated...");
            }
           
        } catch (SQLException e) {
            new ErrorMsg().showErr(e.getMessage());
        }

        conn = null;
    }
    
    public void approveBooking()
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call approveBookingDetails(?)}");
            cs.setString("bId", getId());

            if(cs.executeUpdate()>0){
                try {
                    String emailContent = "Dear "+getName()+",<br><h3>Reservations approved</h3><br><p>Booking Id: <b>"+getId()+"</b><br><br>Your booking has been approved</p><br>Thank You!<br><br><pre>Administrator | ChefGuru Hotel,<br>Sri Sangharaja Piriwena Road,<br>Lower Kahattewela,<br>Bandarawela 90100,<br>Sri Lanka<br>Tel: +94 57 22 30 500<br>Email: mevangurusinghe2@gmail.com</pre>";
                    new emailSender.EmailSenderAPI().sendEmail(getEmail(), "ChefGuru | Bandarawela", emailContent);
                } catch (Exception e) {
                }
                new ErrorMsg().showErr("Record updated successfully...");
            } else {
                new ErrorMsg().showErr("Record not updated...");
            }
           
        } catch (SQLException e) {
            new ErrorMsg().showErr(e.getMessage());
        }

        conn = null;
    }
    
    public void cancelBooking()
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call cancelBookingDetails(?)}");
            cs.setString("bId", getId());

            if(cs.executeUpdate()>0){
                try {
                    String emailContent = "Dear "+getName()+",<br><h3>Reservations canceled</h3><br><p>Booking Id: <b>"+getId()+"</b><br><br>Your booking has been canceled</p><br>Thank You!<br><br><pre>Administrator | ChefGuru Hotel,<br>Sri Sangharaja Piriwena Road,<br>Lower Kahattewela,<br>Bandarawela 90100,<br>Sri Lanka<br>Tel: +94 57 22 30 500<br>Email: mevangurusinghe2@gmail.com</pre>";
                    new emailSender.EmailSenderAPI().sendEmail(getEmail(), "ChefGuru | Bandarawela", emailContent);
                } catch (Exception e) {
                }
                new ErrorMsg().showErr("Record updated successfully...");
            } else {
                new ErrorMsg().showErr("Record not updated...");
            }
           
        } catch (SQLException e) {
            new ErrorMsg().showErr(e.getMessage());
        }

        conn = null;
    }
}
