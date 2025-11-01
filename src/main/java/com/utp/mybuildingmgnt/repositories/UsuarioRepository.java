package com.utp.mybuildingmgnt.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.utp.mybuildingmgnt.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u JOIN FETCH u.cliente WHERE u.dniusuario = :dni")
    Optional<Usuario> findByDniusuario(String dni);

    List<Usuario> findByCliente_Idcliente(Integer idcliente);

}