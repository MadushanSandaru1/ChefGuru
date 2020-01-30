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
public class CheckIn {
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    DBConnection obj = DBConnection.getDb();
    
    private String transactionId;
    private String guestId;
    private String roomId;
    private String checkInDate;
    private String checkOutDate;
    private String noOfAdult;
    private String noOfChild;
    private String discountId;
    private String advance;
    private String totalPayment;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getNoOfAdult() {
        return noOfAdult;
    }

    public void setNoOfAdult(String noOfAdult) {
        this.noOfAdult = noOfAdult;
    }

    public String getNoOfChild() {
        return noOfChild;
    }

    public void setNoOfChild(String noOfChild) {
        this.noOfChild = noOfChild;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public String getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(String totalPayment) {
        this.totalPayment = totalPayment;
    }

    
    
    public void createCheckIn()
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call createCheckInDetails(?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("tId", getTransactionId());
            cs.setString("gId", getGuestId());
            cs.setString("rId", getRoomId());
            cs.setString("checkIn", getCheckInDate());
            cs.setString("checkOut", getCheckOutDate());
            cs.setString("adult", getNoOfAdult());
            cs.setString("child", getNoOfChild());
            cs.setString("dId", getDiscountId());
            cs.setString("advance", getAdvance());
            cs.setString("totalPayment", getTotalPayment());

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
    
    public void updateCheckIn(String editCheckInId)
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call updateCheckInDetails(?,?,?,?,?,?,?,?,?,?)}");
            cs.setString("tId", editCheckInId);
            cs.setString("gId", getGuestId());
            cs.setString("rId", getRoomId());
            cs.setString("checkIn", getCheckInDate());
            cs.setString("checkOut", getCheckOutDate());
            cs.setString("adult", getNoOfAdult());
            cs.setString("child", getNoOfChild());
            cs.setString("dId", getDiscountId());
            cs.setString("advance", getAdvance());
            cs.setString("totalPayment", getTotalPayment());

            if(cs.executeUpdate()==1){
                new ErrorMsg().showErr("Record updated successfully...");
            } else {
                new ErrorMsg().showErr("Record not updated...");
            }
           
        } catch (SQLException e) {
           new ErrorMsg().showErr(e.getMessage());
        }
       
        editCheckInId = null;
        conn = null;
    }
}
