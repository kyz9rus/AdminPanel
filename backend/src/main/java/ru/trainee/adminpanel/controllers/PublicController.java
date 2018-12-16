package ru.trainee.adminpanel.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.trainee.adminpanel.data.model.Banner;
import ru.trainee.adminpanel.service.BannerService;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class PublicController {

    private final BannerService bannerService;

    @GetMapping("/showAllBanners")
    public List<Banner> showAllBanners() {
        return bannerService.showAllBanners();
    }

    @GetMapping("/getAuthority")
    public Object getAuthority() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication.getPrincipal();
    }

}
