package com.mycompany.crm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
    // Method to hash a password using SHA-256
    public static String hashPassword(String password) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Add password bytes to digest
            md.update(password.getBytes());
            
            // Get the hashed bytes
            byte[] hashedBytes = md.digest();
            
            // Convert bytes to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            // Handle algorithm not found exception
            ex.printStackTrace();
            return null;
        }
    }

    // Method to verify a password against a hashed password
    public static boolean verifyPassword(String password, String hashedPassword) {
        String hashedProvidedPassword = hashPassword(password);
        return hashedProvidedPassword.equals(hashedPassword);
    }
}
