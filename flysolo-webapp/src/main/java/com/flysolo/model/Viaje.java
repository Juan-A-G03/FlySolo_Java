package com.flysolo.model;

import com.flysolo.enums.EstadoViaje;
import com.flysolo.enums.TipoViaje;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Viaje {
    private int id;
    private int usuarioId;
    private Integer pilotoId; // Nullable
    private int origenPlanetaId;
    private int destinoPlanetaId;
    private TipoViaje tipoViaje;
    private String tipoTiming; // "INMEDIATO" o "PROGRAMADO"
    private LocalDateTime fechaHoraSolicitada;
    private int numPasajeros;
    private BigDecimal pesoCarga;
    private String descripcionCarga;
    private BigDecimal distanciaCalculada;
    private int tiempoEstimadoViaje; // en minutos
    private BigDecimal precioBase;
    private BigDecimal precioPremium;
    private BigDecimal precioFinal;
    private EstadoViaje estado;
    private boolean esMisionEncubierta;
    private String faccionesAutorizadas; // JSON string
    private LocalDateTime fechaConfirmacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinalizacion;
    private LocalDateTime createdAt;
    
    // Constructor vacío
    public Viaje() {
        this.estado = EstadoViaje.PENDIENTE;
        this.numPasajeros = 1;
        this.pesoCarga = BigDecimal.ZERO;
        this.esMisionEncubierta = false;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getUsuarioId() {
        return usuarioId;
    }
    
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public Integer getPilotoId() {
        return pilotoId;
    }
    
    public void setPilotoId(Integer pilotoId) {
        this.pilotoId = pilotoId;
    }
    
    public int getOrigenPlanetaId() {
        return origenPlanetaId;
    }
    
    public void setOrigenPlanetaId(int origenPlanetaId) {
        this.origenPlanetaId = origenPlanetaId;
    }
    
    public int getDestinoPlanetaId() {
        return destinoPlanetaId;
    }
    
    public void setDestinoPlanetaId(int destinoPlanetaId) {
        this.destinoPlanetaId = destinoPlanetaId;
    }
    
    public TipoViaje getTipoViaje() {
        return tipoViaje;
    }
    
    public void setTipoViaje(TipoViaje tipoViaje) {
        this.tipoViaje = tipoViaje;
    }
    
    public String getTipoTiming() {
        return tipoTiming;
    }
    
    public void setTipoTiming(String tipoTiming) {
        this.tipoTiming = tipoTiming;
    }
    
    public LocalDateTime getFechaHoraSolicitada() {
        return fechaHoraSolicitada;
    }
    
    public void setFechaHoraSolicitada(LocalDateTime fechaHoraSolicitada) {
        this.fechaHoraSolicitada = fechaHoraSolicitada;
    }
    
    public int getNumPasajeros() {
        return numPasajeros;
    }
    
    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }
    
    public BigDecimal getPesoCarga() {
        return pesoCarga;
    }
    
    public void setPesoCarga(BigDecimal pesoCarga) {
        this.pesoCarga = pesoCarga;
    }
    
    public String getDescripcionCarga() {
        return descripcionCarga;
    }
    
    public void setDescripcionCarga(String descripcionCarga) {
        this.descripcionCarga = descripcionCarga;
    }
    
    public BigDecimal getDistanciaCalculada() {
        return distanciaCalculada;
    }
    
    public void setDistanciaCalculada(BigDecimal distanciaCalculada) {
        this.distanciaCalculada = distanciaCalculada;
    }
    
    public int getTiempoEstimadoViaje() {
        return tiempoEstimadoViaje;
    }
    
    public void setTiempoEstimadoViaje(int tiempoEstimadoViaje) {
        this.tiempoEstimadoViaje = tiempoEstimadoViaje;
    }
    
    public BigDecimal getPrecioBase() {
        return precioBase;
    }
    
    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }
    
    public BigDecimal getPrecioPremium() {
        return precioPremium;
    }
    
    public void setPrecioPremium(BigDecimal precioPremium) {
        this.precioPremium = precioPremium;
    }
    
    public BigDecimal getPrecioFinal() {
        return precioFinal;
    }
    
    public void setPrecioFinal(BigDecimal precioFinal) {
        this.precioFinal = precioFinal;
    }
    
    public EstadoViaje getEstado() {
        return estado;
    }
    
    public void setEstado(EstadoViaje estado) {
        this.estado = estado;
    }
    
    public boolean isEsMisionEncubierta() {
        return esMisionEncubierta;
    }
    
    public void setEsMisionEncubierta(boolean esMisionEncubierta) {
        this.esMisionEncubierta = esMisionEncubierta;
    }
    
    public String getFaccionesAutorizadas() {
        return faccionesAutorizadas;
    }
    
    public void setFaccionesAutorizadas(String faccionesAutorizadas) {
        this.faccionesAutorizadas = faccionesAutorizadas;
    }
    
    public LocalDateTime getFechaConfirmacion() {
        return fechaConfirmacion;
    }
    
    public void setFechaConfirmacion(LocalDateTime fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }
    
    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }
    
    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public LocalDateTime getFechaFinalizacion() {
        return fechaFinalizacion;
    }
    
    public void setFechaFinalizacion(LocalDateTime fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    // Métodos de utilidad
    public boolean tienePilotoAsignado() {
        return pilotoId != null;
    }
    
    public boolean esInmediato() {
        return "INMEDIATO".equals(tipoTiming);
    }
    
    public boolean estaEnCurso() {
        return estado == EstadoViaje.EN_CURSO;
    }
    
    public boolean estaCompletado() {
        return estado == EstadoViaje.COMPLETADO;
    }
    
    @Override
    public String toString() {
        return "Viaje{" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", pilotoId=" + pilotoId +
                ", tipoViaje=" + tipoViaje +
                ", estado=" + estado +
                ", precioFinal=" + precioFinal +
                '}';
    }
}