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
@Table(name = "edificios")
public class Edificio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idedificio")
    private Long idedificio;

    @Column(name = "nombre_edificio")
    private String nombre_edificio;

    @Column(name = "direccion_edificio")
    private String direccion_edificio;

    @Column(name = "ruc")
    private String ruc;

    @Column(name = "pais_edificio")
    private String pais_edificio;

    @Column(name = "estado_edificio")
    private long estado_edificio;

}