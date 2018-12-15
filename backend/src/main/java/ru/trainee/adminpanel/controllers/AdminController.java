package ru.trainee.adminpanel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.trainee.adminpanel.data.model.Action;
import ru.trainee.adminpanel.data.model.Banner;
import ru.trainee.adminpanel.other.Constant;
import ru.trainee.adminpanel.service.BannerService;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api/admin")
@RestController
public class AdminController {

    @Autowired
    BannerService bannerService;

    @PostMapping("/saveBanner")
    public ResponseEntity<Long> saveBanner(@RequestBody Banner banner){

        if (bannerService.saveBanner(banner) == Constant.SUCCESS_CODE)
            return new ResponseEntity<>(banner.getId(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editBanner")
    public ResponseEntity<Banner> editBanner(@RequestBody Banner banner){

        Optional<Banner> resultBanner = bannerService.editBanner(banner);

        if (resultBanner.isPresent())
            return new ResponseEntity<>(resultBanner.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteBanner/{id}")
    public ResponseEntity<Long> deleteBanner(@PathVariable("id") Long id){

        if (bannerService.deleteBanner(id) == Constant.SUCCESS_CODE)
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
}
