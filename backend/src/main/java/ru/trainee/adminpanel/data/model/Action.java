package ru.trainee.adminpanel.data.model;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import ru.trainee.adminpanel.utils.ActionType;
import ru.trainee.adminpanel.utils.PostgreSQLEnumType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_seq")
    @SequenceGenerator(name = "action_seq", sequenceName = "SEQ_ACTION", allocationSize = 1)
    private Long id;

    @NotNull
    private Long banner_id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "actionname", columnDefinition = "actionname")
    @Type(type = "pgsql_enum")
    @NotNull
    private ActionType actionName;

    @NotNull
    @Column(name = "actiontime")
    private String actionTime;

    public Action() {
    }

    public Action(Long banner_id, User user, ActionType actionName, String actionTime) {
        this.banner_id = banner_id;
        this.user = user;
        this.actionName = actionName;
        this.actionTime = actionTime;
    }

    @Override
    public String toString() {
        return "Action {id:" + id + ", banner_id:" + banner_id + ", userName:" + user.getLogin() + ", actionName:" + actionName + ", actionTime:" + actionTime + "}";
    }
}
