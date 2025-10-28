package com.utp.mybuildingmgnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InmueblesController {
    @Autowired
    @RequestMapping("/estate")
    public String owner() {
        return "layout/estate";
    }

    @Autowired
    @RequestMapping("/estate-create")
    public String estatecreate() {
        return "layout/estate-create";
    }

    @Autowired
    @RequestMapping("/estate-edit")
    public String estateedit() {
        return "layout/estate-edit";
    }
}