package com.utp.mybuildingmgnt.api;

import com.utp.mybuildingmgnt.models.Inmueble;
import com.utp.mybuildingmgnt.repositories.InmuebleRepository;

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
public class InmuebleController {
   @Autowired
    private InmuebleRepository repository;

   //  listar inmuebles por edificio
@GetMapping("/edificio/{idEdificio}")
public ResponseEntity<List<Inmueble>> listarPorEdificio(@PathVariable("idEdificio") Long idEdificio) {
    try {
        List<Inmueble> lista = repository.findByEdificiosIdedificio(idEdificio);

        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(lista, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
//  crear un nuevo inmueble
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
                    entidad.getPropietarios_idpropietario()
            ));
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