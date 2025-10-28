package com.utp.mybuildingmgnt.repositories;

import com.utp.mybuildingmgnt.models.Ingreso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {

    @Query("SELECT i FROM Ingreso i WHERE i.periodos_idperiodo = :periodo AND i.edificios_idedificio = :edificio")
    List<Ingreso> findByPeriodoAndEdificio(@Param("periodo") int periodo, @Param("edificio") int edificio);

}