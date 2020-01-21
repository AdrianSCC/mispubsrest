package com.example.mispubsrest.Modelos;

import javax.persistence.*;

@Entity
@Table(name="pubs")
public class Pub {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="latitud", nullable = false)
    private Long latitud;

    @Column(name="longitud", nullable = false)
    private Long longitud;

    @Column(name="estilo", nullable = false)
    private String estilo;

    @Column(name="visitas", nullable = false)
    private Integer visitas;

    @Column(name="web")
    private String web;

    @Column(name="imagen")
    private String imagen;

    public Pub() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getLatitud() {
        return latitud;
    }

    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }

    public Long getLongitud() {
        return longitud;
    }

    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Integer getVisitas() {
        return visitas;
    }

    public void setVisitas(Integer visitas) {
        this.visitas = visitas;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Pub{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", estilo='" + estilo + '\'' +
                ", visitas=" + visitas +
                ", web='" + web + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
