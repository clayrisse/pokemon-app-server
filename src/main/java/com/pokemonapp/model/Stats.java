package com.pokemonapp.model;

import javax.persistence.Embeddable;

@Embeddable
public class Stats {

    private int hp;
    private int attack;
    private int spAttack;
    private int spDefence;
    private int defence;
    private int speed;

    public Stats() {
    }

    public Stats(int hp, int attack, int spAttack, int spDefence, int defence, int speed) {
        this.hp = hp;
        this.attack = attack;
        this.spAttack = spAttack;
        this.spDefence = spDefence;
        this.defence = defence;
        this.speed = speed;
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
