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
public class databeli {

    private String no_nota, tgl_beli, pembeli, judul;
    int total, tunai, kembali;

    public String getNota() {
        return no_nota;
    }

    public void setNota(String no_nota) {
        this.no_nota = no_nota;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTgl() {
        return tgl_beli;
    }

    public void setTgl(String t) {
        this.tgl_beli = t;
    }

    public String getPembeli() {
        return pembeli;
    }

    public void setPembeli(String p) {
        this.pembeli = p;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTunai() {
        return tunai;
    }

    public void setTunai(int tunai) {
        this.tunai = tunai;
    }

    public int getKembali() {
        return kembali;
    }

    public void setKembali(int k) {
        this.kembali = k;
    }
}
