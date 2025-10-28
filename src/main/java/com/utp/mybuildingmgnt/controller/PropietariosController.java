package com.utp.mybuildingmgnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropietariosController {
    @Autowired
    @RequestMapping("/owner")
    public String owner() {
        return "layout/owner";
    }

    @Autowired
    @RequestMapping("/owner-create")
    public String ownercreate() {
        return "layout/owner-create";
    }

    @Autowired
    @RequestMapping("/owner-edit")
    public String owneredit() {
        return "layout/owner-edit";
    }
}