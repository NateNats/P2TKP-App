package common;

import java.io.IOException;

import javax.swing.*;

/**
 * Dialog to verify the password before allowing access to editing panels.
 * 
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */
public class PasswordDialog {
    private final JDialog toDialog;

    // Constants for dialog messages
    private static final String PASSWORD_PROMPT = "Masukkan Password:";
    private static final String DIALOG_TITLE = "Konfirmasi untuk mengubah";
    private static final String ACCESS_GRANTED = "Berhasil masuk";
    private static final String ACCESS_DENIED = "Gagal masuk";
    private static final String ERROR_MESSAGE = "Terjadi kesalahan";
    private static final String[] VALID_PASSWORDS = { "admin", "master" };

    /**
     * @param toDialog The dialog to show after the password is verified
     */
    public PasswordDialog(JDialog toDialog) {
        this.toDialog = toDialog;
    }

    public void showDialog() {
        JPasswordField passwordField = new JPasswordField();
        Object[] message = { PASSWORD_PROMPT, passwordField };

        while (true) {
            int option = JOptionPane.showConfirmDialog(
                    null, message, DIALOG_TITLE, JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                char[] inputPassword = passwordField.getPassword();
                boolean validated = validateAndProcessPassword(inputPassword);
                clearPassword(inputPassword);
                passwordField.setText(""); // Clear the field for security

                if (validated) {
                    break;
                }
            } else {
                return; // Exit if the user cancels
            }
        }
    }

    /**
     * @param password The password to validate
     * @return True if the password is valid
     */
    private boolean validateAndProcessPassword(char[] password) {
        try {
            if (validatePassword(password)) {
                JOptionPane.showMessageDialog(null, ACCESS_GRANTED);
                showTargetDialog();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, ACCESS_DENIED);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * @throws IOException If file reading fails
     */
    private boolean validatePassword(char[] password) throws Exception {
        String passwordString = new String(password);
        for (String validPassword : VALID_PASSWORDS) {
            if (PasswordManager.validatePassword(passwordString, validPassword)) {
                return true;
            }
        }
        return false;
    }

    private void showTargetDialog() {
        toDialog.setLocationRelativeTo(null);
        toDialog.setVisible(true);
    }

    private void clearPassword(char[] password) {
        if (password != null) {
            for (int i = 0; i < password.length; i++) {
                password[i] = '\0'; // Clear sensitive data
            }
        }
    }
}
