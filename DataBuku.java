/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokobuku;

import koneksi.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEGION5
 */
public class DataBuku extends javax.swing.JFrame {
DefaultTableModel table = new DefaultTableModel();
    /**
     * Creates new form DataBuku
     */
    public DataBuku() {
        initComponents();
        koneksi conn = new koneksi();
        koneksi.configDB();
        
         tablebuku.setModel(table);
        table.addColumn("Kode Buku");
        table.addColumn("Judul");
        table.addColumn("Genre");
        table.addColumn("Penulis");
        table.addColumn("Harga");
        table.addColumn("Stok");
        
        tampilData();
    }
    private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = tablebuku.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        String query = "SELECT * FROM buku ";
        
        try{
            Connection connect = koneksi.configDB();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                   
                    String id = rslt.getString("id");
                    String judul = rslt.getString("judul");
                    String genre = rslt.getString("genre");
                    String penulis = rslt.getString("penulis");
                    String harga = rslt.getString("harga");
                    String stok = rslt.getString("stok");
                //masukan semua data kedalam array
                String[] data = {id,judul,genre,penulis,harga,stok};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tablebuku.setModel(table);
            
        }catch(Exception e){
            System.out.println(e);
        }
       
    }
    private void cari(){
        int row = tablebuku.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String cari = caribuku.getText();
        
        String query = "SELECT * FROM buku WHERE id  LIKE '%"+cari+"%' OR judul LIKE '%"+cari+"%' ";
                
       try{
           Connection connect = koneksi.configDB();//memanggil koneksi
           Statement sttmnt = connect.createStatement();//membuat statement
           ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
           
           while (rslt.next()){
                //menampung data sementara
                   
                    String id = rslt.getString("id");
                    String judul = rslt.getString("judul");
                    String genre = rslt.getString("genre");
                    String penulis = rslt.getString("penulis");
                    String harga = rslt.getString("harga");
                    String stok = rslt.getString("stok");
                //masukan semua data kedalam array
                String[] data = {id,judul,genre,penulis,harga,stok};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
                
            }
                //mengeset nilai yang ditampung agar muncul di table
                tablebuku.setModel(table);
           
        
    }catch(Exception e){
           System.out.println(e);
    }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        caribuku = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablebuku = new javax.swing.JTable();
        back = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        caribuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caribukuActionPerformed(evt);
            }
        });
        jPanel2.add(caribuku, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 430, 30));

        tablebuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablebuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablebukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablebuku);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 550, 140));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bs.png"))); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 90, -1));

        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel2.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 90, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/src.png"))); // NOI18N
        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 20, 80, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 590, 310));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATA BUKU SARI ANGGREK");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/b2.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 110, 100));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/B1 (2).png"))); // NOI18N
        jLabel4.setText("CARI");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 110, 100));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Sari Anggrek Jl. Jendral Sudirman Bukittinggi, Sumatra Barat");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 455, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Telp.(0752)223 37 ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 354, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void caribukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caribukuActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_caribukuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablebukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablebukuMouseClicked
        // TODO add your handling code here:
        int row = tablebuku.getSelectedRow();
        Kasir menu = new Kasir();
        
        
        String id = table.getValueAt(row, 0).toString();
        menu.buku.setText(id);
        
        String jdl = table.getValueAt(row, 1).toString();
        menu.judul.setText(jdl);
        
        String harga = table.getValueAt(row, 4).toString();
        menu.harga1.setText(harga);
        
        menu.setVisible(true);
        menu.pack();
        menu.setDefaultCloseOperation(Kasir.DISPOSE_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_tablebukuMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        tampilData();
    }//GEN-LAST:event_refreshActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        new Kasir().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTextField caribuku;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresh;
    private javax.swing.JTable tablebuku;
    // End of variables declaration//GEN-END:variables
}