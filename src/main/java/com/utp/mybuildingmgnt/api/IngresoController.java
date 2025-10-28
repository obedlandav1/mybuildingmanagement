package com.utp.mybuildingmgnt.api;

import com.utp.mybuildingmgnt.models.Ingreso;
import com.utp.mybuildingmgnt.repositories.IngresoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class IngresoController {

    @Autowired
    IngresoRepository repository;

    @GetMapping("/ingreso")
    public ResponseEntity<List<Ingreso>> getAll(
            @RequestParam(required = true) int idedificio,
            @RequestParam(required = true) int idperiodo) {
        try {
            List<Ingreso> lista = new ArrayList<Ingreso>();

            repository.findByPeriodoAndEdificio(idperiodo, idedificio).forEach(lista::add);

            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/ingreso/crear")
    public ResponseEntity<Ingreso> create(@RequestBody Ingreso entidad) {
        try {
            Ingreso _entidad = repository.save(new Ingreso(null, 
                    entidad.getFecha_ingreso(),
                    entidad.getMonto_pagado(),
                    entidad.getMetodo_ingreso(),
                    entidad.getComprobante_ingreso(),
                    entidad.getRecibos_idrecibo(),
                    entidad.getPeriodos_idperiodo(),
                    entidad.getEdificios_idedificio()
            ));
            return new ResponseEntity<>(_entidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}