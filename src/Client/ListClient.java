package Client;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import Chambre.ListChambre;
import Main.Acceuil;
import Main.Connexion;
import Réservation.ListReservation;
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
public final class ListClient extends javax.swing.JFrame {

    /**
     * Creates new form ListClient
     */
    public ListClient() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        Afficher();
        id.setEnabled(false);
        chambre.setEnabled(false);
    }
    
    public void Afficher() {
        Connection cons = new Connexion().mysql();
        String[] tab = {"Id", "Nom", "Prenom", "Sexe", "Adresse", "Téléphone", "N°Chambre"};
        DefaultTableModel model = new DefaultTableModel(null, tab);
        final String sql = "select * from client";
        PreparedStatement pst;
        try {
            pst = cons.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tab[0] = rs.getString("id");
                tab[1] = rs.getString("nom");
                tab[2] = rs.getString("prenom");
                tab[3] = rs.getString("sexe");
                tab[4] = rs.getString("adresse");
                tab[5] = rs.getString("numero");
                tab[6] = rs.getString("numChambre");
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
        String[] tab = {"Id", "Nom", "Prenom", "Sexe", "Adresse", "Téléphone", "N°Chambre"};
        DefaultTableModel model = new DefaultTableModel(null, tab);
        final String sql = "select * from client where nom like'%"+nom+"%'";
        PreparedStatement pst;
        try {
            pst = cons.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tab[0] = rs.getString("id");
                tab[1] = rs.getString("nom");
                tab[2] = rs.getString("prenom");
                tab[3] = rs.getString("sexe");
                tab[4] = rs.getString("adresse");
                tab[5] = rs.getString("numero");
                tab[6] = rs.getString("numChambre");
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
        nom.setText("");
        prenom.setText("");
        sexe.setText("");
        adresse.setText("");
        numero.setText("");
        chambre.setText("");
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
        nom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        prenom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sexe = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        adresse = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        numero = new javax.swing.JTextField();
        chambre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        supprimer = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        annuler = new javax.swing.JButton();
        ajouter = new javax.swing.JButton();
        chambres = new javax.swing.JButton();
        reservation = new javax.swing.JButton();
        quitter = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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
        jLabel3.setText("Nom");

        nom.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Prenom");

        prenom.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Sexe");

        sexe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Adresse");

        adresse.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        adresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adresseActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Numéro");

        numero.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        chambre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("N°Chambre");

        supprimer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/icons8-unfriend-skin-type-7-48.png"))); // NOI18N
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        modifier.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/icons8-change-user-40.png"))); // NOI18N
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        annuler.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        annuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/icons8-undo-48.png"))); // NOI18N
        annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerActionPerformed(evt);
            }
        });

        ajouter.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ajouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/icons8-add-user-male-48.png"))); // NOI18N
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        chambres.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        chambres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/icons8-room-48.png"))); // NOI18N
        chambres.setText("Liste des Chambres");
        chambres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chambresActionPerformed(evt);
            }
        });

        reservation.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        reservation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/icons8-booking-50.png"))); // NOI18N
        reservation.setText("Liste des Réservations");
        reservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationActionPerformed(evt);
            }
        });

        quitter.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        quitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/icons8-exit-50.png"))); // NOI18N
        quitter.setText("Quitter");
        quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitterActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Liste des Clients");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Chambre/icons8-home-50.png"))); // NOI18N
        jButton1.setText("Acceuil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(recherche))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chambres)
                        .addGap(18, 18, 18)
                        .addComponent(reservation)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numero, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adresse, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sexe, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prenom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chambre)))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(modifier, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
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
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chambre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chambres, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adresseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adresseActionPerformed

    private void rechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercheKeyReleased
        // TODO add your handling code here:
        Recherche(recherche.getText());
    }//GEN-LAST:event_rechercheKeyReleased

    private void tableauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableauMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableau.getModel();
        int index = tableau.getSelectedRow();
        id.setText(model.getValueAt(index, 0).toString());
        nom.setText(model.getValueAt(index, 1).toString());
        prenom.setText(model.getValueAt(index, 2).toString());
        sexe.setText(model.getValueAt(index, 3).toString());
        adresse.setText(model.getValueAt(index, 4).toString());
        numero.setText(model.getValueAt(index, 5).toString());
        chambre.setText(model.getValueAt(index, 6).toString());
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
            JOptionPane.showMessageDialog(null, "Sélectionnez le client à modifier");
        } else {
            Connection cons = new Connexion().mysql();
            final String sql = "update client set nom = ?, prenom = ?, sexe = ?, adresse = ?, numero = ? where id = ? ";
            PreparedStatement pst;
            try {
                pst = cons.prepareStatement(sql);
                pst.setString(1, nom.getText());
                pst.setString(2, prenom.getText());
                pst.setString(3, sexe.getText());
                pst.setString(4, adresse.getText());
                pst.setString(5, numero.getText());
                pst.setString(6, id.getText());
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
            JOptionPane.showMessageDialog(null, "Sélectionnez le client à supprimer");
        } else {
            Connection cons = new Connexion().mysql();
            final String sql = "delete from client where id = ? ";
            PreparedStatement pst;
            try {
                pst = cons.prepareStatement(sql);
                pst.setString(1, id.getText());
                int rs = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment faire la suppression ?", "Suppression", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (rs == 0) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Suppression éffectuer avec succes");
                    AjoutClient clt = new AjoutClient();
                    clt.UpdateOui(Integer.parseInt(chambre.getText()));
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
    }//GEN-LAST:event_supprimerActionPerformed

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:
        AjoutClient aj = new AjoutClient();
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
        ListReservation aj = new ListReservation();
        aj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reservationActionPerformed

    private void quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitterActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Acceuil ac = new Acceuil();
        ac.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ListClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListClient().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresse;
    private javax.swing.JButton ajouter;
    private javax.swing.JButton annuler;
    private javax.swing.JTextField chambre;
    private javax.swing.JButton chambres;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField numero;
    private javax.swing.JTextField prenom;
    private javax.swing.JButton quitter;
    private javax.swing.JTextField recherche;
    private javax.swing.JButton reservation;
    private javax.swing.JTextField sexe;
    private javax.swing.JButton supprimer;
    private javax.swing.JTable tableau;
    // End of variables declaration//GEN-END:variables
}