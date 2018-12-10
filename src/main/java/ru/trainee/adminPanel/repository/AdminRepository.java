package ru.trainee.adminPanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trainee.adminPanel.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
}
