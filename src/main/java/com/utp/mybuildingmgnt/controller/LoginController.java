package com.utp.mybuildingmgnt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    @RequestMapping("/login")
    public String login() {
        return "layout/login";
    }
}