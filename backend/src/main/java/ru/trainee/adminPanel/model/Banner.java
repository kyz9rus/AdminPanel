package ru.trainee.adminPanel.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Integer.class)
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "banner_id")
    private int id;
    @NotNull
    @Column(name = "imgsrc")
    private String imgSrc;
    @NotNull
    private int width;
    @NotNull
    private int height;
    @NotNull
    @Column(name = "targeturl")
    private String targetUrl;
    @NotNull
    @Column(name = "langid")
    private String langId;

    public Banner(){}

    public Banner(int id){
        this.id = id;
    }

    public Banner(int id, String imgSrc, int width, int height, String targetUrl, String langId) {
        this.id = id;
        this.imgSrc = imgSrc;
        this.width = width;
        this.height = height;
        this.targetUrl = targetUrl;
        this.langId = langId;
    }

    @Override
    public String toString(){
        return "Banner {id:" + id + ", imgSrc:" + imgSrc + ", width:" + width + ", height:" + height + ", targetUrl:" + targetUrl + ", langId:" + langId + "}";
    }
}
