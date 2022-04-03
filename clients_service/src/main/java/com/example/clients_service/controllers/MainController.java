package com.example.clients_service.controllers;

import com.example.clients_service.models.Client;
import com.example.clients_service.models.Client.Gender;
import com.example.clients_service.services.data.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String main(Model model){
        List<Client> clients = clientService.findAll();
        if(!clients.isEmpty()){
            Client client = clients.get(0);
            System.out.println(client.getSurname());
        }

        model.addAttribute("clients", clients);
        return "main";
    }

    @GetMapping("main")
    public String main(){
        return "redirect:";
    }

    @PostMapping("add_client")
    public String addClient(Model model,
                            @RequestParam("surname")String surname,
                            @RequestParam("name")String name,
                            @RequestParam("patronymic")String patronymic,
                            @RequestParam("birthDate")String birthDate,
                            @RequestParam("email")String email,
                            @RequestParam("gender") Gender gender
                            ){
        System.err.println(LocalDate.parse(birthDate,
                DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.err.println(gender);
        LocalDate date = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Client client = new Client(0L, null, name, patronymic, date, email, gender);
        clientService.save(client);


        return "redirect:";
    }
}
