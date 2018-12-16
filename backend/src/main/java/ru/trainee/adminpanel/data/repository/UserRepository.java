package ru.trainee.adminpanel.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.trainee.adminpanel.data.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}