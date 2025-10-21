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

    @GetMapping("/estate-create")
    public String estatecreate(){
        return "layout/estate-create";
    }

    @GetMapping("/estate-edit")
    public String estateedit(){
        return "layout/estate-edit";
    }

    @GetMapping("/owner")
    public String owner() {
        return "layout/owner";
    }

     @GetMapping("/owner-create")
    public String ownercreate() {
        return "layout/owner-create";
    }

     @GetMapping("/owner-edit")
    public String owneredit() {
        return "layout/owner-edit";
    }

    @GetMapping("/budget")
    public String budget() {
        return "layout/budget";
    }

    @GetMapping("/budget-create")
    public String budgetcreate() {
        return "layout/budget-create";
    }

     @GetMapping("/budget-edit")
    public String budgetedit() {
        return "layout/budget-edit";
    }

    @GetMapping("/bills")
    public String bills() {
        return "layout/bills";
    }

    @GetMapping("/bills-detaill")
    public String billsdetaill() {
        return "layout/bills-detaill";
    }


    @GetMapping("/income")
    public String income() {
        return "layout/income";
    }

    @GetMapping("/income-create")
    public String incomecreate() {
        return "layout/income-create";
    }

    @GetMapping("/income-edit")
    public String incomeedit() {
        return "layout/income-edit";
    }

    @GetMapping("/expense")
    public String expense() {
        return "layout/expense";
    }

     @GetMapping("/expense-create")
    public String expensecreate() {
        return "layout/expense-create";
    }

     @GetMapping("/expense-edit")
    public String expenseedit() {
        return "layout/expense-edit";
    }

     @GetMapping("/receipt")
    public String receipt() {
        return "layout/receipt";
    }


     @GetMapping("/receiptpay")
    public String receiptpay() {
        return "layout/receiptpay";
    }

    @GetMapping("/balance")
    public String balance() {
        return "layout/balance";
    }

    @GetMapping("/balance-owner")
    public String balanceowner() {
        return "layout/balance-owner";
    }

    @GetMapping("/expense-matrix")
    public String expensematrix() {
        return "layout/expense-matrix";
    }

}
