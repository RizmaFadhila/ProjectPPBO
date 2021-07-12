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
public class databuku {
    private String id, judul,genre,penulis;
    private int harga;
    private int stok;
    
    public void setId(String id) {
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setPenulis(String p) {
        this.penulis = p;
    }
    public String getPenulis(){
        return penulis;
    }
    public void setJDL(String j) {
        this.judul =j;
    }
    public String getJDL(){
        return judul;
    }
    public void setGenre(String g) {
        this.genre = g;
    }
    public String getGenre(){
        return genre;
    }
    public void setHarga(int h) {
        this.harga = h;
    }
    public int getHarga(){
        return harga;
    }
    public void setStok(int s) {
        this.stok = s;
    }
    public int getStok(){
        return stok;
    }
}
