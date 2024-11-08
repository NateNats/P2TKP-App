package papi_costic.resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class ScoreInterpreter {
    private static final String DATA_FILE_PATH = "./IST_App/src/papi_costic/resource/data/interpretations.dat";
    private Map<String, NavigableMap<Integer, String>> interpretations = new TreeMap<>();

    public ScoreInterpreter() {
        if (!loadInterpretationsFromFile()) {
            initializeDefaultInterpretations();
            saveInterpretationsToFile();
        }
    }

    public void saveInterpretationsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))) {
            oos.writeObject(interpretations);
        } catch (IOException e) {
            System.err.println("Could not save interpretations to file.");
        }
    }

    @SuppressWarnings("unchecked")
    private boolean loadInterpretationsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
            interpretations = (Map<String, NavigableMap<Integer, String>>) ois.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load interpretations from file, using defaults.");
            return false;
        }
    }

    public String interpretScore(String category, int score) {
        NavigableMap<Integer, String> interpretationMap = interpretations.get(category);
        if (interpretationMap == null) {
            return "Unknown category";
        }

        return interpretationMap.floorEntry(score).getValue();
    }

    private void initializeDefaultInterpretations() {
        // L - Leadership Role
        interpretations.put("L", new TreeMap<>(Map.of(
                0, "cenderung enggan menerima peran pemimpin, disertai kurangnya inisiatif menjalankannya.",
                5, "cenderung mau menerima peran pemimpin serta penuh inisiatif dalam menjalankannya.")));
        // P - Need to Control Others
        interpretations.put("P", new TreeMap<>(Map.of(
                0, "enggan mengendalikan orang lain atau tim.",
                5, "butuh mengendalikan orang lain atau tim.")));
        // I - Ease in Decision Making
        interpretations.put("I", new TreeMap<>(Map.of(
                0, "enggan untuk berperan sebagai pengambil suatu keputusan.",
                3,
                "seringkali tampak sangat ragu saat berperan mengambil keputusan, meski sesekali masih ragu-ragu.",
                5, "cukup mudah saat berperan mengambil keputusan, meski sesekali masih ragu-ragu.",
                8, "penuh percaya diri saat berperan sebagai pengambil keputusan.")));
        // F - Need to Support Authority
        interpretations.put("F", new TreeMap<>(Map.of(
                0,
                "tidak butuh mendukung pemegang otoritas, karena secara terbuka akan menolak permintaan mengabdikan diri pada kepentingan perusahaan.",
                3,
                "kurang butuh mendukung pemegang otoritas, karena lebih memilih mendahulukan kepentingannya sendiri terlebih dahulu, setiap kali ada kesempatan.",
                4,
                "butuh mendukung pemegang otoritas, atas dasar rasa tulus untuk mengabdikan diri terhadap perusahaan.",
                6,
                "butuh mendukung pemegang otoritas, atas dasar suatu pamrih dari sikap setia dan membantu yang Ia tunjukkan.")));
        // W - Need for Rules and Supervision
        interpretations.put("W", new TreeMap<>(Map.of(
                0,
                "kurang butuh aturan dan pengawasan, karena ingin mandiri dalam mencapai suatu tujuan yang diberikan kepadanya.",
                4, "butuh arahan dan bimbingan terlebih dahulu, baru berani memulai sendiri hingga selesai.",
                6, "butuh arahan dan perintah sepanjang proses pencapaian suatu tujuan hingga selesai.")));
        // T - Pace
        interpretations.put("T", new TreeMap<>(Map.of(
                0, "tampak santai, karena ingin tugas diselesaikan menurut ukuran dan kemauannya sendiri.",
                4, "tampak sibuk, karena ingin tugas diselesaikan secara efektif dan efisien.")));
        // V - Vigorous Type
        interpretations.put("V", new TreeMap<>(Map.of(
                0, "tampak kurang berdaya dan cenderung akan pasif secara fisik.",
                5, "tampak penuh semangat dan cenderung akan aktif secara fisik.")));
        // R - Theoretical Type
        interpretations.put("R", new TreeMap<>(Map.of(
                0,
                "tampak sebagai praktisi, cenderung mengandalkan pendekatan praktis dalam memecahkan masalah.",
                5,
                "tampak sebagai analis-teoris, cenderung mengandalkan penalaran yang logis dalam memecahkan masalah.")));
        // D - Interest in Working With Details
        interpretations.put("D", new TreeMap<>(Map.of(
                0,
                "tampak suka gambaran besar, karena sadar perlu bertindak cermat namun enggan memperhatikan detil tindakannya.",
                4,
                "tampak suka gambaran detil, karena sadar perlu bertindak cermat disertai upaya untuk memperhatikan detil tindakannya.")));
        // C - Organized Type
        interpretations.put("C", new TreeMap<>(Map.of(
                0,
                "tampak suka mengalah, karena penuh kompromi dalam melakukan pengaturan, disertai kurangnya perhatian pada sistematika tindakan.",
                3,
                "tampak suka bernegosiasi, karena ada beberapa kompromi dalam melakukan pengaturan, namun lebih fokus pada sistematika tindakan.",
                6,
                "tampak suka birokrasi, karena kurang kompromi dalam pengaturan, serta sangat fokus pada terpenuhinya sistematika tindakan secara kaku.")));
        // X - Need to be Noticed
        interpretations.put("X", new TreeMap<>(Map.of(
                0,
                "tampak menyendiri, karena cenderung pemalu, serta enggan jadi pusat perhatian.",
                2,
                "tampak membuka diri sepenuhnya, karena membuka diri secara tulus, tanpa dilandasi keinginan jadi pusat perhatian.",
                4,
                "tampak membuka diri secara hati-hati, karena membuka diri yang disertai pamrih, yang dilandasi keinginan jadi pusat perhatian.",
                6,
                "tampak membuka diri secara agresif, karena aktif memperoleh perhatian orang lain, hingga semua orang menjadikannya pusat perhatian.")));
        // B - Need to Belong to Groups
        interpretations.put("B", new TreeMap<>(Map.of(
                0,
                "tampak menjaga jarak dalam kelompok, pemilih dalam hal bergabung ke kelompok.",
                4,
                "tampak membuka diri secara hati-hati dalam kelompok, karena agak pemilih dalam hal bergabung dalam kelompok, yang mana di satu sisi ingin diterima namun tidak serta merta mau menerima pengaruh dari kelompok yang diikuti.",
                6,
                "tampak membuka diri sepenuhnya dalam kelompok, karena cenderung sangat butuh disukai dan diakui, sehingga mudah menerima pengaruh dari kelompok yang diikuti.")));
        // O - Need for Closeness and Affection
        interpretations.put("O", new TreeMap<>(Map.of(
                0,
                "tampak enggan dekat secara personal, karena tidak suka terlalu dekat secara perorangan.",
                3,
                "tampak mau dekat secara personal namun disertai kehati-hatian, karena tidak terlalu kesepian jika tidak ada yang dekat secara perorangan, serta tidak menolak jika ada yang ingin dekat secara perorangan.",
                5,
                "tampak sangat aktif berusaha dekat secara personal, karena akan kesepian jika tidak ada yang dekat secara perorangan, serta sangat antusias jika ada yang ingin dekat secara perorangan.")));
        // S - Social Extension
        interpretations.put("S", new TreeMap<>(Map.of(
                0, "kurang berminat pada hubungan sosial, karena sulit percaya orang lain.",
                7, "sangat berminat pada hubungan sosial, karena mudah percaya orang lain.")));
        // N - Need to Finish Task
        interpretations.put("N", new TreeMap<>(Map.of(
                0,
                "butuh menghindari penyelesaian tugas secara mandiri, karena ingin menunda atau menghindari menyelesaikan pekerjaan, saat diminta menyelesaikan suatu tugas.",
                4,
                "butuh menyelesaikan beberapa tugas secara mandiri, karena cenderung ingin mengerjakan sebagian kecil pekerjaan sampai tuntas, saat diminta menyelesaikan suatu tugas.",
                6,
                "butuh menyelesaikan sebagian besar tugas secara mandiri, karena cenderung ingin mengerjakan sebagian besar pekerjaan sampai tuntas, saat diminta menyelesaikan suatu tugas.",
                7,
                "butuh menyelesaikan semua tugas secara mandiri, karena cenderung ingin mengerjakan semua pekerjaan sampai tuntas, saat diminta menyelesaikan suatu tugas.")));
        // A - Need to Achieve
        interpretations.put("A", new TreeMap<>(Map.of(
                0,
                "tidak butuh berprestasi, karena prestasi seringkali tidak ingin dicapai karena tujuannya tidak pasti, kurang berambisi, serta mudah puas pada suatu pencapaian yang kurang tinggi.",
                6,
                "butuh berprestasi, karena prestasi seringkali mudah dicapai karena tujuannya jelas, berambisi tinggi, serta sangat menginginkan kesuksesan.")));
        // G - Hard Intense Worked
        interpretations.put("G", new TreeMap<>(Map.of(
                0, "enggan bekerja keras.",
                3, "bekerja untuk kesenangan saja.",
                5, "bekerja keras penuh semangat.")));
        // Z - Need for Change
        interpretations.put("Z", new TreeMap<>(Map.of(
                0,
                "butuh kestabilan, karena suka hal-hal yang pasti dan tetap tanpa perubahan sama sekali.",
                3,
                "butuh kestabilan namun sedikit terbuka pada hal dinamis, karena bisa menerima perubahan asalkan tidak disertai paksaan untuk segera mengikuti perubahan tersebut.",
                5,
                "butuh kestabilan yang bersumber dari penerimaan, sehingga mau mengikuti setiap tuntutan untuk berubah, tanpa banyak bertanya.",
                6,
                "butuh hal dinamis yang bisa dinegosiasikan, karena mau berubah mengikuti tuntutan berubah, asalkan ada kompromi dengan jalan menuju tujuan yang hendak Ia raih.",
                8,
                "butuh hal dinamis yang Ia bisa kendalikan sepenuhnya, karena enggan berkompromi dengan tuntutan untuk berubah, terutama bila perubahan tersebut mempengaruhi jalan menuju tujuan yang hendak Ia raih.")));
        // K - Need to be Forceful
        interpretations.put("K", new TreeMap<>(Map.of(
                0,
                "tidak butuh kendali, karena ingin menjauhi segala hal yang bisa melibatkannya dalam pusat permasalahan.",
                3,
                "butuh sedikit kendali, karena ingin tahu mengenai konflik yang terjadi terkait suatu permasalahan, dalam tujuan bisa memastikan posisi dan tindakannya yang bisa menjamin diperolehnya suasana aman dan minim konflik.",
                5,
                "butuh sebagian kendali, karena ingin tahu mengenai konflik yang terjadi terkait suatu permasalahan, dalam tujuan bisa memastikan posisi dan tindakannya agar bisa memperjuangkan pendapat atau keinginannya melalui kompromi dan negosiasi.",
                7,
                "butuh sebagian besar kendali, karena terlibat secara aktif dalam pusat konflik yang terjadi terkait suatu permasalahan, untuk memastikan masalah selesai.",
                8,
                "butuh kendali sepenuhnya, karena ingin terlibat secara aktif bahkan tampak agresif dalam pusat konflik yang terjadi terkait suatu permasalahan, untuk memastikan masalah selesai sesuai keinginannya, bahkan jika perlu harus menjatuhkan orang lain demi tujuan tersebut.")));
        // E - Emotional Resistant
        interpretations.put("E", new TreeMap<>(Map.of(
                0,
                "reaktif, bertindak tergesa-gesa tanpa pikir panjang, sehingga tampak kurang mampu mengontrol gejolak perasaannya.",
                2,
                "reaktif, bertindak tergesa-gesa tapi mulai mempertimbangkan beberapa situasi dan kondisi yang dihadapi, sehingga tampak mulai ada upaya mengontrol beberapa gejolak perasaannya.",
                4,
                "proaktif, bertindak penuh pertimbangan, sehingga tampak bisa mengontrol gejolak perasaannya.",
                7,
                "kaku, cenderung normatif, tindakannya harus selalu disesuaikan dengan aturan baku, sehingga tampak kurang ekspresif.")));
    }

    public static void main(String[] args) {
        ScoreInterpreter si = new ScoreInterpreter();
        System.out.println(si.interpretScore("I", 1));
        System.out.println(si.interpretScore("I", 2));
        System.out.println(si.interpretScore("I", 4));
        System.out.println(si.interpretScore("I", 6));
        System.out.println(si.interpretScore("I", 8));
    }
}
