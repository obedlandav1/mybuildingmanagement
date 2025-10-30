package com.utp.mybuildingmgnt.api;

import com.utp.mybuildingmgnt.models.Usuario;
import com.utp.mybuildingmgnt.repositories.UsuarioRepository;
import com.utp.mybuildingmgnt.utils.PasswordUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Autowired
    PasswordUtils passutil;

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

    @PostMapping("/usuario/validar")
    ResponseEntity<Map<String, Object>> login(
            // public ResponseEntity<Usuario> login(
            @RequestParam("user") String user,
            @RequestParam("pass") String pass) {
        try {
            Optional<Usuario> entidad = repository.findByDniusuario(user);
            if (entidad.isPresent()) {
                Usuario u = entidad.get();
                if (passutil.matches(pass, u.getClave())) {
                    Map<String, Object> response = new HashMap<>();
                    response.put("status", "OK");
                    response.put("nombre", u.getNombre_usuario()+" "+u.getApellido_usuario());
                    response.put("rol", u.getRol_usuario());
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.INFO, null, "HttpStatus: OK");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    Logger.getLogger(UsuarioController.class.getName()).log(Level.INFO, null,
                            "HttpStatus: UNAUTHORIZED");
                    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
                }
            } else {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.INFO, null, "HttpStatus: NOT_FOUND");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}