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
    public ResponseEntity<Usuario> getByDni(@PathVariable("dni") String dni) {

        try {
            Optional<Usuario> entidad = repository.findByDniusuario(dni);
            if (entidad.isPresent()) {
                Usuario user = entidad.get();
                String inputpass = password.hash(dni);

                if (password.matches(inputpass, user.getClave())) {

                }

                return new ResponseEntity<>(entidad.get(), HttpStatus.OK);

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}