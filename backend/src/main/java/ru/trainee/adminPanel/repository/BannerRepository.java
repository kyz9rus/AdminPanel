package ru.trainee.adminPanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.trainee.adminPanel.model.Banner;

public interface BannerRepository extends JpaRepository<Banner, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into banner (banner_id, imgsrc, width, height, targeturl, langid) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    int saveBanner(int banner_id, String imgsrc, int width, int height, String targeturl, String langid);
}
