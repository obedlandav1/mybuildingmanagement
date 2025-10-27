package com.utp.mybuildingmgnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LandingController {
    @Autowired
    @RequestMapping("/")
    public String landing() {
        return "landing/landing";
    }
}