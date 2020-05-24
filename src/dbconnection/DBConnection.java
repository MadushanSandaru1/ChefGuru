/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sanda
 */
public class DBConnection {
    
    static Connection conn = null;
    
    //private static object
    private static DBConnection db = new DBConnection();
    
    //private constructor
    private DBConnection(){
        
    }
    
    //getter for private object
    public static DBConnection getDb() {
        return db;
    }
    
    //connection method
    public static Connection connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chefguru_new", "root", "");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
}
