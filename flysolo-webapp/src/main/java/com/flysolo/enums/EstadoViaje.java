package com.flysolo.enums;

public enum EstadoViaje {
    PENDIENTE("Pendiente de aceptación"),
    CONFIRMADO("Confirmado - Piloto en camino"),
    EN_CURSO("En curso"),
    COMPLETADO("Completado"),
    CANCELADO("Cancelado"),
    EXPIRADO("Expirado");
    
    private final String descripcion;
    
    EstadoViaje(String descripcion) {
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