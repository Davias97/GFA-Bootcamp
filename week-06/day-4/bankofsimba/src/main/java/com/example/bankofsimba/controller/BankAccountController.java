package com.example.bankofsimba.controller;

import com.example.bankofsimba.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BankAccountController {

    @GetMapping("/show")
    public String showAccount(Model model) {

        BankAccount bankAccount = new BankAccount("Simba", 2000, "lion");
        model.addAttribute("account", bankAccount);

        return "account";
    }

    @GetMapping("/text")
    public String showText(Model model) {
        String htmlText = "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>";
        model.addAttribute("htmlText", htmlText);

        return "htmlception";
    }

    @GetMapping("/fillaccount")
    public String fillAccount(Model model) {

        List<BankAccount> bankAccountList = new ArrayList<>();

        bankAccountList.add(new BankAccount("Simba", 2000, "lion"));
        bankAccountList.add(new BankAccount("Timon", 500, "meerkat"));
        bankAccountList.add(new BankAccount("Pumbaa", 800, "warthog"));
        bankAccountList.add(new BankAccount("Rafiki", 200, "monkey"));

        model.addAttribute("bankAccountTable", bankAccountList);

        return "fillingaccounts";
    }
}
