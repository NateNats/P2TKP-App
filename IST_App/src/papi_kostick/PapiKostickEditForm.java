package papi_kostick;

import papi_kostick.resource.PapiKostickCategory;
import papi_kostick.resource.ScoreInterpreter;

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
    // <editor-fold defaultstate="collapsed" desc="Generated
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

        addWindowListener( new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                cancelButtonActionPerformed(null);
                dispose();
            }
        });
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        CategoryInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH --",
                "L = PERAN – PEMIMPIN (Leadership Role)",
                "P = KEBUTUHAN – MENGATUR ORANG LAIN (Need to Control Others)",
                "I = PERAN – MEMBUAT KEPUTUSAN (Ease in Decision Making)",
                "F = KEBUTUHAN – MENDUKUNG OTORITAS PEMEGANG KEKUASAAN (Need to Support Authority)",
                "W = KEBUTUHAN MENGIKUTI ATURAN DAN PENGAWASAN (Need for Rules and Supervision)",
                "T = PERAN SIBUK (Pace)", "V = PERAN PENUH SEMANGAT (Vigorous Type)",
                "R = PERAN ORANG YANG TEORITIS (Theoretical Type)",
                "D = PERAN BEKERJA DENGAN HAL – HAL RINCI (Interest in Working With Details)",
                "C = PERAN MENGATUR (Organized Type)", "X = KEBUTUHAN UNTUK DIPERHATIKAN (Need to be Noticed)",
                "B = KEBUTUHAN DITERIMA DALAM KELOMPOK (Need to Belong to Groups)",
                "O = KEBUTUHAN KEDEKATAN DAN KASIH SAYANG (Need for Closeness and Affection)",
                "S = PERAN HUBUNGAN SOSIAL (Social Extension)",
                "N = KEBUTUHAN MENYELESAIKAN TUGAS SECARA MANDIRI (Need to Finish Task)",
                "A = KEBUTUHAN BERPRESTASI (Need to Achieve)", "G = PERAN PEKERJA KERAS (Hard Intense Worked)",
                "Z = KEBUTUHAN UNTUK BERUBAH (Need for Change)", "K = KEBUTUHAN UNTUK AGRESIF (Need to be Forceful)",
                "E = PERAN PENGENDALIAN EMOSI (Emotional Resistant)" }));
        CategoryInput.setPreferredSize(new java.awt.Dimension(561, 35));
        CategoryInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryInputActionPerformed(evt);
            }
        });

        EditPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));

        firstInput.setColumns(20);
        firstInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstInput.setLineWrap(true);
        firstInput.setRows(5);
        firstInput.setEnabled(false);
        firstScroll.setViewportView(firstInput);

        secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));

        secondInput.setColumns(20);
        secondInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        secondInput.setLineWrap(true);
        secondInput.setRows(5);
        secondInput.setEnabled(false);
        secondScroll.setViewportView(secondInput);

        thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));

        thirdInput.setColumns(20);
        thirdInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        thirdInput.setLineWrap(true);
        thirdInput.setRows(5);
        thirdInput.setEnabled(false);
        thirdScroll.setViewportView(thirdInput);

        fourthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));

        fourthInput.setColumns(20);
        fourthInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fourthInput.setLineWrap(true);
        fourthInput.setRows(5);
        fourthInput.setEnabled(false);
        fourthScroll.setViewportView(fourthInput);

        fifthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));

        fifthInput.setColumns(20);
        fifthInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fifthInput.setLineWrap(true);
        fifthInput.setRows(5);
        fifthInput.setEnabled(false);
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
                .addComponent(firstScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thirdScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fourthScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fifthScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancelButton.setText("Batal");

        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saveButton.setText("Simpan");

        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

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
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CategoryInputActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CategoryInputActionPerformed
        clearInputs();
        int selectedIndex = CategoryInput.getSelectedIndex();
        if (selectedIndex == 0) {
            return;
        }

        PapiKostickCategory selectedCategory = PapiKostickCategory.values()[selectedIndex - 1];

        switch (selectedCategory) {
            case LEADERSHIP_ROLE:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("l", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 5"));
                secondInput.setText(ScoreInterpreter.getInterpretation("l", 5));
                secondInput.setEnabled(true);
                break;
            case NEED_TO_CONTROL_OTHERS:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("p", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 5"));
                secondInput.setText(ScoreInterpreter.getInterpretation("p", 5));
                secondInput.setEnabled(true);
                break;
            case EASE_IN_DECISION_MAKING:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("i", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 3"));
                secondInput.setText(ScoreInterpreter.getInterpretation("i", 3));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 5"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("i", 5));
                thirdInput.setEnabled(true);
                fourthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 8"));
                fourthInput.setText(ScoreInterpreter.getInterpretation("i", 8));
                fourthInput.setEnabled(true);
                break;
            case NEED_TO_SUPPORT_AUTHORITY:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("f", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 3"));
                secondInput.setText(ScoreInterpreter.getInterpretation("f", 3));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 4"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("f", 4));
                thirdInput.setEnabled(true);
                fourthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 6"));
                fourthInput.setText(ScoreInterpreter.getInterpretation("f", 6));
                fourthInput.setEnabled(true);
                break;
            case NEED_FOR_RULES_AND_SUPERVISION:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("w", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 4"));
                secondInput.setText(ScoreInterpreter.getInterpretation("w", 4));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 6"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("w", 6));
                thirdInput.setEnabled(true);
                break;
            case PACE:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("t", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 4"));
                secondInput.setText(ScoreInterpreter.getInterpretation("t", 4));
                secondInput.setEnabled(true);
                break;
            case VIGOROUS_TYPE:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("v", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 5"));
                secondInput.setText(ScoreInterpreter.getInterpretation("v", 5));
                secondInput.setEnabled(true);
                break;
            case THEORETICAL_TYPE:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("r", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 5"));
                secondInput.setText(ScoreInterpreter.getInterpretation("r", 5));
                secondInput.setEnabled(true);
                break;
            case INTEREST_IN_WORKING_WITH_DETAILS:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("d", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 4"));
                secondInput.setText(ScoreInterpreter.getInterpretation("d", 4));
                secondInput.setEnabled(true);
                break;
            case ORGANIZED_TYPE:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("c", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 3"));
                secondInput.setText(ScoreInterpreter.getInterpretation("c", 3));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 6"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("c", 6));
                thirdInput.setEnabled(true);
                break;
            case NEED_TO_BE_NOTICED:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("x", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 2"));
                secondInput.setText(ScoreInterpreter.getInterpretation("x", 2));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 4"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("x", 4));
                thirdInput.setEnabled(true);
                fourthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 6"));
                fourthInput.setText(ScoreInterpreter.getInterpretation("x", 6));
                fourthInput.setEnabled(true);
                break;
            case NEED_TO_BELONG_TO_GROUPS:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("b", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 4"));
                secondInput.setText(ScoreInterpreter.getInterpretation("b", 4));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 6"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("b", 6));
                thirdInput.setEnabled(true);
                break;
            case NEED_FOR_CLOSENESS_AND_AFFECTION:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("o", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 3"));
                secondInput.setText(ScoreInterpreter.getInterpretation("o", 3));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 5"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("o", 5));
                thirdInput.setEnabled(true);
                break;
            case SOCIAL_EXTENSION:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("s", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 7"));
                secondInput.setText(ScoreInterpreter.getInterpretation("s", 7));
                secondInput.setEnabled(true);
                break;
            case NEED_TO_FINISH_TASK:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("n", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 4"));
                secondInput.setText(ScoreInterpreter.getInterpretation("n", 4));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 5"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("n", 5));
                thirdInput.setEnabled(true);
                fourthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 6"));
                fourthInput.setText(ScoreInterpreter.getInterpretation("n", 6));
                fourthInput.setEnabled(true);
                fifthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 7"));
                fifthInput.setText(ScoreInterpreter.getInterpretation("n", 7));
                fifthInput.setEnabled(true);
                break;
            case NEED_TO_ACHIEVE:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("a", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 6"));
                secondInput.setText(ScoreInterpreter.getInterpretation("a", 6));
                secondInput.setEnabled(true);
                break;
            case HARD_INTENSE_WORKED:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("g", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 3"));
                secondInput.setText(ScoreInterpreter.getInterpretation("g", 3));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 5"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("g", 5));
                thirdInput.setEnabled(true);
                break;
            case NEED_FOR_CHANGE:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("z", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 3"));
                secondInput.setText(ScoreInterpreter.getInterpretation("z", 3));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 5"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("z", 5));
                thirdInput.setEnabled(true);
                fourthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 6"));
                fourthInput.setText(ScoreInterpreter.getInterpretation("z", 6));
                fourthInput.setEnabled(true);
                fifthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 8"));
                fifthInput.setText(ScoreInterpreter.getInterpretation("z", 8));
                fifthInput.setEnabled(true);
                break;
            case NEED_TO_BE_FORCEFUL:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("k", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 3"));
                secondInput.setText(ScoreInterpreter.getInterpretation("k", 3));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 5"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("k", 5));
                thirdInput.setEnabled(true);
                fourthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 6"));
                fourthInput.setText(ScoreInterpreter.getInterpretation("k", 6));
                fourthInput.setEnabled(true);
                fifthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 8"));
                fifthInput.setText(ScoreInterpreter.getInterpretation("k", 8));
                fifthInput.setEnabled(true);
                break;
            case EMOTIONAL_RESISTANT:
                firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 0"));
                firstInput.setText(ScoreInterpreter.getInterpretation("e", 0));
                firstInput.setEnabled(true);
                secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 2"));
                secondInput.setText(ScoreInterpreter.getInterpretation("e", 2));
                secondInput.setEnabled(true);
                thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 4"));
                thirdInput.setText(ScoreInterpreter.getInterpretation("e", 4));
                thirdInput.setEnabled(true);
                fourthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("≥ 7"));
                fourthInput.setText(ScoreInterpreter.getInterpretation("e", 7));
                fourthInput.setEnabled(true);
                break;

        }
    }// GEN-LAST:event_CategoryInputActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_saveButtonActionPerformed

    private void clearInputs() {
        firstScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));
        secondScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));
        thirdScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));
        fourthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));
        fifthScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder(""));
        firstInput.setEnabled(false);
        secondInput.setEnabled(false);
        thirdInput.setEnabled(false);
        fourthInput.setEnabled(false);
        fifthInput.setEnabled(false);
        firstInput.setText("");
        secondInput.setText("");
        thirdInput.setText("");
        fourthInput.setText("");
        fifthInput.setText("");
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
