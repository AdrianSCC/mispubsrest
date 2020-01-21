package com.example.mispubsrest.Modelos;

import javax.persistence.*;

@Entity
@Table(name="sesiones")
public class Sesion {

    @Id
    @Column(name="id_usuario")
    private Integer id_usuario;

    @Column(name="token", nullable = false)
    private String token;

    @Column(name="fecha_inicio", nullable = false)
    private String fecha_inicio;

    @Column(name="fecha_fin", nullable = false)
    private String fecha_fin;

    @Column(name="id_dispositivo", nullable = false)
    private String id_dispositivo;

    public Sesion() {
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    @Override
    public String toString() {
        return "Sesion{" +
                "id_usuario=" + id_usuario +
                ", token='" + token + '\'' +
                ", fecha_inicio='" + fecha_inicio + '\'' +
                ", fecha_fin='" + fecha_fin + '\'' +
                ", id_dispositivo='" + id_dispositivo + '\'' +
                '}';
    }
}
