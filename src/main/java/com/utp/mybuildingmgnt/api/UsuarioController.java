package com.utp.mybuildingmgnt.api;

import com.utp.mybuildingmgnt.models.Edificio;
import com.utp.mybuildingmgnt.models.Usuario;
import com.utp.mybuildingmgnt.repositories.UsuarioRepository;
import com.utp.mybuildingmgnt.utils.PasswordUtils;

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
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;
    PasswordUtils password;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAll(@RequestParam(required = false) String title) {
        try {
            List<Usuario> lista = new ArrayList<Usuario>();
            repository.findAll().forEach(lista::add);
            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario/{dni}")
    public ResponseEntity<Usuario> getByDni(@PathVariable("dni") Long dni) {
        Optional<Usuario> entidad = repository.findByDni_usuario(dni);
        try {
        if (entidad.isPresent()) {
            Usuario user = entidad.get();
            String inputpass = password.hash(dni.toString());

            if (PasswordUtils.matches(inputpass, user.getClave())) {
                return null;
            }

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

                } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/edificio")
    public ResponseEntity<Edificio> create(@RequestBody Edificio entidad) {
        try {
            Edificio _entidad = repository.save(new Edificio(null,
                    entidad.getNombre_edificio(),
                    entidad.getDireccion_edificio(),
                    entidad.getRuc(),
                    entidad.getPais_edificio(),
                    entidad.getEstado_edificio()));
            return new ResponseEntity<>(_entidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edificio/{id}")
    public ResponseEntity<Edificio> update(@PathVariable("id") Long id, @RequestBody Edificio entidad) {
        Edificio _entidad = repository.findById(id).orElse(null);
        if (_entidad != null) {
            _entidad.setNombre_edificio(entidad.getNombre_edificio());
            _entidad.setDireccion_edificio(entidad.getDireccion_edificio());
            _entidad.setRuc(entidad.getRuc());
            _entidad.setPais_edificio(entidad.getPais_edificio());
            _entidad.setEstado_edificio(entidad.getEstado_edificio());
            return new ResponseEntity<>(repository.save(_entidad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/edificio/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}