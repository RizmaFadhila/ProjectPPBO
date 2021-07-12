/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokobuku;

/**
 *
 * @author LEGION5
 */
public class datapenjualan {
    public String nomor_nota,idBuku,judul;
    int jumlahB,totalB;
    int hargaJ;
    
    public String getNonota(){
        return nomor_nota;
    }
    public void setNonota(String n){
        this.nomor_nota = n;
    }
    public String getIDBK(){
        return idBuku;
    }
    public void setIDBK(String b){
        this.idBuku = b;
    }
    public String getJudul(){
        return judul;
    }
    public void setJudul(String j){
        this.judul = j;
    }
    public int getHargaJ(){
        return hargaJ;
    }
    public void setHargaJ(int h){
        this.hargaJ = h;
    }
    public int getJumlahB(){
        return jumlahB;
    }
    public void setJumlahB(int jb){
        this.jumlahB = jb;
    }
    public int getTotalB(){
        return totalB;
    }
    public void setTotalB(int tb){
        this.totalB = tb;
    }
}
