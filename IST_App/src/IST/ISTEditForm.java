/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package IST;

import javax.swing.BorderFactory;
import IST.resource.IST_ScoreInterpreterV2;
import static IST.resource.IST_ScoreInterpreterV2.setInterpretation;
import IST.resource.RubrikCategory;
import java.awt.Color;
import java.awt.Font;
import java.util.*;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author nicol
 */
public class ISTEditForm extends javax.swing.JDialog {

    private Map<String, String[]> inputCache;

    int startIndex;
    int endIndex;
    JTextArea[] textAreas;
    IST_ScoreInterpreterV2 interpretation;
    String key;
    IST_ScoreInterpreterV2.Range k, ks, c, cMin, cPlus, b, bs;

    /**
     * @author <a href="https://github.com/NateNats">Reva</a>
     */
    @SuppressWarnings("empty-statement")
    public ISTEditForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        textAreas = new JTextArea[7];
        interpretation = new IST_ScoreInterpreterV2();
        inputCache = new HashMap<>();

        ks = new IST_ScoreInterpreterV2.Range(0, 83.9999);
        k = new IST_ScoreInterpreterV2.Range(84, 89.9999);
        cMin = new IST_ScoreInterpreterV2.Range(90, 98.9999);
        c = new IST_ScoreInterpreterV2.Range(99, 109.9999);
        cPlus = new IST_ScoreInterpreterV2.Range(110, 119.9999);
        b = new IST_ScoreInterpreterV2.Range(120, 129.9999);
        bs = new IST_ScoreInterpreterV2.Range(130, Double.MAX_VALUE);
        matikan();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combobox = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        KSScroll = new javax.swing.JScrollPane();
        KSInput = new javax.swing.JTextArea();
        KScroll = new javax.swing.JScrollPane();
        KInput = new javax.swing.JTextArea();
        CMinScroll = new javax.swing.JScrollPane();
        CMinInput = new javax.swing.JTextArea();
        CScroll = new javax.swing.JScrollPane();
        CInput = new javax.swing.JTextArea();
        CPlusScroll = new javax.swing.JScrollPane();
        CPlusInput = new javax.swing.JTextArea();
        BScroll = new javax.swing.JScrollPane();
        BInput = new javax.swing.JTextArea();
        BSScroll = new javax.swing.JScrollPane();
        BSInput = new javax.swing.JTextArea();
        simpanbutton = new javax.swing.JButton();
        batalButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH --", "Taraf Kecerdasan", "Kemampuan berpikir komprehensif", "Kemampuan berpikir fleksibel", "Kemampuan berhitung / mengolah angka", "Daya ingat / konsentrasi", "Kreativitas", "Kemampuan menilai / judgement", "Kemampuan analisis", "Kemampuan mengambil keputusan", "Kemampuan berbahasa", "Cara / corak berpikir", "Jenis kecerdasan" }));
        combobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboboxMouseClicked(evt);
            }
        });
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        KSScroll.setToolTipText("");
        KSScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Kurang Sekali (KS)"));

        KSInput.setColumns(20);
        KSInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KSInput.setLineWrap(true);
        KSInput.setRows(5);
        KSInput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        KSInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                KSInputKeyReleased(evt);
            }
        });
        KSScroll.setViewportView(KSInput);

        KScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Kurang (K)"));

        KInput.setColumns(20);
        KInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KInput.setLineWrap(true);
        KInput.setRows(5);
        KInput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        KInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                KInputKeyReleased(evt);
            }
        });
        KScroll.setViewportView(KInput);

        CMinScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Rata-rata bawah (C-)"));

        CMinInput.setColumns(20);
        CMinInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CMinInput.setLineWrap(true);
        CMinInput.setRows(5);
        CMinInput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        CMinInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CMinInputKeyReleased(evt);
            }
        });
        CMinScroll.setViewportView(CMinInput);

        CScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Rata-rata (C)"));

        CInput.setColumns(20);
        CInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CInput.setLineWrap(true);
        CInput.setRows(5);
        CInput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        CInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CInputKeyReleased(evt);
            }
        });
        CScroll.setViewportView(CInput);

        CPlusScroll.setToolTipText("");
        CPlusScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Rata-rata atas (C+)"));

        CPlusInput.setColumns(20);
        CPlusInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CPlusInput.setLineWrap(true);
        CPlusInput.setRows(5);
        CPlusInput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        CPlusInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CPlusInputKeyReleased(evt);
            }
        });
        CPlusScroll.setViewportView(CPlusInput);

        BScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Baik (B)"));

        BInput.setColumns(20);
        BInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BInput.setLineWrap(true);
        BInput.setRows(5);
        BInput.setAutoscrolls(false);
        BInput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        BInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BInputKeyReleased(evt);
            }
        });
        BScroll.setViewportView(BInput);

        BSScroll.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Baik Sekali (BS)"));
        BSScroll.setHorizontalScrollBar(null);

        BSInput.setColumns(20);
        BSInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BSInput.setLineWrap(true);
        BSInput.setRows(5);
        BSInput.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        BSInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BSInputKeyReleased(evt);
            }
        });
        BSScroll.setViewportView(BSInput);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(KSScroll, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CMinScroll, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CPlusScroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BSScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KSScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CMinScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(CScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CPlusScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(BScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(BSScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        simpanbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        simpanbutton.setText("Simpan");
        simpanbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanbuttonActionPerformed(evt);
            }
        });

        batalButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        batalButton.setText("Batal");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(batalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(simpanbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(simpanbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(batalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxActionPerformed
        hidupkan();
        kosong();
        int selected = combobox.getSelectedIndex();

        if (selected == 0) {
//            interpretation.showAllInterpretations();
            KSInput.setEnabled(false);
            KInput.setEnabled(false);
            CMinInput.setEnabled(false);
            CInput.setEnabled(false);
            CPlusInput.setEnabled(false);
            BInput.setEnabled(false);
            BSInput.setEnabled(false);

            return;
        }

        RubrikCategory selectedCategory = RubrikCategory.values()[selected - 1];
        key = selectedCategory.getLabel();

        System.out.println(key);

        if (!key.equals("Jenis kecerdasan")
                && !key.equals("Cara / corak berpikir")
                && !key.equals("Kemampuan berpikir fleksibel")) {
            setTitleBorder();
            hidupkan();

            NavigableMap<IST_ScoreInterpreterV2.Range, String> val = interpretation.getCategoryInterpretation(selectedCategory);

            if (loadToCache(key) == false) {
                KSInput.setText(val.get(ks));
                KInput.setText(val.get(k));
                CMinInput.setText(val.get(cMin));
                CInput.setText(val.get(c));
                CPlusInput.setText(val.get(cPlus));
                BInput.setText(val.get(b));
                BSInput.setText(val.get(bs));
            }

        } else if (key.equals("Jenis kecerdasan")) {

            String[] val = interpretation.getInterpretation(RubrikCategory.JENIS_KECERDASAN, 0.0);
            String[] val2 = interpretation.getInterpretation(RubrikCategory.JENIS_KECERDASAN, 10.0);

            KSScroll.setViewportBorder(BorderFactory.createTitledBorder("WA & GE cenderung lebih tinggi SE & AN"));
            KScroll.setViewportBorder(BorderFactory.createTitledBorder("SE & AN cenderung lebih tinggi WA & GE "));

            if (loadToCache(key) == false) {
                KSInput.setText(val[0]);
                KInput.setText(val2[1]);
            }

            CMinScroll.setViewportBorder(BorderFactory.createTitledBorder(""));
            CScroll.setViewportBorder(BorderFactory.createTitledBorder(""));
            CPlusScroll.setViewportBorder(BorderFactory.createTitledBorder(""));
            BScroll.setViewportBorder(BorderFactory.createTitledBorder(""));
            BSScroll.setViewportBorder(BorderFactory.createTitledBorder(""));

            CMinInput.setEnabled(false);
            CInput.setEnabled(false);
            CPlusInput.setEnabled(false);
            BInput.setEnabled(false);
            BSInput.setEnabled(false);

        } else if (key.equals("Cara / corak berpikir")) {

            String[] val = interpretation.getInterpretation(RubrikCategory.CORAK_BERPIKIR, 0);
            String[] val2 = interpretation.getInterpretation(RubrikCategory.CORAK_BERPIKIR, 10.0);
            String[] val3 = interpretation.getInterpretation(RubrikCategory.CORAK_BERPIKIR, -10.0);

            KSScroll.setViewportBorder(BorderFactory.createTitledBorder("GE+RA >> AN+ZR"));
            KScroll.setViewportBorder(BorderFactory.createTitledBorder("GE+RA << AN+ZR"));
            CMinScroll.setViewportBorder(BorderFactory.createTitledBorder("GE+RA mendekati AN+ZR"));

            if (loadToCache(key) == false) {
                KSInput.setText(val[1]);
                KInput.setText(val2[1]);
                CMinInput.setText(val3[1]);
            }

            CScroll.setViewportBorder(BorderFactory.createTitledBorder(""));
            CPlusScroll.setViewportBorder(BorderFactory.createTitledBorder(""));
            BScroll.setViewportBorder(BorderFactory.createTitledBorder(""));
            BSScroll.setViewportBorder(BorderFactory.createTitledBorder(""));

            CInput.setEnabled(false);
            CPlusInput.setEnabled(false);
            BInput.setEnabled(false);
            BSInput.setEnabled(false);

        } else if (key.equals("Kemampuan berpikir fleksibel")) {
            String[] val = interpretation.getInterpretation(RubrikCategory.BERPIKIR_FLEKSIBEL, -10.0);
            String[] val2 = interpretation.getInterpretation(RubrikCategory.BERPIKIR_FLEKSIBEL, 10.0);
            String[] val3 = interpretation.getInterpretation(RubrikCategory.BERPIKIR_FLEKSIBEL, 0.0);

            KSScroll.setViewportBorder(BorderFactory.createTitledBorder("Selisih -10"));
            KSInput.setText(val[1]);
            KScroll.setViewportBorder(BorderFactory.createTitledBorder("Selisih +10"));
            KInput.setText(val2[1]);
            CMinScroll.setViewportBorder(BorderFactory.createTitledBorder("Selisih tidak sampai 10"));
            CMinInput.setText(val3[1]);

            CScroll.setViewportBorder(BorderFactory.createTitledBorder(""));
            CPlusScroll.setViewportBorder(BorderFactory.createTitledBorder(""));
            BScroll.setViewportBorder(BorderFactory.createTitledBorder(""));
            BSScroll.setViewportBorder(BorderFactory.createTitledBorder(""));

            CInput.setEnabled(false);
            CPlusInput.setEnabled(false);
            BInput.setEnabled(false);
            BSInput.setEnabled(false);

        }

    }//GEN-LAST:event_comboboxActionPerformed

    private boolean loadToCache(String key) {
        if (inputCache.containsKey(key)) {

            String[] cacheValues = inputCache.get(key);

            if (!key.equals("Jenis kecerdasan")
                    && !key.equals("Cara / corak berpikir")
                    && !key.equals("Kemampuan berpikir fleksibel")) {

                KSInput.setText(cacheValues[0]);
                KInput.setText(cacheValues[1]);
                CMinInput.setText(cacheValues[2]);
                CInput.setText(cacheValues[3]);
                CPlusInput.setText(cacheValues[4]);
                BInput.setText(cacheValues[5]);
                BSInput.setText(cacheValues[6]);

            } else if (key.equals("Jenis kecerdasan")) {
                KSInput.setText(cacheValues[0]);
                KInput.setText(cacheValues[1]);

            } else if (key.equals("Cara / corak berpikir") || key.equals("Kemampuan berpikir fleksibel")) {
                KSInput.setText(cacheValues[0]);
                KInput.setText(cacheValues[1]);
                CMinInput.setText(cacheValues[2]);

            }

            return true;
        }

        return false;
    }

    private void saveToCache(String key) {
        String[] cacheValues = null;

        if (!key.equals("Jenis kecerdasan")
                && !key.equals("Cara / corak berpikir")
                && !key.equals("Kemampuan berpikir fleksibel")) {
            cacheValues = new String[7];

            cacheValues[0] = KSInput.getText();
            cacheValues[1] = KInput.getText();
            cacheValues[2] = CMinInput.getText();
            cacheValues[3] = CInput.getText();
            cacheValues[4] = CPlusInput.getText();
            cacheValues[5] = BInput.getText();
            cacheValues[6] = BSInput.getText();

            inputCache.put(key, cacheValues);
            return;

        } else if (key.equals("Cara / corak berpikir")) {
            cacheValues = new String[3];

            cacheValues[0] = KSInput.getText();
            cacheValues[1] = KInput.getText();
            cacheValues[2] = CMinInput.getText();

            inputCache.put(key, cacheValues);
            return;

        } else if (key.equals("Jenis kecerdasan")) {
            cacheValues = new String[2];

            cacheValues[0] = KSInput.getText();
            cacheValues[1] = KInput.getText();

            inputCache.put(key, cacheValues);
            return;

        } else if (key.equals("Kemampuan berpikir fleksibel")) {
            cacheValues = new String[3];

            cacheValues[0] = KSInput.getText();
            cacheValues[1] = KInput.getText();
            cacheValues[2] = CMinInput.getText();

            inputCache.put(key, cacheValues);
            return;

        }

        System.out.println("error:" + key);
    }

    private void setTitleBorder() {
        KSScroll.setViewportBorder(BorderFactory.createTitledBorder("Kurang Sekali (KS)"));
        KScroll.setViewportBorder(BorderFactory.createTitledBorder("Kurang (K)"));
        CMinScroll.setViewportBorder(BorderFactory.createTitledBorder("Rata-rata bawah (C-)"));
        CScroll.setViewportBorder(BorderFactory.createTitledBorder("Rata-rata (C)"));
        CPlusScroll.setViewportBorder(BorderFactory.createTitledBorder("Diatas rata-rata (C+)"));
        BScroll.setViewportBorder(BorderFactory.createTitledBorder("Baik (B)"));
        BSScroll.setViewportBorder(BorderFactory.createTitledBorder("Baik Sekali (BS)"));
    }

    private void resetInput() {
        kosong();
    }

    private void simpanbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanbuttonActionPerformed
        if (!Objects.equals(combobox.getSelectedItem(), "-- PILIH --")) {

            if(inputCache.containsKey("Taraf Kecerdasan")) {
                setInterpretation(RubrikCategory.TARAF_KECERDASAN, inputCache.get("Taraf Kecerdasan"));
            }

            if (inputCache.containsKey("Kemampuan berpikir komprehensif")) {
                setInterpretation(RubrikCategory.BERPIKIR_KOMPREHENSIF, inputCache.get("Kemampuan berpikir komprehensif"));
            }

            if (inputCache.containsKey("Kemampuan berpikir fleksibel")) {
                setInterpretation(RubrikCategory.BERPIKIR_FLEKSIBEL, inputCache.get("Kemampuan berpikir fleksibel"));
            }

            if (inputCache.containsKey("Kemampuan berhitung / mengolah angka")) {
                setInterpretation(RubrikCategory.MENGOLAH_ANGKA, inputCache.get("Kemampuan berhitung / mengolah angka"));
            }

            if (inputCache.containsKey("Daya ingat / konsentrasi")) {
                setInterpretation(RubrikCategory.DAYA_INGAT, inputCache.get("Daya ingat / konsentrasi"));
            }

            if (inputCache.containsKey("Kreativitas")) {
                setInterpretation(RubrikCategory.KREATIVITAS, inputCache.get("Kreativitas"));
            }

            if (inputCache.containsKey("Kemampuan menilai / judgement")) {
                setInterpretation(RubrikCategory.MENILAI, inputCache.get("Kemampuan menilai / judgement"));
            }

            if (inputCache.containsKey("Kemampuan analisis")) {
                setInterpretation(RubrikCategory.ANALISIS, inputCache.get("Kemampuan analisis"));
            }

            if (inputCache.containsKey("Kemampuan mengambil keputusan")) {
                setInterpretation(RubrikCategory.MENGAMBIL_KEPUTUSAN, inputCache.get("Kemampuan mengambil keputusan"));
            }

            if (inputCache.containsKey("Kemampuan berbahasa")) {
                setInterpretation(RubrikCategory.BERBAHASA, inputCache.get("Kemampuan berbahasa"));
            }

            if (inputCache.containsKey("Cara / corak berpikir")) {
                setInterpretation(RubrikCategory.CORAK_BERPIKIR, inputCache.get("Cara / corak berpikir"));
            }

            if (inputCache.containsKey("Jenis kecerdasan")) {
                setInterpretation(RubrikCategory.JENIS_KECERDASAN, inputCache.get("Jenis kecerdasan"));
            }

            inputCache.clear();
            kosong();
        }

    }//GEN-LAST:event_simpanbuttonActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        inputCache.remove("Taraf Kecerdasan");
        inputCache.remove("Kemampuan berpikir komprehensif");
        inputCache.remove("Kemampuan berpikir fleksibel");
        inputCache.remove("Kemampuan berhitung / mengolah angka");
        inputCache.remove("Daya ingat / konsentrasi");
        inputCache.remove("Kreativitas");
        inputCache.remove("Kemampuan menilai / judgement");
        inputCache.remove("Kemampuan analisis");
        inputCache.remove("Kemampuan mengambil keputusa");
        inputCache.remove("Kemampuan berbahasa");
        inputCache.remove("Cara / corak berpikir");
        inputCache.remove("Jenis kecerdasan");
        dispose();
    }//GEN-LAST:event_batalButtonActionPerformed

    private void comboboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboboxMouseClicked
//        if (!combobox.getSelectedItem().equals("-- PILIH --")) {
//            saveToCache(key);
//            return;
//        }
//
//        kosong();
    }//GEN-LAST:event_comboboxMouseClicked

    private void KSInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KSInputKeyReleased
        if (!combobox.getSelectedItem().equals("-- PILIH --")) {
            saveToCache(key);
            return;
        }

        kosong();
    }//GEN-LAST:event_KSInputKeyReleased

    private void CMinInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CMinInputKeyReleased
        if (!combobox.getSelectedItem().equals("-- PILIH --")) {
            saveToCache(key);
            return;
        }

        kosong();
    }//GEN-LAST:event_CMinInputKeyReleased

    private void KInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KInputKeyReleased
        if (!combobox.getSelectedItem().equals("-- PILIH --")) {
            saveToCache(key);
            return;
        }

        kosong();
    }//GEN-LAST:event_KInputKeyReleased

    private void CInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CInputKeyReleased
        if (!combobox.getSelectedItem().equals("-- PILIH --")) {
            saveToCache(key);
            return;
        }

        kosong();
    }//GEN-LAST:event_CInputKeyReleased

    private void CPlusInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPlusInputKeyReleased
        if (!combobox.getSelectedItem().equals("-- PILIH --")) {
            saveToCache(key);
            return;
        }

        kosong();
    }//GEN-LAST:event_CPlusInputKeyReleased

    private void BInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BInputKeyReleased
        if (!combobox.getSelectedItem().equals("-- PILIH --")) {
            saveToCache(key);
            return;
        }

        kosong();
    }//GEN-LAST:event_BInputKeyReleased

    private void BSInputKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BSInputKeyReleased
        if (!combobox.getSelectedItem().equals("-- PILIH --")) {
            saveToCache(key);
            return;
        }

        kosong();
    }//GEN-LAST:event_BSInputKeyReleased

    void add2F(LinkedList<String> ll) {
        for (int i = 0; i < ll.size(); i++) {
            try {
                textAreas[i].setText(ll.get(i));
                System.out.println(ll.get(i));
                System.out.println(i + 1);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    void kosong() {
        KSInput.setText("");
        KInput.setText("");
        CMinInput.setText("");
        CInput.setText("");
        CPlusInput.setText("");
        BInput.setText("");
        BSInput.setText("");
    }

    void matikan() {
        KSInput.setEnabled(false);
        KInput.setEnabled(false);
        CMinInput.setEnabled(false);
        CInput.setEnabled(false);
        CPlusInput.setEnabled(false);
        BInput.setEnabled(false);
        BSInput.setEnabled(false);
    }

    void hidupkan() {
        KSInput.setEnabled(true);
        KInput.setEnabled(true);
        CMinInput.setEnabled(true);
        CInput.setEnabled(true);
        CPlusInput.setEnabled(true);
        BInput.setEnabled(true);
        BSInput.setEnabled(true);
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ISTEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ISTEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ISTEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ISTEditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ISTEditForm dialog = new ISTEditForm(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea BInput;
    private javax.swing.JTextArea BSInput;
    private javax.swing.JScrollPane BSScroll;
    private javax.swing.JScrollPane BScroll;
    private javax.swing.JTextArea CInput;
    private javax.swing.JTextArea CMinInput;
    private javax.swing.JScrollPane CMinScroll;
    private javax.swing.JTextArea CPlusInput;
    private javax.swing.JScrollPane CPlusScroll;
    private javax.swing.JScrollPane CScroll;
    private javax.swing.JTextArea KInput;
    private javax.swing.JTextArea KSInput;
    private javax.swing.JScrollPane KSScroll;
    private javax.swing.JScrollPane KScroll;
    private javax.swing.JButton batalButton;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton simpanbutton;
    // End of variables declaration//GEN-END:variables

    private void updateInterpretation() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
