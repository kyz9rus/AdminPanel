package ru.trainee.adminpanel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.trainee.adminpanel.data.model.Action;
import ru.trainee.adminpanel.data.model.Banner;
import ru.trainee.adminpanel.data.model.User;
import ru.trainee.adminpanel.data.repository.ActionRepository;
import ru.trainee.adminpanel.data.repository.BannerRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerService {

    private final BannerRepository bannerRepository;
    private final ActionRepository actionRepository;

    public Optional<Banner> saveBanner(Banner banner) {
        User admin = getUserFromAuthentication();

        System.out.println("Add new banner: " + banner + " by " + admin.getLogin() + "...");

        Optional<Banner> resultBanner;
        try {
            resultBanner = Optional.of(bannerRepository.save(banner));
            bannerRepository.flush();
        } catch (Exception e) {
            e.printStackTrace();
            resultBanner = Optional.empty();
        }

        Action action = new Action(resultBanner.get().getId(), admin, "ADD", getCurrentDate());
        System.out.println("Add action: " + action + " by " + admin.getLogin() + "...\n");

        try {
            actionRepository.save(action);
        } catch (Exception e) {
            e.printStackTrace();

            bannerRepository.deleteById(banner.getId());
            resultBanner = Optional.empty();
        }

        return resultBanner;
    }

    public boolean deleteBanner(Long id_banner) {
        User admin = getUserFromAuthentication();

        try {
            System.out.println("Delete banner with id:" + id_banner + " by " + admin.getLogin() + "...");

            bannerRepository.deleteById(id_banner);

            Action action = new Action(id_banner, admin, "DELETE", getCurrentDate());
            System.out.println("Add action: " + action + " by " + admin.getLogin() + "...\n");

            actionRepository.save(action);
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }

    public Optional<Banner> editBanner(Banner banner) {
        User admin = getUserFromAuthentication();

        Optional<Banner> resultBanner = Optional.empty();

        try {
            System.out.println("Update banner: " + banner + " by " + admin.getLogin() + "...");

            Optional<Banner> bannerFromDb = bannerRepository.findById(banner.getId());

            if (bannerFromDb.isPresent()) {
                resultBanner = Optional.of(checkBanner(bannerFromDb.get(), banner));
                bannerRepository.save(resultBanner.get());
            }

            Action action = new Action(resultBanner.get().getId(), admin, "EDIT", getCurrentDate());
            System.out.println("Add action: " + action + " by " + admin.getLogin() + "...\n");

            actionRepository.save(action);
        } catch (Exception e) {
            e.printStackTrace();
            resultBanner = Optional.empty();
        }

        return resultBanner;
    }

    private Banner checkBanner(Banner bannerFromDb, Banner bannerFromForm) {
        if (bannerFromForm.getHeight() != 0)
            bannerFromDb.setHeight(bannerFromForm.getHeight());

        if (bannerFromForm.getWidth() != 0)
            bannerFromDb.setWidth(bannerFromForm.getWidth());

        if (bannerFromForm.getImgSrc() != null)
            bannerFromDb.setImgSrc(bannerFromForm.getImgSrc());

        if (bannerFromForm.getTargetUrl() != null)
            bannerFromDb.setTargetUrl(bannerFromForm.getTargetUrl());

        if (bannerFromForm.getLangId() != null)
            bannerFromDb.setLangId(bannerFromForm.getLangId());

        return bannerFromDb;
    }

    public List<Banner> showAllBanners() {
        return bannerRepository.findAll();
    }

    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    public User getUserFromAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = null;

        try {
            if (!authentication.getName().equals("anonymousUser"))
                user = (User) authentication.getPrincipal();
            else
                user = new User();

        } catch (NullPointerException e) {
            System.out.println("There is no authentication user yet.");
        }

        return user;
    }

    public String getCurrentDate() {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date currentDate = new Date();

        return formatForDateNow.format(currentDate);
    }
}
