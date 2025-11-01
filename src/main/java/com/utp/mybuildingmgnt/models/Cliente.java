package com.utp.mybuildingmgnt.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Long idcliente;

    @Column(name = "razon_cliente")
    private String razon_cliente;

    @Column(name = "num_identidad")
    private String num_identidad;

    @Column(name = "direccion_cliente")
    private String direccion_cliente;

    @Column(name = "estado_cliente")
    private int estado_cliente;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<Usuario> usuarios;
}