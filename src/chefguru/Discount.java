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
public class Discount {
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    DBConnection obj = DBConnection.getDb();
    
    private String id;
    private String type;
    private String rate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
    
    public void createDiscount()
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call createDiscountDetails(?,?,?)}");
            cs.setString("dId", getId());
            cs.setString("dType", getType());
            cs.setString("dRate", getRate());

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
    
    public void updateDiscount(String editUserId)
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call updateDiscountDetails(?,?,?)}");
            cs.setString("dId", getId());
            cs.setString("dType", getType());
            cs.setString("dRate", getRate());

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
}
