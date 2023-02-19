package com.challenge.sintad.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer id;

    private String nombre;
    private String apellidos;
    private String email;
    private String password;

    @Column(nullable = false, columnDefinition = "BOOLEAN default 1")
    private boolean estado;
}
