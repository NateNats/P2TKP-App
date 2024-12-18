package common;

import java.io.*;
import java.nio.file.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is a utility class to manage passwords
 * 
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */
public class PasswordManager {
    private static final String STORAGE_FILE = "./credentials.dat";

    // Password entry class to store hashed passwords
    public static class PasswordEntry implements Serializable {
        private String salt;
        private String hashedPassword;
        private String type; // "master" or "admin"

        public PasswordEntry(String salt, String hashedPassword, String type) {
            this.salt = salt;
            this.hashedPassword = hashedPassword;
            this.type = type;
        }

        public String getSalt() {
            return salt;
        }

        public String getHashedPassword() {
            return hashedPassword;
        }

        public String getType() {
            return type;
        }
    }

    /**
     * Ensure storage directory exists
     * 
     * @throws IOException If directory creation fails
     */
    private static void ensureDirectoryExists() throws IOException {
        Path directory = Paths.get(STORAGE_FILE).getParent();
        if (directory != null && !Files.exists(directory)) {
            Files.createDirectories(directory);
        }
    }

    /**
     * Generate a secure random salt
     * 
     * @return Base64 encoded salt
     */
    private static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    /**
     * Hash password using SHA-256
     * 
     * @param password Raw password
     * @param salt     Base64 encoded salt
     * @return Hashed password
     */
    private static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Base64.getDecoder().decode(salt));
            byte[] hashedBytes = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not found", e);
        }
    }

    /**
     * Read existing passwords from file
     * 
     * @return List of existing password entries
     * @throws IOException            If file reading fails
     * @throws ClassNotFoundException If serialization fails
     */
    @SuppressWarnings("unchecked")
    private static List<PasswordEntry> readExistingPasswords() throws IOException, ClassNotFoundException {
        Path path = Paths.get(STORAGE_FILE);
        if (!Files.exists(path)) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(STORAGE_FILE))) {
            return (List<PasswordEntry>) ois.readObject();
        }
    }

    /**
     * Store master password
     * 
     * @param masterPassword Master password to store
     * @throws IOException If file writing fails
     */
    private static void storeMasterPassword(String masterPassword) throws IOException {
        ensureDirectoryExists();

        // Read existing passwords
        List<PasswordEntry> passwords;
        try {
            passwords = readExistingPasswords();

            // Remove existing master password entry if exists
            passwords.removeIf(entry -> entry.getType().equals("master"));
        } catch (ClassNotFoundException e) {
            // If file is corrupted, start with a new list
            passwords = new ArrayList<>();
        }

        // Generate salt
        String masterSalt = generateSalt();

        // Hash password
        String hashedMasterPassword = hashPassword(masterPassword, masterSalt);

        // Add master password entry
        passwords.add(new PasswordEntry(masterSalt, hashedMasterPassword, "master"));

        // Write to file
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(STORAGE_FILE))) {
            oos.writeObject(passwords);
        }
    }

    /**
     * Store admin password
     * 
     * @param adminPassword Admin password to store
     * @throws IOException If file writing fails
     */
    public static void storeAdminPassword(String adminPassword) throws IOException {
        ensureDirectoryExists();

        // Read existing passwords
        List<PasswordEntry> passwords;
        try {
            passwords = readExistingPasswords();

            // Remove existing admin password entry if exists
            passwords.removeIf(entry -> entry.getType().equals("admin"));
        } catch (ClassNotFoundException e) {
            // If file is corrupted, start with a new list
            passwords = new ArrayList<>();
        }

        // Generate salt
        String adminSalt = generateSalt();

        // Hash password
        String hashedAdminPassword = hashPassword(adminPassword, adminSalt);

        // Add admin password entry
        passwords.add(new PasswordEntry(adminSalt, hashedAdminPassword, "admin"));

        // Write to file
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(STORAGE_FILE))) {
            oos.writeObject(passwords);
        }
    }

    /**
     * Validate password
     * 
     * @param inputPassword Password to validate
     * @param type          "master" or "admin"
     * @return True if password is correct
     * @throws IOException            If file reading fails
     * @throws ClassNotFoundException If serialization fails
     */
    public static boolean validatePassword(String inputPassword, String type)
            throws IOException, ClassNotFoundException {
        List<PasswordEntry> passwords = readExistingPasswords();

        for (PasswordEntry entry : passwords) {
            if (entry.getType().equals(type)) {
                // Hash input password with stored salt
                String inputHash = hashPassword(inputPassword, entry.getSalt());

                // Compare hashes
                return inputHash.equals(entry.getHashedPassword());
            }
        }

        return false;
    }
}