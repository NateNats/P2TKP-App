package common;

import javax.swing.*;
import java.util.Arrays;

public class PasswordDialog {
    private final String realPassword = "12345";
    private JDialog toDialog;

    public PasswordDialog(JDialog toDialog) {
        this.toDialog = toDialog;
    }

    public void showDialog() {
        JPasswordField passwordField = new JPasswordField();
        Object[] message = { "Masukkan Password: ", passwordField };

        while (true) {
            int option = JOptionPane.showConfirmDialog(
                    null, message, "Konfirmasi untuk mengubah", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                char[] inputPassword = passwordField.getPassword();

                try {
                    if (Arrays.equals(inputPassword, realPassword.toCharArray())) {
                        JOptionPane.showMessageDialog(null, "Berhasil masuk");
                        toDialog.setVisible(true);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal masuk");
                        passwordField.setText("");
                    }
                } finally {
                    // Explicitly clear the password from memory
                    Arrays.fill(inputPassword, '0');
                }
            } else {
                break;
            }
        }
    }
}