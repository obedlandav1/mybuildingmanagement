package com.utp.mybuildingmgnt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utp.mybuildingmgnt.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //Optional<Usuario> findByDniusuario(String dni);

}