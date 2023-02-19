package com.challenge.sintad.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_entidad")
public class Entidad {

    public Entidad(Integer id, String nro_documento, String razon_social, String nombre_comercial, String direccion, String telefono, boolean estado, TipoContribuyente tipo_contribuyente, TipoDocumento tipo_documento) {
        this.id = id;
        this.nro_documento = nro_documento;
        this.razon_social = razon_social;
        this.nombre_comercial = nombre_comercial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.tipo_contribuyente = tipo_contribuyente;
        this.tipo_documento = tipo_documento;
    }

    public Entidad() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad", length = 11)
    private Integer id;

    @Column(length = 25, nullable = false)
    private String nro_documento;

    @Column(length = 100, nullable = false)
    private String razon_social;

    @Column(length = 100)
    private String nombre_comercial;

    @Column(length = 250)
    private String direccion;

    @Column(length = 50)
    private String telefono;

    @Column(columnDefinition = "BOOLEAN default 1")
    private boolean estado;

    @ManyToOne()
    @JoinColumn(name = "tipo_contribuyente")
    private TipoContribuyente tipo_contribuyente;

    @ManyToOne()
    @JoinColumn(name = "tipo_documento")
    private TipoDocumento tipo_documento;


}
