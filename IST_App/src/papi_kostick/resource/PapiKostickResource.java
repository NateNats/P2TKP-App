package papi_kostick.resource;

import java.io.File;
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
 * This class is a resource class for PapiKostickForm. It contains the data and
 * methods needed to handle user interactions the form.
 * 
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */

public class PapiKostickResource {
    public static String name;
    public static String birthDate;
    public static String testDate;
    public static String education;
    public static String gender;
    public static String purpose;

    public static final Map<Character, Integer> topRow = new HashMap<>();
    public static final Map<Character, Integer> bottomRow = new HashMap<>();

    private final static String REPORT1_PATH = "./src/papi_kostick/resource/report/PapiKostickReport1_v1.12.jasper";
    private final static String REPORT2_PATH = "./src/papi_kostick/resource/report/PapiKostickReport2_v1.12.jasper";

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
        education = "SD";
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

    public static void produceReport() {
        File file1 = new File(REPORT1_PATH);
        File file2 = new File(REPORT2_PATH);
        if (file1.exists() && file2.exists()) {
            Map<String, Object> parameter1 = new HashMap<>();
            parameter1.put("name", name);
            parameter1.put("birthDate", birthDate);
            parameter1.put("testDate", testDate);
            parameter1.put("education", education);
            parameter1.put("gender", gender);
            parameter1.put("purpose", purpose);
            parameter1.put("n", ScoreInterpreter.getInterpretation("n", bottomRow.get('n')));
            parameter1.put("g", ScoreInterpreter.getInterpretation("g", topRow.get('g')));
            parameter1.put("a", ScoreInterpreter.getInterpretation("a", bottomRow.get('a')));
            parameter1.put("l", ScoreInterpreter.getInterpretation("l", topRow.get('l')));
            parameter1.put("p", ScoreInterpreter.getInterpretation("p", bottomRow.get('p')));
            parameter1.put("i", ScoreInterpreter.getInterpretation("i", topRow.get('i')));
            parameter1.put("t", ScoreInterpreter.getInterpretation("t", topRow.get('t')));
            parameter1.put("v", ScoreInterpreter.getInterpretation("v", topRow.get('v')));
            parameter1.put("o", ScoreInterpreter.getInterpretation("o", bottomRow.get('o')));
            parameter1.put("b", ScoreInterpreter.getInterpretation("b", bottomRow.get('b')));
            parameter1.put("s", ScoreInterpreter.getInterpretation("s", topRow.get('s')));

            Map<String, Object> parameter2 = new HashMap<>();
            parameter2.put("x", ScoreInterpreter.getInterpretation("x", bottomRow.get('x')));
            parameter2.put("c", ScoreInterpreter.getInterpretation("c", topRow.get('c')));
            parameter2.put("d", ScoreInterpreter.getInterpretation("d", topRow.get('d')));
            parameter2.put("r", ScoreInterpreter.getInterpretation("r", topRow.get('r')));
            parameter2.put("z", ScoreInterpreter.getInterpretation("z", bottomRow.get('z')));
            parameter2.put("e", ScoreInterpreter.getInterpretation("e", topRow.get('e')));
            parameter2.put("k", ScoreInterpreter.getInterpretation("k", bottomRow.get('k')));
            parameter2.put("f", ScoreInterpreter.getInterpretation("f", bottomRow.get('f')));
            parameter2.put("w", ScoreInterpreter.getInterpretation("w", bottomRow.get('w')));

            try {
                JasperPrint jasperPrint1 = JasperFillManager.fillReport(REPORT1_PATH, parameter1,
                        new JREmptyDataSource());
                JasperPrint jasperPrint2 = JasperFillManager.fillReport(REPORT2_PATH, parameter2,
                        new JREmptyDataSource());

                jasperPrint1.addPage(1, jasperPrint2.getPages().get(0));

                JasperViewer.viewReport(jasperPrint1, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
