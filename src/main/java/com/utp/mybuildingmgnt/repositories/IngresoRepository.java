package com.utp.mybuildingmgnt.repositories;

import com.utp.mybuildingmgnt.models.Ingreso;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {

    List<Ingreso> findByAnioBuilding(int anio, int edificio);

}