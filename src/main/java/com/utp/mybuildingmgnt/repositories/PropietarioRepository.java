package com.utp.mybuildingmgnt.repositories;

import com.utp.mybuildingmgnt.models.Propietario;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
    
     // Listar propietarios por ID de edificio (vinculados mediante inmuebles)
    @Query("SELECT DISTINCT p FROM Propietario p " +
           "JOIN Inmueble i ON p.idpropietario = i.propietarios_idpropietario " +
           "WHERE i.edificios_idedificio = :idEdificio")
    List<Propietario> findByEdificio(@Param("idEdificio") Long idEdificio);

}