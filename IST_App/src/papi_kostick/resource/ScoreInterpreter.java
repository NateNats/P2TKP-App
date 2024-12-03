package papi_kostick.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * This class is used to interpret the score of the PAPI Kostick test.
 * 
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */

public class ScoreInterpreter {
    private static final String DATA_FILE_PATH = "./src/storage/kostick_interpretation.dat";
    private static Map<String, NavigableMap<Integer, String>> interpretations = new TreeMap<>();

    static {
        if (!loadInterpretationsFromFile()) {
            initializeDefaultInterpretations();
            saveInterpretationsToFile();
        }
    }

    public static void saveInterpretationsToFile() {
        File file = new File(DATA_FILE_PATH);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(interpretations);
        } catch (IOException e) {
            System.err.println("Could not save interpretations to file.");
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean loadInterpretationsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
            interpretations = (Map<String, NavigableMap<Integer, String>>) ois.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load interpretations from file, using defaults.");
            return false;
        }
    }

    public static String getInterpretation(String key, int score) {
        NavigableMap<Integer, String> interpretation = interpretations.get(key);
        if (interpretation == null) {
            return "No interpretation found for key " + key;
        }
        return interpretation.floorEntry(score).getValue();
    }

    private static void initializeDefaultInterpretations() {

        // L- Leadership Role
        interpretations.put("l", new TreeMap<Integer, String>() {
            {
                put(0, "Cenderung enggan menerima peran pemimpin, disertai kurangnya inisiatif menjalankannya.");
                put(5, "Cenderung mau menerima peran pemimpin serta penuh inisiatif dalam menjalankannya.");
            }
        });

        // P - Need to Control Others
        interpretations.put("p", new TreeMap<Integer, String>() {
            {
                put(0, "Enggan mengendalikan orang lain atau tim.");
                put(5, "Butuh mengendalikan orang lain atau tim.");
            }
        });

        // I - Ease in Decision Making
        interpretations.put("i", new TreeMap<Integer, String>() {
            {
                put(0, "Enggan untuk berperan sebagai pengambil suatu keputusan.");
                put(3, "Seringkali tampak sangat ragu saat berperan mengambil keputusan, meski sesekali masih ragu-ragu.");
                put(5, "Cukup mudah saat berperan mengambil keputusan, meski sesekali masih ragu-ragu.");
                put(8, "Penuh percaya diri saat berperan sebagai pengambil keputusan.");
            }
        });

        // F - Need to Support Authority
        interpretations.put("f", new TreeMap<Integer, String>() {
            {
                put(0, "Tidak butuh mendukung pemegang otoritas, karena secara terbuka akan menolak permintaan mengabdikan diri pada kepentingan perusahaan.");
                put(3, "Kurang butuh mendukung pemegang otoritas, karena lebih memilih mendahulukan kepentingannya sendiri terlebih dahulu, setiap kali ada kesempatan.");
                put(4, "Butuh mendukung pemegang otoritas, atas dasar rasa tulus untuk mengabdikan diri terhadap perusahaan.");
                put(6, "Butuh mendukung pemegang otoritas, atas dasar suatu pamrih dari sikap setia dan membantu yang Ia tunjukkan.");
            }
        });

        // W - Need for Rules and Supervision
        interpretations.put("w", new TreeMap<Integer, String>() {
            {
                put(0, "Kurang butuh aturan dan pengawasan, karena ingin mandiri dalam mencapai suatu tujuan yang diberikan kepadanya.");
                put(4, "Butuh arahan dan bimbingan terlebih dahulu, baru berani memulai sendiri hingga selesai.");
                put(6, "Butuh arahan dan perintah sepanjang proses pencapaian suatu tujuan hingga selesai.");
            }
        });

        // T - Pace
        interpretations.put("t", new TreeMap<Integer, String>() {
            {
                put(0, "Tampak santai, karena ingin tugas diselesaikan menurut ukuran dan kemauannya sendiri.");
                put(4, "Tampak sibuk, karena ingin tugas diselesaikan secara efektif dan efisien.");
            }
        });

        // V - Vigorous Type
        interpretations.put("v", new TreeMap<Integer, String>() {
            {
                put(0, "Tampak kurang berdaya dan cenderung akan pasif secara fisik.");
                put(5, "Tampak penuh semangat dan cenderung akan aktif secara fisik.");
            }
        });

        // R - Theoretical Type
        interpretations.put("r", new TreeMap<Integer, String>() {
            {
                put(0, "Tampak sebagai praktisi, cenderung mengandalkan pendekatan praktis dalam memecahkan masalah.");
                put(5, "Tampak sebagai analis-teoris, cenderung mengandalkan penalaran yang logis dalam memecahkan masalah.");
            }
        });

        // D - Interest in Working With Details
        interpretations.put("d", new TreeMap<Integer, String>() {
            {
                put(0, "Tampak suka gambaran besar, karena sadar perlu bertindak cermat namun enggan memperhatikan detil tindakannya.");
                put(4, "Tampak suka gambaran detil, karena sadar perlu bertindak cermat disertai upaya untuk memperhatikan detil tindakannya.");
            }
        });

        // C - Organized Type
        interpretations.put("c", new TreeMap<Integer, String>() {
            {
                put(0, "Tampak suka mengalah, karena penuh kompromi dalam melakukan pengaturan, disertai kurangnya perhatian pada sistematika tindakan.");
                put(3, "Tampak suka bernegosiasi, karena ada beberapa kompromi dalam melakukan pengaturan, namun lebih fokus pada sistematika tindakan.");
                put(6, "Tampak suka birokrasi, karena kurang kompromi dalam pengaturan, serta sangat fokus pada terpenuhinya sistematika tindakan secara kaku.");
            }
        });

        // X - Need to be Noticed
        interpretations.put("x", new TreeMap<Integer, String>() {
            {
                put(0, "Tampak menyendiri, karena cenderung pemalu, serta enggan jadi pusat perhatian.");
                put(2, "Tampak membuka diri sepenuhnya, karena membuka diri secara tulus, tanpa dilandasi keinginan jadi pusat perhatian.");
                put(4, "Tampak membuka diri secara hati-hati, karena membuka diri yang disertai pamrih, yang dilandasi keinginan jadi pusat perhatian.");
                put(6, "Tampak membuka diri secara agresif, karena aktif memperoleh perhatian orang lain, hingga semua orang menjadikannya pusat perhatian.");
            }
        });

        // B - Need to Belong to Groups
        interpretations.put("b", new TreeMap<Integer, String>() {
            {
                put(0, "Tampak menjaga jarak dalam kelompok, pemilih dalam hal bergabung ke kelompok.");
                put(4, "Tampak membuka diri secara hati-hati dalam kelompok, karena agak pemilih dalam hal bergabung dalam kelompok, yang mana di satu sisi ingin diterima namun tidak serta merta mau menerima pengaruh dari kelompok yang diikuti.");
                put(6, "Tampak membuka diri sepenuhnya dalam kelompok, karena cenderung sangat butuh disukai dan diakui, sehingga mudah menerima pengaruh dari kelompok yang diikuti.");
            }
        });

        // O - Need for Closeness and Affection
        interpretations.put("o", new TreeMap<Integer, String>() {
            {
                put(0, "Tampak enggan dekat secara personal, karena tidak suka terlalu dekat secara perorangan.");
                put(3, "Tampak mau dekat secara personal namun disertai kehati-hatian, karena tidak terlalu kesepian jika tidak ada yang dekat secara perorangan, serta tidak menolak jika ada yang ingin dekat secara perorangan.");
                put(5, "Tampak sangat aktif berusaha dekat secara personal, karena akan kesepian jika tidak ada yang dekat secara perorangan, serta sangat antusias jika ada yang ingin dekat secara perorangan.");
            }
        });

        // S - Social Extension
        interpretations.put("s", new TreeMap<Integer, String>() {
            {
                put(0, "Kurang berminat pada hubungan sosial, karena sulit percaya orang lain.");
                put(7, "Sangat berminat pada hubungan sosial, karena mudah percaya orang lain.");
            }
        });

        // N - Need to Finish Task
        interpretations.put("n", new TreeMap<Integer, String>() {
            {
                put(0, "Butuh menghindari penyelesaian tugas secara mandiri, karena ingin menunda atau menghindari menyelesaikan pekerjaan, saat diminta menyelesaikan suatu tugas.");
                put(4, "Butuh menyelesaikan beberapa tugas secara mandiri, karena cenderung ingin mengerjakan sebagian kecil pekerjaan sampai tuntas, saat diminta menyelesaikan suatu tugas.");
                put(5, "Butuh menyelesaikan sebagian tugas secara mandiri, karena cenderung ingin mengerjakan sebagian pekerjaan sampai tuntas, saat diminta menyelesaikan suatu tugas.");
                put(6, "Butuh menyelesaikan sebagian besar tugas secara mandiri, karena cenderung ingin mengerjakan sebagian besar pekerjaan sampai tuntas, saat diminta menyelesaikan suatu tugas.");
                put(7, "Butuh menyelesaikan semua tugas secara mandiri, karena cenderung ingin mengerjakan semua pekerjaan sampai tuntas, saat diminta menyelesaikan suatu tugas.");
            }
        });

        // A - Need to Achieve
        interpretations.put("a", new TreeMap<Integer, String>() {
            {
                put(0, "Tidak butuh berprestasi, karena prestasi seringkali tidak ingin dicapai karena tujuannya tidak pasti, kurang berambisi, serta mudah puas pada suatu pencapaian yang kurang tinggi.");
                put(6, "Butuh berprestasi, karena prestasi seringkali mudah dicapai karena tujuannya jelas, berambisi tinggi, serta sangat menginginkan kesuksesan.");
            }
        });

        // G - Hard Intense Worked
        interpretations.put("g", new TreeMap<Integer, String>() {
            {
                put(0, "Enggan bekerja keras.");
                put(3, "Bekerja untuk kesenangan saja.");
                put(5, "Bekerja keras penuh semangat.");
            }
        });

        // Z - Need for Change
        interpretations.put("z", new TreeMap<Integer, String>() {
            {
                put(0, "Butuh kestabilan, karena suka hal-hal yang pasti dan tetap tanpa perubahan sama sekali.");
                put(3, "Butuh kestabilan namun sedikit terbuka pada hal dinamis, karena bisa menerima perubahan asalkan tidak disertai paksaan untuk segera mengikuti perubahan tersebut.");
                put(5, "Butuh kestabilan yang bersumber dari penerimaan, sehingga mau mengikuti setiap tuntutan untuk berubah, tanpa banyak bertanya.");
                put(6, "Butuh hal dinamis yang bisa dinegosiasikan, karena mau berubah mengikuti tuntutan berubah, asalkan ada kompromi dengan jalan menuju tujuan yang hendak Ia raih.");
                put(8, "Butuh hal dinamis yang Ia bisa kendalikan sepenuhnya, karena enggan berkompromi dengan tuntutan untuk berubah, terutama bila perubahan tersebut mempengaruhi jalan menuju tujuan yang hendak Ia raih.");
            }
        });

        // K - Need to be Forceful
        interpretations.put("k", new TreeMap<Integer, String>() {
            {
                put(0, "Tidak butuh kendali, karena ingin menjauhi segala hal yang bisa melibatkannya dalam pusat permasalahan.");
                put(3, "Butuh sedikit kendali, karena ingin tahu mengenai konflik yang terjadi terkait suatu permasalahan, dalam tujuan bisa memastikan posisi dan tindakannya yang bisa menjamin diperolehnya suasana aman dan minim konflik.");
                put(5, "Butuh sebagian kendali, karena ingin tahu mengenai konflik yang terjadi terkait suatu permasalahan, dalam tujuan bisa memastikan posisi dan tindakannya agar bisa memperjuangkan pendapat atau keinginannya melalui kompromi dan negosiasi.");
                put(6, "Butuh sebagian besar kendali, karena terlibat secara aktif dalam pusat konflik yang terjadi terkait suatu permasalahan, untuk memastikan masalah selesai.");
                put(8, "Butuh kendali sepenuhnya, karena ingin terlibat secara aktif bahkan tampak agresif dalam pusat konflik yang terjadi terkait suatu permasalahan, untuk memastikan masalah selesai sesuai keinginannya, bahkan jika perlu harus menjatuhkan orang lain demi tujuan tersebut.");
            }
        });

        // E - Emotional Resistant
        interpretations.put("e", new TreeMap<Integer, String>() {
            {
                put(0, "Reaktif, bertindak tergesa-gesa tanpa pikir panjang, sehingga tampak kurang mampu mengontrol gejolak perasaannya.");
                put(2, "Reaktif, bertindak tergesa-gesa tapi mulai mempertimbangkan beberapa situasi dan kondisi yang dihadapi, sehingga tampak mulai ada upaya mengontrol beberapa gejolak perasaannya.");
                put(4, "Proaktif, bertindak penuh pertimbangan, sehingga tampak bisa mengontrol gejolak perasaannya.");
                put(7, "Kaku, cenderung normatif, tindakannya harus selalu disesuaikan dengan aturan baku, sehingga tampak kurang ekspresif.");
            }
        });

    }
}
