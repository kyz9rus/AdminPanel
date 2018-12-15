package ru.trainee.adminPanel.service;

import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;
import ru.trainee.adminPanel.model.Action;
import ru.trainee.adminPanel.model.Banner;
import ru.trainee.adminPanel.model.User;
import ru.trainee.adminPanel.repository.ActionRepository;
import ru.trainee.adminPanel.repository.BannerRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static ru.trainee.adminPanel.other.Constants.ERROR_CODE;
import static ru.trainee.adminPanel.other.Constants.SUCCESS_CODE;

@RequiredArgsConstructor
@Service
public class BannerService {
    private final BannerRepository bannerRepository;
    private final ActionRepository actionRepository;

    private SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public int saveBanner(Banner banner, String adminName){
        System.out.println("Add new banner: " + banner + " by " + adminName + "...");

        try {
            bannerRepository.saveBanner(banner.getId(), banner.getImgSrc(), banner.getWidth(), banner.getHeight(), banner.getTargetUrl(), banner.getLangId());
        }catch (Exception e){
            e.printStackTrace();
            return ERROR_CODE;
        }

        Date currentDate = new Date();
        Action action = new Action(banner.getId(), new User(adminName), "ADD", formatForDateNow.format(currentDate));

        System.out.println("Add action: " + action + " by " + adminName + "...");
        try {
            actionRepository.saveAction(action.getBanner_id(), action.getUser().getLogin(), action.getActionname(), action.getActiontime());
        }catch (Exception e){
            e.printStackTrace();

            bannerRepository.deleteById(banner.getId());
            return ERROR_CODE;
        }

        return SUCCESS_CODE;
    }

    public int deleteBanner(int id_banner, String adminName){
        try {
            System.out.println("Delete banner with id:" + id_banner + " by " + adminName + "...");

            bannerRepository.deleteById(id_banner);
            bannerRepository.flush();

            Date currentDate = new Date();
            Action action = new Action(id_banner, new User(adminName), "DELETE", formatForDateNow.format(currentDate));

            System.out.println("Add action: " + action + " by " + adminName + "...");

            actionRepository.saveAction(action.getBanner_id(), action.getUser().getLogin(), action.getActionname(), action.getActiontime());
        }catch(Exception e){
            e.printStackTrace();
            return ERROR_CODE;
        }

        return SUCCESS_CODE;
    }

    public int editBanner(Banner banner, String adminName){
        try {
            System.out.println("Update banner: " + banner + " by " + adminName + "...");

            Optional<Banner> bannerFromDb = bannerRepository.findById(banner.getId());

            Banner resultBanner;
            if (bannerFromDb.isPresent()) {
                resultBanner = checkBanner(bannerFromDb.get(), banner);
                bannerRepository.save(resultBanner);
            }

            Date currentDate = new Date();
            Action action = new Action(banner.getId(), new User(adminName), "EDIT", formatForDateNow.format(currentDate));

            System.out.println("Add action: " + action + " by " + adminName + "...");

            actionRepository.saveAction(action.getBanner_id(), action.getUser().getLogin(), action.getActionname(), action.getActiontime());
        }
        catch (Exception e){
            e.printStackTrace();
            return ERROR_CODE;
        }

        return SUCCESS_CODE;
    }

    private Banner checkBanner(Banner bannerFromDb, Banner bannerFromForm){
        if (bannerFromForm.getHeight() != 0)
            bannerFromDb.setHeight(bannerFromForm.getHeight());

        if (bannerFromForm.getWidth() != 0)
            bannerFromDb.setWidth(bannerFromForm.getWidth());

        if (bannerFromForm.getImgSrc().length() != 0)
            bannerFromDb.setImgSrc(bannerFromForm.getImgSrc());

        if (bannerFromForm.getTargetUrl().length() != 0)
            bannerFromDb.setTargetUrl(bannerFromForm.getTargetUrl());

        if (bannerFromForm.getLangId().length() != 0)
            bannerFromDb.setLangId(bannerFromForm.getLangId());

        return bannerFromDb;
    }

    public List<Banner> showAllBanners(){ return bannerRepository.findAll(); }
    public List<Action> getAllActions(){ return actionRepository.findAll(); }
}
