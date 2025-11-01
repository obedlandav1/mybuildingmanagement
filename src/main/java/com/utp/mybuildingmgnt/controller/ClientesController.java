package com.utp.mybuildingmgnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientesController {
    @Autowired
    @RequestMapping("/administrator/client")
    public String building() {
        return "layout/client";
    }

    @Autowired
    @RequestMapping("/administrator/client-create")
    public String buildingcreate() {
        return "layout/client-create";
    }

    @Autowired
    @RequestMapping("/administrator/client-edit/{id}")
    public String buildingedit() {
        return "layout/client-edit";
    }

}