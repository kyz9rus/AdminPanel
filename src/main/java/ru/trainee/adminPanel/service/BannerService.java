package ru.trainee.adminPanel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.trainee.adminPanel.model.Action;
import ru.trainee.adminPanel.model.Banner;
import ru.trainee.adminPanel.repository.ActionRepository;
import ru.trainee.adminPanel.repository.BannerRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BannerService {
    private final BannerRepository bannerRepository;

    private final ActionRepository actionRepository;

    public void addBanner(Banner banner){
        bannerRepository.save(banner);

//        Action action = new Action();
//        actionRepository.save();
    }

    public void deleteBanner(int id_banner){
        bannerRepository.deleteById(id_banner);
    }

    public void editBanner(Banner banner){
        Optional<Banner> bannerFromDb = bannerRepository.findById(banner.getId());
        bannerRepository.delete(bannerFromDb.get());
        bannerRepository.save(banner);
    }
}
