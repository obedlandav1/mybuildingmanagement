package com.utp.mybuildingmgnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuariosController {
    @Autowired
    @RequestMapping("/administrator/user")
    public String user() {
        return "layout/user";
    }

    @Autowired
    @RequestMapping("/administrator/user-create")
    public String usercreate() {
        return "layout/user-create";
    }

    @Autowired
    @RequestMapping("/administrator/user-edit/{id}")
    public String useredit() {
        return "layout/user-edit";
    }

}