package com.example.banksimulation.controller;

import com.example.banksimulation.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/index")
    public String accountList(Model model) {
        model.addAttribute("accountList", accountService.listAllAccount());
        return "account/index";
    }


}
