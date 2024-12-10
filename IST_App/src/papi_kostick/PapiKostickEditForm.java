package papi_kostick;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author Trustacean
 */
public class PapiKostickEditForm extends javax.swing.JDialog {

    /**
     * Creates new form PapiKostickEditForm
     */
    public PapiKostickEditForm(java.awt.Frame parent, boolean modal) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        CategoryInput = new javax.swing.JComboBox<>();
        EditPanel = new javax.swing.JPanel();
        firstScroll = new javax.swing.JScrollPane();
        firstInput = new javax.swing.JTextArea();
        secondScroll = new javax.swing.JScrollPane();
        secondInput = new javax.swing.JTextArea();
        thirdScroll = new javax.swing.JScrollPane();
        thirdInput = new javax.swing.JTextArea();
        fourthScroll = new javax.swing.JScrollPane();
        fourthInput = new javax.swing.JTextArea();
        fifthScroll = new javax.swing.JScrollPane();
        fifthInput = new javax.swing.JTextArea();
        cancelButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        CategoryInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH --", "L = PERAN – PEMIMPIN (Leadership Role)", "P = KEBUTUHAN – MENGATUR ORANG LAIN (Need to Control Others)", "I = PERAN – MEMBUAT KEPUTUSAN (Ease in Decision Making)", "F = KEBUTUHAN – MENDUKUNG OTORITAS PEMEGANG KEKUASAAN (Need to Support Authority)", "W = KEBUTUHAN MENGIKUTI ATURAN DAN PENGAWASAN (Need for Rules and Supervision)", "T = PERAN SIBUK (Pace)", "V = PERAN PENUH SEMANGAT (Vigorous Type)", "R = PERAN ORANG YANG TEORITIS (Theoretical Type)", "D = PERAN BEKERJA DENGAN HAL – HAL RINCI (Interest in Working With Details)", "C = PERAN MENGATUR (Organized Type)", "X = KEBUTUHAN UNTUK DIPERHATIKAN (Need to be Noticed)", "B = KEBUTUHAN DITERIMA DALAM KELOMPOK (Need to Belong to Groups)", "O = KEBUTUHAN KEDEKATAN DAN KASIH SAYANG (Need for Closeness and Affection)", "S = PERAN HUBUNGAN SOSIAL (Social Extension)", "N = KEBUTUHAN MENYELESAIKAN TUGAS SECARA MANDIRI (Need to Finish Task)", "A = KEBUTUHAN BERPRESTASI (Need to Achieve)", "G = PERAN PEKERJA KERAS (Hard Intense Worked)", "Z = KEBUTUHAN UNTUK BERUBAH (Need for Change)", "K = KEBUTUHAN UNTUK AGRESIF (Need to be Forceful)", "E = PERAN PENGENDALIAN EMOSI (Emotional Resistant)" }));
        CategoryInput.setPreferredSize(new java.awt.Dimension(561, 35));
        CategoryInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryInputActionPerformed(evt);
            }
        });

        EditPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(">"));

        firstInput.setColumns(20);
        firstInput.setRows(5);
        firstScroll.setViewportView(firstInput);

        secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(">"));

        secondInput.setColumns(20);
        secondInput.setRows(5);
        secondScroll.setViewportView(secondInput);

        thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(">"));

        thirdInput.setColumns(20);
        thirdInput.setRows(5);
        thirdScroll.setViewportView(thirdInput);

        fourthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(">"));

        fourthInput.setColumns(20);
        fourthInput.setRows(5);
        fourthScroll.setViewportView(fourthInput);

        fifthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(">"));

        fifthInput.setColumns(20);
        fifthInput.setRows(5);
        fifthScroll.setViewportView(fifthInput);

        javax.swing.GroupLayout EditPanelLayout = new javax.swing.GroupLayout(EditPanel);
        EditPanel.setLayout(EditPanelLayout);
        EditPanelLayout.setHorizontalGroup(
            EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstScroll)
                    .addComponent(secondScroll)
                    .addComponent(thirdScroll)
                    .addComponent(fourthScroll, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fifthScroll))
                .addContainerGap())
        );
        EditPanelLayout.setVerticalGroup(
            EditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(firstScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thirdScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fourthScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fifthScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancelButton.setText("Batal");

        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saveButton.setText("Simpan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CategoryInput, 0, 0, Short.MAX_VALUE)
                    .addComponent(EditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CategoryInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CategoryInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoryInputActionPerformed

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
            java.util.logging.Logger.getLogger(PapiKostickEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PapiKostickEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PapiKostickEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PapiKostickEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PapiKostickEditForm dialog = new PapiKostickEditForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CategoryInput;
    private javax.swing.JPanel EditPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextArea fifthInput;
    private javax.swing.JScrollPane fifthScroll;
    private javax.swing.JTextArea firstInput;
    private javax.swing.JScrollPane firstScroll;
    private javax.swing.JTextArea fourthInput;
    private javax.swing.JScrollPane fourthScroll;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextArea secondInput;
    private javax.swing.JScrollPane secondScroll;
    private javax.swing.JTextArea thirdInput;
    private javax.swing.JScrollPane thirdScroll;
    // End of variables declaration//GEN-END:variables
}