package com.challenge.sintad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "tb_tipo_documento")
public class TipoDocumento {

    public TipoDocumento(Integer id, String codigo, String nombre, String descripcion, boolean estado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public TipoDocumento() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento", length = 11)
    private Integer id;

    @Column(length = 20, nullable = false, unique = true)
    private String codigo;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 200)
    private String descripcion;

    @Column(nullable = false, columnDefinition = "BOOLEAN default 1")
    private boolean estado;

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    //@JsonIgnore
    //private Set<Entidad> entidades;
}
