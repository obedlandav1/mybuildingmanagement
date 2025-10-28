package com.utp.mybuildingmgnt.repositories;

import com.utp.mybuildingmgnt.models.Propietario;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {

       @Query("SELECT DISTINCT p FROM Propietario p JOIN Inmueble i ON i.propietarios_idpropietario = p.idpropietario WHERE i.edificios_idedificio = :idEdificio")
       List<Propietario> findPropietariosByEdificio(@Param("idEdificio") Long idEdificio);

}