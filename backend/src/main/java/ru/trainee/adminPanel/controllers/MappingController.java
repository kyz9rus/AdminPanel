package ru.trainee.adminPanel.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.trainee.adminPanel.model.User;

import java.util.HashMap;

@Controller
public class MappingController {
    @RequestMapping("/login")
    public String toLogin(){ return "login"; }

    @RequestMapping("/admin")
    public String toAdmin(){ return "admin.html"; }
}
