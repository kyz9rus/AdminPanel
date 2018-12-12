package ru.trainee.adminPanel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String login;
    private String password;

    public Admin(){}
    public Admin(String login, String password){
        this.login = login;
        this.password = password;
    }
}
