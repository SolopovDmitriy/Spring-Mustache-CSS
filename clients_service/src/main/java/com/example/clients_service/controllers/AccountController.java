package com.example.clients_service.controllers;

import com.example.clients_service.models.Phone;
import com.example.clients_service.services.data.AccountService;
import com.example.clients_service.services.data.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public String phone(Model model){
       //  List<Phone> phones = phoneService.findAll();
       //  model.addAttribute("phones", phones);
        return "account";
    }


//    @PostMapping("add_phone")
//    public String addPhone(Model model, @RequestParam("phone")String phone){
//        Phone phone1 = new Phone(0L, phone);
//        phoneService.save(phone1);
//        return "redirect:/phones";
//    }
}
