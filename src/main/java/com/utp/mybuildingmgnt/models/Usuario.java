package com.utp.mybuildingmgnt.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private String dniusuario;

    @Column(name = "clave")
    private String clave;

}