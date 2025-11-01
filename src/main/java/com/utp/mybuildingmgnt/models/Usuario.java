package com.utp.mybuildingmgnt.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "clave", length = 100)
    private String clave;

    @ManyToOne
    @JoinColumn(name = "clientes_idcliente", referencedColumnName = "idcliente")
    @JsonBackReference
    private Cliente cliente;

}