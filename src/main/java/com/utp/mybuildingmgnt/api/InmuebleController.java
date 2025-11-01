package com.utp.mybuildingmgnt.api;

import com.utp.mybuildingmgnt.models.Inmueble;
import com.utp.mybuildingmgnt.models.Propietario;
import com.utp.mybuildingmgnt.repositories.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/inmuebles")
public class InmuebleController {

    @Autowired
    private InmuebleRepository repository;

    // LISTAR 
    @GetMapping("/inmuebles/edificio/{idEdificio}")
    public List<Inmueble> listarPorEdificio(@PathVariable Long idEdificio) {
        return repository.findAll()
                .stream()
                .filter(inmueble -> inmueble.getEdificios_idedificio() == idEdificio)
                .collect(Collectors.toList());
    }

    // CREAR
    @PostMapping("/crear")
    public ResponseEntity<Inmueble> crear(@RequestBody Inmueble entidad) {
        try {
            // Por defecto, el estado debe iniciar como "Activo"
            if (entidad.getEstado_inm() == null || entidad.getEstado_inm().isEmpty()) {
                entidad.setEstado_inm("Activo");
            }

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
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ACTUALIZAR
    @PutMapping("/editar/{id}")
    public ResponseEntity<Inmueble> actualizar(@PathVariable("id") Long id, @RequestBody Inmueble entidad) {
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

    // ELIMINAR
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
