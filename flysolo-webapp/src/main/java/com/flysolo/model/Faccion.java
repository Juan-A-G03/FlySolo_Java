package com.flysolo.model;

import java.time.LocalDateTime;

public class Faccion {
    private int id;
    private String nombre;
    private String descripcion;
    private String colorHex;
    private boolean activa;
    private LocalDateTime createdAt;
    
    // Constructor vacío
    public Faccion() {
        this.activa = true;
        this.createdAt = LocalDateTime.now();
    }
    
    // Constructor con parámetros
    public Faccion(String nombre, String descripcion, String colorHex) {
        this();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.colorHex = colorHex;
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getColorHex() {
        return colorHex;
    }
    
    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }
    
    public boolean isActiva() {
        return activa;
    }
    
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    // Métodos de utilidad
    public boolean esImperio() {
        return "IMPERIO".equalsIgnoreCase(nombre);
    }
    
    public boolean esRebelde() {
        return "REBELDES".equalsIgnoreCase(nombre);
    }
    
    public boolean esNeutral() {
        return "NEUTRALES".equalsIgnoreCase(nombre);
    }
    
    @Override
    public String toString() {
        return "Faccion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", colorHex='" + colorHex + '\'' +
                ", activa=" + activa +
                '}';
    }
}