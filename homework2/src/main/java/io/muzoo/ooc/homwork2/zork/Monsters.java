package io.muzoo.ooc.homwork2.zork;

import sun.nio.cs.ext.IBM037;

public class Monsters implements GetProperties {   /// monster and boss

    private Integer hp;
    private Integer location; // where is the monster
    private Integer attack;
    private Integer defence;
    private final String description;

    public Monsters(Integer hp, Integer attack, Integer defence, String description) {

        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.description = description;

    }

    @Override
    public Integer getHp() {
        return this.hp;
    }
    @Override
    public Integer getAttack() {
        return this.attack;
    }

    @Override
    public Integer getLocation() {
        return this.location;
    }

    @Override
    public Integer getDefence() {
        return this.defence;
    }

    public String getDescription(String name) {
        return this.description;
    }

    public static void main(String[] args) {

    }
}
