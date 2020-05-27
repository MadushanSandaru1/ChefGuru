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
import reports_format.Checkin_Invoice;

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
    
    private String id;
    private String guestId;
    private String roomId;
    private String checkInDate;
    private String checkOutDate;
    private String discountId;
    private String advancePayment;

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
     * @return the guestId
     */
    public String getGuestId() {
        return guestId;
    }

    /**
     * @param guestId the guestId to set
     */
    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    /**
     * @return the roomId
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
     * @return the checkInDate
     */
    public String getCheckInDate() {
        return checkInDate;
    }

    /**
     * @param checkInDate the checkInDate to set
     */
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * @return the checkOutDate
     */
    public String getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * @param checkOutDate the checkOutDate to set
     */
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * @return the discountId
     */
    public String getDiscountId() {
        return discountId;
    }

    /**
     * @param discountId the discountId to set
     */
    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    /**
     * @return the advancePayment
     */
    public String getAdvancePayment() {
        return advancePayment;
    }

    /**
     * @param advancePayment the advancePayment to set
     */
    public void setAdvancePayment(String advancePayment) {
        this.advancePayment = advancePayment;
    }
    
    public void createCheckIn()
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{call createCheckInDetails(?,?,?,?,?,?,?)}");
            cs.setString("tId", getId());
            cs.setString("gId", getGuestId());
            cs.setString("rId", getRoomId());
            cs.setString("checkinDate", getCheckInDate());
            cs.setString("checkoutDate", getCheckOutDate());
            cs.setString("dId", getDiscountId());
            cs.setString("advancePayment", getAdvancePayment());
            
            if(cs.executeUpdate()==3){
                new ErrorMsg().showErr("Record inserted successfully...");
                
                Checkin_Invoice checkin_Invoice = new Checkin_Invoice(getRoomId(), getCheckOutDate(), getAdvancePayment());
                checkin_Invoice.setVisible(true);
            } else {
                new ErrorMsg().showErr("Record not inserted...");
            }
           
        } catch (SQLException e) {
            new ErrorMsg().showErr(e.getMessage());
        }

        conn = null;
    }
    
}
