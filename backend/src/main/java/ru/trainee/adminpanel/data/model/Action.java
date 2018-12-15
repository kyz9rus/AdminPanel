package ru.trainee.adminpanel.data.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private Long banner_id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="username")
    private User user;

    @NotNull
    @Column(name="actionname")
    private String actionName;
    @NotNull
    @Column(name="actiontime")
    private String actionTime;

    public Action(){}

    public Action(Long banner_id, User user, String actionName, String actionTime){
        this.banner_id = banner_id;
        this.user = user;
        this.actionName = actionName;
        this.actionTime = actionTime;
    }

    @Override
    public String toString(){
        return "Action {id:" + id + ", banner_id:" + banner_id + ", userName:" + user.getLogin() + ", actionName:" + actionName + ", actionTime:" + actionTime + "}";
    }

    enum ActionName{ADD, EDIT, DELETE}

}
