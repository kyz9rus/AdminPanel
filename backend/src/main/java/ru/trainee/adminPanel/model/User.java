package ru.trainee.adminPanel.model;

import com.fasterxml.jackson.annotation.*;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Externalizable;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "login")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String login;
    @NotNull
    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    public List<Action> actions;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_login"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(){}
    public User(String login){
        this.login = login;
    }
    public User(User user){
        login = user.getLogin();
        password = user.getPassword();
        roles = user.getRoles();
    }
    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString(){
        return "User {login:" + login + ", password:" + password + "}";
    }
}
