/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sanda
 */
public class SingletonDBConnection {

    /**
     * @param args the command line arguments
     */
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public static void main(String[] args) {
        
        new SingletonDBConnection().viewData();
        
    }
    
    public void viewData(){
        try {
            DBConnection obj = DBConnection.getDb();
            conn = obj.connect();
            
            String sql = "SELECT * from student";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            System.out.println("Id\t\tName\t\tMaths\t\tScience\t\tHistory\t\tSum\t\tAvg\t\tGrade");
            
            while(rs.next()){
                System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getInt(4)+"\t\t"+rs.getInt(5)+"\t\t"+(rs.getInt(3)+rs.getInt(4)+rs.getInt(5))+"\t\t"+Math.round((rs.getInt(3)+rs.getInt(4)+rs.getInt(5))/3.0*100.0)/100.0+"\t\t"+grade((rs.getInt(3)+rs.getInt(4)+rs.getInt(5))/3));
            }
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public char grade(int marks){
        char grade = 0;
        
        if(marks <= 100 && marks >=75){
            grade = 'A';
        }
        else if(marks < 75 && marks >=55){
            grade = 'B';
        }
        else if(marks < 55 && marks >=35){
            grade = 'C';
        }
        else{
            grade = 'F';
        }
        
        return grade;
    }
    
}
