/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IST.resource;

import IST.resource.RubrikCategory;

import java.io.*;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 *
 * @author nicol
 */
public class IST_ScoreInterpreterV2 {

    private static final String DATA_FILE_PATH = "./storage/IST_rubrik_interpretation.dat";
    private static final String DATA_FILE_PATH2 = "./storage/IST_rubrik_interpretFleksibel.dat";
    private static final String DATA_FILE_PATH3 = "./storage/IST_rubrik_interpretCorakBerpikir.dat";
    private static final String DATA_FILE_PATH4 = "./storage/IST_rubrik_interpretKecerdasan.dat";
    private static Map<RubrikCategory, NavigableMap<Range, String>> interpretations = new TreeMap<>();
    private static Map<Double, String> interpretFleksibel = new TreeMap<>();
    private static Map<Double, String> interpretCorakBerpikir = new TreeMap<>();
    private static Map<Double, String> interpretKecerdasan = new TreeMap<>();

    static {
        if (!loadInterpretationsFromFile() || !loadInterpretFleksibelFromFile() || !loadInterpretCorakBerpikirFromFile() || !loadInterpretKecerdasanFromFile()) {
            initializeDefaultInterpretations();
            saveInterpretationsToFile();
            saveInterpretFleksibelToFile();
            saveInterpretCorakBerpikirToFile();
            saveInterpretKecerdasanToFile();
        }
    }

    public static boolean saveInterpretationsToFile() {
        File file = new File(DATA_FILE_PATH);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(interpretations);
            System.out.println("Interpretations saved to file.");
        } catch (IOException e) {
            System.err.println("Could not save interpretations to file: " + e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean saveInterpretFleksibelToFile() {
        File file = new File(DATA_FILE_PATH2);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(interpretFleksibel);
            System.out.println("Fleksibel interpretations saved to file.");
        } catch (IOException e) {
            System.err.println("Could not save fleksibel interpretations to file.");
            return false;
        }
        return true;
    }

    public static boolean saveInterpretCorakBerpikirToFile() {
        File file = new File(DATA_FILE_PATH3);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(interpretCorakBerpikir);
            System.out.println("Corak berpikir interpretations saved to file.");
        } catch (IOException e) {
            System.err.println("Could not save corak berpikir interpretations to file.");
            return false;
        }
        return true;
    }

    public static boolean saveInterpretKecerdasanToFile() {
        File file = new File(DATA_FILE_PATH4);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(interpretKecerdasan);
            System.out.println("Kecerdasan interpretations saved to file.");
        } catch (IOException e) {
            System.err.println("Could not save kecerdasan interpretations to file.");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    private static boolean loadInterpretationsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
            interpretations = (Map<RubrikCategory, NavigableMap<Range, String>>) ois.readObject();
            System.out.println("Interpretations loaded from file.");
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load interpretations from file, using defaults.");
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean loadInterpretFleksibelFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH2))) {
            interpretFleksibel = (Map<Double, String>) ois.readObject();
            System.out.println("Fleksibel interpretations loaded from file.");
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load fleksbiel interpretations from file, using defaults.");
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean loadInterpretCorakBerpikirFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH3))) {
            interpretCorakBerpikir = (Map<Double, String>) ois.readObject();
            System.out.println("Corak berpikir interpretations loaded from file.");
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load interpretations from file, using defaults.");
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean loadInterpretKecerdasanFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH4))) {
            interpretKecerdasan = (Map<Double, String>) ois.readObject();
            System.out.println("Kecerdasan interpretations loaded from file.");
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load fleksbiel interpretations from file, using defaults.");
            return false;
        }
    }

    public static void initializeDefaultInterpretations() {

        // Taraf Kecerdasan
        interpretations.put(RubrikCategory.TARAF_KECERDASAN, new TreeMap<Range, String>() {
            {
                put(new Range(0, 83.9999), "Cakupan wawasannya bahkan cukup sulit untuk menyelesaikan persoalan sederhana.");
                put(new Range(84, 89.9999), "Cakupan wawasannya hanya cukup untuk menyelesaikan persoalan sederhana.");
                put(new Range(90, 98.9999), "");
                put(new Range(99, 109.9999), "Cakupan wawasannya cukup membantunya menyelesaikan persoalan sedikit kompleks.");
                put(new Range(110, 119.9999), "Cakupan wawasannya cukup membantunya menyelesaikan persoalan cukup kompleks.");
                put(new Range(120, 129.9999), "Cakupan wawasannya cukup membantunya menyelesaikan sebagian besar persoalan kompleks.");
                put(new Range(130, Double.MAX_VALUE), "Cakupan wawasannya cukup membantunya menyelesaikan berbagai persoalan kompleks.");
            }
        });

        // Kemampuan berpikir komprehensif
        interpretations.put(RubrikCategory.BERPIKIR_KOMPREHENSIF, new TreeMap<Range, String>() {
            {
                put(new Range(0, 83.9999), "Sulit mempertimbangkan informasi yang tersedia karerna kurang ulet mencari keterkaitan antar informasi.");
                put(new Range(84, 89.9999), "Bisa mempertimbangkan sebagian kecil informasi yang tersedia karena masih bersedia mencari sebagian kecil keterkaitan antar informasi.");
                put(new Range(90, 98.9999), "");
                put(new Range(99, 109.9999), "Bisa mempertimbangkan beberapa informasi yang tersedia karena masih bersedia mencari beberapa bagian keterkaitan antar informasi.");
                put(new Range(110, 119.9999), "Bisa mempertimbangkan sebagian informasi yang tersedia karena masih bersedia mencari sebagian keterkaitan antar informasi.");
                put(new Range(120, 129.9999), "Mempertimbangkan sebagian besar informasi yang tersedia karena cukup ulet mencari keterkaitan antar informasi.");
                put(new Range(130, Double.MAX_VALUE), "Sangat mempertimbangkan informasi yang tersedia karena ulet mencari keterkaitan antar informasi.");
            }
        });

        // Kemampuan mengolah angka
        interpretations.put(RubrikCategory.MENGOLAH_ANGKA, new TreeMap<Range, String>() {
            {
                put(new Range(0, 83.9999), "Sulit berpikir teratur dan logis dalam menyelesaikan persoalan perhitungan, baik itu masalah rutin dan masalah insidental.");
                put(new Range(84, 89.9999), "Bisa berpikir teratur dan logis dalam menyelesaikan persoalan perhitungan, namun sebatas masalah rutin atau masalah umum.");
                put(new Range(90, 98.9999), "");
                put(new Range(99, 109.9999), "Bisa berpikir teratur dan logis dalam menyelesaikan persoalan perhitungan, baik itu masalah rutin dan sebagian kecil masalah insidental.");
                put(new Range(110, 119.9999), "Bisa berpikir teratur dan logis dalam menyelesaikan persoalan perhitungan, baik itu masalah rutin dan sebagian masalah insidental.");
                put(new Range(120, 129.9999), "Bisa berpikir teratur dan logis dalam menyelesaikan persoalan perhitungan, baik itu masalah rutin dan sebagian besar masalah insidental.");
                put(new Range(130, Double.MAX_VALUE), "Bisa berpikir teratur dan logis dalam menyelesaikan persoalan perhitungan, baik itu masalah rutin dan masalah insidental.");
            }
        });

        // Daya ingat
        interpretations.put(RubrikCategory.DAYA_INGAT, new TreeMap<Range, String>() {
            {
                put(new Range(0, 83.9999), "Daya ingat yang terbatas, akibat sulit berkonsentrasi.");
                put(new Range(84, 89.9999), "Daya ingat pada hal-hal sederhana, karena agak sulit berkonsentrasi.");
                put(new Range(90, 98.9999), "");
                put(new Range(99, 109.9999), "Daya ingat pada hal-hal agak kompleks, karena bisa berkonsentrasi pada hal-hal agak rumit tersebut.");
                put(new Range(110, 119.9999), "Daya ingat pada hal-hal cukup kompleks, karena bisa berkonsentrasi pada hal-hal cukup rumit tersebut.");
                put(new Range(120, 129.9999), "Daya ingat pada sebagian besar hal-hal kompleks, karena bisa berkonsentrasi pada sebagian besar hal-hal rumit tersebut.");
                put(new Range(130, Double.MAX_VALUE), "Daya ingat kuat, karena bisa berkonsentrasi pada berbagai hal.");
            }
        });

        // Kreativitas
        interpretations.put(RubrikCategory.KREATIVITAS, new TreeMap<Range, String>() {
            {
                put(new Range(0, 83.9999), "Sulit membuat perubahan yang mengarah pada perbaikan dan pembaharuan tanpa meniru orang lain.");
                put(new Range(84, 89.9999), "Mampu membuat perubahan yang mengarah pada perbaikan dan pembaharuan, namun kurang orisional.");
                put(new Range(90, 98.9999), "");
                put(new Range(99, 109.9999), "Mampu membuat beberapa hal kecil mengenai perubahan, yang mengarah pada perbaikan dan pembaharuan yang orisional.");
                put(new Range(110, 119.9999), "Mampu membuat sebagian perubahan, yang mengarah pada perbaikan dan pembaharuan yang orisional.");
                put(new Range(120, 129.9999), "Mampu membuat sebagian besar perubahan, yang mengarah pada perbaikan dan pembaharuan yang orisional.");
                put(new Range(130, Double.MAX_VALUE), "Mampu membuat berbagai perubahan, yang mengarah pada perbaikan dan pembaharuan yang orisional.");
            }
        });

        // Menilai
        interpretations.put(RubrikCategory.MENILAI, new TreeMap<Range, String>() {
            {
                put(new Range(0, 83.9999), "Sulit menilai keadaan terkait suatu masalah karena enggan mencari informasi informasi, sehingga kesulitan menetapkan prioritas dan pilihan perhatian serta pilihan solusi, bahkan yang paling sederhana.");
                put(new Range(84, 89.9999), "Masih bisa menilai beberapa keadaan terkait suatu masalah berbekal informasi yang sanggup diakses secara mudah, sehingga masih mampu menetapkan beberapa prioritas dan pilihan perhatian serta pilihan solusi biasa dilakukan sehari-hari.");
                put(new Range(90, 98.9999), "");
                put(new Range(99, 109.9999), "Mampu menilai sebagian kecil keadaan terkait suatu masalah berbekal beberapa informasi agak aktual, sehingga mampu menetapkan prioritas dan pilihan perhatian serta pilihan solusi agak kompleks.");
                put(new Range(110, 119.9999), "Mampu menilai sebagian keadaan terkait suatu masalah berbekal beberapa informasi cukup aktual, sehingga mampu menetapkan beberapa prioritas dan pilihan perhatian serta pilihan solusi yang cukup kompleks.");
                put(new Range(120, 129.9999), "Mampu menilai sebagian besar keadaan terkait suatu masalah berbekal berbagai informasi aktual, sehingga mampu menetapkan beberapa prioritas serta pilihan perhatian dan pilihan solusi yang cukup dibutuhkan.");
                put(new Range(130, Double.MAX_VALUE), "Mampu menilai keadaan terkait suatu masalah berbekal berbagai informasi aktual, sehingga mampu menetapkan prioritas dan pilihan perhatian serta pilihan solusi yang paling dibutuhkan.");
            }
        });

        // Analisis
        interpretations.put(RubrikCategory.ANALISIS, new TreeMap<Range, String>() {
            {
                put(new Range(0, 83.9999), "Sulit membandingkan informasi yang diperoleh, dalam tujuan menemukan persamaan, perbedaan, hubungan, dan pengaruhnya satu sama lain.");
                put(new Range(84, 89.9999), "Mampu membandingkan beberapa informasi yang diperoleh, untuk menemukan beberapa hal sederhana terkait persamaan, perbedaan, hubungan, dan pengaruhnya satu sama lain.");
                put(new Range(90, 98.9999), "");
                put(new Range(99, 109.9999), "Mampu membandingkan sebagian kecil informasi yang diperoleh, untuk menemukan beberapa hal agak kompleks terkait persamaan, perbedaan, hubungan, dan pengaruhnya satu sama lain.");
                put(new Range(110, 119.9999), "Mampu membandingkan sebagian informasi yang diperoleh, untuk menemukan beberapa hal agak kompleks terkait persamaan, perbedaan, hubungan, dan pengaruhnya satu sama lain.");
                put(new Range(120, 129.9999), "Mampu membandingkan sebagian besar informasi yang diperoleh, untuk menemukan sebagian besar persamaan, perbedaan, hubungan, atau pengaruh yang kompleks satu sama lain.");
                put(new Range(130, Double.MAX_VALUE), "Mampu membandingkan berbagai informasi yang diperoleh, untuk menemukan berbagai persamaan, perbedaan, hubungan, atau pengaruhnya yang kompleks satu sama lain.");
            }
        });

        // Mengambil keputusan
        interpretations.put(RubrikCategory.MENGAMBIL_KEPUTUSAN, new TreeMap<Range, String>() {
            {
                put(new Range(0, 83.9999), "Sulit mengambil keputusan, karena enggan memperhitungkan aspek persoalan dan alternatif solusi.");
                put(new Range(84, 89.9999), "Butuh waktu cukup lama dalam mengambil keputusan yang sederhana, yang memperhitungkan kebiasaan yang paling mudah dilakukan sebagai rujukan aspek persoalan dan alternatif solusi.");
                put(new Range(90, 98.9999), "");
                put(new Range(99, 109.9999), "Butuh beberapa mengambil keputusan  yang agak matang, yang memperhitungkan beberapa aspek persoalan dan beberapa alternatif solusi yang memungkinkan.");
                put(new Range(110, 119.9999), "Butuh beberapa waktu hingga bisa mengambil keputusan  yang cukup matang, yang memperhitungkan sebagian aspek persoalan dan sebagian alternatif solusi yang memungkinkan.");
                put(new Range(120, 129.9999), "Cepat mengambil keputusan  yang cukup matang, yang memperhitungkan sebagian besar aspek persoalan dan sebagian besar alternatif solusi yang memungkinkan.");
                put(new Range(130, Double.MAX_VALUE), "Cepat mengambil keputusan  yang matang, yang memperhitungkan semua aspek persoalan dan semua alternatif solusi yang memungkinkan.");
            }
        });

        // Kemampuan berbahasa
        interpretations.put(RubrikCategory.BERBAHASA, new TreeMap<Range, String>() {
            {
                put(new Range(0, 83.9999), "Sulit menangkap dan mengekspresikan gagasan, kemauan, dan perasaan dalam bentuk bahasa (verbal), dalam konteks komunikasi.");
                put(new Range(84, 89.9999), "Mampu menangkap dan mengekspresikan beberapa gagasan, kemauan, dan perasaan dalam bentuk bahasa (verbal) yang sederhana, dalam konteks komunikasi sederhana.");
                put(new Range(90, 98.9999), "");
                put(new Range(99, 109.9999), "Mampu menangkap dan mengekspresikan beberapa gagasan, kemauan, dan perasaan dalam bentuk bahasa (verbal), dalam konteks komunikasi agak kompleks.");
                put(new Range(110, 119.9999), "Mampu menangkap dan mengekspresikan sebagian gagasan, kemauan, dan perasaan dalam bentuk bahasa (verbal), dalam konteks komunikasi cukup kompleks.");
                put(new Range(120, 129.9999), "Mampu menangkap dan mengekspresikan sebagian besar gagasan, kemauan, dan perasaan dalam bentuk bahasa (verbal), dalam sebagian besar konteks kecermatan dan komunikasi.");
                put(new Range(130, Double.MAX_VALUE), "Mampu menangkap dan mengekspresikan gagasan, kemauan, dan perasaan dalam bentuk bahasa (verbal), dalam berbagai konteks komunikasi.");
            }
        });


        // Berpikir fleksibel

        interpretFleksibel.put(-10.0, "Cepat mencari jalan keluar ketika ada hambatan");
        interpretFleksibel.put(10.0, "Menggunakan satu jalan keluar yang biasa digunakan ketika ada hambatan");
        interpretFleksibel.put(0.0, "Corak berpikir belum terarah karena masih dalam taraf perkembangan");
        /*
         * nanti bandingin GERA dan ANZR, kalo selisih -10, bakal muncul fleksibel
         * kalo selisih 10, nanti muncul kaku
         * kalo selisih ga sampe 10, nanti bakal muncul belum terarah-belum konsisten
         * */

        // Jenis kecerdasan

        // Corak berpikir
        interpretCorakBerpikir.put(0.0, "Pola berpikirnya adalah normatif, dimana caranya mengenali, mengurai, hingga menyusun alternatif solusi pada permasalahan yang dihadapi, mayoritas mengandalkan pendekatan konsep atau rujukan teori yang sudah mapan.");
        interpretCorakBerpikir.put(10.0, "Cara berpikirnya adalah fleksibel, dimana caranya mengenali, mengurai, hingga menyusun alternatif solusi pada permasalahan yang dihadapi, mayoritas mengandalkan pengenalannya dari sisi kebiasaan sehari-hari dan mengandalkan pendekatan pengalaman yang terbukti pernah berhasil.");
        interpretCorakBerpikir.put(-10.0, "Corak cara berpikirnya terhitung belumg jelas. Hal tersebut ditandai oleh caranya mengenali, mengurai, hingga menyusun alternatif solusi pada permasalahan yang dihadapi, yang masih belum konsisten untuk diulang kembali di kesempatan lain.");
        /*
                  pake GE RA AN ZR, terus dibandingkan antara GERA dengan ANZR
                  Jika GERA mendekati ANZR, nanti muncul birokratis-normatif
                  Kalo ANZR mendekati GERA, nanti muncul fleksible
                  kalo GERA mendekati ANZR, nanti belum terarah-belum konsisten
        **/


        // Jenis kecerdasan
        interpretKecerdasan.put(0.0, "Menemukan pemecahan masalah tanpa hadirnya objek permasalahan secara nyata, sehingga cenderung efektif dalam menggunakan konsep serta simbol ketika menyelesaikan masalah.");
        interpretKecerdasan.put(10.0, "Menemukan pemecahan masalah wajib menghadirkan objek permasalahan secara nyata, sehingga cenderung efektif dalam menggunakan temuan konkrit ketika menyelesaikan masalah.");
        /*
                WA & GE cenderung lebih tinggi SE & AN => Tipe pemikiran teoritis-konseptual
                SE & AN cenderung lebih tinggi WA & GE => Tipe pemikiran praktis
        */
    }

    public String[] getInterpretation(RubrikCategory aspect, double score) {
        if (aspect.getLabel().equals(RubrikCategory.BERPIKIR_FLEKSIBEL.getLabel())) {
            return getInterpretFleksibel(score);
        } else if (aspect.getLabel().equals(RubrikCategory.JENIS_KECERDASAN.getLabel())) {
            return getInterpretJenisKecerdasan(score);
        } else if (aspect.getLabel().equals(RubrikCategory.CORAK_BERPIKIR.getLabel())) {
            return getInterpretCorakBerpikir(score);
        }

        NavigableMap<Range, String> interpretation = interpretations.get(aspect);

        for (Range range : interpretation.keySet()) {
            if (range.isInRange(score)) {
                return new String[]{String.valueOf(score), getNumScore(score), interpretation.get(range)};
            }
        }

        return null;
    }

    private static String[] getInterpretFleksibel(double score) {
        return new String[]{getNumScore(score), interpretFleksibel.get(score)};
    }

    private static String[] getInterpretJenisKecerdasan(double score) {
        return new String[]{getNumScore(score), interpretKecerdasan.get(score)};
    }

    private static String[] getInterpretCorakBerpikir(double score) {
        return new String[]{getNumScore(score), interpretCorakBerpikir.get(score)};
    }

    private static String getNumScore(double score) {
        if (score > 0 && score <= 83.9999) {
            return "KS";
        } else if (score >= 84 && score <= 89.9999) {
            return "K";
        } else if (score >= 90 && score <= 98.9999) {
            return "C-";
        } else if (score >= 99 && score <= 109.9999) {
            return "C";
        } else if (score >= 110 && score <= 119.9999) {
            return "C+";
        } else if (score >= 120 && score <= 129.9999) {
            return "B";
        }

        return "BS";
    }

    public static void reloadInterpretations() {
        interpretations.clear();
        interpretFleksibel.clear();
        interpretKecerdasan.clear();
        interpretCorakBerpikir.clear();

        if (!loadInterpretationsFromFile() || !loadInterpretFleksibelFromFile() || !loadInterpretCorakBerpikirFromFile() || !loadInterpretKecerdasanFromFile()) {
            initializeDefaultInterpretations();
            saveInterpretationsToFile();
            saveInterpretFleksibelToFile();
            saveInterpretCorakBerpikirToFile();
            saveInterpretKecerdasanToFile();
        }
    }
    
    public NavigableMap<Range, String> getCategoryInterpretation(RubrikCategory category) {
        return interpretations.get(category);
    }
    
    //  change the value of the interpretation
    public static void setInterpretation(RubrikCategory key, String[] val) {
        if (key.equals(RubrikCategory.BERPIKIR_FLEKSIBEL)) {
            interpretFleksibel.put(-10.0, val[0]);
            interpretFleksibel.put(10.0, val[1]);
            interpretFleksibel.put(0.0, val[2]);
            if (saveInterpretFleksibelToFile()) {
                System.out.println("Interpretation saved to file.");
            } else {
                System.err.println("Could not save interpretation to file.");
            }

        } else if (key.equals(RubrikCategory.JENIS_KECERDASAN)) {
            interpretKecerdasan.put(0.0, val[0]);
            interpretKecerdasan.put(10.0, val[1]);

            if (saveInterpretationsToFile()) {
                System.out.println("Interpretation saved to file.");
            } else {
                System.err.println("Could not save interpretation to file.");
            }

        } else if (key.equals(RubrikCategory.CORAK_BERPIKIR)) {
            interpretCorakBerpikir.put(0.0, val[0]);
            interpretCorakBerpikir.put(10.0, val[1]);
            interpretCorakBerpikir.put(-10.0, val[2]);

            if (saveInterpretCorakBerpikirToFile()) {
                System.out.println("Interpretation saved to file.");
            } else {
                System.err.println("Could not save interpretation to file.");
            }

        } else {
            interpretations.get(key).put(new Range(0, 83.9999), val[0]);
            interpretations.get(key).put(new Range(84, 89.9999), val[1]);
            interpretations.get(key).put(new Range(90, 98.9999), val[2]);
            interpretations.get(key).put(new Range(99, 109.9999), val[3]);
            interpretations.get(key).put(new Range(110, 119.9999), val[4]);
            interpretations.get(key).put(new Range(120, 129.9999), val[5]);
            interpretations.get(key).put(new Range(130, Double.MAX_VALUE), val[6]);

            if (saveInterpretationsToFile()) {
                System.out.println("Interpretation saved to file.");
            } else {
                System.err.println("Could not save interpretation to file.");
            }
        }
    }

    public static class Range implements Serializable, Comparable<Range> {

        private final double lowerBound;
        private final double upperBound;

        public Range(double lowerBound, double upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        public boolean isInRange(double value) {
            return value >= this.lowerBound && value <= this.upperBound;
        }

        @Override
        public String toString() {
            return "Range{" + "lowerBound=" + lowerBound + ", upperBound=" + upperBound + '}';
        }

        @Override
        public int compareTo(Range other) {
            // Bandingkan berdasarkan lowerBound, jika sama bandingkan upperBound
            if (this.lowerBound != other.lowerBound) {
                return Double.compare(this.lowerBound, other.lowerBound);
            }
            return Double.compare(this.upperBound, other.upperBound);
        }
    }

    public void showAllInterpretations() {
        for (RubrikCategory key : interpretations.keySet()) {
            System.out.println(key.getLabel());
            NavigableMap<Range, String> interpretation = interpretations.get(key);
            for (Range range : interpretation.keySet()) {
                System.out.println(range + " -> " + interpretation.get(range));
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        IST_ScoreInterpreterV2 interpreter = new IST_ScoreInterpreterV2();
//        String[] score = interpreter.getInterpretation(RubrikCategory.BERBAHASA, 100);
//        System.out.println("nilai: " + score[0]);
//        System.out.println("interpretasi: " + score[1]);
//
//    }
}