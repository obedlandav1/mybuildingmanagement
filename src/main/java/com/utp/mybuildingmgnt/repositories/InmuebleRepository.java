package com.utp.mybuildingmgnt.repositories;

import com.utp.mybuildingmgnt.models.Inmueble;
import com.utp.mybuildingmgnt.models.Propietario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {


}
