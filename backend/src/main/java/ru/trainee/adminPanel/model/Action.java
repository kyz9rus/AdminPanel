package ru.trainee.adminPanel.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Integer.class)
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @JsonBackReference
//    public Banner getBanner(){
//        return banner;
//    }

//    @JsonBackReference
//    public User getUser(){
//        return user;
//    }

    @NotNull
//    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
//    @JoinColumn(name="banner_id")
    private int banner_id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="username")
    private User user;

    @NotNull
    private String actionname;
    @NotNull
    private String actiontime;

    public Action(){}

    public Action(int banner_id, User user, String actionName, String actiontime){
        this.banner_id = banner_id;
        this.user = user;
        this.actionname = actionName;
        this.actiontime = actiontime;
    }

    @Override
    public String toString(){
        return "Action {id:" + id + ", banner_id:" + banner_id + ", userName:" + user.getLogin() + ", actionName:" + actionname + ", actionTime:" + actiontime + "}";
    }

}
