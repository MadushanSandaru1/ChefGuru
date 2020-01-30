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
public class CheckOut {
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    DBConnection obj = DBConnection.getDb();
    
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }    
    
    public void checkOut()
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call checkOutDetails(?)}");
            cs.setString("tId", getTransactionId());

            if(cs.executeUpdate()==2){
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
