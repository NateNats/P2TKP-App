/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package msdt;

import common.MainFrame;
import ist_app.Main;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import msdt.resource.MSDTScoreInterpreter;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author nicol
 */
public class MSDTForm extends javax.swing.JPanel {
    private MainFrame mainFrame;
    /**
     * Creates new form mapping_msdt
     */
    MSDTScoreInterpreter score;

    public MSDTForm(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        score = new MSDTScoreInterpreter();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        judul = new javax.swing.JLabel();
        aksiPanel = new javax.swing.JPanel();
        combobox = new javax.swing.JComboBox<>();
        kepemimpinan = new javax.swing.JLabel();
        namaLabel = new javax.swing.JLabel();
        namaInput = new javax.swing.JTextField();
        hasilPanel = new javax.swing.JPanel();
        hasilScrollPane = new javax.swing.JScrollPane();
        hasilTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        tombolCetak = new javax.swing.JButton();
        tombolUbah = new javax.swing.JButton();
        tombolKeluar = new javax.swing.JButton();

        judul.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        judul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judul.setText("MAPPING MSDT");
        judul.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        aksiPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Masukkan"));

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH --", "Deserter", "Compromiser", "Missionary", "Buereaucrat", "Autocrat", "Benevolent Autocrat", "Developer", "Executive" }));
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });

        kepemimpinan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        kepemimpinan.setText("Tipe Kepemimpinan:");

        namaLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        namaLabel.setText("Nama                        :");

        javax.swing.GroupLayout aksiPanelLayout = new javax.swing.GroupLayout(aksiPanel);
        aksiPanel.setLayout(aksiPanelLayout);
        aksiPanelLayout.setHorizontalGroup(
            aksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(aksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(namaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kepemimpinan, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(namaInput)
                    .addComponent(combobox, 0, 463, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        aksiPanelLayout.setVerticalGroup(
            aksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aksiPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(aksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaLabel)
                    .addComponent(namaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(aksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kepemimpinan))
                .addGap(24, 24, 24))
        );

        hasilPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Hasil"));

        hasilTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hasilTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Aspek Psikologis", "Uraian", "Skor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        hasilScrollPane.setViewportView(hasilTable);

        javax.swing.GroupLayout hasilPanelLayout = new javax.swing.GroupLayout(hasilPanel);
        hasilPanel.setLayout(hasilPanelLayout);
        hasilPanelLayout.setHorizontalGroup(
            hasilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hasilPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hasilScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                .addContainerGap())
        );
        hasilPanelLayout.setVerticalGroup(
            hasilPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hasilPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hasilScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Aksi"));

        tombolCetak.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tombolCetak.setText("Cetak");
        tombolCetak.setPreferredSize(new java.awt.Dimension(120, 40));
        tombolCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCetakActionPerformed(evt);
            }
        });

        tombolUbah.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tombolUbah.setText("Ubah");
        tombolUbah.setPreferredSize(new java.awt.Dimension(120, 40));
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tombolKeluar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tombolKeluar.setText("Keluar");
        tombolKeluar.setPreferredSize(new java.awt.Dimension(120, 40));
        tombolKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tombolCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tombolUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tombolKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(239, 239, 239))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolCetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolUbah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(judul, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
                    .addComponent(aksiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hasilPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul)
                .addGap(12, 12, 12)
                .addComponent(aksiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hasilPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxActionPerformed
        String val = combobox.getSelectedItem().toString();
        //TableModel dataModel = new AbstractTableModel();
        String[] cols = {"Aspek Psikologis", "Uraian", "Skor"};

        if (val.equals("-- PILIH --")) {
            DefaultTableModel model = new DefaultTableModel(cols, 0);
            hasilTable.setModel(model);

        } else {
            hasilTable.setModel(score.chooseCombo(val));
        }

        //hasilTable.setModel(dataModel);
    }//GEN-LAST:event_comboboxActionPerformed

    private void tombolCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCetakActionPerformed
        String fileName = "msdt/resources/report/msdtReport.jasper";
        
        try {
            SimpleDateFormat originalFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
            String formattedDate = "";
            SimpleDateFormat newFormat = new SimpleDateFormat("dd MMMM yyyy");
        } catch (Exception e) {

        }
    }//GEN-LAST:event_tombolCetakActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolKeluarActionPerformed
        mainFrame.showCard("MainMenuPanel");
        mainFrame.setTitle("KATEGORISASI MAPPING");
    }//GEN-LAST:event_tombolKeluarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aksiPanel;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JPanel hasilPanel;
    private javax.swing.JScrollPane hasilScrollPane;
    private javax.swing.JTable hasilTable;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel judul;
    private javax.swing.JLabel kepemimpinan;
    private javax.swing.JTextField namaInput;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JButton tombolCetak;
    private javax.swing.JButton tombolKeluar;
    private javax.swing.JButton tombolUbah;
    // End of variables declaration//GEN-END:variables
}