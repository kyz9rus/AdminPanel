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
    private String imgsrc;
    @NotNull
    private int width;
    @NotNull
    private int height;
    @NotNull
    private String targeturl;
    @NotNull
    private String langid;

//    @JsonBackReference
//    @JsonIgnore
//    @OneToMany(mappedBy = "banner")
//    private List<Action> actions;

    public Banner(){}

    public Banner(int id){
        this.id = id;
    }

    public Banner(int id, String imgsrc, int width, int height, String targeturl, String langid) {
        this.id = id;
        this.imgsrc = imgsrc;
        this.width = width;
        this.height = height;
        this.targeturl = targeturl;
        this.langid = langid;
    }

    @Override
    public String toString(){
        return "Banner {id:" + id + ", imgSrc:" + imgsrc + ", width:" + width + ", height:" + height + ", targetUrl:" + targeturl + ", langId:" + langid + "}";
    }
}
