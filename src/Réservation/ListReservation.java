package Réservation;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import Client.*;
import Chambre.ListChambre;
import Main.Acceuil;
import Main.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Imrana
 */
public final class ListReservation extends javax.swing.JFrame {

    /**
     * Creates new form ListClient
     */
    public ListReservation() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        Afficher();
        id.setEnabled(false);
    }
    
    public void Afficher() {
        Connection cons = new Connexion().mysql();
        String[] tab = {"Id", "Date d'arrivée", "Date de depart", "Numéro client"};
        DefaultTableModel model = new DefaultTableModel(null, tab);
        final String sql = "select * from reservation";
        PreparedStatement pst;
        try {
            pst = cons.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tab[0] = rs.getString("id");
                tab[1] = rs.getString("dateA");
                tab[2] = rs.getString("dateD");
                tab[3] = rs.getString("numclient");
                model.addRow(tab);
            }
            tableau.setModel(model);
            cons.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null," "+err.getMessage() , "Message d'erreur ", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void Recherche(String nom) {
        Connection cons = new Connexion().mysql();
        String[] tab = {"Id", "Date d'arrivée", "Date de depart", "Numéro client"};
        DefaultTableModel model = new DefaultTableModel(null, tab);
        final String sql = "select * from reservation where numclient like'%"+nom+"%'";
        PreparedStatement pst;
        try {
            pst = cons.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tab[0] = rs.getString("id");
                tab[1] = rs.getString("dateA");
                tab[2] = rs.getString("dateD");
                tab[3] = rs.getString("numclient");
                model.addRow(tab);
            }
            tableau.setModel(model);
            cons.close();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null," "+err.getMessage() , "Message d'erreur ", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public void Annuler() {
        id.setText("");
        dateA.setText("");
        dateP.setText("");
        numclient.setText("");
    }
    
    public void Sup(String num) {
       Connection cons = new Connexion().mysql();
            final String sql = "delete from reservation where numClient = ? ";
            PreparedStatement pst;
            try {
                pst = cons.prepareStatement(sql);
                pst.setString(1, num);
                int rs = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment faire la suppression ?", "Suppression", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (rs == 0) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Suppression éffectuer avec succes");
                    AjoutClient clt = new AjoutClient();
                    Afficher();
                    Annuler();
                    //this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Suppression annulée");
                }
                cons.close();
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null," "+err.getMessage() , "Message d'erreur ", JOptionPane.ERROR_MESSAGE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        recherche = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateA = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dateP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        numclient = new javax.swing.JTextField();
        supprimer = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        annuler = new javax.swing.JButton();
        ajouter = new javax.swing.JButton();
        chambres = new javax.swing.JButton();
        reservation = new javax.swing.JButton();
        quitter = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        tableau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableauMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableau);

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  Recherche");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        recherche.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rechercheActionPerformed(evt);
            }
        });
        recherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rechercheKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Id");

        id.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Date d'arrivée");

        dateA.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Date de depart");

        dateP.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Numéro client");

        numclient.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        supprimer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Réservation/icons8-unfriend-skin-type-7-48.png"))); // NOI18N
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        modifier.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Réservation/icons8-change-user-40.png"))); // NOI18N
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        annuler.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        annuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Réservation/icons8-undo-48.png"))); // NOI18N
        annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerActionPerformed(evt);
            }
        });

        ajouter.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ajouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Réservation/icons8-add-user-male-48.png"))); // NOI18N
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        chambres.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        chambres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Réservation/icons8-room-48.png"))); // NOI18N
        chambres.setText("Liste des Chambres");
        chambres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chambresActionPerformed(evt);
            }
        });

        reservation.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        reservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Réservation/icons8-client-48.png"))); // NOI18N
        reservation.setText("Liste des Clients");
        reservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationActionPerformed(evt);
            }
        });

        quitter.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Réservation/icons8-exit-50.png"))); // NOI18N
        quitter.setText("Quitter");
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Liste des Réservations");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Réservation/icons8-visa-stamp-48.png"))); // NOI18N
        jButton1.setText("Valider");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Réservation/icons8-home-50.png"))); // NOI18N
        jButton4.setText("Acceuil");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(recherche))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ajouter)
                        .addGap(18, 18, 18)
                        .addComponent(chambres)
                        .addGap(18, 18, 18)
                        .addComponent(reservation)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dateA, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateP, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                        .addComponent(annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(numclient)
                                    .addComponent(id))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(recherche)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numclient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(annuler, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chambres, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercheKeyReleased
        // TODO add your handling code here:
        Recherche(recherche.getText());
    }//GEN-LAST:event_rechercheKeyReleased

    private void tableauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableauMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableau.getModel();
        int index = tableau.getSelectedRow();
        id.setText(model.getValueAt(index, 0).toString());
        dateA.setText(model.getValueAt(index, 1).toString());
        dateP.setText(model.getValueAt(index, 2).toString());
        numclient.setText(model.getValueAt(index, 3).toString());
    }//GEN-LAST:event_tableauMouseClicked

    private void rechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rechercheActionPerformed

    private void annulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerActionPerformed
        // TODO add your handling code here:
        Annuler();
    }//GEN-LAST:event_annulerActionPerformed

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
        // TODO add your handling code here:
        if (id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sélectionnez la réservation à modifier");
        } else {
            Connection cons = new Connexion().mysql();
            final String sql = "update reservation set dateA = ?, dateD = ?, numClient = ? where id = ? ";
            PreparedStatement pst;
            try {
                pst = cons.prepareStatement(sql);
                pst.setString(1, dateA.getText());
                pst.setString(2, dateP.getText());
                pst.setString(3, numclient.getText());
                pst.setString(4, id.getText());
                int rs = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment faire la modification ?", "Modification", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (rs == 0) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Modification éffectuer avec succes");
                    Afficher();
                    //this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Modification annulée");
                }
                cons.close();
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null," "+err.getMessage() , "Message d'erreur ", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_modifierActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed
        // TODO add your handling code here:
        if (id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sélectionnez la réservation à supprimer");
        } else {
            Sup(numclient.getText());
        }
    }//GEN-LAST:event_supprimerActionPerformed

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:
        AjoutReservation aj = new AjoutReservation();
        aj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ajouterActionPerformed

    private void chambresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chambresActionPerformed
        // TODO add your handling code here:
        ListChambre aj = new ListChambre();
        aj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_chambresActionPerformed

    private void reservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationActionPerformed
        // TODO add your handling code here:
        ListClient aj = new ListClient();
        aj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reservationActionPerformed

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sélectionnez la réservation à valider");
        } else {
            AjoutClient aj = new AjoutClient();
            aj.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Acceuil ac = new Acceuil();
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListReservation().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouter;
    private javax.swing.JButton annuler;
    private javax.swing.JButton chambres;
    private javax.swing.JTextField dateA;
    private javax.swing.JTextField dateP;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField numclient;
    private javax.swing.JButton quitter;
    private javax.swing.JTextField recherche;
    private javax.swing.JButton reservation;
    private javax.swing.JButton supprimer;
    private javax.swing.JTable tableau;
    // End of variables declaration//GEN-END:variables
}
