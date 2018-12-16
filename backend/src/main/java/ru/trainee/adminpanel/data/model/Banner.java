package ru.trainee.adminpanel.data.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="banner")
public class Banner {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="banner_seq")
    @SequenceGenerator(name="banner_seq", sequenceName="SEQ_BANNER", allocationSize=1)
    @Column(name = "banner_id")
    private Long id;
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

    public Banner(Long id, String imgSrc, int width, int height, String targetUrl, String langId) {
        this.id = id;
        this.imgSrc = imgSrc;
        this.width = width;
        this.height = height;
        this.targetUrl = targetUrl;
        this.langId = langId;
    }

    public Banner(String imgSrc, int width, int height, String targetUrl, String langId) {
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
