package common;

import javax.swing.*;

import java.util.Arrays;

/**
 * this class is a dialog used to verify the password before allowing access to
 * the editing panels
 * 
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */
public class PasswordDialog {
    private JDialog toDialog;

    public PasswordDialog(JDialog toDialog) {
        this.toDialog = toDialog;
    }

    public void showDialog() {
        JPasswordField passwordField = new JPasswordField();
        Object[] message = { "Masukkan Password: ", passwordField };

        // Loop until the user enters the correct password or cancels
        while (true) {
            int option = JOptionPane.showConfirmDialog(
                    null, message, "Konfirmasi untuk mengubah", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                char[] inputPassword = passwordField.getPassword();

                try {
                    if (PasswordManager.validatePassword(new String(inputPassword), "admin")
                            || PasswordManager.validatePassword(new String(inputPassword), "master")) {
                        JOptionPane.showMessageDialog(null, "Berhasil masuk");
                        toDialog.setLocationRelativeTo(null);
                        toDialog.setVisible(true);
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal masuk");
                        passwordField.setText("");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan");
                } finally {
                    // Explicitly clear the password from memory
                    Arrays.fill(inputPassword, '0');
                }
            } else {
                return;
            }
        }
    }
}