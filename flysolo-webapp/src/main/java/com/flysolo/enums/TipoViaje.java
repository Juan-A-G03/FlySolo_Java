package com.flysolo.enums;

public enum TipoViaje {
    PASAJERO("Transporte de Pasajeros"),
    CARGA("Transporte de Carga");
    
    private final String descripcion;
    
    TipoViaje(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        return descripcion;
    }
}