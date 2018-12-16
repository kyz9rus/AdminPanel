package ru.trainee.adminpanel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MappingController {

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/admin")
    public String toAdmin() {
        return "admin.html";
    }
}
