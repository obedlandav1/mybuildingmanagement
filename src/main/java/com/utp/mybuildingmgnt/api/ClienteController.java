package com.utp.mybuildingmgnt.api;

import com.utp.mybuildingmgnt.models.Cliente;
import com.utp.mybuildingmgnt.repositories.ClienteRepository;
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
public class ClienteController {

    @Autowired
    ClienteRepository repository;

    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> getAll(@RequestParam(required = false) String title) {
        try {
            List<Cliente> lista = new ArrayList<Cliente>();
            repository.findAll().forEach(lista::add);
            if (lista.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") Long id) {
        Optional<Cliente> entidad = repository.findById(id);
        if (entidad.isPresent()) {
            return new ResponseEntity<>(entidad.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cliente")
    public ResponseEntity<Cliente> create(@RequestBody Cliente entidad) {
        try {

            Cliente cli = new Cliente();
            cli.setRazon_cliente(entidad.getRazon_cliente());
            cli.setNum_identidad(entidad.getNum_identidad());
            cli.setDireccion_cliente(entidad.getDireccion_cliente());
            cli.setEstado_cliente(entidad.getEstado_cliente());

            Cliente _entidad = repository.save(cli);
            
            return new ResponseEntity<>(_entidad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") Long id, @RequestBody Cliente entidad) {
        Cliente _entidad = repository.findById(id).orElse(null);
        if (_entidad != null) {
            _entidad.setRazon_cliente(entidad.getRazon_cliente());
            _entidad.setNum_identidad(entidad.getNum_identidad());
            _entidad.setDireccion_cliente(entidad.getDireccion_cliente());
            _entidad.setEstado_cliente(entidad.getEstado_cliente());
            return new ResponseEntity<>(repository.save(_entidad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}