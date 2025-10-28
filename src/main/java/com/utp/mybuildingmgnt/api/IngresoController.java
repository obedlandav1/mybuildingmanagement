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

    @GetMapping("/ingreso/{id}")
    public ResponseEntity<Ingreso> getById(@PathVariable("id") Long id) {
        Optional<Ingreso> entidad = repository.findById(id);
        if (entidad.isPresent()) {
            return new ResponseEntity<>(entidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/ingreso/crear")
    public ResponseEntity<Ingreso> create(@RequestBody Ingreso entidad) {
        try {
            Ingreso _entidad = repository.save(new Ingreso(null,
                    entidad.getFecha_ingreso(),
                    entidad.getTipo_ingreso(),
                    entidad.getMonto_pagado(),
                    entidad.getMetodo_ingreso(),
                    entidad.getComprobante_ingreso(),
                    entidad.getRecibos_idrecibo(),
                    entidad.getPeriodos_idperiodo(),
                    entidad.getEdificios_idedificio()));
            return new ResponseEntity<>(_entidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ingreso/{id}")
    public ResponseEntity<Ingreso> update(@PathVariable("id") Long id, @RequestBody Ingreso entidad) {
        Ingreso _entidad = repository.findById(id).orElse(null);
        if (_entidad != null) {
                    _entidad.setFecha_ingreso(entidad.getFecha_ingreso());
                    _entidad.setTipo_ingreso(entidad.getTipo_ingreso());
                    _entidad.setMonto_pagado(entidad.getMonto_pagado());
                    _entidad.setMetodo_ingreso(entidad.getMetodo_ingreso());
                    _entidad.setComprobante_ingreso(entidad.getComprobante_ingreso());
                    _entidad.setRecibos_idrecibo(entidad.getRecibos_idrecibo());
                    _entidad.setPeriodos_idperiodo(entidad.getPeriodos_idperiodo());
                    _entidad.setEdificios_idedificio(entidad.getEdificios_idedificio());
            return new ResponseEntity<>(repository.save(_entidad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/ingreso/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}