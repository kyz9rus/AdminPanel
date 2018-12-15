package ru.trainee.adminpanel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MappingController {
    @PostMapping("/login")
    public String toLogin(){ return "login"; }

    @PostMapping("/admin")
    public String toAdmin(){ return "admin.html"; }
}