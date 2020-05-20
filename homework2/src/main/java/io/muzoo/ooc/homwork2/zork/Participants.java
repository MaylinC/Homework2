package io.muzoo.ooc.homwork2.zork;

public class Participants implements GetProperties {

    private Integer hp;
    private Integer location; // where is the monster
    private Integer attack;
    private Integer defence;
    private boolean sword;
    private Integer numPotions;

    public Participants() {
        hp = 100;
        attack = 15;
        defence = 10;
        this.sword = false;
    }

    @Override
    public Integer getHp() {
        return this.hp;
    }

    @Override
    public Integer getAttack() { return this.attack; }

    @Override
    public Integer getLocation() {
        return this.location;
    }

    @Override
    public Integer getDefence() {
        return this.defence;
    }

    public void setSword() {
        this.sword = true;
        this.attack += 50;
    }

    public void heal() {
        if(numPotions > 0) {
            numPotions--;
            this.hp += 50;
        }
    }


}
