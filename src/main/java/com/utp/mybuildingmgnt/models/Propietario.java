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
@Table(name = "propietarios")
public class Propietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpropietario")
    private Long idpropietario;

    @Column(name = "dni_pro")
    private String dni_pro;

    @Column(name = "nombre_pro")
    private String nombre_pro;

    @Column(name = "apellido_pro")
    private String apellido_pro;

    @Column(name = "telefono_pro")
    private int telefono_pro;

    @Column(name = "correo_pro")
    private String correo_pro;

    @Column(name = "estado_pro")
    private String estado_pro;

}