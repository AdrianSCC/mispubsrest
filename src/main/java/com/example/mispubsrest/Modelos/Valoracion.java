package com.example.mispubsrest.Modelos;

import javax.persistence.*;

@Entity
@Table(name = "valoraciones")
public class Valoracion {

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name ="idusuario", nullable = false)
    private Integer idusuario;

    @Column(name = "idpub", nullable = false)
    private Integer idpub;

    @Column(name = "valoracion", nullable = false)
    private Integer valoracion;

    @Column(name = "detalle")
    private String detalle;

    public Valoracion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdpub() {
        return idpub;
    }

    public void setIdpub(Integer idpub) {
        this.idpub = idpub;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Valoracion{" +
                "id=" + id +
                ", idusuario=" + idusuario +
                ", idpub=" + idpub +
                ", valoracion=" + valoracion +
                ", detalle='" + detalle + '\'' +
                '}';
    }
}
