package com.utp.mybuildingmgnt.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idusuario;

    @Column(name = "rol_usuario")
    private int rol_usuario;

    @Column(name = "nombre_usuario")
    private String nombre_usuario;

    @Column(name = "apellido_usuario")
    private String apellido_usuario;

    @Column(name = "dni_usuario")
    private String dni_usuario;

    @Column(name = "clave")
    private String clave;

}