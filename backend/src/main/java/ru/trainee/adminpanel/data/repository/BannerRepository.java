package ru.trainee.adminpanel.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.trainee.adminpanel.data.model.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Long> {}
