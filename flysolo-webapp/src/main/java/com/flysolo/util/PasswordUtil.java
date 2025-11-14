package com.flysolo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
    
    /**
     * Hashea password usando MD5 (simple para proyecto académico)
     * @param password Password en texto plano
     * @return Password hasheado en hexadecimal
     */
    public static String hashPassword(String password) {
        if (password == null || password.isEmpty()) {
            return "";
        }
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(password.getBytes());
            
            // Convertir bytes a hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
            
        } catch (NoSuchAlgorithmException e) {
            // Fallback: devolver password sin hashear si falla MD5
            return password;
        }
    }
    
    /**
     * Verifica si un password coincide con su hash
     * @param rawPassword Password en texto plano
     * @param hashedPassword Password hasheado almacenado
     * @return true si coinciden
     */
    public static boolean verifyPassword(String rawPassword, String hashedPassword) {
        if (rawPassword == null || hashedPassword == null) {
            return false;
        }
        
        String hashedRaw = hashPassword(rawPassword);
        return hashedRaw.equals(hashedPassword);
    }
    
    /**
     * Para desarrollo: password sin hashear (texto plano)
     * @param password Password original
     * @return Mismo password (para testing)
     */
    public static String plainPassword(String password) {
        return password != null ? password : "";
    }
    
    /**
     * Genera un password temporal aleatorio
     * @param length Longitud deseada (mínimo 8)
     * @return Password temporal
     */
    public static String generateTempPassword(int length) {
        if (length < 8) length = 8;
        
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            sb.append(chars.charAt(index));
        }
        
        return sb.toString();
    }
    
    /**
     * Valida fortaleza del password según reglas del negocio
     * @param password Password a validar
     * @return Mensaje de error o null si es válido
     */
    public static String validatePasswordStrength(String password) {
        if (password == null || password.length() < 8) {
            return "Password debe tener al menos 8 caracteres";
        }
        
        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            if (Character.isDigit(c)) hasDigit = true;
            if ("!@#$%^&*()_+-=[]{}|;:,.<>?".indexOf(c) >= 0) hasSpecial = true;
        }
        
        if (!hasLetter) {
            return "Password debe contener al menos una letra";
        }
        
        if (!hasDigit) {
            return "Password debe contener al menos un número";
        }
        
        // Para proyecto académico, caracteres especiales son opcionales
        // if (!hasSpecial) {
        //     return "Password debe contener al menos un carácter especial";
        // }
        
        return null; // Password válido
    }
}