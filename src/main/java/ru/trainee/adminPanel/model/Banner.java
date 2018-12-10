package ru.trainee.adminPanel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String imgSrc;
    private int width;
    private int height;
    private String targetUrl;
    private int langId;

    public Banner(){}

    public Banner(int id, String imgSrc, int width, int height, String targetUrl, int langId){
        this.id = id;
        this.imgSrc = imgSrc;
        this.width = width;
        this.height = height;
        this.targetUrl = targetUrl;
        this.langId = langId;
    }
}
