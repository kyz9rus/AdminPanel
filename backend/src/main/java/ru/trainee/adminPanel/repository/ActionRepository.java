package ru.trainee.adminPanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.trainee.adminPanel.model.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {
    @Query(value = "insert into action (id, banner_id, actionname, actiontime) VALUES (?1, ?2, (CAST ?3 AS name_action), ?4)", nativeQuery = true)
    void saveAction(int id, int banner_id, String actionname, String actiontime);
}
