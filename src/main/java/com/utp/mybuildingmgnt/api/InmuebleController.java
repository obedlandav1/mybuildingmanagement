package com.utp.mybuildingmgnt.api;

import com.utp.mybuildingmgnt.models.Inmueble;
import com.utp.mybuildingmgnt.repositories.InmuebleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class InmuebleController {
    @Autowired
    private InmuebleRepository repository;

    // listar inmuebles por edificio
    @GetMapping("/inmuebles/edificio/{idEdificio}")
    public List<Inmueble> listarPorEdificio(@PathVariable Long idEdificio) {
        // Filtra los inmuebles que tengan edificios_idedificio igual al recibido
        return repository.findAll()
                .stream()
                .filter(inmueble -> inmueble.getEdificios_idedificio() == idEdificio)
                .collect(Collectors.toList());
    }

    // crear un nuevo inmueble
    @PostMapping
    public ResponseEntity<Inmueble> crear(@RequestBody Inmueble entidad) {
        try {
            Inmueble nuevo = repository.save(new Inmueble(
                    null,
                    entidad.getNumero_inm(),
                    entidad.getPorcentaje_inm(),
                    entidad.getEstado_inm(),
                    entidad.getTipo_inmueble(),
                    entidad.getMetro_cuadrado(),
                    entidad.getEdificios_idedificio(),
                    entidad.getPropietarios_idpropietario()));
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // actualizar un inmueble existente
    @PutMapping("/{id}")
    public ResponseEntity<Inmueble> actualizar(@PathVariable Long id, @RequestBody Inmueble entidad) {
        Optional<Inmueble> inmuebleData = repository.findById(id);

        if (inmuebleData.isPresent()) {
            Inmueble inmueble = inmuebleData.get();
            inmueble.setNumero_inm(entidad.getNumero_inm());
            inmueble.setPorcentaje_inm(entidad.getPorcentaje_inm());
            inmueble.setEstado_inm(entidad.getEstado_inm());
            inmueble.setTipo_inmueble(entidad.getTipo_inmueble());
            inmueble.setMetro_cuadrado(entidad.getMetro_cuadrado());
            inmueble.setEdificios_idedificio(entidad.getEdificios_idedificio());
            inmueble.setPropietarios_idpropietario(entidad.getPropietarios_idpropietario());
            return new ResponseEntity<>(repository.save(inmueble), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // eliminar un inmueble por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}