package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAOConnection {
    
    public Connection BDConnection(){
        
        Connection conn = null;
        
        try {
            
            String url = "jdbc:mysql://localhost:3306/javadb?user=root&password=123456";
            conn = DriverManager.getConnection(url);
        
        } catch (SQLException e) {
        
            JOptionPane.showMessageDialog(null, "DAO:" + e.getMessage());
        
        }
        
       return conn;
    }
    
}
