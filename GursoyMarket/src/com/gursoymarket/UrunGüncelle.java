
package com.gursoymarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class UrunGüncelle extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    PreparedStatement prs;
    Statement st;
  
    String dbUrl = "jdbc:mysql://localhost:3306/stok_takip";

    public UrunGüncelle() {
        initComponents();
        ImageIcon icon = new ImageIcon("src/contract.png");
        this.setIconImage(icon.getImage());
        connection();
        tablo();
        this.setLocationRelativeTo(null);

    }

    public void connection() {
        try {
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(dbUrl, "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Veritabanı Bağlantısı Başarısız");
        }
    }

    public void tablo() {
        try {
            String sql = "select id as Id ,Urun_Adi as Urun_Adi,alis_fiyati as Alis_Fiyati,satis_fiyati as Satis_Fiyati,"
                    + "Urun_Turu as Urun_Turu,stok_miktari as Stok_Miktari, bolum as Bölüm from ürünler order by Urun_Turu asc";
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
        ürünGüncelle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        sorterText1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        güncelleId = new javax.swing.JLabel();
        güncelleStokMiktari = new javax.swing.JTextField();
        güncelleAlisFiyati = new javax.swing.JTextField();
        güncelleSatisFiyati = new javax.swing.JTextField();
        güncelleÜrünGrubu = new javax.swing.JTextField();
        güncelleÜrünAdi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bolum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ürün Güncelleme");
        setBackground(new java.awt.Color(153, 255, 153));
        setBounds(new java.awt.Rectangle(300, 100, 0, 0));
        setResizable(false);

        jLabel11.setBackground(new java.awt.Color(153, 255, 153));
        jLabel11.setText("ÜRÜN ADI");

        jLabel10.setBackground(new java.awt.Color(153, 255, 153));
        jLabel10.setText("ALIŞ FİYATI");

        jLabel9.setBackground(new java.awt.Color(153, 255, 153));
        jLabel9.setText("SATIŞ FİYATI");

        jLabel8.setBackground(new java.awt.Color(153, 255, 153));
        jLabel8.setText("ÜRÜN TÜRÜ");

        jLabel6.setBackground(new java.awt.Color(153, 255, 153));
        jLabel6.setText("STOK MİKTARI");

        ürünGüncelle.setBackground(new java.awt.Color(51, 0, 255));
        ürünGüncelle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/contract.png"))); // NOI18N
        ürünGüncelle.setText("ÜRÜN GÜNCELLE");
        ürünGüncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ürünGüncelleActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(153, 255, 153));

        tablo.setBackground(new java.awt.Color(255, 255, 204));
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

        jLabel13.setBackground(new java.awt.Color(153, 255, 153));
        jLabel13.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/magnifying-glass.png"))); // NOI18N

        jScrollPane19.setBackground(new java.awt.Color(153, 255, 153));

        sorterText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sorterText1KeyPressed(evt);
            }
        });
        jScrollPane19.setViewportView(sorterText1);

        jLabel1.setBackground(new java.awt.Color(153, 255, 153));
        jLabel1.setText("ID");

        güncelleId.setBackground(new java.awt.Color(153, 255, 153));
        güncelleId.setText("-");

        jLabel2.setText("BÖLÜM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ürünGüncelle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(güncelleSatisFiyati)
                    .addComponent(güncelleAlisFiyati)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(güncelleÜrünGrubu, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(güncelleStokMiktari, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(güncelleId)
                                    .addComponent(güncelleÜrünAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bolum, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(güncelleId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(güncelleÜrünAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(güncelleAlisFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(8, 8, 8)
                        .addComponent(güncelleSatisFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(güncelleÜrünGrubu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(güncelleStokMiktari, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bolum, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(ürünGüncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ürünGüncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ürünGüncelleActionPerformed

        try {
            String Adi=güncelleÜrünAdi.getText();
            String bölum=bolum.getText();
            int alisFiyati = Integer.valueOf(güncelleAlisFiyati.getText());
            int satisFiyati = Integer.valueOf(güncelleSatisFiyati.getText());
            String ürünGrubu = güncelleÜrünGrubu.getText();
            int ürünAdedi = Integer.valueOf(güncelleStokMiktari.getText());
            int id = Integer.valueOf(güncelleId.getText());
            String query = ("update ürünler set bolum='" + bölum + "',Urun_Adi='"+Adi+"',alis_fiyati='" + alisFiyati + "',satis_fiyati='" + satisFiyati
                    + "',stok_miktari='" + ürünAdedi + "',satis_fiyati='" + satisFiyati + "',Urun_Turu='" + ürünGrubu + "' where id='" + id + "'");

            st = (com.mysql.jdbc.Statement) con.createStatement();
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Kayıt Başarılı Bir Şekilde Güncellendi", "Kayıt Güncellendi", HEIGHT);

            güncelleId.setText("-");
            güncelleÜrünAdi.setText("");
            güncelleAlisFiyati.setText("");
            güncelleSatisFiyati.setText("");
            güncelleÜrünGrubu.setText("");
            güncelleStokMiktari.setText("");
            bolum.setText("");
            tablo();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Kayıt Güncellenemedi Bilgileri Kontrol Ediniz veya Listeden Yeniden Seçiniz", "Kayıt Güncellenemedi", HEIGHT);
        }
    }//GEN-LAST:event_ürünGüncelleActionPerformed

    private void tabloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabloMouseClicked
        try {
            int row = tablo.getSelectedRow();
            String tableClick = (tablo.getModel().getValueAt(row, 0).toString());
            String sqlString = "select * from ürünler where id='" + tableClick + "'  ";
            prs = con.prepareStatement(sqlString);
            rs = prs.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("Urun_Adi");
                güncelleÜrünAdi.setText(add1);
                String add2 = rs.getString("alis_fiyati");
                güncelleAlisFiyati.setText(add2);
                String add3 = rs.getString("satis_fiyati");
                güncelleSatisFiyati.setText(add3);
                String add4 = rs.getString("Urun_Turu");
                güncelleÜrünGrubu.setText(add4);
                String add5 = rs.getString("stok_miktari");
                güncelleStokMiktari.setText(add5);
                String add6 = rs.getString("id");
                güncelleId.setText(add6);
                String add7=rs.getString("bolum");
                bolum.setText(add7);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tabloMouseClicked

    private void sorterText1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sorterText1KeyPressed
        TableRowSorter<TableModel> sorter = new TableRowSorter<>((DefaultTableModel) tablo.getModel());
        sorter.setRowFilter(RowFilter.regexFilter(this.sorterText1.getText()));
        tablo.setRowSorter(sorter);
        tablo();
    }//GEN-LAST:event_sorterText1KeyPressed

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
            java.util.logging.Logger.getLogger(UrunGüncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UrunGüncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UrunGüncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UrunGüncelle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UrunGüncelle().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bolum;
    private javax.swing.JTextField güncelleAlisFiyati;
    private javax.swing.JLabel güncelleId;
    private javax.swing.JTextField güncelleSatisFiyati;
    private javax.swing.JTextField güncelleStokMiktari;
    private javax.swing.JTextField güncelleÜrünAdi;
    private javax.swing.JTextField güncelleÜrünGrubu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JTextPane sorterText1;
    private javax.swing.JTable tablo;
    public javax.swing.JButton ürünGüncelle;
    // End of variables declaration//GEN-END:variables
}
