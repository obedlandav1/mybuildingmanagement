package com.utp.mybuildingmgnt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String landing() {
        return "landing/landing";
    }

    @GetMapping("/login")
    public String login() {
        return "layout/login";
    }

    @GetMapping("/main")
    public String main() {
        return "layout/main";
    }

    @GetMapping("/building")
    public String building() {
        return "layout/building";
    }

    

}
