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
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

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
    private String fName;
    private String lName;
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
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
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
            cs = conn.prepareCall("{call createUserDetails(?,?,?,?,?,?)}");
            cs.setString("username", getId());
            cs.setString("fName", getfName());
            cs.setString("lName", getlName());
            cs.setString("email", getEmail());
            cs.setString("phone", getPhone());
            cs.setString("password", getPassword());

            if(cs.executeUpdate()==2){
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
            cs = conn.prepareCall("{call updateUserDetails(?,?,?,?,?)}");
            cs.setString("username", getId());
            cs.setString("fName", getfName());
            cs.setString("lName", getlName());
            cs.setString("email", getEmail());
            cs.setString("phone", getPhone());
            //cs.setString("password", getPassword());

            if(cs.executeUpdate()==1){
                new ErrorMsg().showErr("Record updated successfully...");
            } else {
                new ErrorMsg().showErr("Record not updated...");
            }
           
       } catch (SQLException e) {
           new ErrorMsg().showErr(e.getMessage());
       }
       
       conn = null;
    }
    
    public void changePassword(String editUserId)
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call changePassword(?,?)}");
            cs.setString("username", editUserId);
            cs.setString("password", getPassword());

            if(cs.executeUpdate()==1){
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
