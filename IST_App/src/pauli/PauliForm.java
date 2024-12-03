/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pauli;

import java.awt.CardLayout;

import javax.swing.JPanel;

import pauli.resource.PauliResource;

/**
 *
 * @author Trustacean
 */
public class PauliForm extends javax.swing.JPanel {
    private JPanel cards;
    private CardLayout cardLayout;

    /**
     * Creates new form PauliForm
     */
    public PauliForm(JPanel cards, CardLayout cardLayout) {
        this.cards = cards;
        this.cardLayout = cardLayout;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        judulPanel = new javax.swing.JPanel();
        judul = new javax.swing.JLabel();
        masukanPanel = new javax.swing.JPanel();
        tingkatPercayaDiriLabel = new javax.swing.JLabel();
        tingkatPercayaDiriInput = new javax.swing.JComboBox<>();
        kemampuanKerjaLabel = new javax.swing.JLabel();
        kemampuanKerjaInput = new javax.swing.JComboBox<>();
        kemampuanAdaptasiLabel = new javax.swing.JLabel();
        kemampuanAdaptasiInput = new javax.swing.JComboBox<>();
        ketekunanLabel = new javax.swing.JLabel();
        ketekunanInput = new javax.swing.JComboBox<>();
        konsentrasiLabel = new javax.swing.JLabel();
        konsentrasiInput = new javax.swing.JComboBox<>();
        manajemenEmosiLabel = new javax.swing.JLabel();
        manajemenEmosiInput = new javax.swing.JComboBox<>();
        motivasiBerprestasiLabel = new javax.swing.JLabel();
        motivasiBerprestasiInput = new javax.swing.JComboBox<>();
        aksiPanel = new javax.swing.JPanel();
        resetButton = new javax.swing.JButton();
        cetakButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        keluarButton = new javax.swing.JButton();

        judulPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        judul.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setText("PAULI MAPPING");

        javax.swing.GroupLayout judulPanelLayout = new javax.swing.GroupLayout(judulPanel);
        judulPanel.setLayout(judulPanelLayout);
        judulPanelLayout.setHorizontalGroup(
            judulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        judulPanelLayout.setVerticalGroup(
            judulPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(judulPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        masukanPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Masukan"));

        tingkatPercayaDiriLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tingkatPercayaDiriLabel.setText("Kemampuan Kerja & Motivasi Kerja");

        tingkatPercayaDiriInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ha < Rata-rata", "Ha = Rata-rata", "Ha > Rata-rata" }));
        tingkatPercayaDiriInput.setPreferredSize(new java.awt.Dimension(260, 35));
        tingkatPercayaDiriInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tingkatPercayaDiriInputActionPerformed(evt);
            }
        });

        kemampuanKerjaLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kemampuanKerjaLabel.setText("Kemampuan Kerja & Motivasi Kerja");

        kemampuanKerjaInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rendah", "Sedang", "Tinggi" }));
        kemampuanKerjaInput.setPreferredSize(new java.awt.Dimension(260, 35));
        kemampuanKerjaInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kemampuanKerjaInputActionPerformed(evt);
            }
        });

        kemampuanAdaptasiLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kemampuanAdaptasiLabel.setText("Kemampuan Adaptasi");

        kemampuanAdaptasiInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rendah", "Sedang", "Tinggi" }));
        kemampuanAdaptasiInput.setPreferredSize(new java.awt.Dimension(260, 35));
        kemampuanAdaptasiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kemampuanAdaptasiInputActionPerformed(evt);
            }
        });

        ketekunanLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ketekunanLabel.setText("Ketekunan");

        ketekunanInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rendah", "Sedang", "Tinggi" }));
        ketekunanInput.setPreferredSize(new java.awt.Dimension(260, 35));
        ketekunanInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ketekunanInputActionPerformed(evt);
            }
        });

        konsentrasiLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        konsentrasiLabel.setText("Konsentrasi");

        konsentrasiInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rendah", "Sedang", "Tinggi" }));
        konsentrasiInput.setPreferredSize(new java.awt.Dimension(260, 35));
        konsentrasiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                konsentrasiInputActionPerformed(evt);
            }
        });

        manajemenEmosiLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        manajemenEmosiLabel.setText("Manajemen Emosi");

        manajemenEmosiInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rendah", "Sedang", "Tinggi" }));
        manajemenEmosiInput.setPreferredSize(new java.awt.Dimension(260, 35));
        manajemenEmosiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manajemenEmosiInputActionPerformed(evt);
            }
        });

        motivasiBerprestasiLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        motivasiBerprestasiLabel.setText("Motivasi Berprestasi & Kemampuan Mengembangkan Diri");

        motivasiBerprestasiInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rendah", "Sedang", "Tinggi" }));
        motivasiBerprestasiInput.setPreferredSize(new java.awt.Dimension(260, 35));
        motivasiBerprestasiInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivasiBerprestasiInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout masukanPanelLayout = new javax.swing.GroupLayout(masukanPanel);
        masukanPanel.setLayout(masukanPanelLayout);
        masukanPanelLayout.setHorizontalGroup(
            masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masukanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(masukanPanelLayout.createSequentialGroup()
                        .addGroup(masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kemampuanKerjaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ketekunanLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(motivasiBerprestasiLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(manajemenEmosiLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(konsentrasiLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kemampuanAdaptasiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(masukanPanelLayout.createSequentialGroup()
                        .addComponent(tingkatPercayaDiriLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(110, 110, 110)))
                .addGroup(masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kemampuanKerjaInput, 0, 180, Short.MAX_VALUE)
                    .addComponent(kemampuanAdaptasiInput, 0, 1, Short.MAX_VALUE)
                    .addComponent(ketekunanInput, 0, 1, Short.MAX_VALUE)
                    .addComponent(konsentrasiInput, 0, 1, Short.MAX_VALUE)
                    .addComponent(manajemenEmosiInput, 0, 1, Short.MAX_VALUE)
                    .addComponent(motivasiBerprestasiInput, 0, 1, Short.MAX_VALUE)
                    .addComponent(tingkatPercayaDiriInput, 0, 1, Short.MAX_VALUE))
                .addGap(220, 220, 220))
        );
        masukanPanelLayout.setVerticalGroup(
            masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masukanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tingkatPercayaDiriLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tingkatPercayaDiriInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kemampuanKerjaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kemampuanKerjaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kemampuanAdaptasiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kemampuanAdaptasiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ketekunanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ketekunanInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(konsentrasiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(konsentrasiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manajemenEmosiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manajemenEmosiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(masukanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motivasiBerprestasiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motivasiBerprestasiInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        aksiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Aksi"));
        aksiPanel.setLayout(new java.awt.GridBagLayout());

        resetButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resetButton.setText("Batal");
        resetButton.setPreferredSize(new java.awt.Dimension(120, 40));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        aksiPanel.add(resetButton, new java.awt.GridBagConstraints());

        cetakButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cetakButton.setText("Cetak");
        cetakButton.setPreferredSize(new java.awt.Dimension(120, 40));
        cetakButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakButtonActionPerformed(evt);
            }
        });
        aksiPanel.add(cetakButton, new java.awt.GridBagConstraints());

        editButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editButton.setText("Ubah");
        editButton.setPreferredSize(new java.awt.Dimension(120, 40));
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        aksiPanel.add(editButton, new java.awt.GridBagConstraints());

        keluarButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        keluarButton.setText("Keluar");
        keluarButton.setPreferredSize(new java.awt.Dimension(120, 40));
        keluarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarButtonActionPerformed(evt);
            }
        });
        aksiPanel.add(keluarButton, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(masukanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(judulPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aksiPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masukanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetButtonActionPerformed

    private void cetakButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakButtonActionPerformed
        PauliResource.produceReport();
    }//GEN-LAST:event_cetakButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

    private void keluarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarButtonActionPerformed
        cardLayout.show(cards, "MainMenuPanel");
    }//GEN-LAST:event_keluarButtonActionPerformed

    private void kemampuanKerjaInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kemampuanKerjaInputActionPerformed
        PauliResource.kemampuanKerja = kemampuanKerjaInput.getSelectedIndex();
    }//GEN-LAST:event_kemampuanKerjaInputActionPerformed

    private void kemampuanAdaptasiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kemampuanAdaptasiInputActionPerformed
        PauliResource.kemampuanAdaptasi = kemampuanAdaptasiInput.getSelectedIndex();
    }//GEN-LAST:event_kemampuanAdaptasiInputActionPerformed

    private void ketekunanInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ketekunanInputActionPerformed
        PauliResource.ketekunan = ketekunanInput.getSelectedIndex();
    }//GEN-LAST:event_ketekunanInputActionPerformed

    private void konsentrasiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_konsentrasiInputActionPerformed
        PauliResource.konsentrasi = konsentrasiInput.getSelectedIndex();
    }//GEN-LAST:event_konsentrasiInputActionPerformed

    private void manajemenEmosiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manajemenEmosiInputActionPerformed
        PauliResource.manajemenEmosi = manajemenEmosiInput.getSelectedIndex();
    }//GEN-LAST:event_manajemenEmosiInputActionPerformed

    private void motivasiBerprestasiInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivasiBerprestasiInputActionPerformed
        PauliResource.motivasiBerprestasi = motivasiBerprestasiInput.getSelectedIndex();
    }//GEN-LAST:event_motivasiBerprestasiInputActionPerformed

    private void tingkatPercayaDiriInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tingkatPercayaDiriInputActionPerformed
        PauliResource.tingkatPercayaDiri = tingkatPercayaDiriInput.getSelectedIndex();
    }//GEN-LAST:event_tingkatPercayaDiriInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aksiPanel;
    private javax.swing.JButton cetakButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel judul;
    private javax.swing.JPanel judulPanel;
    private javax.swing.JButton keluarButton;
    private javax.swing.JComboBox<String> kemampuanAdaptasiInput;
    private javax.swing.JLabel kemampuanAdaptasiLabel;
    private javax.swing.JComboBox<String> kemampuanKerjaInput;
    private javax.swing.JLabel kemampuanKerjaLabel;
    private javax.swing.JComboBox<String> ketekunanInput;
    private javax.swing.JLabel ketekunanLabel;
    private javax.swing.JComboBox<String> konsentrasiInput;
    private javax.swing.JLabel konsentrasiLabel;
    private javax.swing.JComboBox<String> manajemenEmosiInput;
    private javax.swing.JLabel manajemenEmosiLabel;
    private javax.swing.JPanel masukanPanel;
    private javax.swing.JComboBox<String> motivasiBerprestasiInput;
    private javax.swing.JLabel motivasiBerprestasiLabel;
    private javax.swing.JButton resetButton;
    private javax.swing.JComboBox<String> tingkatPercayaDiriInput;
    private javax.swing.JLabel tingkatPercayaDiriLabel;
    // End of variables declaration//GEN-END:variables
}
