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
public class User {
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    DBConnection obj = DBConnection.getDb();
    
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String fName) {
        this.name = fName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void createUser()
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call createUserDetails(?,?,?,?,?)}");
            cs.setString("username", getId());
            cs.setString("uName", getName());
            cs.setString("email", getEmail());
            cs.setString("phone", getPhone());
            cs.setString("password", getPassword());
            
            if(cs.executeUpdate()>0){
                try {
                    String emailContent = "Dear "+getName()+",<br><h3>ChefGuru Account Username and Password</h3><br><p>Account Id: <b>"+getId()+"</b><br><br><b>"+getPassword()+"</b> is Your Chefguru Hotel Management System Password</p><br>Thank You!<br><br><pre>Administrator | ChefGuru Hotel,<br>Sri Sangharaja Piriwena Road,<br>Lower Kahattewela,<br>Bandarawela 90100,<br>Sri Lanka<br>Tel: +94 57 22 30 500<br>Email: mevangurusinghe2@gmail.com</pre>";
                    new emailSender.EmailSenderAPI().sendEmail(getEmail(), "ChefGuru | Bandarawela", emailContent);
                } catch (Exception e) {
                }
                new ErrorMsg().showErr("Record inserted successfully...");
            } else {
                new ErrorMsg().showErr("Record not inserted...");
            }
           
        } catch (SQLException e) {
            new ErrorMsg().showErr(e.getMessage());
        }

        conn = null;
    }
    
    public void updateUser(String editUserId)
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call updateUserDetails(?,?,?,?)}");
            cs.setString("username", editUserId);
            cs.setString("uName", getName());
            cs.setString("email", getEmail());
            cs.setString("phone", getPhone());
            //cs.setString("password", getPassword());

            if(cs.executeUpdate()>0){
                try {
                    String emailContent = "Dear "+getName()+",<br><h3>Updated Your ChefGuru Account Information</h3><br><p>Account Id: <b>"+editUserId+"</b><br>Name: <b>"+getName()+"</b><br>Email: <b>"+getEmail()+"</b><br>Phone No: <b>"+getPhone()+"</b><br><br></p><br>Thank You!<br><br><pre>Administrator | ChefGuru Hotel,<br>Sri Sangharaja Piriwena Road,<br>Lower Kahattewela,<br>Bandarawela 90100,<br>Sri Lanka<br>Tel: +94 57 22 30 500<br>Email: mevangurusinghe2@gmail.com</pre>";
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
       
        editUserId = null;
        conn = null;
    }
    
    public void changePassword(String editUserId)
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call changePassword(?,?)}");
            cs.setString("username", editUserId);
            cs.setString("password", getPassword());

            if(cs.executeUpdate()>0){
                try {
                    String emailContent = "Dear "+getName()+",<br><h3>New Password in ChefGuru Account</h3><br><p>Account Id: <b>"+editUserId+"</b><br><br><b>"+getPassword()+"</b> is Your Chefguru Hotel Management System New Password</p><br>Thank You!<br><br><pre>Administrator | ChefGuru Hotel,<br>Sri Sangharaja Piriwena Road,<br>Lower Kahattewela,<br>Bandarawela 90100,<br>Sri Lanka<br>Tel: +94 57 22 30 500<br>Email: mevangurusinghe2@gmail.com</pre>";
                    new emailSender.EmailSenderAPI().sendEmail(getEmail(), "ChefGuru | Bandarawela", emailContent);
                } catch (Exception e) {
                }
                new ErrorMsg().showErr("Password changed successfully...");
            } else {
                new ErrorMsg().showErr("Password not changed...");
            }
           
       } catch (SQLException e) {
           new ErrorMsg().showErr(e.getMessage());
       }
       
       conn = null;
    }
}
