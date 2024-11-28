/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ist_app;

import java.util.LinkedList;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

/**
 *
 * @author nicol
 */
public class EditForm extends javax.swing.JDialog {

    LinkedList<String> tarKecerdasan, berpikirKompreheren, kemAnalisis, dayaIngat, kreativitas, menilai, mengambilKeputusan, berbahasa, coraBerpikir, jenisKecerdasan, fleksibel, angka;
    int startIndex;
    int endIndex;
    JTextArea[] textAreas;

    /**
     * Creates new form test_2
     */
    @SuppressWarnings("empty-statement")
    public EditForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inisiasitexfield();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        textAreas = new JTextArea[7];
        inisiasiArray();
        matikan();
        inisiasill();
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
        jPanel2 = new javax.swing.JPanel();
        simpanbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH --", "Taraf Kecerdasan", "Kemampuan Analisis", "Kemampuan Berpikir Komprehensif", "Daya Ingat", "Kemampuan berbahasa", "Kreativitas", "Kemampuan menilai", "Kemampuan mengambil keputusan", "Corak/cara berpikir", "Kemampuan berpikir fleksibel", "Kemampuan berhitung / mengolah angka" }));
        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        KSInput.setColumns(20);
        KSInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KSInput.setRows(5);
        KSInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Kurang Sekali (KS)"));
        KSScroll.setViewportView(KSInput);

        KInput.setColumns(20);
        KInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        KInput.setRows(5);
        KInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Kurang (K)"));
        KScroll.setViewportView(KInput);

        CMinInput.setColumns(20);
        CMinInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CMinInput.setRows(5);
        CMinInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Rata-rata bawah (C-)"));
        CMinScroll.setViewportView(CMinInput);

        CInput.setColumns(20);
        CInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CInput.setRows(5);
        CInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Rata-rata (C)"));
        CScroll.setViewportView(CInput);

        CPlusInput.setColumns(20);
        CPlusInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CPlusInput.setRows(5);
        CPlusInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Rata-rata atas (C+)"));
        CPlusScroll.setViewportView(CPlusInput);

        BInput.setColumns(20);
        BInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BInput.setRows(5);
        BInput.setAutoscrolls(false);
        BInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Baik (B)"));
        BScroll.setViewportView(BInput);

        BSScroll.setHorizontalScrollBar(null);

        BSInput.setColumns(20);
        BSInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BSInput.setLineWrap(true);
        BSInput.setRows(5);
        BSInput.setBorder(javax.swing.BorderFactory.createTitledBorder("Baik Sekali (BS)"));
        BSScroll.setViewportView(BSInput);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KSScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addComponent(CScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addComponent(CPlusScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addComponent(BScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addComponent(BSScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(KScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(CMinScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(KSScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(190, 190, 190)
                .addComponent(CScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CPlusScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BSScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(97, 97, 97)
                    .addComponent(KScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(357, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(183, 183, 183)
                    .addComponent(CMinScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(271, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        simpanbutton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        simpanbutton.setText("Simpan");
        simpanbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(simpanbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 175, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 175, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combobox, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(simpanbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 327, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 327, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxActionPerformed
        kosong();
        String value = combobox.getSelectedItem().toString();

        if (value.equals("-- PILIH --")) {
            matikan();
        } else if (value.equals("Taraf Kecerdasan")) {
            hidupkan();
            add2F(tarKecerdasan);
        } else if (value.equals("Kemampuan Analisis")) {
            hidupkan();
            add2F(kemAnalisis);
        } else if (value.equals("Kemampuan Berpikir Komprehensif")) {
            hidupkan();
            add2F(berpikirKompreheren);
        } else if (value.equals("Daya Ingat")) {
            hidupkan();
            add2F(dayaIngat);
        } else if (value.equals("Kemampuan berbahasa")) {
            hidupkan();
            add2F(berbahasa);
        } else if (value.equals("Kreativitas")) {
            hidupkan();
            add2F(kreativitas);
        } else if (value.equals("Kemampuan menilai")) {
            hidupkan();
            add2F(menilai);
        } else if (value.equals("Kemampuan mengambil keputusan")) {
            hidupkan();
            add2F(mengambilKeputusan);
        } else if (value.equals("Corak/cara berpikir")) {
            hidupkan();
            add2F(coraBerpikir);
        } else if (value.equals("Kemampuan berpikir fleksibel")) {
            hidupkan();
            add2F(fleksibel);
        } else if (value.equals("Kemampuan berhitung / mengolah angka")) {
            hidupkan();
            add2F(angka);
        }
        //LinkedList<String> output = getTextBySection(value);
        //inputToTextF(output);
    }//GEN-LAST:event_comboboxActionPerformed

    private void simpanbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanbuttonActionPerformed
        try {
            String value = combobox.getSelectedItem().toString();

            if (value.equals("Taraf Kecerdasan")) {
                write2txt("./src/ist_app/resource/rubrik/taraf kecerdasan.txt", tarKecerdasan);
            } else if (value.equals("Kemampuan Analisis")) {
                write2txt("./src/ist_app/resource/rubrik/kemampuan analisis.txt", kemAnalisis);
            } else if (value.equals("Kemampuan Berpikir Komprehensif")) {
                write2txt("./src/ist_app/resource/rubrik/kemampuan berpikir kompreherensif.txt", berpikirKompreheren);
            } else if (value.equals("Daya Ingat")) {
                write2txt("./src/ist_app/resource/rubrik/daya ingat.txt", dayaIngat);
            } else if (value.equals("Kemampuan berbahasa")) {
                write2txt("./src/ist_app/resource/rubrik/kemampuan berbahasa.txt", berbahasa);
            } else if (value.equals("Kreativitas")) {
                write2txt("./src/ist_app/resource/rubrik/kreativitas.txt", kreativitas);
            } else if (value.equals("Kemampuan menilai")) {
                write2txt("./src/ist_app/resource/rubrik/kemampuan menilai.txt", menilai);
            } else if (value.equals("Kemampuan mengambil keputusan")) {
                write2txt("./src/ist_app/resource/rubrik/kemampuan mengambil keputusan.txt", mengambilKeputusan);
            } else if (value.equals("Corak/cara berpikir")) {
                write2txt("./src/ist_app/resource/rubrik/corak berpikir.txt", coraBerpikir);
            } else if (value.equals("Kemampuan berpikir fleksibel")) {
                write2txt("./src/ist_app/resource/rubrik/kemampuan berfikir fleksibel.txt", fleksibel);
            } else if (value.equals("Kemampuan berhitung / mengolah angka")) {
                write2txt("./src/ist_app/resource/rubrik/Kemampuan berhitung n mengolah angka.txt", angka);
            }

            combobox.setSelectedIndex(0);
            kosong();
            inisiasill();

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_simpanbuttonActionPerformed

    void write2txt(String filename, LinkedList<String> value) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            
            for (int i = 0; i < value.size(); i++) {
                value.set(i, textAreas[i].getText());
            }
            
            StringBuilder joinedValue = new StringBuilder();
            
            for (int i = 0; i < value.size(); i++) {
                joinedValue.append(value.get(i)).append(";");
                System.out.println(value.get(i));
            }
            
            writer.write(joinedValue.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    String array2str(LinkedList<String> ll) {
        StringBuilder val = new StringBuilder();

        for (int i = 0; i <= ll.size(); i++) {
            val.append(ll.get(i));
            val.append(" ;");
        }

        System.out.println(val.toString());
        return val.toString();
    }

    String chVal(LinkedList<String> ll) {
        StringBuilder n = new StringBuilder();

        ll = new LinkedList<>();
        for (int i = 0; i < textAreas.length; i++) {
            n.append(textAreas[i].getText()).append(";");
            ll.add(textAreas[i].getText());
        }
        System.out.println(n.toString());
        return n.toString();
    }

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
    
    void inisiasitexfield() {
        KSInput.setLineWrap(true);
        KSInput.setWrapStyleWord(true);
        KInput.setLineWrap(true);
        KInput.setWrapStyleWord(true);
        CMinInput.setLineWrap(true);
        CMinInput.setWrapStyleWord(true);
        CInput.setLineWrap(true);
        CInput.setWrapStyleWord(true);
        CPlusInput.setLineWrap(true);
        CPlusInput.setWrapStyleWord(true);
        BInput.setLineWrap(true);
        BInput.setWrapStyleWord(true);
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

    void inisiasill() {
        tarKecerdasan = new LinkedList<>();
        berpikirKompreheren = new LinkedList<>();
        kemAnalisis = new LinkedList<>();
        dayaIngat = new LinkedList<>();
        kreativitas = new LinkedList<>();
        menilai = new LinkedList<>();
        mengambilKeputusan = new LinkedList<>();
        berbahasa = new LinkedList<>();
        coraBerpikir = new LinkedList<>();
        jenisKecerdasan = new LinkedList<>();
        fleksibel = new LinkedList<>();
        angka = new LinkedList<>();
    }

    void inputToTextF(String[] val) {
        for (int i = 0; i <= val.length; i++) {
            textAreas[i].setText(val[i]);
        }
    }

    void inisiasiArray() {
        textAreas[0] = (JTextArea) KSScroll.getViewport().getView();
        textAreas[1] = (JTextArea) KScroll.getViewport().getView();
        textAreas[2] = (JTextArea) CMinScroll.getViewport().getView();
        textAreas[3] = (JTextArea) CScroll.getViewport().getView();
        textAreas[4] = (JTextArea) CPlusScroll.getViewport().getView();
        textAreas[5] = (JTextArea) BScroll.getViewport().getView();
        textAreas[6] = (JTextArea) BSScroll.getViewport().getView();
    }

    void matikan() {
        for (int i = 0; i < textAreas.length; i++) {
            textAreas[i].setEditable(false);
        }
    }

    void hidupkan() {
        for (int i = 0; i < textAreas.length; i++) {
            textAreas[i].setEditable(true);
        }
    }

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
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditForm dialog = new EditForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton simpanbutton;
    // End of variables declaration//GEN-END:variables
}
