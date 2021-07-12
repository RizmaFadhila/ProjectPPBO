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
public class penjualancontrol {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;

    public penjualancontrol() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toko", "root", "");
            st = (Statement) con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi database gagal" + e);
        }
    }
    public List CekBuku(String Nonota,String IdBuku){
        List logDetailBeli = new ArrayList();
        sql = "select no_nota,idbuku,hargajual,jumlahbeli,totalbayar from penjualan where no_nota='"+Nonota+"' and idbuku='"+IdBuku+"'";
         try{
            rs=st.executeQuery(sql);
            while(rs.next()){
            datapenjualan dp = new datapenjualan();
            dp.setIDBK(rs.getString("idbuku"));
            dp.setJudul(rs.getString("judul"));
            dp.setHargaJ(rs.getInt("hargajual"));
            dp.setJumlahB(rs.getInt("jumlahbeli"));
            dp.setTotalB(rs.getInt("totalbayar"));
            logDetailBeli.add(dp);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "terjadi kesalahan cek data" + e);
        }
        return logDetailBeli;
    }
    public int tambahpenjualan(datapenjualan a){
        sql= "insert into penjualan values('"+a.getNonota()+"','"+a.getIDBK()+"','"+a.getJudul()+"','"+a.getHargaJ()+"','"+a.getJumlahB()+"','"+a.getTotalB()+"')";
        int hasil =0;
        try{
            hasil=st.executeUpdate(sql);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "terjadi kesalahan pada: " + e);
        }
        return hasil;
    }
    public List CariBuku(String cari){
        List logCari= new ArrayList();
        sql = "select no_nota,idbuku,judul,hargajual,jumlahbeli,totalbayar from penjualan where no_nota like '%"+cari+"%' or idbuku like'%"+cari+"%'";
         try{
            rs=st.executeQuery(sql);
            while(rs.next()){
            datapenjualan dp = new datapenjualan();
            dp.setNonota(rs.getString("no_nota"));
            dp.setIDBK(rs.getString("idbuku"));
            dp.setHargaJ(rs.getInt("hargajual"));
            dp.setJumlahB(rs.getInt("jumlahbeli"));
            dp.setTotalB(rs.getInt("totalbayar"));
            logCari.add(dp);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "terjadi kesalahan cari data" + e);
        }
        return logCari;
    }
    }
