package com.utp.mybuildingmgnt.api;

import com.utp.mybuildingmgnt.models.Propietario;
import com.utp.mybuildingmgnt.repositories.PropietarioRepository;

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
public class PropietarioController {

    @Autowired
     private PropietarioRepository repository;

      // Listar por edificio

   // listar propietario por edificio
     @GetMapping("propietarios/edificio/{id}")
    public ResponseEntity<?> getPropietariosPorEdificio(@PathVariable Long id) {
        try {
            List<Propietario> propietarios = repository.findPropietariosByEdificio(id);
            if (propietarios.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No se encontraron propietarios para este edificio");
            }
            return ResponseEntity.ok(propietarios);
        } catch (Exception e) {
            // Manejo de errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener los propietarios: " + e.getMessage());
        }
    }
     // Crear propietario
    @PostMapping("/propietario/crear")
    public ResponseEntity<Propietario> create(@RequestBody Propietario entidad) {
        try {
            Propietario _entidad = repository.save(new Propietario(
                    null,
                    entidad.getDni_pro(),
                    entidad.getNombre_pro(),
                    entidad.getApellido_pro(),
                    entidad.getTelefono_pro(),
                    entidad.getCorreo_pro(),
                    entidad.getEstado_pro()
            ));
            return new ResponseEntity<>(_entidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

      // Actualizar propietario
    @PutMapping("/propietario/editar/{id}")
    public ResponseEntity<Propietario> actualizar(@PathVariable("id") Long id, @RequestBody Propietario entidad) {
        Optional<Propietario> propietarioData = repository.findById(id);
        if (propietarioData.isPresent()) {
            Propietario _prop = propietarioData.get();
            _prop.setDni_pro(entidad.getDni_pro());
            _prop.setNombre_pro(entidad.getNombre_pro());
            _prop.setApellido_pro(entidad.getApellido_pro());
            _prop.setTelefono_pro(entidad.getTelefono_pro());
            _prop.setCorreo_pro(entidad.getCorreo_pro());
            _prop.setEstado_pro(entidad.getEstado_pro());
            return new ResponseEntity<>(repository.save(_prop), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar propietario
    @DeleteMapping("/propietario/eliminar/{id}")
    public ResponseEntity<HttpStatus> eliminar(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}