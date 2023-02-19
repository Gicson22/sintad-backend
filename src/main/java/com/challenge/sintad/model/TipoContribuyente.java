package com.challenge.sintad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "tb_tipo_contribuyente")
public class TipoContribuyente {
    public TipoContribuyente(Integer id, String nombre, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    public TipoContribuyente() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contribuyente", length = 11)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private boolean estado;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    //@JsonIgnore
    //private Set<Entidad> entidades;

}
