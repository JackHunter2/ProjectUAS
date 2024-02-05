/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static Connection connectDB() throws SQLException{           
        Connection connect
            = DriverManager.getConnection("jdbc:mysql://localhost/register", "root", "");
        return connect; 
    }
}
