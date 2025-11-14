package com.flysolo.util;

import java.util.regex.Pattern;

public class ValidationUtil {
    
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    
    // Validar email
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email.trim()).matches();
    }
    
    // Validar password: mínimo 8 caracteres, al menos 1 letra y 1 número
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        boolean hasLetter = false;
        boolean hasDigit = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) hasLetter = true;
            if (Character.isDigit(c)) hasDigit = true;
        }
        
        return hasLetter && hasDigit;
    }
    
    // Validar nombre/apellido
    public static boolean isValidName(String name) {
        return name != null && name.trim().length() >= 2 && name.trim().length() <= 50;
    }
    
    // Limpiar string
    public static String clean(String str) {
        return str != null ? str.trim() : "";
    }
    
    // Verificar que no esté vacío
    public static boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }
    
    // Validar rango
    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
    
    // Mensaje de error para password
    public static String getPasswordRequirements() {
        return "Password debe tener mínimo 8 caracteres, al menos 1 letra y 1 número";
    }

    public static String cleanString(String str) {
        return clean(str); // Llama al método existente
    }

}