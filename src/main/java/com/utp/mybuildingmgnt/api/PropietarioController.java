package com.utp.mybuildingmgnt.api;

import com.utp.mybuildingmgnt.models.Propietario;
import com.utp.mybuildingmgnt.repositories.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioRepository repository;

    // LISTAR TODOS LOS PROPIETARIOS
    @GetMapping("/propietarios")
    public ResponseEntity<List<Propietario>> listarTodos() {
        try {
            List<Propietario> lista = new ArrayList<>();
            repository.findAll().forEach(lista::add);

            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // BUSCAR PROPIETARIO POR ID
    @GetMapping("/propietarios/{id}")
    public ResponseEntity<Propietario> obtenerPorId(@PathVariable("id") Long id) {
        Optional<Propietario> propietarioData = repository.findById(id);
        return propietarioData
                .map(propietario -> new ResponseEntity<>(propietario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // FILTRAR PROPIETARIOS POR EDIFICIO
    @GetMapping("/edificio/{id}")
    public ResponseEntity<?> getPropietariosPorEdificio(@PathVariable Long id) {
        try {
            List<Propietario> propietarios = repository.findPropietariosByEdificio(id);
            if (propietarios.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("No se encontraron propietarios para este edificio");
            }
            return ResponseEntity.ok(propietarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener los propietarios: " + e.getMessage());
        }
    }

    // CREAR 
    @PostMapping("/crear")
    public ResponseEntity<Propietario> crear(@RequestBody Propietario entidad) {
        try {
            Propietario nuevo = new Propietario(
                    null,
                    entidad.getDni_pro(),
                    entidad.getNombre_pro(),
                    entidad.getApellido_pro(),
                    entidad.getTelefono_pro(),
                    entidad.getCorreo_pro(),
                    entidad.getEstado_pro()
            );
            Propietario guardado = repository.save(nuevo);
            return new ResponseEntity<>(guardado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ACTUALIZAR 
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Propietario> actualizar(@PathVariable("id") Long id, @RequestBody Propietario entidad) {
        Optional<Propietario> propietarioData = repository.findById(id);

        if (propietarioData.isPresent()) {
            Propietario existente = propietarioData.get();
            existente.setDni_pro(entidad.getDni_pro());
            existente.setNombre_pro(entidad.getNombre_pro());
            existente.setApellido_pro(entidad.getApellido_pro());
            existente.setTelefono_pro(entidad.getTelefono_pro());
            existente.setCorreo_pro(entidad.getCorreo_pro());
            existente.setEstado_pro(entidad.getEstado_pro());
            return new ResponseEntity<>(repository.save(existente), HttpStatus.OK);
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
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
