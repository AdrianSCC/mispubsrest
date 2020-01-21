package com.example.mispubsrest.Modelos;

import javax.persistence.*;

@Entity
@Table(name="sesiones")
public class Sesion {

    @Id
    @Column(name="idUsuario")
    private Integer idUsuario;

    @Column(name="token", nullable = false)
    private String token;

    @Column(name="fechaInicio", nullable = false)
    private String fechaInicio;

    @Column(name="fechaFin", nullable = false)
    private String fechaFin;

    @Column(name="idDispositivo", nullable = false)
    private String idDispositivo;

    public Sesion() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(String idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    @Override
    public String toString() {
        return "Sesion{" +
                "idUsuario=" + idUsuario +
                ", token='" + token + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                ", idDispositivo='" + idDispositivo + '\'' +
                '}';
    }
}
