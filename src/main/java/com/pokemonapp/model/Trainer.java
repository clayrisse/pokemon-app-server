package com.pokemonapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.Date;
import java.util.StringTokenizer;


@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String username;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birth;
    private String picture;

    private String hobby;

    public Trainer() {}

    public Trainer(String username, Date birth, String hobby) {
        setUsername(username);
        this.birth = birth;
        this.picture = "https://www.kindpng.com/picc/m/21-214439_free-high-quality-person-icon-default-profile-picture.png";
        this.hobby = hobby;
    }

    public Trainer(String username, Date birth, String picture, String hobby) {
        setUsername(username);
        this.birth = birth;
        this.picture = picture;
        this.hobby = hobby;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        char[] arr = username.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        this.username = new String(arr);
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}