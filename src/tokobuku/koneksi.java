/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokobuku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class koneksi {
    private static Connection MySQLConfig;
    public static Connection configDB()throws SQLException{
        try{
            String url="jdbc:mysql://localhost:3306/toko";
            String user="root";
            String pass="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLConfig=DriverManager.getConnection(url, user, pass);
            
        }catch (SQLException e){
           JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        }
        return MySQLConfig;
    }
}
