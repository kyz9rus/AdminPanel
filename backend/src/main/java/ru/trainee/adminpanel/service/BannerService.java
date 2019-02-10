package ru.trainee.adminpanel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trainee.adminpanel.data.model.Action;
import ru.trainee.adminpanel.data.model.Banner;
import ru.trainee.adminpanel.data.model.User;
import ru.trainee.adminpanel.data.repository.BannerRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerService {
    private final BannerRepository bannerRepository;

    private final ActionService actionService;

    public Optional<Banner> saveBanner(Banner banner) {
        Authentication authentication = new Authentication();
        User admin = authentication.getUserFromAuthentication();

        Optional<Banner> resultBanner;
        try {
            resultBanner = Optional.of(bannerRepository.save(banner));
            bannerRepository.flush();
        } catch (Exception e) {
            e.printStackTrace();
            resultBanner = Optional.empty();
        }

        Action action = new Action(resultBanner.get().getId(), admin, "ADD", getCurrentDate());
        try {
            actionService.saveAction(action);
        } catch (Exception e) {
            e.printStackTrace();

            bannerRepository.deleteById(resultBanner.get().getId());
            resultBanner = Optional.empty();
        }

        return resultBanner;
    }

    public Optional<Banner> editBanner(Banner banner) {
        Authentication authentication = new Authentication();
        User admin = authentication.getUserFromAuthentication();

        Optional<Banner> resultBanner = Optional.empty();

        try {
            Optional<Banner> bannerFromDb = bannerRepository.findById(banner.getId());

            if (bannerFromDb.isPresent()) {
                resultBanner = Optional.of(checkBanner(bannerFromDb.get(), banner));
                bannerRepository.save(resultBanner.get());
            }

            Action action = new Action(resultBanner.get().getId(), admin, "EDIT", getCurrentDate());

            actionService.saveAction(action);
        } catch (Exception e) {
            e.printStackTrace();

            resultBanner = Optional.empty();
        }

        return resultBanner;
    }

    public boolean deleteBanner(Long bannerId) {
        Authentication authentication = new Authentication();
        User admin = authentication.getUserFromAuthentication();

        try {
            bannerRepository.deleteById(bannerId);

            Action action = new Action(bannerId, admin, "DELETE", getCurrentDate());

            actionService.saveAction(action);
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

        return true;
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

    String getCurrentDate() {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date currentDate = new Date();

        return formatForDateNow.format(currentDate);
    }
}