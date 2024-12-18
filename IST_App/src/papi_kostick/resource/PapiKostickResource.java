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

    // Initialize
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
        return getTopRowSum() == 45 && topRow.containsValue(0) == false;
    }

    public static boolean isBottomRowValueValid() {
        return getBottomRowSum() == 45 && bottomRow.containsValue(0) == false;
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

    /**
     * Handle the input for the PAPI Kostick form
     * 
     * @param inputField The input field to handle
     * @param key        The key to handle
     * @param isTopRow   Whether the input field is in the top row
     * @param panel      The panel to handle
     * @param button     The button to handle
     */
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

    /**
     * enable or disable the button based on the input validity
     * 
     * @param button The button to handle
     */
    public static void handleInput(JButton button) {
        button.setEnabled(isTopRowValueValid() && isBottomRowValueValid() && isInputValid());
    }

    /**
     * Update the value of the map
     * 
     * @param key      The key to update
     * @param value    The value to update
     * @param isTopRow Whether the value is in the top row
     */
    private static void updateMapValue(char key, int value, boolean isTopRow) {
        if (isTopRow) {
            topRow.put(key, value);
        } else {
            bottomRow.put(key, value);
        }
    }

    /**
     * Handle the date input
     * 
     * @param date The date to handle
     * @return The formatted date
     */
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
            parameter1.put("n", PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.NEED_TO_FINISH_TASK,
                    bottomRow.get('n')));
            parameter1.put("g", PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.HARD_INTENSE_WORKED,
                    topRow.get('g')));
            parameter1.put("a", PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.NEED_TO_ACHIEVE,
                    bottomRow.get('a')));
            parameter1.put("l", PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.LEADERSHIP_ROLE,
                    topRow.get('l')));
            parameter1.put("p", PapiKostickScoreInterpreter
                    .getInterpretation(PapiKostickCategory.NEED_TO_CONTROL_OTHERS, bottomRow.get('p')));
            parameter1.put("i", PapiKostickScoreInterpreter
                    .getInterpretation(PapiKostickCategory.EASE_IN_DECISION_MAKING, topRow.get('i')));
            parameter1.put("t",
                    PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.PACE, topRow.get('t')));
            parameter1.put("v",
                    PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.VIGOROUS_TYPE, topRow.get('v')));
            parameter1.put("o", PapiKostickScoreInterpreter
                    .getInterpretation(PapiKostickCategory.NEED_FOR_CLOSENESS_AND_AFFECTION, bottomRow.get('o')));
            parameter1.put("b", PapiKostickScoreInterpreter
                    .getInterpretation(PapiKostickCategory.NEED_TO_BELONG_TO_GROUPS, bottomRow.get('b')));
            parameter1.put("s", PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.SOCIAL_EXTENSION,
                    topRow.get('s')));

            Map<String, Object> parameter2 = new HashMap<>();
            parameter2.put("x", PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.NEED_TO_BE_NOTICED,
                    bottomRow.get('x')));
            parameter2.put("c",
                    PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.ORGANIZED_TYPE, topRow.get('c')));
            parameter2.put("d", PapiKostickScoreInterpreter
                    .getInterpretation(PapiKostickCategory.INTEREST_IN_WORKING_WITH_DETAILS, topRow.get('d')));
            parameter2.put("r", PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.THEORETICAL_TYPE,
                    topRow.get('r')));
            parameter2.put("z", PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.NEED_FOR_CHANGE,
                    bottomRow.get('z')));
            parameter2.put("e", PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.EMOTIONAL_RESISTANT,
                    topRow.get('e')));
            parameter2.put("k", PapiKostickScoreInterpreter.getInterpretation(PapiKostickCategory.NEED_TO_BE_FORCEFUL,
                    bottomRow.get('k')));
            parameter2.put("f", PapiKostickScoreInterpreter
                    .getInterpretation(PapiKostickCategory.NEED_TO_SUPPORT_AUTHORITY, bottomRow.get('f')));
            parameter2.put("w", PapiKostickScoreInterpreter
                    .getInterpretation(PapiKostickCategory.NEED_FOR_RULES_AND_SUPERVISION, bottomRow.get('w')));

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
