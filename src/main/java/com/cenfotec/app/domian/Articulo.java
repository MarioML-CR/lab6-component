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
}
