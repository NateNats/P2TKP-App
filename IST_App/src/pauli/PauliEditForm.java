package pauli;

import pauli.resource.PauliCategory;
import pauli.resource.PauliScoreInterpreter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author Trustacean
 */
public class PauliEditForm extends javax.swing.JDialog {
    PauliCategory cachedCategory;
    /**
     * Creates new form PauliEditForm
     */
    public PauliEditForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        categoryInput = new javax.swing.JComboBox<>();
        editPanel = new javax.swing.JPanel();
        rendahScroll = new javax.swing.JScrollPane();
        rendahInput = new javax.swing.JTextArea();
        sedangScroll = new javax.swing.JScrollPane();
        sedangInput = new javax.swing.JTextArea();
        tinggiScroll = new javax.swing.JScrollPane();
        tinggiInput = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        addWindowListener( new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                cancelButtonActionPerformed(null);
                dispose();
            }
        });

        categoryInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH --", "Ha vs Rata-rata (Tingkat Percaya Diri & Inisiatif)", "Jumlah (Kemampuan Kerja & Motivasi Kerja)", "Posisi Kolom (Kemampuan Adaptasi)", "Kesalahan (Ketekunan)", "Pembenaran (Konsentrasi)", "Penyimpangan (Manajemen Emosi)", "Tinggi (Motivasi Berprestasi & Kemauan Mengembangkan Diri)", "Ketekunan & Konsentrasi (Ketelitian)" }));
        categoryInput.setPreferredSize(new java.awt.Dimension(561, 35));

        categoryInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryInputActionPerformed(evt);
            }
        });

        editPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rendahScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Rendah"));

        rendahInput.setColumns(20);
        rendahInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rendahInput.setLineWrap(true);
        rendahInput.setRows(5);
        rendahInput.setWrapStyleWord(true);
        rendahInput.setEnabled(false);
        rendahScroll.setViewportView(rendahInput);

        sedangScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Sedang"));

        sedangInput.setColumns(20);
        sedangInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sedangInput.setLineWrap(true);
        sedangInput.setRows(5);
        sedangInput.setWrapStyleWord(true);
        sedangInput.setEnabled(false);
        sedangScroll.setViewportView(sedangInput);

        tinggiScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Sedang"));

        tinggiInput.setColumns(20);
        tinggiInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tinggiInput.setLineWrap(true);
        tinggiInput.setRows(5);
        tinggiInput.setWrapStyleWord(true);
        tinggiInput.setEnabled(false);
        tinggiScroll.setViewportView(tinggiInput);

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rendahScroll)
                    .addComponent(sedangScroll, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tinggiScroll, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rendahScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sedangScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tinggiScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saveButton.setText("Simpan");

        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancelButton.setText("Batal");

        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(categoryInput, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(categoryInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        updateInterpretation();
        PauliScoreInterpreter.saveInterpretationsToFile();
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        PauliScoreInterpreter.reloadInterpretations();
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void CategoryInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryInputActionPerformed
        updateInterpretation();
        clearInputs();
        int selectedCategory = categoryInput.getSelectedIndex();
        if (selectedCategory == 0) {
            rendahInput.setEnabled(false);
            sedangInput.setEnabled(false);
            tinggiInput.setEnabled(false);
            return;
        }
        PauliCategory category = PauliCategory.values()[selectedCategory - 1];
        cachedCategory = category;
        if (category == PauliCategory.KETEKUNAN_KONSENTRASI) {
            System.out.println("erm");
            rendahInput.setEnabled(false);
            sedangInput.setEnabled(false);
            tinggiInput.setEnabled(false);
            return;
        }
        rendahInput.setText(PauliScoreInterpreter.getInterpretation(category, 0));
        sedangInput.setText(PauliScoreInterpreter.getInterpretation(category, 1));
        tinggiInput.setText(PauliScoreInterpreter.getInterpretation(category, 2));

    }//GEN-LAST:event_CategoryInputActionPerformed

    private void clearInputs() {
        rendahInput.setEnabled(true);
        sedangInput.setEnabled(true);
        tinggiInput.setEnabled(true);
        rendahInput.setText("");
        sedangInput.setText("");
        tinggiInput.setText("");
    }

    private void updateInterpretation() {
        if (cachedCategory == null || cachedCategory == PauliCategory.KETEKUNAN_KONSENTRASI) {
            return;
        }
        PauliScoreInterpreter.setInterpretation(cachedCategory, 0, rendahInput.getText());
        PauliScoreInterpreter.setInterpretation(cachedCategory, 1, sedangInput.getText());
        PauliScoreInterpreter.setInterpretation(cachedCategory, 2, tinggiInput.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> categoryInput;
    private javax.swing.JPanel editPanel;
    private javax.swing.JTextArea rendahInput;
    private javax.swing.JScrollPane rendahScroll;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextArea sedangInput;
    private javax.swing.JScrollPane sedangScroll;
    private javax.swing.JTextArea tinggiInput;
    private javax.swing.JScrollPane tinggiScroll;
    // End of variables declaration//GEN-END:variables
}
