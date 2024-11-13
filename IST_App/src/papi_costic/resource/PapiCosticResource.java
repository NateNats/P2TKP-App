package papi_costic.resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * This class is a resource class for PapiCosticForm. It contains the data and
 * methods needed to handle user interactions the form.
 * 
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */

public class PapiCosticResource {
    public static String name;
    public static String birthDate;
    public static String testDate;
    public static String education;
    public static String gender;
    public static String purpose;

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
        name = "";
        birthDate = null;
        testDate = null;
        education = "";
        gender = "Laki-laki";
        purpose = "";
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

        if (name.isEmpty() || birthDate == null || testDate == null || education.isEmpty() || gender.isEmpty()
                || purpose.isEmpty()) {
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
