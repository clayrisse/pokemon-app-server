package com.pokemonapp.dto;

public class PokeDTO {

    private String name;
    private String image;
    private int height;
    private int weight;
    private int experience;
    private int items;

    private int hp;
    private int attack;
    private int spAttack;
    private int spDefence;
    private int defence;
    private int speed;

    public PokeDTO() { }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

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

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpAttack() {
        return spAttack;
    }
    public void setSpAttack(int spAttack) {
        this.spAttack = spAttack;
    }

    public int getSpDefence() {
        return spDefence;
    }
    public void setSpDefence(int spDefence) {
        this.spDefence = spDefence;
    }

    public int getDefence() {
        return defence;
    }
    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
