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
@Table(name = "ingresos")
public class Ingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idingreso")
    private Long idingreso;

    @Column(name = "fecha_ingreso")
    private String fecha_ingreso;

    @Column(name = "tipo_ingreso")
    private String tipo_ingreso;

    @Column(name = "monto_pagado")
    private double monto_pagado;

    @Column(name = "metodo_ingreso")
    private String metodo_ingreso;

    @Column(name = "comprobante_ingreso")
    private long comprobante_ingreso;

    @Column(name = "recibos_idrecibo")
    private int recibos_idrecibo;

    @Column(name = "periodos_idperiodo")
    private int periodos_idperiodo;

    @Column(name = "edificios_idedificio")
    private int edificios_idedificio;

}