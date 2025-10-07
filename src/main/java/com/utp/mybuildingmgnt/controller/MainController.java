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

    @GetMapping("/building-create")
    public String buildingcreate() {
        return "layout/building-create";
    }

    @GetMapping("/building-edit")
    public String buildingedit() {
        return "layout/building-edit";
    }

    @GetMapping("/estate")
    public String estate() {
        return "layout/estate";
    }

    @GetMapping("/owner")
    public String owner() {
        return "layout/owner";
    }

    @GetMapping("/budget")
    public String budget() {
        return "layout/budget";
    }

    @GetMapping("/bills")
    public String bills() {
        return "layout/bills";
    }

    @GetMapping("/income")
    public String income() {
        return "layout/income";
    }

    @GetMapping("/expense")
    public String expense() {
        return "layout/expense";
    }
}
