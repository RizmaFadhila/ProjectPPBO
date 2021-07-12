/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokobuku;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LEGION5
 */
public class belicontrol {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;

    public belicontrol() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toko", "root", "");
            st = (Statement) con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal" + e);
        }
    }
    public List tampil(){
        List logBeli = new ArrayList();
        sql = "select no_nota,tanggal,nama,total,tunai,kembali from kasir order by id asc";
        try{
            rs=st.executeQuery(sql);
            while(rs.next()){
            databeli db = new databeli();
            db.setNota(rs.getString("no_nota"));
            db.setTgl(rs.getString("tanggal"));
            db.setPembeli(rs.getString("nama"));
            db.setTotal(rs.getInt("total"));
            db.setTunai(rs.getInt("tunai"));
            db.setKembali(rs.getInt("kembali"));
            logBeli.add(db);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "terjadi kesalahan tampil data" + e);
        }
        return logBeli;
    }
}
