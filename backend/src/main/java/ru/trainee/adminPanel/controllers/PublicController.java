package ru.trainee.adminPanel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.trainee.adminPanel.model.Banner;
import ru.trainee.adminPanel.service.BannerService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class PublicController {
    @Autowired
    BannerService bannerService;

    @GetMapping("/showAllBanners")
    public List<Banner> showAllBanners(){
        return bannerService.showAllBanners();
    }

    @GetMapping("/getAuthority")
    public Object getAuthority(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getPrincipal();
    }

}
