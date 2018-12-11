package ru.trainee.adminPanel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.trainee.adminPanel.model.Admin;

@Controller
public class MainController {

    @RequestMapping("/")
    public String hello(Model model){
        Admin admin = new Admin("admin1", "qwerty123");
        model.addAttribute(admin);

        return "index";
    }
}
