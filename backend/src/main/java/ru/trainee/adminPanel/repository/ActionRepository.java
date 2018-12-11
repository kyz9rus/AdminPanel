package ru.trainee.adminPanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.trainee.adminPanel.model.Action;

public interface ActionRepository extends JpaRepository<Action, Integer> {
}
