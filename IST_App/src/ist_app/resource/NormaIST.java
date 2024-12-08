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
import java.util.NavigableMap;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;

public class NormaIST {

    private static Map<String, NavigableMap<Integer, Integer>> dataMap = new TreeMap<>();

    private static void initializeDataMap() {
        dataMap.put("AN12", new TreeMap<Integer, Integer>() {
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

        dataMap.put("AN13", new TreeMap<Integer, Integer>() {
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
        dataMap.put("AN14", new TreeMap<Integer, Integer>() {
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
        dataMap.put("AN15", new TreeMap<Integer, Integer>() {
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
        dataMap.put("AN16", new TreeMap<Integer, Integer>() {
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
        dataMap.put("AN17", new TreeMap<Integer, Integer>() {
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
        dataMap.put("AN18", new TreeMap<Integer, Integer>() {
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
        dataMap.put("AN19-20", new TreeMap<Integer, Integer>() {
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
        dataMap.put("AN21-25", new TreeMap<Integer, Integer>() {
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

        dataMap.put("AN26-30", new TreeMap<Integer, Integer>() {
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

        dataMap.put("AN31-35", new TreeMap<Integer, Integer>() {
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

        dataMap.put("AN36-40", new TreeMap<Integer, Integer>() {
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

        dataMap.put("AN41-45", new TreeMap<Integer, Integer>() {
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

        dataMap.put("AN46-50", new TreeMap<Integer, Integer>() {
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

        dataMap.put("AN51-60", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA12", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA13", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA14", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA15", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA16", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA17", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA18", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA19-20", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA21-25", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA26-30", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA31-35", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA36-40", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA41-45", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA46-50", new TreeMap<Integer, Integer>() {
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

        dataMap.put("FA51-60", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME12", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME13", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME14", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME15", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME16", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME17", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME18", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME19-20", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME21-25", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME26-30", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME31-35", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME36-40", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME41-45", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME46-50", new TreeMap<Integer, Integer>() {
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

        dataMap.put("ME51-60", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA12", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA13", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA14", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA15", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA16", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA17", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA18", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA19-20", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA21-25", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA26-30", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA31-35", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA36-40", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA41-45", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA46-50", new TreeMap<Integer, Integer>() {
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

        dataMap.put("RA51-60", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE12", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE13", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE14", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE15", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE16", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE17", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE18", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE19-20", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE21-25", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE26-30", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE31-35", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE36-40", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE41-45", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE46-50", new TreeMap<Integer, Integer>() {
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

        dataMap.put("SE51-60", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA12", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA13", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA14", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA15", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA16", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA17", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA18", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA19-20", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA21-25", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA26-30", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA31-35", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA36-40", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA41-45", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA46-50", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WA51-60", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU12", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU13", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU14", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU15", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU16", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU17", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU18", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU19-20", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU21-25", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU26-30", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU31-35", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU36-40", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU41-45", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU46-50", new TreeMap<Integer, Integer>() {
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

        dataMap.put("WU51-60", new TreeMap<Integer, Integer>() {
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

        dataMap.put("GE12", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE13", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE14", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE15", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE16", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE17", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE18", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE19-20", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE21-25", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE26-30", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE31-35", new TreeMap<Integer, Integer>() {
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

        dataMap.put("GE36-40", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE41-45", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE46-50", new TreeMap<Integer, Integer>() {
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
        dataMap.put("GE51-60", new TreeMap<Integer, Integer>() {
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

        dataMap.put("GESAMT12", new TreeMap<Integer, Integer>() {
            {
                put(171, 139);
                put(161, 139);
                put(151, 139);
                put(141, 139);
                put(131, 139);
                put(121, 139);
                put(111, 133);
                put(101, 127);
                put(91, 121);
                put(81, 115);
                put(71, 109);
                put(61, 104);
                put(51, 98);
                put(41, 92);
                put(31, 86);
                put(21, 80);
                put(11, 74);
                put(1, 68);
            }
        });
        dataMap.put("GESAMT13", new TreeMap<Integer, Integer>() {
            {
                put(171, 133);
                put(161, 133);
                put(151, 133);
                put(141, 133);
                put(131, 133);
                put(121, 133);
                put(111, 128);
                put(101, 122);
                put(91, 117);
                put(81, 111);
                put(71, 106);
                put(61, 100);
                put(51, 94);
                put(41, 89);
                put(31, 83);
                put(21, 78);
                put(11, 72);
                put(1, 67);
            }
        });
        dataMap.put("GESAMT14", new TreeMap<Integer, Integer>() {
            {
                put(171, 134);
                put(161, 134);
                put(151, 134);
                put(141, 134);
                put(131, 134);
                put(121, 129);
                put(111, 124);
                put(101, 118);
                put(91, 113);
                put(81, 108);
                put(71, 103);
                put(61, 97);
                put(51, 92);
                put(41, 87);
                put(31, 82);
                put(21, 76);
                put(11, 71);
                put(1, 66);
            }
        });
        dataMap.put("GESAMT15", new TreeMap<Integer, Integer>() {
            {
                put(171, 134);
                put(161, 134);
                put(151, 134);
                put(141, 134);
                put(131, 129);
                put(121, 124);
                put(111, 119);
                put(101, 114);
                put(91, 109);
                put(81, 104);
                put(71, 99);
                put(61, 94);
                put(51, 89);
                put(41, 84);
                put(31, 79);
                put(21, 74);
                put(11, 69);
                put(1, 64);
            }
        });
        dataMap.put("GESAMT16", new TreeMap<Integer, Integer>() {
            {
                put(171, 134);
                put(161, 134);
                put(151, 134);
                put(141, 130);
                put(131, 125);
                put(121, 120);
                put(111, 115);
                put(101, 110);
                put(91, 106);
                put(81, 101);
                put(71, 96);
                put(61, 91);
                put(51, 87);
                put(41, 82);
                put(31, 77);
                put(21, 72);
                put(11, 68);
                put(1, 63);
            }
        });
        dataMap.put("GESAMT17", new TreeMap<Integer, Integer>() {
            {
                put(171, 138);
                put(161, 133);
                put(151, 129);
                put(141, 125);
                put(131, 120);
                put(121, 116);
                put(111, 112);
                put(101, 107);
                put(91, 103);
                put(81, 99);
                put(71, 94);
                put(61, 90);
                put(51, 86);
                put(41, 81);
                put(31, 77);
                put(21, 73);
                put(11, 68);
                put(1, 63);
            }
        });
        dataMap.put("GESAMT18", new TreeMap<Integer, Integer>() {
            {
                put(171, 135);
                put(161, 131);
                put(151, 127);
                put(141, 123);
                put(131, 118);
                put(121, 114);
                put(111, 110);
                put(101, 106);
                put(91, 102);
                put(81, 98);
                put(71, 93);
                put(61, 89);
                put(51, 85);
                put(41, 81);
                put(31, 77);
                put(21, 73);
                put(11, 68);
                put(1, 64);
            }
        });
        dataMap.put("GESAMT19-20", new TreeMap<Integer, Integer>() {
            {
                put(171, 130);
                put(161, 127);
                put(151, 123);
                put(141, 119);
                put(131, 116);
                put(121, 112);
                put(111, 108);
                put(101, 104);
                put(91, 101);
                put(81, 97);
                put(71, 93);
                put(61, 90);
                put(51, 86);
                put(41, 82);
                put(31, 79);
                put(21, 75);
                put(11, 71);
                put(1, 67);
            }
        });
        dataMap.put("GESAMT21-25", new TreeMap<Integer, Integer>() {
            {
                put(171, 132);
                put(161, 128);
                put(151, 124);
                put(141, 120);
                put(131, 117);
                put(121, 113);
                put(111, 109);
                put(101, 105);
                put(91, 101);
                put(81, 97);
                put(71, 94);
                put(61, 90);
                put(51, 88);
                put(41, 82);
                put(31, 78);
                put(21, 74);
                put(11, 70);
                put(1, 67);
            }
        });
        dataMap.put("GESAMT26-30", new TreeMap<Integer, Integer>() {
            {
                put(171, 133);
                put(161, 129);
                put(151, 125);
                put(141, 121);
                put(131, 117);
                put(121, 113);
                put(111, 110);
                put(101, 106);
                put(91, 102);
                put(81, 98);
                put(71, 94);
                put(61, 90);
                put(51, 87);
                put(41, 83);
                put(31, 79);
                put(21, 75);
                put(11, 71);
                put(1, 67);
            }
        });
        dataMap.put("GESAMT31-35", new TreeMap<Integer, Integer>() {
            {
                put(171, 133);
                put(161, 129);
                put(151, 125);
                put(141, 121);
                put(131, 118);
                put(121, 114);
                put(111, 110);
                put(101, 107);
                put(91, 103);
                put(81, 99);
                put(71, 96);
                put(61, 92);
                put(51, 88);
                put(41, 84);
                put(31, 81);
                put(21, 77);
                put(11, 73);
                put(1, 70);
            }
        });
        dataMap.put("GESAMT36-40", new TreeMap<Integer, Integer>() {
            {
                put(171, 132);
                put(161, 128);
                put(151, 125);
                put(141, 121);
                put(131, 118);
                put(121, 114);
                put(111, 111);
                put(101, 108);
                put(91, 104);
                put(81, 101);
                put(71, 97);
                put(61, 94);
                put(51, 90);
                put(41, 87);
                put(31, 83);
                put(21, 80);
                put(11, 77);
                put(1, 73);
            }
        });
        dataMap.put("GESAMT41-45", new TreeMap<Integer, Integer>() {
            {
                put(171, 133);
                put(161, 130);
                put(151, 127);
                put(141, 123);
                put(131, 120);
                put(121, 116);
                put(111, 113);
                put(101, 109);
                put(91, 104);
                put(81, 102);
                put(71, 99);
                put(61, 96);
                put(51, 92);
                put(41, 89);
                put(31, 85);
                put(21, 82);
                put(11, 78);
                put(1, 75);
            }
        });
        dataMap.put("GESAMT46-50", new TreeMap<Integer, Integer>() {
            {
                put(171, 136);
                put(161, 133);
                put(151, 129);
                put(141, 126);
                put(131, 122);
                put(121, 119);
                put(111, 115);
                put(101, 111);
                put(91, 108);
                put(81, 104);
                put(71, 101);
                put(61, 97);
                put(51, 94);
                put(41, 90);
                put(31, 86);
                put(21, 83);
                put(11, 79);
                put(1, 76);
            }
        });
        dataMap.put("GESAMT51-60", new TreeMap<Integer, Integer>() {
            {
                put(171, 136);
                put(161, 134);
                put(151, 130);
                put(141, 126);
                put(131, 123);
                put(121, 120);
                put(111, 116);
                put(101, 112);
                put(91, 110);
                put(81, 106);
                put(71, 103);
                put(61, 100);
                put(51, 96);
                put(41, 93);
                put(31, 90);
                put(21, 86);
                put(11, 83);
                put(1, 80);
            }
        });

    }
}
