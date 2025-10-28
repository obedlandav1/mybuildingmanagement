package com.utp.mybuildingmgnt.repositories;

import com.utp.mybuildingmgnt.models.Usuario;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByDni_usuario(Long dni);

}