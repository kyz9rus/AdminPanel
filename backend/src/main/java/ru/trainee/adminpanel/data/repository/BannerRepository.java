package ru.trainee.adminpanel.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.trainee.adminpanel.data.model.Banner;

public interface BannerRepository extends JpaRepository<Banner, Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into banner (banner_id, imgsrc, width, height, targeturl, langid) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    int saveBanner(Long banner_id, String imgsrc, int width, int height, String targeturl, String langid);
}
