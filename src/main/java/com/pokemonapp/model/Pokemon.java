package com.pokemonapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @NotNull
    @Column( unique= true )
    private String name;
    private String image;
    private int height;
    private int weight;
    private int experience;
    private int items;
    @Embedded
    private Stats stats;
    @ManyToMany(mappedBy = "pokeList")
    private List<Trainer> trainerList =new ArrayList<>();

    public Pokemon() {
    }

    public Pokemon(String image, String name, int height, int weight, int experience, int items, Stats stats) {
        this.image = image;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.experience = experience;
        this.items = items;
        this.stats = stats;
    }

    public List<Trainer> getTrainerList() { return trainerList; }
    public void setTrainerList(List<Trainer> trainerList) { this.trainerList = trainerList; }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getItems() {
        return items;
    }
    public void setItems(int items) {
        this.items = items;
    }

    public Stats getStats() {
        return stats;
    }
    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
