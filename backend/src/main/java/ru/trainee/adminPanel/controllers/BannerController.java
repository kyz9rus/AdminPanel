package ru.trainee.adminPanel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.trainee.adminPanel.model.Action;
import ru.trainee.adminPanel.model.Banner;
import ru.trainee.adminPanel.model.User;
import ru.trainee.adminPanel.service.BannerService;

import java.util.List;

import static ru.trainee.adminPanel.other.Constants.SUCCESS_CODE;

@RequestMapping("/api/admin")
@RestController
public class BannerController {
    @Autowired
    BannerService bannerService;

    @PostMapping("/saveBanner/{nameAdmin}")
    public ResponseEntity<Integer> saveBanner(@PathVariable("nameAdmin") String adminName, @RequestBody Banner banner){

        if (bannerService.saveBanner(banner, adminName) == SUCCESS_CODE)
            return new ResponseEntity<>(banner.getId(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editBanner/{nameAdmin}")
    public ResponseEntity<Integer> editBanner(@PathVariable("nameAdmin") String adminName, @RequestBody Banner banner){

        if (bannerService.editBanner(banner, adminName) == SUCCESS_CODE)
            return new ResponseEntity<>(banner.getId(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteBanner/{id}/{adminName}")
    public ResponseEntity<Integer> deleteBanner(@PathVariable("id") int id, @PathVariable("adminName") String adminName){

        if (bannerService.deleteBanner(id, adminName) == SUCCESS_CODE)
            return new ResponseEntity<>(id, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllActions")
    public ResponseEntity<List<Action>> getAllActions(){
        List<Action> actions = bannerService.getAllActions();

        if (!actions.isEmpty())
            return new ResponseEntity<>(actions, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAdminName")
    public String getName(){
        String authority = "";
        User admin;

        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (!authentication.getName().equals("anonymousUser")) {
                admin = (User) authentication.getPrincipal();
                authority = admin.getLogin();
            }
        }
        catch(NullPointerException e){
            System.out.println("There is no authentication user yet.");
        }

        return authority;
    }


}
