package ru.trainee.adminPanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trainee.adminPanel.model.Banner;

public interface BannerRepository extends JpaRepository<Banner, Integer> {
}
