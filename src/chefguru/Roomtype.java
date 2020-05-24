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
public class Roomtype {
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    
    DBConnection obj = DBConnection.getDb();
    
    private String Id;
    private String roomType;
    private String description;
    private String rate;
    private String image;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public void createRoomType()
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{CALL createRoomTypeDetails(?,?,?,?,?)}");
            cs.setString("rId", getId());
            cs.setString("rType", getRoomType());
            cs.setString("rDescription", getDescription());
            cs.setString("rRate", getRate());
            cs.setString("rImage", getImage());

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
    
    public void updateRoomType(String editRoomTypeId)
    {
       
        conn = obj.connect();
            
        try {
            cs = conn.prepareCall("{CALL updateRoomTypeDetails(?,?,?,?)}");
            cs.setString("rId", editRoomTypeId);
            cs.setString("rType", getRoomType());
            cs.setString("rDescription", getDescription());
            cs.setString("rRate", getRate());

            if(cs.executeUpdate()==1){
                new ErrorMsg().showErr("Record updated successfully...");
            } else {
                new ErrorMsg().showErr("Record not updated...");
            }
           
        } catch (SQLException e) {
            new ErrorMsg().showErr(e.getMessage());
        }

        editRoomTypeId = null;
        conn = null;
    }
}
