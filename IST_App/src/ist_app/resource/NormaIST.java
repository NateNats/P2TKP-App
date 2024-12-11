/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ist_app.resource;

/**
 *
 * @author nicol
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;

public class NormaIST {

    private static final String DATA_FILE_PATH = "./src/storage/norma_IST.dat";
    private static final String DATA_GESAMT_FILE_PATH = "./src/storage/norma_GESAMT_IST.dat";
    private static Map<String, NavigableMap<Integer, Integer>> interpretations = new TreeMap<>();
    private static Map<String, NavigableMap<Range, Integer>> interpretGESAMT = new TreeMap<>();
    private static Map<Integer, Integer> iqMap = new HashMap<>();
    private static Map<Integer, Integer> stdScoreMap = new HashMap<>();

    static {
        if (!loadInterpretationsFromFile() || !loadGESAMTInterpretationsFromFile()) {
            initializeDataMap();
            saveInterpretationsToFile();
            saveInterpretGESAMTToFile();
        }
    }

    static class Range implements Comparable<Range> {

        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isInRange(double value) {
            return value >= this.start && value <= this.end;
        }

        public boolean contains(int value) {
            return value >= start && value <= end;
        }

        @Override
        public int compareTo(Range other) {
            if (this.end < other.start) {
                return -1;
            } else if (this.start > other.end) {
                return 1;
            } else {
                return 0; // Overlapping ranges are considered equal
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Range range = (Range) obj;
            return start == range.start && end == range.end;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(start) * 31 + Integer.hashCode(end);
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }

    }

    private static void saveInterpretationsToFile() {
        File file = new File(DATA_FILE_PATH);
        File parentDir = file.getParentFile();

        if (!parentDir.exists()) {
            parentDir.mkdir();
        }

        try (ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(file))) {
            oos1.writeObject(interpretations);
        } catch (Exception e) {
            System.err.println("Could not save interpretations to file.");
        }
    }

    private static void saveInterpretGESAMTToFile() {
        File file = new File(DATA_GESAMT_FILE_PATH);
        File parentDir = file.getParentFile();

        if (!parentDir.exists()) {
            parentDir.mkdir();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(interpretGESAMT);
        } catch (Exception e) {
            System.err.println("Could not save interpretations to file.");
        }
    }

    @SuppressWarnings("unchecked")
    public static boolean loadInterpretationsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
            interpretations = (Map<String, NavigableMap<Integer, Integer>>) ois.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load interpretations from file, using defaults.");
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public static boolean loadGESAMTInterpretationsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_GESAMT_FILE_PATH))) {
            interpretGESAMT = (Map<String, NavigableMap<Range, Integer>>) ois.readObject();
            return true;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Could not load interpretations GESAMT from file, using defaults.");
            return false;
        }
    }

    public Integer getIqScore(Integer GESAMT) {
        return iqMap.get(GESAMT);
    }

    public Integer getStdScore(Integer ge) {
        return stdScoreMap.get(ge);
    }

    public Integer getInterpretation(String key, int rw, int age) {

        key = concateKey(key, age);

        NavigableMap<Integer, Integer> val = interpretations.get(key);
        if (interpretations == null) {
            return null;
        }
        return val.get(rw);
    }

    private String concateKey(String key, int age) {
        if (age >= 19 && age <= 20) {
            key = key.concat("19-20");

        } else if (age >= 21 && age <= 25) {
            key = key.concat("21-25");

        } else if (age >= 26 && age <= 30) {
            key = key.concat("26-30");

        } else if (age >= 31 && age <= 35) {
            key = key.concat("31-35");

        } else if (age >= 36 && age <= 40) {
            key = key.concat("36-40");

        } else if (age >= 41 && age <= 45) {
            key = key.concat("41-45");

        } else if (age >= 46 && age <= 50) {
            key = key.concat("46-50");

        } else if (age >= 51 && age <= 60) {
            key = key.concat("51-60");

        } else {
            key = key.concat(Integer.toString(age));
        }

        return key;
    }

    public Integer getInterpretGESAMT(String key, int rw, int age) {

        key = concateKey(key, age);
        System.out.println(key);

        NavigableMap<Range, Integer> map = interpretGESAMT.get(key);
        if (map != null) {
            for (Map.Entry<Range, Integer> entry : map.entrySet()) {
                if (entry.getKey().contains(rw)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    private static void initializeDataMap() {
        iqMap.put(140, 160);
        iqMap.put(139, 157);
        iqMap.put(138, 157);
        iqMap.put(137, 154);
        iqMap.put(136, 154);
        iqMap.put(135, 151);
        iqMap.put(134, 151);
        iqMap.put(133, 148);
        iqMap.put(132, 148);
        iqMap.put(131, 145);
        iqMap.put(130, 145);
        iqMap.put(129, 142);
        iqMap.put(128, 142);
        iqMap.put(127, 139);
        iqMap.put(126, 139);
        iqMap.put(125, 136);
        iqMap.put(124, 136);
        iqMap.put(123, 133);
        iqMap.put(122, 133);
        iqMap.put(121, 130);
        iqMap.put(120, 130);
        iqMap.put(119, 127);
        iqMap.put(118, 127);
        iqMap.put(117, 124);
        iqMap.put(116, 124);
        iqMap.put(115, 121);
        iqMap.put(114, 121);
        iqMap.put(113, 118);
        iqMap.put(112, 118);
        iqMap.put(111, 115);
        iqMap.put(110, 115);
        iqMap.put(109, 112);
        iqMap.put(108, 112);
        iqMap.put(107, 109);
        iqMap.put(106, 109);
        iqMap.put(105, 106);
        iqMap.put(104, 106);
        iqMap.put(103, 103);
        iqMap.put(102, 103);
        iqMap.put(101, 100);
        iqMap.put(100, 100);
        iqMap.put(99, 97);
        iqMap.put(98, 97);
        iqMap.put(97, 94);
        iqMap.put(96, 94);
        iqMap.put(95, 91);
        iqMap.put(94, 91);
        iqMap.put(93, 88);
        iqMap.put(92, 88);
        iqMap.put(91, 85);
        iqMap.put(90, 85);
        iqMap.put(89, 82);
        iqMap.put(88, 82);
        iqMap.put(87, 79);
        iqMap.put(86, 79);
        iqMap.put(85, 76);
        iqMap.put(84, 76);
        iqMap.put(83, 73);
        iqMap.put(82, 73);
        iqMap.put(81, 70);
        iqMap.put(80, 70);
        iqMap.put(79, 67);
        iqMap.put(78, 67);
        iqMap.put(77, 64);
        iqMap.put(76, 64);
        iqMap.put(75, 61);
        iqMap.put(74, 61);
        iqMap.put(73, 58);
        iqMap.put(72, 58);
        iqMap.put(71, 55);
        iqMap.put(70, 55);
        iqMap.put(69, 52);
        iqMap.put(68, 52);
        iqMap.put(67, 49);
        iqMap.put(66, 49);
        iqMap.put(65, 46);
        iqMap.put(64, 46);
        iqMap.put(63, 43);
        iqMap.put(62, 43);
        iqMap.put(61, 40);
        iqMap.put(60, 40);
        iqMap.put(59, 37);
        iqMap.put(58, 37);

        stdScoreMap.put(20, 31);
        stdScoreMap.put(19, 30);
        stdScoreMap.put(18, 29);
        stdScoreMap.put(17, 28);
        stdScoreMap.put(16, 27);
        stdScoreMap.put(15, 25);
        stdScoreMap.put(14, 23);
        stdScoreMap.put(13, 24);
        stdScoreMap.put(12, 21);
        stdScoreMap.put(11, 19);
        stdScoreMap.put(10, 17);
        stdScoreMap.put(9, 15);
        stdScoreMap.put(8, 11);
        stdScoreMap.put(7, 9);
        stdScoreMap.put(6, 7);
        stdScoreMap.put(5, 5);
        stdScoreMap.put(4, 4);
        stdScoreMap.put(3, 3);
        stdScoreMap.put(2, 2);
        stdScoreMap.put(1, 1);
        stdScoreMap.put(0, 0);

        interpretations.put("AN12", new TreeMap<Integer, Integer>() {
            {
                put(20, 135);
                put(19, 135);
                put(18, 135);
                put(17, 135);
                put(16, 135);
                put(15, 135);
                put(14, 132);
                put(13, 128);
                put(12, 124);
                put(11, 120);
                put(10, 116);
                put(9, 112);
                put(8, 108);
                put(7, 105);
                put(6, 101);
                put(5, 97);
                put(4, 93);
                put(3, 89);
                put(2, 85);
                put(1, 82);
                put(0, 78);
            }
        });

        interpretations.put("AN13", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 132);
                put(18, 132);
                put(17, 132);
                put(16, 132);
                put(15, 132);
                put(14, 129);
                put(13, 125);
                put(12, 121);
                put(11, 117);
                put(10, 114);
                put(9, 110);
                put(8, 106);
                put(7, 103);
                put(6, 99);
                put(5, 95);
                put(4, 91);
                put(3, 88);
                put(2, 84);
                put(1, 80);
                put(0, 77);
            }
        });
        interpretations.put("AN14", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 132);
                put(18, 132);
                put(17, 132);
                put(16, 132);
                put(15, 128);
                put(14, 125);
                put(13, 121);
                put(12, 118);
                put(11, 115);
                put(10, 111);
                put(9, 108);
                put(8, 104);
                put(7, 101);
                put(6, 97);
                put(5, 94);
                put(4, 90);
                put(3, 87);
                put(2, 83);
                put(1, 80);
                put(0, 77);
            }
        });
        interpretations.put("AN15", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 133);
                put(18, 130);
                put(17, 127);
                put(16, 124);
                put(15, 121);
                put(14, 119);
                put(13, 116);
                put(12, 113);
                put(11, 110);
                put(10, 107);
                put(9, 104);
                put(8, 101);
                put(7, 99);
                put(6, 96);
                put(5, 93);
                put(4, 90);
                put(3, 87);
                put(2, 84);
                put(1, 81);
                put(0, 79);
            }
        });
        interpretations.put("AN16", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 129);
                put(18, 127);
                put(17, 124);
                put(16, 121);
                put(15, 118);
                put(14, 115);
                put(13, 112);
                put(12, 109);
                put(11, 107);
                put(10, 104);
                put(9, 101);
                put(8, 98);
                put(7, 95);
                put(6, 92);
                put(5, 89);
                put(4, 87);
                put(3, 84);
                put(2, 81);
                put(1, 78);
                put(0, 75);
            }
        });
        interpretations.put("AN17", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 125);
                put(18, 122);
                put(17, 120);
                put(16, 117);
                put(15, 115);
                put(14, 112);
                put(13, 109);
                put(12, 107);
                put(11, 104);
                put(10, 102);
                put(9, 99);
                put(8, 97);
                put(7, 94);
                put(6, 92);
                put(5, 89);
                put(4, 86);
                put(3, 84);
                put(2, 81);
                put(1, 79);
                put(0, 76);
            }
        });
        interpretations.put("AN18", new TreeMap<Integer, Integer>() {
            {
                put(20, 126);
                put(19, 124);
                put(18, 121);
                put(17, 119);
                put(16, 116);
                put(15, 114);
                put(14, 111);
                put(13, 108);
                put(12, 103);
                put(11, 101);
                put(10, 98);
                put(9, 96);
                put(8, 93);
                put(7, 91);
                put(6, 88);
                put(5, 85);
                put(4, 83);
                put(3, 80);
                put(2, 78);
                put(1, 75);
                put(0, 73);
            }
        });
        interpretations.put("AN19-20", new TreeMap<Integer, Integer>() {
            {
                put(20, 126);
                put(19, 123);
                put(18, 121);
                put(17, 118);
                put(16, 115);
                put(15, 113);
                put(14, 110);
                put(13, 108);
                put(12, 105);
                put(11, 103);
                put(10, 100);
                put(9, 97);
                put(8, 95);
                put(7, 92);
                put(6, 90);
                put(5, 87);
                put(4, 85);
                put(3, 82);
                put(2, 79);
                put(1, 77);
                put(0, 74);
            }
        });
        interpretations.put("AN21-25", new TreeMap<Integer, Integer>() {
            {
                put(20, 126);
                put(19, 123);
                put(18, 121);
                put(17, 118);
                put(16, 116);
                put(15, 113);
                put(14, 111);
                put(13, 108);
                put(12, 106);
                put(11, 103);
                put(10, 101);
                put(9, 98);
                put(8, 96);
                put(7, 93);
                put(6, 91);
                put(5, 88);
                put(4, 86);
                put(3, 83);
                put(2, 81);
                put(1, 78);
                put(0, 76);
            }
        });

        interpretations.put("AN26-30", new TreeMap<Integer, Integer>() {
            {
                put(20, 125);
                put(19, 123);
                put(18, 121);
                put(17, 118);
                put(16, 116);
                put(15, 114);
                put(14, 111);
                put(13, 109);
                put(12, 106);
                put(11, 104);
                put(10, 102);
                put(9, 99);
                put(8, 97);
                put(7, 95);
                put(6, 92);
                put(5, 90);
                put(4, 87);
                put(3, 85);
                put(2, 83);
                put(1, 80);
                put(0, 78);
            }
        });

        interpretations.put("AN31-35", new TreeMap<Integer, Integer>() {
            {
                put(20, 126);
                put(19, 123);
                put(18, 121);
                put(17, 119);
                put(16, 117);
                put(15, 114);
                put(14, 112);
                put(13, 110);
                put(12, 108);
                put(11, 105);
                put(10, 103);
                put(9, 101);
                put(8, 98);
                put(7, 96);
                put(6, 94);
                put(5, 92);
                put(4, 89);
                put(3, 87);
                put(2, 85);
                put(1, 83);
                put(0, 80);
            }
        });

        interpretations.put("AN36-40", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 125);
                put(18, 122);
                put(17, 120);
                put(16, 118);
                put(15, 115);
                put(14, 113);
                put(13, 111);
                put(12, 109);
                put(11, 106);
                put(10, 104);
                put(9, 102);
                put(8, 100);
                put(7, 97);
                put(6, 95);
                put(5, 93);
                put(4, 90);
                put(3, 88);
                put(2, 86);
                put(1, 84);
                put(0, 81);
            }
        });

        interpretations.put("AN41-45", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 125);
                put(18, 126);
                put(17, 121);
                put(16, 118);
                put(15, 116);
                put(14, 114);
                put(13, 112);
                put(12, 110);
                put(11, 107);
                put(10, 105);
                put(9, 103);
                put(8, 101);
                put(7, 98);
                put(6, 96);
                put(5, 94);
                put(4, 92);
                put(3, 90);
                put(2, 87);
                put(1, 85);
                put(0, 83);
            }
        });

        interpretations.put("AN46-50", new TreeMap<Integer, Integer>() {
            {
                put(20, 128);
                put(19, 126);
                put(18, 124);
                put(17, 122);
                put(16, 120);
                put(15, 117);
                put(14, 115);
                put(13, 113);
                put(12, 111);
                put(11, 109);
                put(10, 107);
                put(9, 104);
                put(8, 102);
                put(7, 100);
                put(6, 98);
                put(5, 96);
                put(4, 93);
                put(3, 91);
                put(2, 89);
                put(1, 87);
                put(0, 85);
            }
        });

        interpretations.put("AN51-60", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 130);
                put(18, 127);
                put(17, 125);
                put(16, 123);
                put(15, 120);
                put(14, 118);
                put(13, 116);
                put(12, 113);
                put(11, 111);
                put(10, 109);
                put(9, 106);
                put(8, 104);
                put(7, 102);
                put(6, 99);
                put(5, 97);
                put(4, 95);
                put(3, 92);
                put(2, 90);
                put(1, 88);
                put(0, 85);
            }
        });

        interpretations.put("FA12", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 134);
                put(18, 134);
                put(17, 134);
                put(16, 130);
                put(15, 127);
                put(14, 123);
                put(13, 120);
                put(12, 116);
                put(11, 113);
                put(10, 109);
                put(9, 105);
                put(8, 102);
                put(7, 98);
                put(6, 95);
                put(5, 91);
                put(4, 88);
                put(3, 84);
                put(2, 80);
                put(1, 77);
                put(0, 74);
            }
        });

        interpretations.put("FA13", new TreeMap<Integer, Integer>() {
            {
                put(20, 135);
                put(19, 135);
                put(18, 132);
                put(17, 128);
                put(16, 125);
                put(15, 122);
                put(14, 119);
                put(13, 116);
                put(12, 113);
                put(11, 110);
                put(10, 107);
                put(9, 103);
                put(8, 100);
                put(7, 97);
                put(6, 94);
                put(5, 91);
                put(4, 88);
                put(3, 85);
                put(2, 82);
                put(1, 78);
                put(0, 75);
            }
        });

        interpretations.put("FA14", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 131);
                put(18, 131);
                put(17, 128);
                put(16, 125);
                put(15, 121);
                put(14, 118);
                put(13, 115);
                put(12, 112);
                put(11, 108);
                put(10, 105);
                put(9, 102);
                put(8, 99);
                put(7, 95);
                put(6, 92);
                put(5, 89);
                put(4, 86);
                put(3, 83);
                put(2, 79);
                put(1, 76);
                put(0, 73);
            }
        });

        interpretations.put("FA15", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 129);
                put(18, 126);
                put(17, 123);
                put(16, 121);
                put(15, 118);
                put(14, 115);
                put(13, 112);
                put(12, 109);
                put(11, 106);
                put(10, 103);
                put(9, 101);
                put(8, 98);
                put(7, 95);
                put(6, 92);
                put(5, 89);
                put(4, 86);
                put(3, 83);
                put(2, 81);
                put(1, 78);
                put(0, 75);
            }
        });

        interpretations.put("FA16", new TreeMap<Integer, Integer>() {
            {
                put(20, 130);
                put(19, 127);
                put(18, 124);
                put(17, 122);
                put(16, 119);
                put(15, 116);
                put(14, 113);
                put(13, 111);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 99);
                put(8, 97);
                put(7, 94);
                put(6, 91);
                put(5, 88);
                put(4, 86);
                put(3, 83);
                put(2, 80);
                put(1, 77);
                put(0, 74);
            }
        });

        interpretations.put("FA17", new TreeMap<Integer, Integer>() {
            {
                put(20, 126);
                put(19, 124);
                put(18, 121);
                put(17, 119);
                put(16, 116);
                put(15, 114);
                put(14, 111);
                put(13, 109);
                put(12, 106);
                put(11, 104);
                put(10, 101);
                put(9, 99);
                put(8, 96);
                put(7, 94);
                put(6, 91);
                put(5, 89);
                put(4, 86);
                put(3, 84);
                put(2, 81);
                put(1, 79);
                put(0, 76);
            }
        });

        interpretations.put("FA18", new TreeMap<Integer, Integer>() {
            {
                put(20, 130);
                put(19, 127);
                put(18, 124);
                put(17, 121);
                put(16, 118);
                put(15, 115);
                put(14, 112);
                put(13, 109);
                put(12, 106);
                put(11, 104);
                put(10, 101);
                put(9, 98);
                put(8, 95);
                put(7, 92);
                put(6, 89);
                put(5, 86);
                put(4, 83);
                put(3, 80);
                put(2, 77);
                put(1, 74);
                put(0, 71);
            }
        });

        interpretations.put("FA19-20", new TreeMap<Integer, Integer>() {
            {
                put(20, 126);
                put(19, 124);
                put(18, 121);
                put(17, 118);
                put(16, 115);
                put(15, 113);
                put(14, 110);
                put(13, 107);
                put(12, 105);
                put(11, 102);
                put(10, 99);
                put(9, 96);
                put(8, 94);
                put(7, 91);
                put(6, 88);
                put(5, 86);
                put(4, 83);
                put(3, 80);
                put(2, 78);
                put(1, 75);
                put(0, 72);
            }
        });

        interpretations.put("FA21-25", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 124);
                put(18, 121);
                put(17, 119);
                put(16, 116);
                put(15, 113);
                put(14, 110);
                put(13, 107);
                put(12, 104);
                put(11, 101);
                put(10, 99);
                put(9, 96);
                put(8, 93);
                put(7, 90);
                put(6, 87);
                put(5, 84);
                put(4, 81);
                put(3, 79);
                put(2, 76);
                put(1, 73);
                put(0, 70);
            }
        });

        interpretations.put("FA26-30", new TreeMap<Integer, Integer>() {
            {
                put(20, 128);
                put(19, 125);
                put(18, 122);
                put(17, 119);
                put(16, 116);
                put(15, 113);
                put(14, 111);
                put(13, 108);
                put(12, 105);
                put(11, 102);
                put(10, 99);
                put(9, 96);
                put(8, 93);
                put(7, 91);
                put(6, 88);
                put(5, 85);
                put(4, 82);
                put(3, 79);
                put(2, 76);
                put(1, 73);
                put(0, 71);
            }
        });

        interpretations.put("FA31-35", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 126);
                put(18, 123);
                put(17, 120);
                put(16, 118);
                put(15, 115);
                put(14, 112);
                put(13, 109);
                put(12, 106);
                put(11, 104);
                put(10, 101);
                put(9, 98);
                put(8, 95);
                put(7, 93);
                put(6, 90);
                put(5, 87);
                put(4, 84);
                put(3, 81);
                put(2, 79);
                put(1, 76);
                put(0, 73);
            }
        });

        interpretations.put("FA36-40", new TreeMap<Integer, Integer>() {
            {
                put(20, 128);
                put(19, 126);
                put(18, 123);
                put(17, 121);
                put(16, 118);
                put(15, 115);
                put(14, 113);
                put(13, 110);
                put(12, 108);
                put(11, 105);
                put(10, 103);
                put(9, 100);
                put(8, 97);
                put(7, 95);
                put(6, 92);
                put(5, 90);
                put(4, 87);
                put(3, 85);
                put(2, 82);
                put(1, 79);
                put(0, 77);
            }
        });

        interpretations.put("FA41-45", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 127);
                put(18, 124);
                put(17, 122);
                put(16, 119);
                put(15, 117);
                put(14, 114);
                put(13, 112);
                put(12, 109);
                put(11, 106);
                put(10, 104);
                put(9, 101);
                put(8, 99);
                put(7, 96);
                put(6, 94);
                put(5, 91);
                put(4, 88);
                put(3, 86);
                put(2, 83);
                put(1, 81);
                put(0, 78);
            }
        });

        interpretations.put("FA46-50", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 131);
                put(18, 128);
                put(17, 125);
                put(16, 122);
                put(15, 119);
                put(14, 117);
                put(13, 114);
                put(12, 111);
                put(11, 108);
                put(10, 106);
                put(9, 103);
                put(8, 100);
                put(7, 97);
                put(6, 94);
                put(5, 92);
                put(4, 90);
                put(3, 86);
                put(2, 83);
                put(1, 80);
                put(0, 78);
            }
        });

        interpretations.put("FA51-60", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 132);
                put(18, 129);
                put(17, 126);
                put(16, 124);
                put(15, 121);
                put(14, 118);
                put(13, 116);
                put(12, 113);
                put(11, 111);
                put(10, 108);
                put(9, 105);
                put(8, 103);
                put(7, 100);
                put(6, 97);
                put(5, 95);
                put(4, 92);
                put(3, 89);
                put(2, 87);
                put(1, 84);
                put(0, 82);
            }
        });

        interpretations.put("ME12", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 133);
                put(18, 133);
                put(17, 130);
                put(16, 127);
                put(15, 124);
                put(14, 121);
                put(13, 119);
                put(12, 116);
                put(11, 113);
                put(10, 110);
                put(9, 107);
                put(8, 104);
                put(7, 101);
                put(6, 98);
                put(5, 95);
                put(4, 92);
                put(3, 89);
                put(2, 86);
                put(1, 83);
                put(0, 80);
            }
        });

        interpretations.put("ME13", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 133);
                put(18, 130);
                put(17, 127);
                put(16, 125);
                put(15, 122);
                put(14, 119);
                put(13, 116);
                put(12, 113);
                put(11, 110);
                put(10, 107);
                put(9, 105);
                put(8, 102);
                put(7, 101);
                put(6, 96);
                put(5, 93);
                put(4, 90);
                put(3, 87);
                put(2, 85);
                put(1, 82);
                put(0, 79);
            }
        });

        interpretations.put("ME14", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 129);
                put(18, 129);
                put(17, 126);
                put(16, 124);
                put(15, 121);
                put(14, 118);
                put(13, 115);
                put(12, 112);
                put(11, 109);
                put(10, 106);
                put(9, 103);
                put(8, 100);
                put(7, 97);
                put(6, 94);
                put(5, 91);
                put(4, 88);
                put(3, 85);
                put(2, 82);
                put(1, 79);
                put(0, 76);
            }
        });

        interpretations.put("ME15", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 126);
                put(18, 124);
                put(17, 121);
                put(16, 118);
                put(15, 116);
                put(14, 113);
                put(13, 111);
                put(12, 108);
                put(11, 105);
                put(10, 103);
                put(9, 100);
                put(8, 97);
                put(7, 95);
                put(6, 92);
                put(5, 89);
                put(4, 87);
                put(3, 84);
                put(2, 82);
                put(1, 79);
                put(0, 76);
            }
        });

        interpretations.put("ME16", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 124);
                put(18, 121);
                put(17, 119);
                put(16, 116);
                put(15, 113);
                put(14, 111);
                put(13, 108);
                put(12, 105);
                put(11, 102);
                put(10, 100);
                put(9, 97);
                put(8, 94);
                put(7, 92);
                put(6, 89);
                put(5, 86);
                put(4, 84);
                put(3, 81);
                put(2, 78);
                put(1, 75);
                put(0, 73);
            }
        });

        interpretations.put("ME17", new TreeMap<Integer, Integer>() {
            {
                put(20, 123);
                put(19, 121);
                put(18, 118);
                put(17, 116);
                put(16, 113);
                put(15, 111);
                put(14, 108);
                put(13, 106);
                put(12, 103);
                put(11, 101);
                put(10, 98);
                put(9, 96);
                put(8, 93);
                put(7, 91);
                put(6, 88);
                put(5, 86);
                put(4, 83);
                put(3, 81);
                put(2, 78);
                put(1, 76);
                put(0, 73);
            }
        });

        interpretations.put("ME18", new TreeMap<Integer, Integer>() {
            {
                put(20, 121);
                put(19, 118);
                put(18, 116);
                put(17, 114);
                put(16, 111);
                put(15, 109);
                put(14, 106);
                put(13, 104);
                put(12, 102);
                put(11, 99);
                put(10, 97);
                put(9, 95);
                put(8, 92);
                put(7, 90);
                put(6, 87);
                put(5, 85);
                put(4, 83);
                put(3, 80);
                put(2, 78);
                put(1, 75);
                put(0, 73);
            }
        });

        interpretations.put("ME19-20", new TreeMap<Integer, Integer>() {
            {
                put(20, 119);
                put(19, 117);
                put(18, 114);
                put(17, 112);
                put(16, 110);
                put(15, 108);
                put(14, 106);
                put(13, 103);
                put(12, 101);
                put(11, 99);
                put(10, 97);
                put(9, 94);
                put(8, 92);
                put(7, 90);
                put(6, 88);
                put(5, 86);
                put(4, 83);
                put(3, 81);
                put(2, 79);
                put(1, 77);
                put(0, 74);
            }
        });

        interpretations.put("ME21-25", new TreeMap<Integer, Integer>() {
            {
                put(20, 122);
                put(19, 119);
                put(18, 117);
                put(17, 115);
                put(16, 112);
                put(15, 110);
                put(14, 108);
                put(13, 105);
                put(12, 103);
                put(11, 101);
                put(10, 98);
                put(9, 96);
                put(8, 94);
                put(7, 91);
                put(6, 89);
                put(5, 87);
                put(4, 84);
                put(3, 82);
                put(2, 80);
                put(1, 77);
                put(0, 75);
            }
        });

        interpretations.put("ME26-30", new TreeMap<Integer, Integer>() {
            {
                put(20, 123);
                put(19, 120);
                put(18, 118);
                put(17, 116);
                put(16, 114);
                put(15, 111);
                put(14, 109);
                put(13, 107);
                put(12, 105);
                put(11, 102);
                put(10, 100);
                put(9, 98);
                put(8, 95);
                put(7, 93);
                put(6, 91);
                put(5, 89);
                put(4, 86);
                put(3, 84);
                put(2, 82);
                put(1, 80);
                put(0, 77);
            }
        });

        interpretations.put("ME31-35", new TreeMap<Integer, Integer>() {
            {
                put(20, 124);
                put(19, 122);
                put(18, 119);
                put(17, 117);
                put(16, 115);
                put(15, 113);
                put(14, 110);
                put(13, 108);
                put(12, 106);
                put(11, 103);
                put(10, 101);
                put(9, 99);
                put(8, 97);
                put(7, 94);
                put(6, 92);
                put(5, 90);
                put(4, 88);
                put(3, 85);
                put(2, 83);
                put(1, 81);
                put(0, 78);
            }
        });

        interpretations.put("ME36-40", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 124);
                put(18, 122);
                put(17, 120);
                put(16, 117);
                put(15, 115);
                put(14, 112);
                put(13, 110);
                put(12, 107);
                put(11, 105);
                put(10, 102);
                put(9, 100);
                put(8, 98);
                put(7, 95);
                put(6, 93);
                put(5, 90);
                put(4, 88);
                put(3, 85);
                put(2, 83);
                put(1, 80);
                put(0, 78);
            }
        });

        interpretations.put("ME41-45", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 124);
                put(18, 122);
                put(17, 120);
                put(16, 118);
                put(15, 115);
                put(14, 113);
                put(13, 111);
                put(12, 108);
                put(11, 106);
                put(10, 104);
                put(9, 102);
                put(8, 99);
                put(7, 97);
                put(6, 95);
                put(5, 93);
                put(4, 90);
                put(3, 88);
                put(2, 86);
                put(1, 83);
                put(0, 81);
            }
        });

        interpretations.put("ME46-50", new TreeMap<Integer, Integer>() {
            {
                put(20, 128);
                put(19, 126);
                put(18, 123);
                put(17, 121);
                put(16, 119);
                put(15, 117);
                put(14, 114);
                put(13, 112);
                put(12, 110);
                put(11, 108);
                put(10, 106);
                put(9, 103);
                put(8, 101);
                put(7, 99);
                put(6, 97);
                put(5, 94);
                put(4, 92);
                put(3, 90);
                put(2, 88);
                put(1, 86);
                put(0, 83);
            }
        });

        interpretations.put("ME51-60", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 129);
                put(18, 127);
                put(17, 124);
                put(16, 122);
                put(15, 120);
                put(14, 117);
                put(13, 115);
                put(12, 113);
                put(11, 110);
                put(10, 108);
                put(9, 106);
                put(8, 103);
                put(7, 101);
                put(6, 99);
                put(5, 97);
                put(4, 94);
                put(3, 92);
                put(2, 90);
                put(1, 87);
                put(0, 85);
            }
        });

        interpretations.put("RA12", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 133);
                put(18, 133);
                put(17, 133);
                put(16, 133);
                put(15, 133);
                put(14, 129);
                put(13, 126);
                put(12, 122);
                put(11, 118);
                put(10, 114);
                put(9, 111);
                put(8, 107);
                put(7, 103);
                put(6, 100);
                put(5, 96);
                put(4, 92);
                put(3, 89);
                put(2, 85);
                put(1, 81);
                put(0, 77);
            }
        });

        interpretations.put("RA13", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 134);
                put(18, 134);
                put(17, 134);
                put(16, 131);
                put(15, 128);
                put(14, 124);
                put(13, 121);
                put(12, 117);
                put(11, 114);
                put(10, 110);
                put(9, 107);
                put(8, 103);
                put(7, 100);
                put(6, 97);
                put(5, 93);
                put(4, 90);
                put(3, 86);
                put(2, 83);
                put(1, 79);
                put(0, 76);
            }
        });

        interpretations.put("RA14", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 134);
                put(18, 134);
                put(17, 134);
                put(16, 130);
                put(15, 127);
                put(14, 123);
                put(13, 120);
                put(12, 116);
                put(11, 113);
                put(10, 109);
                put(9, 105);
                put(8, 102);
                put(7, 98);
                put(6, 95);
                put(5, 91);
                put(4, 88);
                put(3, 84);
                put(2, 80);
                put(1, 77);
                put(0, 73);
            }
        });

        interpretations.put("RA15", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 133);
                put(18, 130);
                put(17, 127);
                put(16, 124);
                put(15, 121);
                put(14, 118);
                put(13, 114);
                put(12, 111);
                put(11, 108);
                put(10, 125);
                put(9, 123);
                put(8, 99);
                put(7, 96);
                put(6, 93);
                put(5, 89);
                put(4, 86);
                put(3, 83);
                put(2, 80);
                put(1, 77);
                put(0, 74);
            }
        });

        interpretations.put("RA16", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 131);
                put(18, 128);
                put(17, 125);
                put(16, 122);
                put(15, 119);
                put(14, 116);
                put(13, 113);
                put(12, 110);
                put(11, 107);
                put(10, 104);
                put(9, 101);
                put(8, 98);
                put(7, 95);
                put(6, 92);
                put(5, 88);
                put(4, 85);
                put(3, 82);
                put(2, 79);
                put(1, 76);
                put(0, 73);
            }
        });

        interpretations.put("RA17", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 129);
                put(18, 126);
                put(17, 124);
                put(16, 121);
                put(15, 118);
                put(14, 115);
                put(13, 112);
                put(12, 109);
                put(11, 106);
                put(10, 103);
                put(9, 100);
                put(8, 97);
                put(7, 94);
                put(6, 91);
                put(5, 88);
                put(4, 85);
                put(3, 82);
                put(2, 79);
                put(1, 76);
                put(0, 74);
            }
        });

        interpretations.put("RA18", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 128);
                put(18, 125);
                put(17, 122);
                put(16, 119);
                put(15, 117);
                put(14, 114);
                put(13, 111);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 99);
                put(8, 97);
                put(7, 94);
                put(6, 91);
                put(5, 88);
                put(4, 85);
                put(3, 82);
                put(2, 79);
                put(1, 77);
                put(0, 74);
            }
        });

        interpretations.put("RA19-20", new TreeMap<Integer, Integer>() {
            {
                put(20, 130);
                put(19, 127);
                put(18, 124);
                put(17, 121);
                put(16, 119);
                put(15, 116);
                put(14, 113);
                put(13, 110);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 99);
                put(8, 96);
                put(7, 94);
                put(6, 91);
                put(5, 88);
                put(4, 85);
                put(3, 83);
                put(2, 80);
                put(1, 77);
                put(0, 74);
            }
        });

        interpretations.put("RA21-25", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 128);
                put(18, 125);
                put(17, 122);
                put(16, 119);
                put(15, 117);
                put(14, 114);
                put(13, 111);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 99);
                put(8, 97);
                put(7, 94);
                put(6, 91);
                put(5, 88);
                put(4, 85);
                put(3, 82);
                put(2, 79);
                put(1, 77);
                put(0, 74);
            }
        });

        interpretations.put("RA26-30", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 128);
                put(18, 125);
                put(17, 122);
                put(16, 119);
                put(15, 117);
                put(14, 114);
                put(13, 111);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 99);
                put(8, 97);
                put(7, 94);
                put(6, 91);
                put(5, 88);
                put(4, 85);
                put(3, 82);
                put(2, 79);
                put(1, 77);
                put(0, 74);
            }
        });

        interpretations.put("RA31-35", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 126);
                put(18, 124);
                put(17, 121);
                put(16, 118);
                put(15, 116);
                put(14, 113);
                put(13, 110);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 99);
                put(8, 97);
                put(7, 94);
                put(6, 91);
                put(5, 89);
                put(4, 86);
                put(3, 83);
                put(2, 81);
                put(1, 78);
                put(0, 75);
            }
        });

        interpretations.put("RA36-40", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 128);
                put(18, 125);
                put(17, 122);
                put(16, 119);
                put(15, 116);
                put(14, 114);
                put(13, 111);
                put(12, 108);
                put(11, 105);
                put(10, 103);
                put(9, 100);
                put(8, 97);
                put(7, 94);
                put(6, 91);
                put(5, 89);
                put(4, 86);
                put(3, 83);
                put(2, 80);
                put(1, 78);
                put(0, 75);
            }
        });

        interpretations.put("RA41-45", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 130);
                put(18, 127);
                put(17, 125);
                put(16, 122);
                put(15, 119);
                put(14, 116);
                put(13, 113);
                put(12, 110);
                put(11, 107);
                put(10, 105);
                put(9, 102);
                put(8, 99);
                put(7, 96);
                put(6, 93);
                put(5, 90);
                put(4, 87);
                put(3, 85);
                put(2, 82);
                put(1, 79);
                put(0, 76);
            }
        });

        interpretations.put("RA46-50", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 131);
                put(18, 128);
                put(17, 125);
                put(16, 123);
                put(15, 120);
                put(14, 117);
                put(13, 114);
                put(12, 111);
                put(11, 108);
                put(10, 105);
                put(9, 103);
                put(8, 100);
                put(7, 97);
                put(6, 94);
                put(5, 91);
                put(4, 88);
                put(3, 85);
                put(2, 83);
                put(1, 80);
                put(0, 77);
            }
        });

        interpretations.put("RA51-60", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 132);
                put(18, 129);
                put(17, 126);
                put(16, 123);
                put(15, 121);
                put(14, 118);
                put(13, 115);
                put(12, 112);
                put(11, 109);
                put(10, 107);
                put(9, 104);
                put(8, 101);
                put(7, 98);
                put(6, 96);
                put(5, 93);
                put(4, 90);
                put(3, 87);
                put(2, 84);
                put(1, 82);
                put(0, 79);
            }
        });

        interpretations.put("SE12", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 134);
                put(18, 134);
                put(17, 134);
                put(16, 134);
                put(15, 134);
                put(14, 130);
                put(13, 126);
                put(12, 122);
                put(11, 118);
                put(10, 114);
                put(9, 110);
                put(8, 106);
                put(7, 102);
                put(6, 98);
                put(5, 94);
                put(4, 90);
                put(3, 86);
                put(2, 82);
                put(1, 78);
                put(0, 74);
            }
        });

        interpretations.put("SE13", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 134);
                put(18, 134);
                put(17, 134);
                put(16, 134);
                put(15, 130);
                put(14, 127);
                put(13, 123);
                put(12, 119);
                put(11, 115);
                put(10, 111);
                put(9, 107);
                put(8, 103);
                put(7, 100);
                put(6, 96);
                put(5, 92);
                put(4, 88);
                put(3, 84);
                put(2, 80);
                put(1, 77);
                put(0, 73);
            }
        });

        interpretations.put("SE14", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 134);
                put(18, 134);
                put(17, 134);
                put(16, 131);
                put(15, 127);
                put(14, 123);
                put(13, 120);
                put(12, 116);
                put(11, 112);
                put(10, 109);
                put(9, 105);
                put(8, 101);
                put(7, 97);
                put(6, 94);
                put(5, 90);
                put(4, 86);
                put(3, 83);
                put(2, 79);
                put(1, 75);
                put(0, 71);
            }
        });

        interpretations.put("SE15", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 132);
                put(18, 132);
                put(17, 129);
                put(16, 126);
                put(15, 123);
                put(14, 119);
                put(13, 115);
                put(12, 112);
                put(11, 108);
                put(10, 105);
                put(9, 101);
                put(8, 98);
                put(7, 94);
                put(6, 91);
                put(5, 88);
                put(4, 84);
                put(3, 81);
                put(2, 77);
                put(1, 74);
                put(0, 70);
            }
        });

        interpretations.put("SE16", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 132);
                put(18, 128);
                put(17, 125);
                put(16, 122);
                put(15, 118);
                put(14, 115);
                put(13, 112);
                put(12, 108);
                put(11, 125);
                put(10, 102);
                put(9, 98);
                put(8, 95);
                put(7, 92);
                put(6, 88);
                put(5, 85);
                put(4, 82);
                put(3, 78);
                put(2, 75);
                put(1, 72);
                put(0, 68);
            }
        });

        interpretations.put("SE17", new TreeMap<Integer, Integer>() {
            {
                put(20, 130);
                put(19, 127);
                put(18, 124);
                put(17, 121);
                put(16, 118);
                put(15, 115);
                put(14, 112);
                put(13, 108);
                put(12, 125);
                put(11, 102);
                put(10, 99);
                put(9, 96);
                put(8, 93);
                put(7, 90);
                put(6, 87);
                put(5, 84);
                put(4, 81);
                put(3, 78);
                put(2, 75);
                put(1, 72);
                put(0, 69);
            }
        });

        interpretations.put("SE18", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 124);
                put(18, 121);
                put(17, 119);
                put(16, 116);
                put(15, 113);
                put(14, 110);
                put(13, 107);
                put(12, 104);
                put(11, 101);
                put(10, 99);
                put(9, 96);
                put(8, 93);
                put(7, 90);
                put(6, 87);
                put(5, 84);
                put(4, 81);
                put(3, 79);
                put(2, 76);
                put(1, 73);
                put(0, 70);
            }
        });

        interpretations.put("SE19-20", new TreeMap<Integer, Integer>() {
            {
                put(20, 126);
                put(19, 123);
                put(18, 120);
                put(17, 117);
                put(16, 114);
                put(15, 112);
                put(14, 109);
                put(13, 106);
                put(12, 103);
                put(11, 101);
                put(10, 98);
                put(9, 95);
                put(8, 92);
                put(7, 89);
                put(6, 87);
                put(5, 84);
                put(4, 81);
                put(3, 78);
                put(2, 76);
                put(1, 73);
                put(0, 70);
            }
        });

        interpretations.put("SE21-25", new TreeMap<Integer, Integer>() {
            {
                put(20, 126);
                put(19, 124);
                put(18, 121);
                put(17, 118);
                put(16, 115);
                put(15, 112);
                put(14, 109);
                put(13, 106);
                put(12, 103);
                put(11, 100);
                put(10, 97);
                put(9, 94);
                put(8, 91);
                put(7, 88);
                put(6, 85);
                put(5, 82);
                put(4, 79);
                put(3, 76);
                put(2, 74);
                put(1, 71);
                put(0, 68);
            }
        });

        interpretations.put("SE26-30", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 124);
                put(18, 121);
                put(17, 118);
                put(16, 115);
                put(15, 112);
                put(14, 108);
                put(13, 105);
                put(12, 102);
                put(11, 99);
                put(10, 96);
                put(9, 93);
                put(8, 90);
                put(7, 87);
                put(6, 84);
                put(5, 81);
                put(4, 78);
                put(3, 75);
                put(2, 72);
                put(1, 69);
                put(0, 66);
            }
        });

        interpretations.put("SE31-35", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 124);
                put(18, 121);
                put(17, 118);
                put(16, 115);
                put(15, 112);
                put(14, 109);
                put(13, 106);
                put(12, 103);
                put(11, 100);
                put(10, 97);
                put(9, 94);
                put(8, 91);
                put(7, 89);
                put(6, 86);
                put(5, 83);
                put(4, 80);
                put(3, 77);
                put(2, 74);
                put(1, 71);
                put(0, 68);
            }
        });

        interpretations.put("SE36-40", new TreeMap<Integer, Integer>() {
            {
                put(20, 123);
                put(19, 125);
                put(18, 122);
                put(17, 119);
                put(16, 116);
                put(15, 113);
                put(14, 110);
                put(13, 107);
                put(12, 104);
                put(11, 101);
                put(10, 99);
                put(9, 96);
                put(8, 93);
                put(7, 90);
                put(6, 87);
                put(5, 84);
                put(4, 81);
                put(3, 78);
                put(2, 75);
                put(1, 72);
                put(0, 69);
            }
        });

        interpretations.put("SE41-45", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 126);
                put(18, 123);
                put(17, 120);
                put(16, 117);
                put(15, 114);
                put(14, 111);
                put(13, 109);
                put(12, 106);
                put(11, 103);
                put(10, 100);
                put(9, 97);
                put(8, 94);
                put(7, 91);
                put(6, 89);
                put(5, 86);
                put(4, 83);
                put(3, 80);
                put(2, 77);
                put(1, 74);
                put(0, 71);
            }
        });

        interpretations.put("SE46-50", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 129);
                put(18, 126);
                put(17, 123);
                put(16, 120);
                put(15, 117);
                put(14, 114);
                put(13, 111);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 99);
                put(8, 96);
                put(7, 93);
                put(6, 90);
                put(5, 87);
                put(4, 84);
                put(3, 81);
                put(2, 79);
                put(1, 76);
                put(0, 73);
            }
        });

        interpretations.put("SE51-60", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 131);
                put(18, 129);
                put(17, 126);
                put(16, 123);
                put(15, 120);
                put(14, 117);
                put(13, 114);
                put(12, 111);
                put(11, 108);
                put(10, 105);
                put(9, 102);
                put(8, 99);
                put(7, 96);
                put(6, 93);
                put(5, 90);
                put(4, 87);
                put(3, 84);
                put(2, 81);
                put(1, 79);
                put(0, 76);
            }
        });

        interpretations.put("WA12", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 133);
                put(18, 133);
                put(17, 133);
                put(16, 133);
                put(15, 133);
                put(14, 129);
                put(13, 125);
                put(12, 120);
                put(11, 116);
                put(10, 112);
                put(9, 108);
                put(8, 104);
                put(7, 100);
                put(6, 95);
                put(5, 91);
                put(4, 87);
                put(3, 83);
                put(2, 79);
                put(1, 75);
                put(0, 70);
            }
        });

        interpretations.put("WA13", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 133);
                put(18, 133);
                put(17, 133);
                put(16, 133);
                put(15, 129);
                put(14, 125);
                put(13, 121);
                put(12, 117);
                put(11, 113);
                put(10, 109);
                put(9, 105);
                put(8, 101);
                put(7, 97);
                put(6, 93);
                put(5, 89);
                put(4, 85);
                put(3, 81);
                put(2, 77);
                put(1, 73);
                put(0, 69);
            }
        });

        interpretations.put("WA14", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 131);
                put(18, 131);
                put(17, 131);
                put(16, 127);
                put(15, 124);
                put(14, 121);
                put(13, 117);
                put(12, 114);
                put(11, 110);
                put(10, 106);
                put(9, 103);
                put(8, 99);
                put(7, 96);
                put(6, 92);
                put(5, 89);
                put(4, 85);
                put(3, 81);
                put(2, 78);
                put(1, 74);
                put(0, 71);
            }
        });

        interpretations.put("WA15", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 131);
                put(18, 131);
                put(17, 128);
                put(16, 124);
                put(15, 121);
                put(14, 117);
                put(13, 114);
                put(12, 110);
                put(11, 107);
                put(10, 103);
                put(9, 100);
                put(8, 97);
                put(7, 93);
                put(6, 90);
                put(5, 86);
                put(4, 83);
                put(3, 79);
                put(2, 76);
                put(1, 72);
                put(0, 69);
            }
        });

        interpretations.put("WA16", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 132);
                put(18, 128);
                put(17, 125);
                put(16, 122);
                put(15, 118);
                put(14, 115);
                put(13, 112);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 98);
                put(8, 95);
                put(7, 92);
                put(6, 88);
                put(5, 85);
                put(4, 82);
                put(3, 78);
                put(2, 75);
                put(1, 72);
                put(0, 68);
            }
        });

        interpretations.put("WA17", new TreeMap<Integer, Integer>() {
            {
                put(20, 137);
                put(19, 133);
                put(18, 126);
                put(17, 130);
                put(16, 122);
                put(15, 119);
                put(14, 115);
                put(13, 111);
                put(12, 107);
                put(11, 104);
                put(10, 100);
                put(9, 96);
                put(8, 93);
                put(7, 89);
                put(6, 85);
                put(5, 81);
                put(4, 78);
                put(3, 74);
                put(2, 70);
                put(1, 67);
                put(0, 63);
            }
        });

        interpretations.put("WA18", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 130);
                put(18, 126);
                put(17, 123);
                put(16, 119);
                put(15, 116);
                put(14, 112);
                put(13, 109);
                put(12, 106);
                put(11, 102);
                put(10, 99);
                put(9, 95);
                put(8, 92);
                put(7, 88);
                put(6, 85);
                put(5, 81);
                put(4, 78);
                put(3, 74);
                put(2, 71);
                put(1, 68);
                put(0, 64);
            }
        });

        interpretations.put("WA19-20", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 128);
                put(18, 125);
                put(17, 121);
                put(16, 118);
                put(15, 115);
                put(14, 111);
                put(13, 108);
                put(12, 105);
                put(11, 101);
                put(10, 98);
                put(9, 95);
                put(8, 91);
                put(7, 88);
                put(6, 85);
                put(5, 81);
                put(4, 78);
                put(3, 75);
                put(2, 71);
                put(1, 68);
                put(0, 65);
            }
        });

        interpretations.put("WA21-25", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 131);
                put(18, 127);
                put(17, 124);
                put(16, 120);
                put(15, 116);
                put(14, 113);
                put(13, 109);
                put(12, 106);
                put(11, 102);
                put(10, 99);
                put(9, 95);
                put(8, 91);
                put(7, 88);
                put(6, 84);
                put(5, 81);
                put(4, 77);
                put(3, 74);
                put(2, 70);
                put(1, 66);
                put(0, 63);
            }
        });

        interpretations.put("WA26-30", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 129);
                put(18, 126);
                put(17, 123);
                put(16, 119);
                put(15, 116);
                put(14, 113);
                put(13, 109);
                put(12, 106);
                put(11, 103);
                put(10, 99);
                put(9, 96);
                put(8, 93);
                put(7, 89);
                put(6, 86);
                put(5, 83);
                put(4, 79);
                put(3, 76);
                put(2, 73);
                put(1, 69);
                put(0, 66);
            }
        });

        interpretations.put("WA31-35", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 131);
                put(18, 127);
                put(17, 124);
                put(16, 121);
                put(15, 117);
                put(14, 114);
                put(13, 111);
                put(12, 107);
                put(11, 104);
                put(10, 101);
                put(9, 97);
                put(8, 94);
                put(7, 91);
                put(6, 87);
                put(5, 84);
                put(4, 81);
                put(3, 77);
                put(2, 74);
                put(1, 71);
                put(0, 67);
            }
        });

        interpretations.put("WA36-40", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 130);
                put(18, 127);
                put(17, 124);
                put(16, 121);
                put(15, 118);
                put(14, 114);
                put(13, 111);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 99);
                put(8, 96);
                put(7, 93);
                put(6, 89);
                put(5, 86);
                put(4, 83);
                put(3, 80);
                put(2, 77);
                put(1, 74);
                put(0, 71);
            }
        });

        interpretations.put("WA41-45", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 129);
                put(18, 126);
                put(17, 123);
                put(16, 120);
                put(15, 117);
                put(14, 115);
                put(13, 112);
                put(12, 109);
                put(11, 106);
                put(10, 103);
                put(9, 100);
                put(8, 97);
                put(7, 95);
                put(6, 92);
                put(5, 89);
                put(4, 86);
                put(3, 83);
                put(2, 80);
                put(1, 77);
                put(0, 75);
            }
        });

        interpretations.put("WA46-50", new TreeMap<Integer, Integer>() {
            {
                put(20, 135);
                put(19, 135);
                put(18, 131);
                put(17, 128);
                put(16, 125);
                put(15, 122);
                put(14, 118);
                put(13, 115);
                put(12, 112);
                put(11, 109);
                put(10, 105);
                put(9, 102);
                put(8, 99);
                put(7, 96);
                put(6, 93);
                put(5, 89);
                put(4, 86);
                put(3, 83);
                put(2, 80);
                put(1, 76);
                put(0, 73);
            }
        });

        interpretations.put("WA51-60", new TreeMap<Integer, Integer>() {
            {
                put(20, 135);
                put(19, 135);
                put(18, 135);
                put(17, 131);
                put(16, 128);
                put(15, 125);
                put(14, 122);
                put(13, 118);
                put(12, 115);
                put(11, 112);
                put(10, 109);
                put(9, 105);
                put(8, 102);
                put(7, 99);
                put(6, 96);
                put(5, 93);
                put(4, 89);
                put(3, 86);
                put(2, 83);
                put(1, 80);
                put(0, 76);
            }
        });

        interpretations.put("WU12", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 133);
                put(18, 133);
                put(17, 130);
                put(16, 127);
                put(15, 123);
                put(14, 120);
                put(13, 117);
                put(12, 114);
                put(11, 111);
                put(10, 108);
                put(9, 105);
                put(8, 102);
                put(7, 98);
                put(6, 95);
                put(5, 92);
                put(4, 89);
                put(3, 86);
                put(2, 83);
                put(1, 80);
                put(0, 77);
            }
        });

        interpretations.put("WU13", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 134);
                put(18, 131);
                put(17, 128);
                put(16, 125);
                put(15, 122);
                put(14, 119);
                put(13, 116);
                put(12, 113);
                put(11, 109);
                put(10, 106);
                put(9, 103);
                put(8, 100);
                put(7, 97);
                put(6, 94);
                put(5, 91);
                put(4, 88);
                put(3, 84);
                put(2, 81);
                put(1, 78);
                put(0, 75);
            }
        });

        interpretations.put("WU14", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 133);
                put(18, 133);
                put(17, 130);
                put(16, 126);
                put(15, 123);
                put(14, 119);
                put(13, 116);
                put(12, 112);
                put(11, 109);
                put(10, 106);
                put(9, 102);
                put(8, 99);
                put(7, 95);
                put(6, 92);
                put(5, 88);
                put(4, 85);
                put(3, 81);
                put(2, 78);
                put(1, 74);
                put(0, 71);
            }
        });

        interpretations.put("WU15", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 132);
                put(18, 132);
                put(17, 129);
                put(16, 125);
                put(15, 122);
                put(14, 118);
                put(13, 115);
                put(12, 111);
                put(11, 108);
                put(10, 104);
                put(9, 101);
                put(8, 98);
                put(7, 94);
                put(6, 91);
                put(5, 87);
                put(4, 84);
                put(3, 80);
                put(2, 77);
                put(1, 73);
                put(0, 70);
            }
        });

        interpretations.put("WU16", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 131);
                put(18, 128);
                put(17, 125);
                put(16, 122);
                put(15, 118);
                put(14, 115);
                put(13, 112);
                put(12, 109);
                put(11, 106);
                put(10, 103);
                put(9, 100);
                put(8, 97);
                put(7, 93);
                put(6, 90);
                put(5, 87);
                put(4, 84);
                put(3, 81);
                put(2, 78);
                put(1, 75);
                put(0, 72);
            }
        });

        interpretations.put("WU17", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 129);
                put(18, 126);
                put(17, 123);
                put(16, 120);
                put(15, 117);
                put(14, 114);
                put(13, 111);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 99);
                put(8, 96);
                put(7, 93);
                put(6, 90);
                put(5, 87);
                put(4, 84);
                put(3, 81);
                put(2, 78);
                put(1, 75);
                put(0, 72);
            }
        });

        interpretations.put("WU18", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 126);
                put(18, 123);
                put(17, 121);
                put(16, 117);
                put(15, 115);
                put(14, 112);
                put(13, 109);
                put(12, 107);
                put(11, 104);
                put(10, 101);
                put(9, 98);
                put(8, 96);
                put(7, 93);
                put(6, 90);
                put(5, 87);
                put(4, 84);
                put(3, 82);
                put(2, 79);
                put(1, 76);
                put(0, 73);
            }
        });

        interpretations.put("WU19-20", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 126);
                put(18, 123);
                put(17, 121);
                put(16, 118);
                put(15, 115);
                put(14, 112);
                put(13, 109);
                put(12, 106);
                put(11, 103);
                put(10, 101);
                put(9, 98);
                put(8, 95);
                put(7, 92);
                put(6, 89);
                put(5, 86);
                put(4, 83);
                put(3, 81);
                put(2, 78);
                put(1, 75);
                put(0, 72);
            }
        });

        interpretations.put("WU21-25", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 126);
                put(18, 123);
                put(17, 120);
                put(16, 117);
                put(15, 115);
                put(14, 112);
                put(13, 109);
                put(12, 106);
                put(11, 103);
                put(10, 100);
                put(9, 97);
                put(8, 95);
                put(7, 92);
                put(6, 89);
                put(5, 86);
                put(4, 83);
                put(3, 80);
                put(2, 77);
                put(1, 75);
                put(0, 72);
            }
        });

        interpretations.put("WU26-30", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 128);
                put(18, 125);
                put(17, 122);
                put(16, 119);
                put(15, 116);
                put(14, 113);
                put(13, 110);
                put(12, 107);
                put(11, 104);
                put(10, 101);
                put(9, 99);
                put(8, 96);
                put(7, 93);
                put(6, 90);
                put(5, 87);
                put(4, 84);
                put(3, 81);
                put(2, 78);
                put(1, 75);
                put(0, 72);
            }
        });

        interpretations.put("WU31-35", new TreeMap<Integer, Integer>() {
            {
                put(20, 130);
                put(19, 127);
                put(18, 124);
                put(17, 122);
                put(16, 119);
                put(15, 116);
                put(14, 113);
                put(13, 111);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 99);
                put(8, 97);
                put(7, 94);
                put(6, 91);
                put(5, 88);
                put(4, 86);
                put(3, 83);
                put(2, 80);
                put(1, 77);
                put(0, 74);
            }
        });

        interpretations.put("WU36-40", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 129);
                put(18, 126);
                put(17, 123);
                put(16, 121);
                put(15, 118);
                put(14, 115);
                put(13, 112);
                put(12, 109);
                put(11, 107);
                put(10, 104);
                put(9, 101);
                put(8, 98);
                put(7, 96);
                put(6, 93);
                put(5, 90);
                put(4, 87);
                put(3, 84);
                put(2, 82);
                put(1, 79);
                put(0, 76);
            }
        });

        interpretations.put("WU41-45", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 129);
                put(18, 126);
                put(17, 124);
                put(16, 121);
                put(15, 118);
                put(14, 115);
                put(13, 113);
                put(12, 110);
                put(11, 107);
                put(10, 105);
                put(9, 102);
                put(8, 99);
                put(7, 96);
                put(6, 94);
                put(5, 91);
                put(4, 88);
                put(3, 86);
                put(2, 83);
                put(1, 80);
                put(0, 78);
            }
        });

        interpretations.put("WU46-50", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 131);
                put(18, 128);
                put(17, 125);
                put(16, 123);
                put(15, 120);
                put(14, 117);
                put(13, 115);
                put(12, 112);
                put(11, 109);
                put(10, 106);
                put(9, 104);
                put(8, 101);
                put(7, 98);
                put(6, 96);
                put(5, 93);
                put(4, 90);
                put(3, 88);
                put(2, 85);
                put(1, 82);
                put(0, 79);
            }
        });

        interpretations.put("ZR12", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 133);
                put(18, 133);
                put(17, 133);
                put(16, 133);
                put(15, 130);
                put(14, 127);
                put(13, 123);
                put(12, 120);
                put(11, 117);
                put(10, 113);
                put(9, 110);
                put(8, 107);
                put(7, 103);
                put(6, 100);
                put(5, 97);
                put(4, 93);
                put(3, 90);
                put(2, 87);
                put(1, 83);
                put(0, 80);
            }
        });

        interpretations.put("ZR13", new TreeMap<Integer, Integer>() {
            {
                put(20, 134);
                put(19, 134);
                put(18, 134);
                put(17, 131);
                put(16, 128);
                put(15, 125);
                put(14, 122);
                put(13, 119);
                put(12, 116);
                put(11, 113);
                put(10, 110);
                put(9, 107);
                put(8, 104);
                put(7, 101);
                put(6, 99);
                put(5, 96);
                put(4, 93);
                put(3, 90);
                put(2, 87);
                put(1, 84);
                put(0, 81);
            }
        });

        interpretations.put("ZR14", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 131);
                put(18, 131);
                put(17, 129);
                put(16, 125);
                put(15, 123);
                put(14, 120);
                put(13, 117);
                put(12, 114);
                put(11, 111);
                put(10, 108);
                put(9, 105);
                put(8, 103);
                put(7, 100);
                put(6, 97);
                put(5, 94);
                put(4, 91);
                put(3, 88);
                put(2, 85);
                put(1, 83);
                put(0, 80);
            }
        });

        interpretations.put("ZR15", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 129);
                put(18, 126);
                put(17, 124);
                put(16, 121);
                put(15, 118);
                put(14, 116);
                put(13, 113);
                put(12, 110);
                put(11, 108);
                put(10, 105);
                put(9, 102);
                put(8, 99);
                put(7, 97);
                put(6, 94);
                put(5, 91);
                put(4, 89);
                put(3, 86);
                put(2, 83);
                put(1, 81);
                put(0, 78);
            }
        });

        interpretations.put("ZR16", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 126);
                put(18, 124);
                put(17, 121);
                put(16, 119);
                put(15, 116);
                put(14, 114);
                put(13, 111);
                put(12, 108);
                put(11, 106);
                put(10, 103);
                put(9, 101);
                put(8, 98);
                put(7, 96);
                put(6, 93);
                put(5, 91);
                put(4, 88);
                put(3, 85);
                put(2, 83);
                put(1, 80);
                put(0, 78);
            }
        });

        interpretations.put("ZR17", new TreeMap<Integer, Integer>() {
            {
                put(20, 126);
                put(19, 124);
                put(18, 121);
                put(17, 119);
                put(16, 116);
                put(15, 114);
                put(14, 111);
                put(13, 109);
                put(12, 106);
                put(11, 104);
                put(10, 101);
                put(9, 99);
                put(8, 96);
                put(7, 94);
                put(6, 91);
                put(5, 89);
                put(4, 86);
                put(3, 84);
                put(2, 81);
                put(1, 79);
                put(0, 76);
            }
        });

        interpretations.put("ZR18", new TreeMap<Integer, Integer>() {
            {
                put(20, 124);
                put(19, 122);
                put(18, 119);
                put(17, 117);
                put(16, 115);
                put(15, 112);
                put(14, 110);
                put(13, 107);
                put(12, 105);
                put(11, 103);
                put(10, 100);
                put(9, 98);
                put(8, 95);
                put(7, 93);
                put(6, 91);
                put(5, 88);
                put(4, 86);
                put(3, 84);
                put(2, 81);
                put(1, 79);
                put(0, 76);
            }
        });

        interpretations.put("ZR19-20", new TreeMap<Integer, Integer>() {
            {
                put(20, 123);
                put(19, 120);
                put(18, 118);
                put(17, 116);
                put(16, 113);
                put(15, 111);
                put(14, 109);
                put(13, 106);
                put(12, 104);
                put(11, 102);
                put(10, 99);
                put(9, 97);
                put(8, 95);
                put(7, 92);
                put(6, 90);
                put(5, 88);
                put(4, 85);
                put(3, 83);
                put(2, 81);
                put(1, 78);
                put(0, 76);
            }
        });

        interpretations.put("ZR21-25", new TreeMap<Integer, Integer>() {
            {
                put(20, 125);
                put(19, 122);
                put(18, 120);
                put(17, 118);
                put(16, 115);
                put(15, 113);
                put(14, 110);
                put(13, 108);
                put(12, 106);
                put(11, 103);
                put(10, 101);
                put(9, 99);
                put(8, 96);
                put(7, 94);
                put(6, 91);
                put(5, 89);
                put(4, 87);
                put(3, 84);
                put(2, 82);
                put(1, 80);
                put(0, 77);
            }
        });

        interpretations.put("ZR26-30", new TreeMap<Integer, Integer>() {
            {
                put(20, 125);
                put(19, 123);
                put(18, 120);
                put(17, 118);
                put(16, 116);
                put(15, 113);
                put(14, 111);
                put(13, 109);
                put(12, 107);
                put(11, 104);
                put(10, 102);
                put(9, 100);
                put(8, 97);
                put(7, 95);
                put(6, 93);
                put(5, 90);
                put(4, 88);
                put(3, 86);
                put(2, 83);
                put(1, 81);
                put(0, 79);
            }
        });

        interpretations.put("ZR31-35", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 125);
                put(18, 122);
                put(17, 120);
                put(16, 117);
                put(15, 115);
                put(14, 113);
                put(13, 110);
                put(12, 108);
                put(11, 105);
                put(10, 103);
                put(9, 101);
                put(8, 98);
                put(7, 96);
                put(6, 94);
                put(5, 91);
                put(4, 89);
                put(3, 86);
                put(2, 84);
                put(1, 82);
                put(0, 79);
            }
        });

        interpretations.put("ZR36-40", new TreeMap<Integer, Integer>() {
            {
                put(20, 126);
                put(19, 124);
                put(18, 121);
                put(17, 119);
                put(16, 117);
                put(15, 115);
                put(14, 112);
                put(13, 110);
                put(12, 108);
                put(11, 106);
                put(10, 104);
                put(9, 101);
                put(8, 99);
                put(7, 97);
                put(6, 95);
                put(5, 92);
                put(4, 90);
                put(3, 88);
                put(2, 86);
                put(1, 84);
                put(0, 81);
            }
        });

        interpretations.put("ZR41-45", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 126);
                put(18, 124);
                put(17, 121);
                put(16, 119);
                put(15, 117);
                put(14, 114);
                put(13, 112);
                put(12, 110);
                put(11, 107);
                put(10, 105);
                put(9, 102);
                put(8, 100);
                put(7, 98);
                put(6, 95);
                put(5, 93);
                put(4, 90);
                put(3, 88);
                put(2, 86);
                put(1, 83);
                put(0, 81);
            }
        });

        interpretations.put("ZR46-50", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 127);
                put(18, 124);
                put(17, 122);
                put(16, 120);
                put(15, 118);
                put(14, 115);
                put(13, 113);
                put(12, 111);
                put(11, 108);
                put(10, 106);
                put(9, 104);
                put(8, 102);
                put(7, 99);
                put(6, 97);
                put(5, 95);
                put(4, 92);
                put(3, 90);
                put(2, 88);
                put(1, 86);
                put(0, 83);
            }
        });

        interpretations.put("ZR51-60", new TreeMap<Integer, Integer>() {
            {
                put(20, 130);
                put(19, 128);
                put(18, 126);
                put(17, 123);
                put(16, 121);
                put(15, 119);
                put(14, 116);
                put(13, 114);
                put(12, 112);
                put(11, 109);
                put(10, 107);
                put(9, 105);
                put(8, 102);
                put(7, 100);
                put(6, 98);
                put(5, 95);
                put(4, 93);
                put(3, 91);
                put(2, 88);
                put(1, 86);
                put(0, 84);
            }
        });

        interpretations.put("WU51-60", new TreeMap<Integer, Integer>() {
            {
                put(20, 136);
                put(19, 133);
                put(18, 131);
                put(17, 128);
                put(16, 125);
                put(15, 122);
                put(14, 119);
                put(13, 117);
                put(12, 114);
                put(11, 111);
                put(10, 108);
                put(9, 106);
                put(8, 102);
                put(7, 100);
                put(6, 97);
                put(5, 94);
                put(4, 92);
                put(3, 89);
                put(2, 86);
                put(1, 83);
                put(0, 81);
            }
        });

        interpretations.put("GE12", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 132);
                put(18, 132);
                put(17, 132);
                put(16, 132);
                put(15, 132);
                put(14, 129);
                put(13, 125);
                put(12, 121);
                put(11, 117);
                put(10, 114);
                put(9, 110);
                put(8, 106);
                put(7, 103);
                put(6, 99);
                put(5, 95);
                put(4, 91);
                put(3, 88);
                put(2, 84);
                put(1, 80);
                put(0, 77);
            }
        });
        interpretations.put("GE13", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 132);
                put(18, 132);
                put(17, 132);
                put(16, 132);
                put(15, 129);
                put(14, 125);
                put(13, 121);
                put(12, 118);
                put(11, 114);
                put(10, 111);
                put(9, 107);
                put(8, 104);
                put(7, 100);
                put(6, 97);
                put(5, 93);
                put(4, 89);
                put(3, 86);
                put(2, 82);
                put(1, 79);
                put(0, 75);
            }
        });
        interpretations.put("GE14", new TreeMap<Integer, Integer>() {
            {
                put(20, 132);
                put(19, 132);
                put(18, 132);
                put(17, 132);
                put(16, 129);
                put(15, 126);
                put(14, 122);
                put(13, 119);
                put(12, 115);
                put(11, 112);
                put(10, 108);
                put(9, 105);
                put(8, 101);
                put(7, 97);
                put(6, 94);
                put(5, 91);
                put(4, 88);
                put(3, 84);
                put(2, 81);
                put(1, 77);
                put(0, 74);
            }
        });
        interpretations.put("GE15", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 133);
                put(18, 133);
                put(17, 130);
                put(16, 126);
                put(15, 123);
                put(14, 119);
                put(13, 116);
                put(12, 112);
                put(11, 109);
                put(10, 106);
                put(9, 102);
                put(8, 99);
                put(7, 95);
                put(6, 92);
                put(5, 88);
                put(4, 85);
                put(3, 81);
                put(2, 78);
                put(1, 74);
                put(0, 71);
            }
        });
        interpretations.put("GE16", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 131);
                put(18, 128);
                put(17, 125);
                put(16, 122);
                put(15, 119);
                put(14, 116);
                put(13, 113);
                put(12, 109);
                put(11, 106);
                put(10, 103);
                put(9, 100);
                put(8, 97);
                put(7, 94);
                put(6, 91);
                put(5, 88);
                put(4, 84);
                put(3, 81);
                put(2, 78);
                put(1, 75);
                put(0, 72);
            }
        });
        interpretations.put("GE17", new TreeMap<Integer, Integer>() {
            {
                put(20, 127);
                put(19, 124);
                put(18, 122);
                put(17, 119);
                put(16, 116);
                put(15, 114);
                put(14, 111);
                put(13, 108);
                put(12, 106);
                put(11, 103);
                put(10, 101);
                put(9, 98);
                put(8, 95);
                put(7, 93);
                put(6, 90);
                put(5, 87);
                put(4, 85);
                put(3, 82);
                put(2, 79);
                put(1, 77);
                put(0, 74);
            }
        });
        interpretations.put("GE18", new TreeMap<Integer, Integer>() {
            {
                put(20, 125);
                put(19, 122);
                put(18, 120);
                put(17, 117);
                put(16, 115);
                put(15, 112);
                put(14, 110);
                put(13, 107);
                put(12, 105);
                put(11, 102);
                put(10, 100);
                put(9, 97);
                put(8, 95);
                put(7, 92);
                put(6, 90);
                put(5, 87);
                put(4, 85);
                put(3, 82);
                put(2, 80);
                put(1, 77);
                put(0, 75);
            }
        });
        interpretations.put("GE19-20", new TreeMap<Integer, Integer>() {
            {
                put(20, 124);
                put(19, 122);
                put(18, 119);
                put(17, 116);
                put(16, 114);
                put(15, 111);
                put(14, 109);
                put(13, 106);
                put(12, 104);
                put(11, 101);
                put(10, 98);
                put(9, 96);
                put(8, 93);
                put(7, 91);
                put(6, 88);
                put(5, 86);
                put(4, 83);
                put(3, 81);
                put(2, 78);
                put(1, 75);
                put(0, 73);
            }
        });
        interpretations.put("GE21-25", new TreeMap<Integer, Integer>() {
            {
                put(20, 125);
                put(19, 122);
                put(18, 119);
                put(17, 117);
                put(16, 114);
                put(15, 111);
                put(14, 108);
                put(13, 106);
                put(12, 103);
                put(11, 100);
                put(10, 97);
                put(9, 94);
                put(8, 92);
                put(7, 89);
                put(6, 86);
                put(5, 83);
                put(4, 81);
                put(3, 76);
                put(2, 75);
                put(1, 72);
                put(0, 69);
            }
        });
        interpretations.put("GE26-30", new TreeMap<Integer, Integer>() {
            {
                put(20, 124);
                put(19, 121);
                put(18, 119);
                put(17, 116);
                put(16, 113);
                put(15, 110);
                put(14, 108);
                put(13, 105);
                put(12, 102);
                put(11, 99);
                put(10, 96);
                put(9, 94);
                put(8, 91);
                put(7, 88);
                put(6, 85);
                put(5, 83);
                put(4, 80);
                put(3, 77);
                put(2, 74);
                put(1, 71);
                put(0, 69);
            }
        });
        interpretations.put("GE31-35", new TreeMap<Integer, Integer>() {
            {
                put(20, 126);
                put(19, 123);
                put(18, 120);
                put(17, 117);
                put(16, 115);
                put(15, 112);
                put(14, 109);
                put(13, 106);
                put(12, 103);
                put(11, 100);
                put(10, 97);
                put(9, 95);
                put(8, 92);
                put(7, 89);
                put(6, 86);
                put(5, 83);
                put(4, 80);
                put(3, 77);
                put(2, 75);
                put(1, 72);
                put(0, 69);
            }
        });

        interpretations.put("GE36-40", new TreeMap<Integer, Integer>() {
            {
                put(20, 128);
                put(19, 125);
                put(18, 122);
                put(17, 119);
                put(16, 116);
                put(15, 113);
                put(14, 110);
                put(13, 107);
                put(12, 104);
                put(11, 101);
                put(10, 99);
                put(9, 96);
                put(8, 93);
                put(7, 90);
                put(6, 87);
                put(5, 84);
                put(4, 81);
                put(3, 78);
                put(2, 75);
                put(1, 72);
                put(0, 69);
            }
        });
        interpretations.put("GE41-45", new TreeMap<Integer, Integer>() {
            {
                put(20, 129);
                put(19, 126);
                put(18, 123);
                put(17, 120);
                put(16, 117);
                put(15, 114);
                put(14, 111);
                put(13, 109);
                put(12, 106);
                put(11, 103);
                put(10, 100);
                put(9, 97);
                put(8, 94);
                put(7, 91);
                put(6, 89);
                put(5, 86);
                put(4, 83);
                put(3, 80);
                put(2, 77);
                put(1, 74);
                put(0, 71);
            }
        });
        interpretations.put("GE46-50", new TreeMap<Integer, Integer>() {
            {
                put(20, 131);
                put(19, 128);
                put(18, 125);
                put(17, 122);
                put(16, 119);
                put(15, 116);
                put(14, 114);
                put(13, 111);
                put(12, 108);
                put(11, 105);
                put(10, 102);
                put(9, 99);
                put(8, 96);
                put(7, 93);
                put(6, 90);
                put(5, 87);
                put(4, 84);
                put(3, 81);
                put(2, 78);
                put(1, 75);
                put(0, 72);
            }
        });
        interpretations.put("GE51-60", new TreeMap<Integer, Integer>() {
            {
                put(20, 133);
                put(19, 130);
                put(18, 127);
                put(17, 124);
                put(16, 121);
                put(15, 118);
                put(14, 115);
                put(13, 112);
                put(12, 109);
                put(11, 106);
                put(10, 103);
                put(9, 100);
                put(8, 97);
                put(7, 94);
                put(6, 91);
                put(5, 89);
                put(4, 86);
                put(3, 83);
                put(2, 80);
                put(1, 77);
                put(0, 74);
            }
        });

        interpretGESAMT.put("GESAMT12", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 139);
                put(new Range(161, 170), 139);
                put(new Range(151, 160), 139);
                put(new Range(141, 150), 139);
                put(new Range(131, 140), 139);
                put(new Range(121, 130), 139);
                put(new Range(111, 120), 133);
                put(new Range(101, 110), 127);
                put(new Range(91, 100), 121);
                put(new Range(81, 90), 115);
                put(new Range(71, 80), 109);
                put(new Range(61, 70), 104);
                put(new Range(51, 60), 98);
                put(new Range(41, 50), 92);
                put(new Range(31, 40), 86);
                put(new Range(21, 30), 80);
                put(new Range(11, 20), 74);
                put(new Range(1, 10), 68);
            }
        });

        interpretGESAMT.put("GESAMT13", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 133);
                put(new Range(161, 170), 133);
                put(new Range(151, 160), 133);
                put(new Range(141, 150), 133);
                put(new Range(131, 140), 133);
                put(new Range(121, 130), 133);
                put(new Range(111, 120), 128);
                put(new Range(101, 110), 122);
                put(new Range(91, 100), 117);
                put(new Range(81, 90), 111);
                put(new Range(71, 80), 106);
                put(new Range(61, 70), 100);
                put(new Range(51, 60), 94);
                put(new Range(41, 50), 89);
                put(new Range(31, 40), 83);
                put(new Range(21, 30), 78);
                put(new Range(11, 20), 72);
                put(new Range(1, 10), 67);
            }
        });

        interpretGESAMT.put("GESAMT14", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 134);
                put(new Range(161, 170), 134);
                put(new Range(151, 160), 134);
                put(new Range(141, 150), 134);
                put(new Range(131, 140), 134);
                put(new Range(121, 130), 129);
                put(new Range(111, 120), 124);
                put(new Range(101, 110), 118);
                put(new Range(91, 100), 113);
                put(new Range(81, 90), 108);
                put(new Range(71, 80), 103);
                put(new Range(61, 70), 97);
                put(new Range(51, 60), 92);
                put(new Range(41, 50), 87);
                put(new Range(31, 40), 82);
                put(new Range(21, 30), 76);
                put(new Range(11, 20), 71);
                put(new Range(1, 10), 66);
            }
        });

        interpretGESAMT.put("GESAMT15", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 134);
                put(new Range(161, 170), 134);
                put(new Range(151, 160), 134);
                put(new Range(141, 150), 134);
                put(new Range(131, 140), 129);
                put(new Range(121, 130), 124);
                put(new Range(111, 120), 119);
                put(new Range(101, 110), 114);
                put(new Range(91, 100), 109);
                put(new Range(81, 90), 104);
                put(new Range(71, 80), 99);
                put(new Range(61, 70), 94);
                put(new Range(51, 60), 89);
                put(new Range(41, 50), 84);
                put(new Range(31, 40), 79);
                put(new Range(21, 30), 74);
                put(new Range(11, 20), 69);
                put(new Range(1, 10), 64);
            }
        });

        interpretGESAMT.put("GESAMT16", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 134);
                put(new Range(161, 170), 134);
                put(new Range(151, 160), 134);
                put(new Range(141, 150), 130);
                put(new Range(131, 140), 125);
                put(new Range(121, 130), 120);
                put(new Range(111, 120), 115);
                put(new Range(101, 110), 110);
                put(new Range(91, 100), 106);
                put(new Range(81, 90), 101);
                put(new Range(71, 80), 96);
                put(new Range(61, 70), 91);
                put(new Range(51, 60), 87);
                put(new Range(41, 50), 82);
                put(new Range(31, 40), 77);
                put(new Range(21, 30), 72);
                put(new Range(11, 20), 68);
                put(new Range(1, 10), 63);
            }
        });

        interpretGESAMT.put("GESAMT17", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 138);
                put(new Range(161, 170), 133);
                put(new Range(151, 160), 129);
                put(new Range(141, 150), 125);
                put(new Range(131, 140), 120);
                put(new Range(121, 130), 116);
                put(new Range(111, 120), 112);
                put(new Range(101, 110), 107);
                put(new Range(91, 100), 103);
                put(new Range(81, 90), 99);
                put(new Range(71, 80), 94);
                put(new Range(61, 70), 90);
                put(new Range(51, 60), 86);
                put(new Range(41, 50), 81);
                put(new Range(31, 40), 77);
                put(new Range(21, 30), 73);
                put(new Range(11, 20), 68);
                put(new Range(1, 10), 63);
            }
        });

        interpretGESAMT.put("GESAMT18", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 135);
                put(new Range(161, 170), 131);
                put(new Range(151, 160), 127);
                put(new Range(141, 150), 123);
                put(new Range(131, 140), 118);
                put(new Range(121, 130), 114);
                put(new Range(111, 120), 110);
                put(new Range(101, 110), 106);
                put(new Range(91, 100), 102);
                put(new Range(81, 90), 98);
                put(new Range(71, 80), 93);
                put(new Range(61, 70), 89);
                put(new Range(51, 60), 85);
                put(new Range(41, 50), 81);
                put(new Range(31, 40), 77);
                put(new Range(21, 30), 73);
                put(new Range(11, 20), 68);
                put(new Range(1, 10), 64);
            }
        });

        interpretGESAMT.put("GESAMT19-20", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 130);
                put(new Range(161, 170), 127);
                put(new Range(151, 160), 123);
                put(new Range(141, 150), 119);
                put(new Range(131, 140), 116);
                put(new Range(121, 130), 112);
                put(new Range(111, 120), 108);
                put(new Range(101, 110), 104);
                put(new Range(91, 100), 101);
                put(new Range(81, 90), 97);
                put(new Range(71, 80), 93);
                put(new Range(61, 70), 90);
                put(new Range(51, 60), 86);
                put(new Range(41, 50), 82);
                put(new Range(31, 40), 79);
                put(new Range(21, 30), 75);
                put(new Range(11, 20), 71);
                put(new Range(1, 10), 67);
            }
        });
        interpretGESAMT.put("GESAMT21-25", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 132);
                put(new Range(161, 170), 128);
                put(new Range(151, 160), 124);
                put(new Range(141, 150), 120);
                put(new Range(131, 140), 117);
                put(new Range(121, 130), 113);
                put(new Range(111, 120), 109);
                put(new Range(101, 110), 105);
                put(new Range(91, 100), 101);
                put(new Range(81, 90), 97);
                put(new Range(71, 80), 94);
                put(new Range(61, 70), 90);
                put(new Range(51, 60), 88);
                put(new Range(41, 50), 82);
                put(new Range(31, 40), 78);
                put(new Range(21, 30), 74);
                put(new Range(11, 20), 70);
                put(new Range(1, 10), 67);
            }
        });
        interpretGESAMT.put("GESAMT26-30", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 133);
                put(new Range(161, 170), 129);
                put(new Range(151, 160), 125);
                put(new Range(141, 150), 121);
                put(new Range(131, 140), 117);
                put(new Range(121, 130), 113);
                put(new Range(111, 120), 110);
                put(new Range(101, 110), 106);
                put(new Range(91, 100), 102);
                put(new Range(81, 90), 98);
                put(new Range(71, 80), 94);
                put(new Range(61, 70), 90);
                put(new Range(51, 60), 87);
                put(new Range(41, 50), 83);
                put(new Range(31, 40), 79);
                put(new Range(21, 30), 75);
                put(new Range(11, 20), 71);
                put(new Range(1, 10), 67);
            }
        });
        interpretGESAMT.put("GESAMT31-35", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 133);
                put(new Range(161, 170), 129);
                put(new Range(151, 160), 125);
                put(new Range(141, 150), 121);
                put(new Range(131, 140), 118);
                put(new Range(121, 130), 114);
                put(new Range(111, 120), 110);
                put(new Range(101, 110), 107);
                put(new Range(91, 100), 103);
                put(new Range(81, 90), 99);
                put(new Range(71, 80), 96);
                put(new Range(61, 70), 92);
                put(new Range(51, 60), 88);
                put(new Range(41, 50), 84);
                put(new Range(31, 40), 81);
                put(new Range(21, 30), 77);
                put(new Range(11, 20), 73);
                put(new Range(1, 10), 70);
            }
        });
        interpretGESAMT.put("GESAMT36-40", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 132);
                put(new Range(161, 170), 128);
                put(new Range(151, 160), 125);
                put(new Range(141, 150), 121);
                put(new Range(131, 140), 118);
                put(new Range(121, 130), 114);
                put(new Range(111, 120), 111);
                put(new Range(101, 110), 108);
                put(new Range(91, 100), 104);
                put(new Range(81, 90), 101);
                put(new Range(71, 80), 97);
                put(new Range(61, 70), 94);
                put(new Range(51, 60), 90);
                put(new Range(41, 50), 87);
                put(new Range(31, 40), 83);
                put(new Range(21, 30), 80);
                put(new Range(11, 20), 77);
                put(new Range(1, 10), 73);
            }
        });
        interpretGESAMT.put("GESAMT41-45", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 133);
                put(new Range(161, 170), 130);
                put(new Range(151, 160), 127);
                put(new Range(141, 150), 123);
                put(new Range(131, 140), 120);
                put(new Range(121, 130), 116);
                put(new Range(111, 120), 113);
                put(new Range(101, 110), 109);
                put(new Range(91, 100), 104);
                put(new Range(81, 90), 102);
                put(new Range(71, 80), 99);
                put(new Range(61, 70), 96);
                put(new Range(51, 60), 92);
                put(new Range(41, 50), 89);
                put(new Range(31, 40), 85);
                put(new Range(21, 30), 82);
                put(new Range(11, 20), 78);
                put(new Range(1, 10), 75);
            }
        });
        interpretGESAMT.put("GESAMT46-50", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 136);
                put(new Range(161, 170), 133);
                put(new Range(151, 160), 129);
                put(new Range(141, 150), 126);
                put(new Range(131, 140), 122);
                put(new Range(121, 130), 119);
                put(new Range(111, 120), 115);
                put(new Range(101, 110), 111);
                put(new Range(91, 100), 108);
                put(new Range(81, 90), 104);
                put(new Range(71, 80), 101);
                put(new Range(61, 70), 97);
                put(new Range(51, 60), 94);
                put(new Range(41, 50), 90);
                put(new Range(31, 40), 86);
                put(new Range(21, 30), 83);
                put(new Range(11, 20), 79);
                put(new Range(1, 10), 76);
            }
        });
        interpretGESAMT.put("GESAMT51-60", new TreeMap<Range, Integer>() {
            {
                put(new Range(171, 180), 136);
                put(new Range(161, 170), 134);
                put(new Range(151, 160), 130);
                put(new Range(141, 150), 126);
                put(new Range(131, 140), 123);
                put(new Range(121, 130), 120);
                put(new Range(111, 120), 116);
                put(new Range(101, 110), 112);
                put(new Range(91, 100), 110);
                put(new Range(81, 90), 106);
                put(new Range(71, 80), 103);
                put(new Range(61, 70), 100);
                put(new Range(51, 60), 96);
                put(new Range(41, 50), 93);
                put(new Range(31, 40), 90);
                put(new Range(21, 30), 86);
                put(new Range(11, 20), 83);
                put(new Range(1, 10), 80);
            }
        });
    }

//    public static void main(String[] args) {
//        NormaIST norm = new NormaIST();
//
//        int swGESAMT = norm.getInterpretGESAMT("GESAMT", 174, 12);
//        System.out.println("swGESAMT: " + swGESAMT);
//        int iq = norm.getIqScore(swGESAMT);
//        System.out.println("IQ: " + iq);
//    }
}
