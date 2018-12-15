package ru.trainee.adminpanel.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trainee.adminpanel.data.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}