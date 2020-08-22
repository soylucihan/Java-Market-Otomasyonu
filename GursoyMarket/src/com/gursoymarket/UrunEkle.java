
package com.gursoymarket;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class UrunEkle extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    PreparedStatement prs;
    Statement st;
    
    String dbUrl = "jdbc:mysql://localhost:3306/stok_takip";

    public UrunEkle() {
        initComponents();
        ImageIcon icon = new ImageIcon("src/plus.png");
        this.setIconImage(icon.getImage());
        connection();
        tablo();
        this.setLocationRelativeTo(null);

    }

    public void connection() {
        try {
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbUrl, "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Veritabanı BaÄŸlantısı Başarısız");
        }
    }

    public void tablo() {
        try {
            String sql = "select id as Id ,Urun_Adi as Urun_Adi,alis_fiyati as Alis_Fiyati,satis_fiyati as Satis_Fiyati,"
                    + "Urun_Turu as Urun_Turu,stok_miktari as Stok_Miktari from ürünler order by Urun_Turu asc";
            prs = con.prepareStatement(sql);
            rs = prs.executeQuery();
            tablo.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo = new javax.swing.JTable();
        ürünEkle = new javax.swing.JButton();
        ekleAlisFiyati = new javax.swing.JTextField();
        ekleÜrünAdi = new javax.swing.JTextField();
        ekleSatisFiyati = new javax.swing.JTextField();
        ekleStokMiktari = new javax.swing.JTextField();
        ekleÜrünGrubu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bolum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ürün Ekleme");
        setBackground(new java.awt.Color(255, 204, 204));
        setBounds(new java.awt.Rectangle(300, 100, 0, 0));
        setResizable(false);

        jLabel11.setBackground(new java.awt.Color(255, 204, 204));
        jLabel11.setText("ÜRÜN ADI");

        jLabel10.setBackground(new java.awt.Color(255, 204, 204));
        jLabel10.setText("ALIŞ FİYATI");

        jLabel9.setBackground(new java.awt.Color(255, 204, 204));
        jLabel9.setText("SATIŞ FİYATI");

        jLabel8.setBackground(new java.awt.Color(255, 204, 204));
        jLabel8.setText("ÜRÜN TÜRÜ");

        jLabel6.setBackground(new java.awt.Color(255, 204, 204));
        jLabel6.setText("STOK MİKTARI");

        jScrollPane1.setBackground(new java.awt.Color(102, 255, 204));

        tablo.setBackground(new java.awt.Color(102, 255, 204));
        tablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabloMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablo);

        ürünEkle.setBackground(new java.awt.Color(51, 51, 255));
        ürünEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/plus.png"))); // NOI18N
        ürünEkle.setText("ÜRÜN EKLE");
        ürünEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ürünEkleActionPerformed(evt);
            }
        });

        jLabel1.setText("BÃ–LÜM-->>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(ekleÜrünGrubu, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ekleStokMiktari, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bolum, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addComponent(ürünEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ekleAlisFiyati)
                    .addComponent(ekleÜrünAdi)
                    .addComponent(ekleSatisFiyati))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ekleÜrünAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ekleAlisFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel9)
                        .addGap(11, 11, 11)
                        .addComponent(ekleSatisFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ekleÜrünGrubu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ekleStokMiktari, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ürünEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabloMouseClicked
        try {
            int row = tablo.getSelectedRow();
            String tableClick = (tablo.getModel().getValueAt(row, 0).toString());
            String sqlString = "select * from ürünler where id='" + tableClick + "'  ";
            prs = con.prepareStatement(sqlString);
            rs = prs.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("Urun_Adi");
                ekleÜrünAdi.setText(add1);
                String add2 = rs.getString("alis_fiyati");
                ekleAlisFiyati.setText(add2);
                String add3 = rs.getString("satis_fiyati");
                ekleSatisFiyati.setText(add3);
                String add4 = rs.getString("Urun_Turu");
                ekleÜrünGrubu.setText(add4);
                String add5 = rs.getString("stok_miktari");
                ekleStokMiktari.setText(add5);
                String add6=rs.getString("bolum");
                bolum.setText(add6);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tabloMouseClicked

    private void ürünEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ürünEkleActionPerformed
        try {
            String ürünAdi = ekleÜrünAdi.getText();
            String alisFiyati = ekleAlisFiyati.getText();
            int satisFiyati = Integer.valueOf(ekleSatisFiyati.getText());
            String ürünGrubu = ekleÜrünGrubu.getText();
            int stokMiktari = Integer.valueOf(ekleStokMiktari.getText());
            String Bolum=bolum.getText();

            String query = ("insert into ürünler(Urun_Adi,alis_fiyati,satis_fiyati,Urun_Turu,stok_miktari,bolum) "
                    + "values('" + ürünAdi + "','" + alisFiyati + "','" + satisFiyati + "','" + ürünGrubu + "','" + stokMiktari + "','" + Bolum + "')");

            st = (com.mysql.jdbc.Statement) con.createStatement();
            st.executeUpdate(query);

            ekleAlisFiyati.setText("");
            ekleAlisFiyati.setText("");
            ekleSatisFiyati.setText("");
            ekleÜrünGrubu.setText("");
            ekleStokMiktari.setText("");
            JOptionPane.showMessageDialog(null, "ÜRÜN Başarılı Bir Şekilde Eklendi", "ÜRÜN Eklendi", HEIGHT);
            tablo();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ÜRÜN Eklenemedi Lütfen ÜRÜN Bilgilerini Kontrol Ediniz", "ÜRÜN Ekleme Başarısız", HEIGHT);
        }
    }//GEN-LAST:event_ürünEkleActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(UrunEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrunEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrunEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrunEkle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UrunEkle().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bolum;
    private javax.swing.JTextField ekleAlisFiyati;
    private javax.swing.JTextField ekleSatisFiyati;
    private javax.swing.JTextField ekleStokMiktari;
    private javax.swing.JTextField ekleÜrünAdi;
    private javax.swing.JTextField ekleÜrünGrubu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablo;
    private javax.swing.JButton ürünEkle;
    // End of variables declaration//GEN-END:variables
}
