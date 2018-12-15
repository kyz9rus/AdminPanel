package ru.trainee.adminPanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.trainee.adminPanel.model.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into action (banner_id, username, actionname, actiontime) VALUES (?1, ?2,  CAST (?3 AS name_actions), CAST (?4 AS timestamp))", nativeQuery = true)
    int saveAction(int banner_id, String username, String actionname, String actiontime);
}
