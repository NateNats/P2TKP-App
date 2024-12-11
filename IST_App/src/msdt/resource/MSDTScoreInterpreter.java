/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msdt.resource;

import ist_app.Main;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import msdt.MSDTForm;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author nicol
 */
public class MSDTScoreInterpreter {

    private static final String DATA_FILE_PATH = "./src/storage/MSDT_interpretation.dat";
    private static Map<String, NavigableMap<String, Pair<String, String>>> interpretations = new TreeMap<>();

    static {
        if (!loadInterpretationsFromFile()) {
            initializeDefaultInterpretations();
            SaveInterpretationsToFile();
        }
    }

    public static void SaveInterpretationsToFile() {
        File file = new File(DATA_FILE_PATH);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(interpretations);
        } catch (IOException e) {
            System.err.println("could not save interpretations to file.");
        }
    }

    private static void initializeDefaultInterpretations() {
        interpretations.put("Deserter", new TreeMap<String, Pair<String, String>>() {
            {
                put("Dampak dan pengaruh", new Pair<>("Enggan mengarahkan timnya.", "K"));
                put("Kesadaran berorganisasi", new Pair<>("Enggan memahami tata cara dan tata kelola organisasi karena ada keenganan tersendiri untuk menyelesaikan tugasnya sendiri sehingga terkesan mengabaikan anggota timnya.", "K"));
                put("Membangun Hubungan Kerja", new Pair<>("Masih mampu membangun relasi sosial atau jaringan relasi sosial yang normatif ketika dalam kerja kelompok, yang mana sangat berjarak dengan orang lain.", "K/C-"));
                put("Mengembangkan orang lain", new Pair<>("Enggan mengajarkan atau enggan mendorong proses belajar orang lain.", "K/C-"));
                put("Mengarahkan orang lain", new Pair<>("Meski secara keseluruhan enggan, namun masih mau untuk memerintah dan mengatur orang lain untuk mengatur sesuatu sesuai posisi dan kewenangannya, terutama atas dasar perintah atasan atau mandat dari aturan baku.", "C-"));
                put("Memimpin kelompok", new Pair<>("Lebih suka menghindari peran sebagai pemimpin kelompok, meski saat dipaksa maka masih mampu menjalankan peran tersebut dengan bentuk tindakan secara instruktif.", "C-"));
            }
        });

        interpretations.put("Compromiser", new TreeMap<String, Pair<String, String>>() {
            {
                put("Dampak dan pengaruh", new Pair<>("Masih mampu mengarahkan anggota timnya, namun lebih mengutamakan terjalinnya keakraban dibandingkan mengelola tugasnya.", "C-"));
                put("Kesadaran berorganisasi", new Pair<>("Bersedia memahamu sebagian tata cara dan tata kelola organisasi dengan tujuan utama agar bisa menjalin hubungan baik dan kesan baik bagi setiap anggotanya.", "C-"));
                put("Membangun Hubungan Kerja", new Pair<>("Mampu membangun relasi sosial atau jaringan relasi sosial yang hangat dan akrab dalam kerja kelompok", "B/C+"));
                put("Mengembangkan orang lain", new Pair<>("Kadang masih mau mengajarkan atau mendorong proses belajar orang lain.", "C-"));
                put("Mengarahkan orang lain", new Pair<>("Masih mau memerintah dan mengatur orang lain untuk melakukan sesuatu sesuai posisi dan kewenangannya, namun seringkali mengesampingkannya demu terjaganya hubungan.", "K/C-"));
                put("Memimpin kelompok", new Pair<>("Mampu berperan sebagai pemimpin kelompok yang mengutamakan keakraban.", "C-"));
            }
        });

        interpretations.put("Missionary", new TreeMap<String, Pair<String, String>>() {
            {
                put("Dampak dan pengaruh", new Pair<>("Masih mampu mengarahkan anggota timnya, terutama dengan pendekatan keakraban.", "C-"));
                put("Kesadaran berorganisasi", new Pair<>("Bersedia memahami seluruh tata cara dan tata kelola organisasi, dengan tujuan utama agar bisa menjalin hubungan baik dan kesan baik bagi setiap anggota timnya.", "C-"));
                put("Membangun Hubungan Kerja", new Pair<>("Mampu membangun relasi sosial atau jaringan relasi sosial yang hangat dan akrab dalam kerja kelompok", "B/C+"));
                put("Mengembangkan orang lain", new Pair<>("Kadang masih mau mengajarkan atau mendorong proses belajar orang lain.", "C-"));
                put("Mengarahkan orang lain", new Pair<>("Masih mau memerintah dan mengatur orang lain untuk melakukan sesuatu sesuai posisi dan kewenangannya, namun seringkali mengesampingkannya demu terjaganya hubungan.", "K/C-"));
                put("Memimpin kelompok", new Pair<>("Mampu berperan sebagai pemimpin kelompok yang mengutamakan keakraban.", "C-"));
            }
        });

        interpretations.put("Buereaucrat", new TreeMap<String, Pair<String, String>>() {
            {
                put("Dampak dan pengaruh", new Pair<>("Cukup mampu mengarahkan anggota timnya, terutama dengan pendekatan instruktif.", "C-"));
                put("Kesadaran berorganisasi", new Pair<>("Bersedia memahami seluruh tata cara dan tata kelola organisasi, dengan tujuan utama agar bisa mendapatkan cara mengatur setiap anggota timnya berdasarkan aturan baku yang tersedia.", "K/C-"));
                put("Membangun Hubungan Kerja", new Pair<>("Masih mampu membangun relasi sosial atau jaringan relasi sosial yang normatif ketika dalam kerja kelompok, yang mana sangat berjarak dengan orang lain.", "K/C-"));
                put("Mengembangkan orang lain", new Pair<>("Enggan mengajarkan atau enggan mendorong proses belajar orang lain.", "K/C-"));
                put("Mengarahkan orang lain", new Pair<>("Masih mau memerintah dan mengatur orang lain untuk melakukan sesuatu sesuai posisi dan kewenangannya, terutama atas dasar perintah atasan atau mandat dari aturana baku.", "C"));
                put("Memimpin kelompok", new Pair<>("Mampu berperan sebagai pemimpin kelompok yang bertindak secara instruktif.", "C"));
            }
        });

        interpretations.put("Autocrat", new TreeMap<String, Pair<String, String>>() {
            {
                put("Dampak dan pengaruh", new Pair<>("Cukup mampu mengarahkan anggota timnya dengan pendekata instruktif", "C-"));
                put("Kesadaran berorganisasi", new Pair<>("Bersedia memahami sebagian besar tata cara dan tata kelola organisasi, dengan tujuan utama agar bisa mengatur bagi setiap anggota timnya disertai tetap mengutamakan meninggalkan kesan baik bagi mereka.", "C+"));
                put("Membangun Hubungan Kerja", new Pair<>("Masih mampu membangun relasi sosial atau jaringan relasi sosial dalam kerja kelompok, meski agar berjarak dengan orang lain.", "C-"));
                put("Mengembangkan orang lain", new Pair<>("Mampu mengajarkan atau mendorong proses belajar orang lain.", "B/C+"));
                put("Mengarahkan orang lain", new Pair<>("Mau memerintah dan mengatur orang lain untuk melakukan sesuatu sesuai posisi dan kewenangannya.", "B/C+"));
                put("Memimpin kelompok", new Pair<>("Mampu berperan sebagai pemimpin kelompok yang bertindak secara kolegial.", "C+"));
            }
        });

        interpretations.put("Autocrat", new TreeMap<String, Pair<String, String>>() {
            {
                put("Dampak dan pengaruh", new Pair<>("Cukup mampu mengarahkan anggota timnya dengan pendekata instruktif", "C"));
                put("Kesadaran berorganisasi", new Pair<>("Bersedia memahami beberapa tata cara dan tata kelola organisasi, dengan tujuan utama agar bisa menyelesaikan tugasnya sendiri meski terkesan mengabaikan anggota timnya.", "K/C-"));
                put("Membangun Hubungan Kerja", new Pair<>("Masih mampu membangun relasi sosial atau jaringan relasi sosial yang normatif ketika dalam kerja kelompok, yang mana sangat berjarak dengan orang lain.", "K/C-"));
                put("Mengembangkan orang lain", new Pair<>("Enggan mengajarkan atau enggan mendorong proses belaja orang lain.", "K/C-"));
                put("Mengarahkan orang lain", new Pair<>("Mau memerintah dan mengatur orang lain untuk melakukan sesuatu sesuai posisi dan kewenangannya, terutama atas dasar perintah atasan atau mandat dari aturan baku.", "C"));
                put("Memimpin kelompok", new Pair<>("Mampu berperan sebagai pemimpin kelompok yang bertindak secara instruktif.", "C"));
            }
        });

        interpretations.put("Benevolent Autocrat", new TreeMap<String, Pair<String, String>>() {
            {
                put("Dampak dan pengaruh", new Pair<>("Cukup mampu mengarahkan anggota timnya dengan pendekatan instruktif", "C-"));
                put("Kesadaran berorganisasi", new Pair<>("Bersedia memahami sebagian besar tata cara dan tata kelola organisasi, dengan tujuan utama agar bisa mengatur bagi setiap anggota timnya disertai tetap mengutamakan meninggalkan kesan baik bagi mereka.", "C+"));
                put("Membangun Hubungan Kerja", new Pair<>("Cukup mampu membangun relasi sosial atau jaringan relasi sosial dalam kerja kelompok, meski agar berjarak dengan orang lain.", "C-"));
                put("Mengembangkan orang lain", new Pair<>("Mau mengajarkan atau mendorong proses belajar orang lain.", "B/C+"));
                put("Mengarahkan orang lain", new Pair<>("Mau memerintah dan mengatur orang lain untuk melakukan sesuatu sesuai posisi dan kewenangannya.", "B/C+"));
                put("Memimpin kelompok", new Pair<>("Mampu berperan sebagai pemimpin kelompok yang bertindak secara instruktif.", "C"));
            }
        });

        interpretations.put("Developer", new TreeMap<String, Pair<String, String>>() {
            {
                put("Dampak dan pengaruh", new Pair<>("Mampu mengarahkan anggota timnya pada orientasi pengembangan diri, dan lebih fokus pada hal tersebut dibandingkan orientasi pada pencapaian target kerja.", "C-"));
                put("Kesadaran berorganisasi", new Pair<>("Bersedia memahami sebagian besar tata cara dan tata kelola organisasi, dengan tujuan utama agar bisa mendorong setiap anggota timnya untuk berkembang seoptimal mungkin.", "C+"));
                put("Membangun Hubungan Kerja", new Pair<>("Mampu membangun relasi sosial atau jaringan sosial yang hangat dan akrab dalam kerja kelompok, atas dasar pendekatan kolegial.", "C+"));
                put("Mengembangkan orang lain", new Pair<>("Mau mengajarkan atau mendorong proses belajar orang lain.", "B/C+"));
                put("Mengarahkan orang lain", new Pair<>("Mau memerintah dan mengatur orang lain untuk melakukan sesuatu sesuai posisi dan kewenangannya.", "B/C+"));
                put("Memimpin kelompok", new Pair<>("Mampu berperan sebagai pemimpin kelompok yang bertindak secara kolegial.", "C"));
            }
        });

        interpretations.put("Executive", new TreeMap<String, Pair<String, String>>() {
            {
                put("Dampak dan pengaruh", new Pair<>("Mampu mengarahkan timnya secara profesional.", "B"));
                put("Kesadaran berorganisasi", new Pair<>("Bersedia memahami seluruh tata cara dan tata kelola organisasi, dengan tujuan utama agar bisa mengelola timnya secara profesional", "B"));
                put("Membangun Hubungan Kerja", new Pair<>("Mampu membangun relasi sosial atau jaringan relasi sosial yang hangat dan akrab dalam kerja kelompok.", "B"));
                put("Mengembangkan orang lain", new Pair<>("Mau mengajarkan atau mendorong proses belajar orang lain.", "B/C+"));
                put("Mengarahkan orang lain", new Pair<>("Mau memerintah dan mengatur orang lain untuk melakukan sesuatu sesuai posisi dan kewenangannya.", "B/C+"));
                put("Memimpin kelompok", new Pair<>("Mampu berperan sebagai pemimpin kelompok yang memberi motivasi.", "B"));
            }
        });

    }

    static class Pair<T, U> implements Serializable {

        private T first;
        private U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;

        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean loadInterpretationsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
            interpretations = (Map<String, NavigableMap<String, Pair<String, String>>>) ois.readObject();
            return true;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("could not load interpretations from file, using defaullts.");
            return false;
        }
    }

    public DefaultTableModel chooseCombo(String choice) {
        if (choice == null || choice.isEmpty()) {
            System.err.println("Error: The choice parameter is null or empty.");
            return new DefaultTableModel(new String[]{"Aspek", "Deskripsi", "Skor"}, 0);
        }

        try {
            String[] columns = {"Aspek", "Deskripsi", "Skor"};
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            for (Map.Entry<String, NavigableMap<String, Pair<String, String>>> entry : interpretations.entrySet()) {
                if (choice.equals(entry.getKey())) {
                    NavigableMap<String, Pair<String, String>> aspects = entry.getValue();

                    for (Map.Entry<String, Pair<String, String>> val : aspects.entrySet()) {
                        String aspek = val.getKey();
                        Pair<String, String> pair = val.getValue();
                        String deskripsi = pair.getFirst();
                        String skor = pair.getSecond();

                        model.addRow(new String[]{aspek, deskripsi, skor});
                    }

                    return model;
                }
            }
            System.out.println("Warning: No data found for choice: " + choice);
            return model;

        } catch (Exception e) {
            System.err.println("Error: Could not input interpretations to table. " + e.getMessage());
            return new DefaultTableModel(new String[]{"Aspek", "Deskripsi", "Skor"}, 0);
        }
    }

    public static void setInterpretation() {

    }

    public List<AspectScore> setAspect(JTable table) {
        List<AspectScore> score = new ArrayList<>();
        TableModel model = table.getModel();

        for (int row = 0; row < model.getRowCount(); row++) {
            String aspek = (String) model.getValueAt(row, 0);
            String uraian = (String) model.getValueAt(row, 1);
            String skor = (String) model.getValueAt(row, 2);

            score.add(new AspectScore(aspek, uraian, skor));
        }

        return score;
    }

    public static void produceReport() {
        String fileName = "msdt/resources/report/msdtReport.jasper";

        try {
            SimpleDateFormat originalFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
            String formattedDate = "";
            SimpleDateFormat newFormat = new SimpleDateFormat("dd MMMM yyyy");
        } catch (Exception e) {
            System.err.println("1: " + e);
        }
//
//        Map<String, Object> parameter = new HashMap<String, Object>();
//
//        nilai = score.setAspect(hasilTable);
//
//        parameter.put("nama", namaInput.getText());
//        parameter.put("jenis", combobox.getSelectedItem().toString());
//
//        JRBeanCollectionDataSource tabelVal
//                = new JRBeanCollectionDataSource(nilai);
//
//        parameter.put("msdt", tabelVal);
//
//        InputStream stream = Main.class.getResourceAsStream(fileName);
//        try {
//            JasperPrint jasperprint = JasperFillManager.fillReport(
//                    ClassLoader.getSystemResourceAsStream(fileName),
//                    parameter, new JREmptyDataSource());
//        } catch (JRException ex) {
//            Logger.getLogger(MSDTForm.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
