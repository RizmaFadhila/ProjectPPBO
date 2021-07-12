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
import javax.swing.JTextField;

/**
 *
 * @author LEGION5
 */
public class bukucontrol {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;

    public bukucontrol() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toko", "root", "");
            st = (Statement) con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal" + e);
        }
    }
    public List tampil(){
        List logBuku = new ArrayList();
        sql = "select id,judul,genre,penulis,harga,stok from buku order by id asc";
        try{
            rs=st.executeQuery(sql);
            while(rs.next()){
            databuku bk = new databuku();
            bk.setId(rs.getString("id"));
            bk.setJDL(rs.getString("judul"));
            bk.setGenre(rs.getString("genre"));
            bk.setPenulis(rs.getString("penulis"));
            bk.setHarga(rs.getInt("harga"));
            bk.setStok(rs.getInt("stok"));
            logBuku.add(bk);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "terjadi kesalahan tampil data" + e);
        }
        return logBuku;
    }
    
    public List cariBuku(String key){
        List logBuku = new ArrayList();
        sql = "select id,judul,genre,penulis,harga,stok from buku where judul like'%"+key+
                "%' or penulis like '%"+key+"%' or id like '%"+key+"%'";
        try{    
            rs=st.executeQuery(sql);
            while(rs.next()){
            databuku db = new databuku();
            db.setId(rs.getString("id"));
            db.setJDL(rs.getString("judul"));
            db.setGenre(rs.getString("genre"));
            db.setPenulis(rs.getString("penulis"));
            db.setHarga(rs.getInt("harga"));
            db.setStok(rs.getInt("stok"));
            logBuku.add(db);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "terjadi kesalahan cari data" + e);
        }
        return logBuku;
    }
    public int updateStok(int stok, String idbuku){
        sql="update buku set stok='"+stok+"' where id='"+idbuku+"'";
        int hasil =0;
        try{
            hasil=st.executeUpdate(sql);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "terjadi kesalahan pada: " + e);
        }
        return hasil;
    }
}
