package com.flysolo.enums;

public enum TipoUsuario {
    PASAJERO("Pasajero"),
    PILOTO("Piloto"), 
    ADMIN("Administrador");
    
    private final String displayName;
    
    TipoUsuario(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
}