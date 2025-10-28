package com.utp.mybuildingmgnt.repositories;

import com.utp.mybuildingmgnt.models.Inmueble;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {

    List<Inmueble> findByEdificiosIdedificio(Long edificios_idedificio);

}