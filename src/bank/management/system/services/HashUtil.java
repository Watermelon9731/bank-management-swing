package bank.management.system.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    public static String hashSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                hexString.append(String.format("%02X", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            throw new RuntimeException("SHA-256 does not support",ex);
        }
    }

    ;
}
