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
@Table(name = "inmuebles")
public class Inmueble implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idinmueble")
    private Long idinmueble;

    @Column(name = "numero_inm")
    private int numero_inm;

    @Column(name = "porcentaje_inm")
    private double porcentaje_inm;

    @Column(name = "estado_inm")
    private String estado_inm;

    @Column(name = "tipo_inmueble")
    private String tipo_inmueble;

    @Column(name = "metro_cuadrado")
    private double metro_cuadrado;

    @Column(name = "edificios_idedificio")
    private Long edificios_idedificio;

    @Column(name = "propietarios_idpropietario")
    private Long propietarios_idpropietario;

}