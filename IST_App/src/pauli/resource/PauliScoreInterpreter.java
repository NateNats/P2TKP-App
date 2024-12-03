package pauli.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.HashMap;

public class PauliScoreInterpreter {
    private static final String DATA_FILE_PATH = "./src/storage/pauli_interpretation.dat";
    private static final String K_DATA_FILE_PATH = "./src/storage/pauli_ketelitian_interpretation.dat";
    private static Map<String, Map<Integer, String>> interpretations = new HashMap<>();
    private static Map<Integer, Map<Integer, String>> ketelitianInterpretations = new HashMap<>();

    static {
        if (!loadInterpretationsFromFile() || !loadKetelitianInterpretationsFromFile()) {
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

        file = new File(K_DATA_FILE_PATH);
        parentDir = file.getParentFile();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(ketelitianInterpretations);
        } catch (IOException e) {
            System.err.println("Could not save interpretations to file.");
        }
    }

    private static void initializeDefaultInterpretations() {
        // 0 Rendah
        // 1 Sedang
        // 2 Tinggi
        interpretations.put("tingkat percaya diri", new HashMap<Integer, String>() {
            {
                put(0, "Kurang percaya pada kemampuan diri dan kurang mampu memaksimalkan potensi diri di awal kerja. Cenderungk lamban membuat keputusan karena sama sekali enggan mengambil resiko. Cenderung enggan berinisiatif.");
                put(1, "Cukup percaya pada kemampuan diri dan cukup mampu memaksimalkan sebagian potensi diri di awal kerja. Cukup cepat membuat keputusan karena cukup berani mengambil resiko, meski masih menyisakan beberapa keraguan. Cenderung menimbang beberapa hal sebelum berinisiatif.");
                put(2, "Percaya pada kemampuan diri dan mampu memaksimalkan potensi diri di awal kerja di tingkat paling optimal. Cenderung cepat membuat keputusan karena berani mengambil resiko. Cenderung cepat berinisiatif. Risk taker.");
            }
        });
        interpretations.put("kemampuan kerja", new HashMap<Integer, String>() {
            {
                put(0, "Kesulitan menyelesaikan target kerja; motivasi kerja rendah.");
                put(1, "Cukup mampu menyelesaikan sebagian target kerja; motivasi kerja cukup tinggi.");
                put(2, "Mampu menyelesaikan target kerja seoptimal mungkin; motivasi kerja tinggi.");
            }
        });
        interpretations.put("kemampuan adaptasi", new HashMap<Integer, String>() {
            {
                put(0, "Kesulitan menyesuaikan diri dengan tekanan kerja yang tinggi.");
                put(1, "Cukup mampu menyesuaikan diri dengan tekanan kerja yang sedang.");
                put(2, "Sulit menyesuaikan diri dengan berbagai tingkat tekanan kerja.");
            }
        });
        interpretations.put("ketekunan", new HashMap<Integer, String>() {
            {
                put(0, "Kurang tekun dalam mengelola setiap detil persoalan yang tengah dihadapi.");
                put(1, "Cukup tekun dalam mengelola sebagian detil persoalan yang tengah dihadapi.");
                put(2, "Tekun dalam mengelola setiap detil persoalan yang tengah dihadapi.");
            }
        });
        interpretations.put("konsentrasi", new HashMap<Integer, String>() {
            {
                put(0, "Sulit berkonsentrasi pada berbagai potensi kesalahan di persoalan yang tengah dihadapi.");
                put(1, "Mampu berkonsentrasi pada sebagian potensi kesalahan di persoalan yang tengah dihadapi.");
                put(2, "Mampu berkonsentrasi pada berbagai potensi kesalahan di persoalan yang tengah dihadapi.");
            }
        });
        interpretations.put("manajemen emosi", new HashMap<Integer, String>() {
            {
                put(0, "Memiliki emosi yang cenderung kurang stabil, sehingga sangat berpengaruh pada hasil pekerjaannya. Kurang memiliki kemauan mengatasi dampak dari gejolak perasaannya; kurang mampu mengendalikan perasaannya dalam bekerja.");
                put(1, "Memiliki emosi yang cenderung cukup stabil, meski masih cukup berpengaruh pada hasil pekerjaannya; Memiliki cukup kemauan untuk mengatasi beberapa dampak gejolak perasaannya; cukup mampu mengendalikan sebagian gejolak perasaannya dalam bekerja.");
                put(2, "Memiliki emosi yang cenderung stabil, sehingga tidak berpengaruh pada hasil pekerjaannya; memiliki kemauan besar untuk mengatasi dampak gejolak perasaannya; Mampu mengendalikan gejolak perasaannya dalam bekerja.");
            }
        });
        interpretations.put("motivasi berprestasi", new HashMap<Integer, String>() {
            {
                put(0, "Kurang memiliki motivasi dan hasrat berprestasi dalam meningkatkan potensi kerja, sehingga sulit mencapai hasil kerja bahkan yang paling minimal. Cenderung enggan mengembangkan diri dalam motif mencapai prestasi.");
                put(1, "Memiliki motivasi dan hasrat berprestasi dalam meningkatkan potensi kerja yang bisa memenuhi norma prestasi rata-rata, sehingga hasil kerja cenderung akan tercapai sebagian dari hasil yang diharapkan. Cenderung akan tergerak mengembangkan diri dalam motif mencapai prestasi rata-rata.");
                put(2, "Memiliki motivasi dan hasrat berprestasi yang tinggi dalam upaya meningkatkan potensi kerja semaksimal mungkin, sehingga hasil kerja dapat tercapai optimal. Cenderung akan tergerak mengembangkan diri dalam motif mencapai prestasi seoptimal mungkin.");
            }
        });

        ketelitianInterpretations.put(0, new HashMap<Integer, String>() {
            {
                put(0, "Sedikit kurang teliti pada detil tindakan, yaitu kurang detil saat memulai dan saat mengerjakan, sehingga kesulitan memeriksa ulang adanya seluruh potensi kesalahan.");
                put(1, "Sedikit kurang teliti pada detil tindakan, yaitu kurang detil saat memulai, namun cukup detil saat mengerjakan, sehingga masih mampu memeriksa ulang adanya sebagian kecil potensi kesalahan.");
                put(2, "Sedikit kurang teliti pada detil tindakan, yaitu kurang detil saat memulai, namun detil saat mengerjakan, sehingga masih bisa memeriksa ulang adanya beberapa potensi kesalahan.");
            }
        });

        ketelitianInterpretations.put(1, new HashMap<Integer, String>() {
            {
                put(0, "Sedikit kurang teliti pada detil tindakan, yaitu detil saat memulai, namun kurang detil saat mengerjakan, sehingga kesulitan memeriksa ulang adanya potensi kesalahan.");
                put(1, "Cukup teliti pada detil tindakan, yaitu cukup detil saat memulai dan saat mengerjakan, sehingga mampu memeriksa ulang adanya sebagian potensi kesalahan.");
                put(2, "Cukup teliti pada sebagian detil tindakan, yaitu cukup detil saat memulai dan sangat detil saat mengerjakan, sehingga mampu memeriksa ulang sebagian besar potensi kesalahan.");
            }
        });

        ketelitianInterpretations.put(2, new HashMap<Integer, String>() {
            {
                put(0, "Agak teliti pada detil tindakan, yaitu detil saat memulai namun kurang detil saat mengerjakan, sehingga kesulitan memeriksa ulang adanya potensi kesalahan.");
                put(1, "Cukup teliti pada sebagian detil tindakan, yaitu detil saat memulai dan cukup detil  saat mengerjakan, sehingga mampu memeriksa ulang adanya sebagian potensi kesalahan.");
                put(2, "Sangat teliti pada detil tindakan, yaitu detil saat memulai dan saat mengerjakan, sehingga mampu memeriksa ulang berbagai potensi kesalahan.");
            }
        });

    }

    public static String getInterpretation(String key, int value) {
        return interpretations.get(key).get(value);
    }

    public static String getKetelitianInterpretation(int ketekunan, int konsentrasi) {
        return ketelitianInterpretations.getOrDefault(ketekunan, new HashMap<>()).get(konsentrasi);
    }

    @SuppressWarnings("unchecked")
    private static boolean loadInterpretationsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
            interpretations = (Map<String, Map<Integer, String>>) ois.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load interpretations from file, using defaults.");
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    private static boolean loadKetelitianInterpretationsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(K_DATA_FILE_PATH))) {
            ketelitianInterpretations = (Map<Integer, Map<Integer, String>>) ois.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load interpretations from file, using defaults.");
            return false;
        }
    }
}
