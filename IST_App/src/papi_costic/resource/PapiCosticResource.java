package papi_costic.resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PapiCosticResource {
    public static String nama;
    public static String tglLahir;
    public static String tglTes;
    public static String pendidikan;
    public static String kelamin;
    public static String tujuan;

    public static final Map<Character, Integer> topRow = new HashMap<>();
    public static final Map<Character, Integer> bottomRow = new HashMap<>();

    static {
        for (char key : new char[] { 'g', 'l', 'i', 't', 'v', 's', 'r', 'd', 'c', 'e' }) {
            topRow.put(key, 0);
        }
        for (char key : new char[] { 'n', 'a', 'p', 'x', 'b', 'o', 'z', 'k', 'f', 'w' }) {
            bottomRow.put(key, 0);
        }
        resetValues();
    }

    public static int getTopRowSum() {
        return topRow.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static int getBottomRowSum() {
        return bottomRow.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static boolean isTopRowValueValid() {
        return getTopRowSum() == 45;
    }

    public static boolean isBottomRowValueValid() {
        return getBottomRowSum() == 45;
    }

    public static void resetValues() {
        nama = "";
        tglLahir = null;
        tglTes = null;
        pendidikan = "";
        kelamin = "Laki-laki";
        tujuan = "";
        topRow.replaceAll((k, v) -> 0);
        bottomRow.replaceAll((k, v) -> 0);
    }

    public static boolean isInputValid() {
        for (int v : topRow.values()) {
            if (v == 0) {
                return false;
            }
        }

        for (int v : bottomRow.values()) {
            if (v == 0) {
                return false;
            }
        }

        if (nama.isEmpty() || tglLahir == null || tglTes == null || pendidikan.isEmpty() || kelamin.isEmpty()
                || tujuan.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void handleIntegerInput(JTextField inputField, char key, boolean isTopRow, JPanel panel,
            JButton button) {
        try {
            if (inputField.getText().isEmpty()) {
                updateMapValue(key, 0, isTopRow);
                button.setEnabled(false);
                return;
            }
            int value = Integer.parseInt(inputField.getText());
            updateMapValue(key, value, isTopRow);
            handleInput(button);
        } catch (NumberFormatException error) {
            inputField.setText("");
            JOptionPane.showMessageDialog(panel, "Nilai harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void handleInput(JButton button) {
        button.setEnabled(isTopRowValueValid() && isBottomRowValueValid() && isInputValid());
        System.out.println("Top Row Valid " + isTopRowValueValid());
        System.out.println("Bottom Row Valid " + isBottomRowValueValid());
        System.out.println("Input Valid " + isInputValid());
    }

    private static void updateMapValue(char key, int value, boolean isTopRow) {
        if (isTopRow) {
            topRow.put(key, value);
        } else {
            bottomRow.put(key, value);
        }
    }

    public static String handleDateInput(Date date) {
        if (date == null) {
            return "";
        }

        SimpleDateFormat originalFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        SimpleDateFormat newFormat = new SimpleDateFormat("dd MMMM yyyy");

        try {
            return newFormat.format(originalFormat.parse(date.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";

    }

}
