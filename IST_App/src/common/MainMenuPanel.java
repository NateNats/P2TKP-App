/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package common;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 *
 * @author Trustacean
 */
public class MainMenuPanel extends javax.swing.JPanel {
    private JPanel cards;
    private CardLayout cardLayout;

    /**
     * Creates new form MainMenu
     */
    public MainMenuPanel(JPanel cards, CardLayout cardsLayout) {
        this.cardLayout = cardsLayout;
        this.cards = cards;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        judulPanel = new javax.swing.JPanel();
        judul = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        insetContainer = new javax.swing.JPanel();
        istButton = new javax.swing.JButton();
        papiButton = new javax.swing.JButton();
        msdtButton = new javax.swing.JButton();
        pauliButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(915, 734));

        judulPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        judul.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setText("KATEGORISASI MAPPING");

        javax.swing.GroupLayout judulPanelLayout = new javax.swing.GroupLayout(judulPanel);
        judulPanel.setLayout(judulPanelLayout);
        judulPanelLayout.setHorizontalGroup(
            judulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                .addContainerGap())
        );
        judulPanelLayout.setVerticalGroup(
            judulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        container.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        insetContainer.setLayout(new java.awt.GridLayout(4, 0, 0, 40));

        istButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        istButton.setText("IST Mapping");
        istButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                istButtonActionPerformed(evt);
            }
        });
        insetContainer.add(istButton);

        papiButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        papiButton.setText("PAPI Mapping");
        papiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                papiButtonActionPerformed(evt);
            }
        });
        insetContainer.add(papiButton);

        msdtButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        msdtButton.setText("MSDT Mapping");
        msdtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msdtButtonActionPerformed(evt);
            }
        });
        insetContainer.add(msdtButton);

        pauliButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pauliButton.setText("PAULI Mapping");
        pauliButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauliButtonActionPerformed(evt);
            }
        });
        insetContainer.add(pauliButton);

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(insetContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(insetContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(judulPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void istButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton1ActionPerformed

    private void papiButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        cardLayout.show(cards, "PapiKostickForm");
    }// GEN-LAST:event_jButton2ActionPerformed

    private void msdtButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton3ActionPerformed

    private void pauliButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JPanel insetContainer;
    private javax.swing.JButton istButton;
    private javax.swing.JLabel judul;
    private javax.swing.JPanel judulPanel;
    private javax.swing.JButton msdtButton;
    private javax.swing.JButton papiButton;
    private javax.swing.JButton pauliButton;
    // End of variables declaration//GEN-END:variables
}
