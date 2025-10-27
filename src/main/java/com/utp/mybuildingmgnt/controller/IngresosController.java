package com.utp.mybuildingmgnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IngresosController {
    @Autowired
    @RequestMapping("/income")
    public String income() {
        return "layout/income";
    }

    @Autowired
    @RequestMapping("/income-create")
    public String incomecreate() {
        return "layout/income-create";
    }

    @Autowired
    @RequestMapping("/income-edit")
    public String incomeedit() {
        return "layout/income-edit";
    }
}