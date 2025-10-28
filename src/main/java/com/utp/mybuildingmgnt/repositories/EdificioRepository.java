package com.utp.mybuildingmgnt.repositories;

import com.utp.mybuildingmgnt.models.Edificio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EdificioRepository extends JpaRepository<Edificio, Long> {

}