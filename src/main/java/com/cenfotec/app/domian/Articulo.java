package com.cenfotec.app.domian;

import javax.persistence.*;

@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Antologia antologia;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Antologia getAntologia() {
        return antologia;
    }

    public void setAntologia(Antologia antologia) {
        this.antologia = antologia;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", antologia=" + antologia +
                '}';
    }
}
