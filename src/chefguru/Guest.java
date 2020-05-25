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
public class Guest {
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    DBConnection obj = DBConnection.getDb();
    
    private String id;
    private String name;
    private String address;
    private String email;
    private String phone;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void createGuest()
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call createGuestDetails(?,?,?,?,?)}");
            cs.setString("gId", getId());
            cs.setString("gName", getName());
            cs.setString("gAddress", getAddress());
            cs.setString("gEmail", getEmail());
            cs.setString("gPhone", getPhone());

            if(cs.executeUpdate()==1){
                new ErrorMsg().showErr("Record inserted successfully...");
            } else {
                new ErrorMsg().showErr("Record not inserted...");
            }
           
        } catch (SQLException e) {
            new ErrorMsg().showErr(e.getMessage());
        }

        conn = null;
    }
    
    public void updateGuest(String editGuestId)
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call updateGuestDetails(?,?,?,?,?)}");
            cs.setString("gId", editGuestId);
            cs.setString("gName", getName());
            cs.setString("gAddress", getAddress());
            cs.setString("gEmail", getEmail());
            cs.setString("gPhone", getPhone());

            if(cs.executeUpdate()==1){
                new ErrorMsg().showErr("Record updated successfully...");
            } else {
                new ErrorMsg().showErr("Record not updated...");
            }
           
        } catch (SQLException e) {
           new ErrorMsg().showErr(e.getMessage());
        }
       
        editGuestId = null;
        conn = null;
    }
}
