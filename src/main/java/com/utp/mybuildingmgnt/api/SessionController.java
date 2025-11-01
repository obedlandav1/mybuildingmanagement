package com.utp.mybuildingmgnt.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @PostMapping("/usuario")
    public Map<String, Object> setUsuario(
            @RequestParam int idusuario,
            @RequestParam String nomusuario,
            @RequestParam int rolusuario,
            @RequestParam int idcliente,
            @RequestParam String nomcliente,
            HttpSession session) {
        session.setAttribute("idusuario", idusuario);
        session.setAttribute("nomusuario", nomusuario);
        session.setAttribute("rolusuario", rolusuario);
        session.setAttribute("idcliente", idcliente);
        session.setAttribute("nomcliente", nomcliente);

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK);
        response.put("idusuario", idusuario);
        response.put("nomusuario", nomusuario);
        response.put("rolusuario", rolusuario);
        response.put("idcliente", idcliente);
        response.put("nomcliente", nomcliente);
        return response;
    }

    @GetMapping("/usuario")
    public Map<String, Object> getUsuario(HttpSession session) {
        Map<String, Object> data = new HashMap<>();
        data.put("idusuario", session.getAttribute("idusuario"));
        data.put("nomusuario", session.getAttribute("nomusuario"));
        data.put("rolusuario", session.getAttribute("rolusuario"));
        data.put("idcliente", session.getAttribute("idcliente"));
        data.put("nomcliente", session.getAttribute("nomcliente"));
        return data;
    }

    @PostMapping("/cliente")
    public Map<String, Object> setCliente(
            @RequestParam int idcliente,
            @RequestParam String nombre,
            HttpSession session) {
        session.setAttribute("idcliente", idcliente);
        session.setAttribute("nombrecliente", nombre);

        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK);
        response.put("idcliente", idcliente);
        response.put("nombrecliente", nombre);
        return response;
    }

    @GetMapping("/cliente")
    public Map<String, Object> getCliente(HttpSession session) {
        Map<String, Object> data = new HashMap<>();
        data.put("idcliente", session.getAttribute("idcliente"));
        data.put("nombrecliente", session.getAttribute("nombrecliente"));
        return data;
    }
}