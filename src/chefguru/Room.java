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
public class Room {
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    DBConnection obj = DBConnection.getDb();
    
    private String roomId;
    private String roomType;
    private String roomRate;
    private String roomOccupancy;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(String roomRate) {
        this.roomRate = roomRate;
    }

    public String getRoomOccupancy() {
        return roomOccupancy;
    }

    public void setRoomOccupancy(String roomOccupancy) {
        this.roomOccupancy = roomOccupancy;
    }
    
    public void createRoom()
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{CALL createRoomDetails(?,?,?,?)}");
            cs.setString("rId", getRoomId());
            cs.setString("rType", getRoomType());
            cs.setString("rRate", getRoomRate());
            cs.setString("rOccupancy", getRoomOccupancy());

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
    
    public void updateRoom(String editRoomId)
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{CALL updateRoomDetails(?,?,?,?)}");
            cs.setString("rId", editRoomId);
            cs.setString("rType", getRoomType());
            cs.setString("rRate", getRoomRate());
            cs.setString("rOccupancy", getRoomOccupancy());

            if(cs.executeUpdate()==1){
                new ErrorMsg().showErr("Record updated successfully...");
            } else {
                new ErrorMsg().showErr("Record not updated...");
            }
           
        } catch (SQLException e) {
            new ErrorMsg().showErr(e.getMessage());
        }

        editRoomId = null;
        conn = null;
    }
}
