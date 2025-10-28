package com.utp.mybuildingmgnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EdificiosController {
    @Autowired
    @RequestMapping("/building")
    public String building() {
        return "layout/building";
    }

    @Autowired
    @RequestMapping("/building-create")
    public String buildingcreate() {
        return "layout/building-create";
    }

    @Autowired
    @RequestMapping("/building-edit")
    public String buildingedit() {
        return "layout/building-edit";
    }

}
