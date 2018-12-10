package ru.trainee.adminPanel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int id_banner;
    private String name_admin;
    private String name_action;
    private String time_action;

    public Action(){}

    public Action(int id, int id_banner, String name_admin, String name_action, String time_action){
        this.id = id;
        this.id_banner = id_banner;
        this.name_admin = name_admin;
        this.name_action = name_action;
        this.time_action = time_action;
    }

}
