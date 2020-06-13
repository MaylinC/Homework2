package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.item.*;

public class Participants implements GetProperties {

    private Integer hp;
    private Integer maxHp;
    private Integer attack;
    private Integer defence;
    private Knife knife;
    private SetRoom location;
    private Inventory inventory;
    private ResurrectionStone resurrectionStone;
    private ExcaliburSword excaliburSword;
    private IronBattleArmor armor;

    public Participants() {
        this.hp = 100;
        this.maxHp = 100;
        this.attack = 15;
        this.defence = 10;
        knife = new Knife();
        resurrectionStone = new ResurrectionStone();
        excaliburSword = new ExcaliburSword();
        armor = new IronBattleArmor();
        this.inventory = new Inventory();
    }

    public Participants(Integer hp, Integer attack, Integer defence, SetRoom location) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.location = location;
    }

    @Override
    public Integer getHp() {
        return this.hp;
    }

    @Override
    public Integer getMaxHp() {
        return this.maxHp;
    }

    @Override
    public Integer getAttack() {
        return this.attack;
    }

    @Override
    public Integer getDefence() {
        return this.defence;
    }

    public Knife getKnife() {
        return knife;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ResurrectionStone getStone() {
        return resurrectionStone;
    }

    public ExcaliburSword getExcaliburSword() {
        return excaliburSword;
    }

    public IronBattleArmor getArmor(){
        return armor;
    }

    public void setFoundStone() {
        resurrectionStone.setFound();
        System.out.println("Now you have found one of the third object -Resurrection Stone- you will gain extra more HP when you meet the boss");
    }

    public void setFoundSword() {
        excaliburSword.setFound();
        System.out.println("Now you have found the most powerful sword -Sword of Excalibur- you can use this to defeat the boss, during battle zone with boss");
    }

    public void setFoundArmor() {
        armor.setFound();
        System.out.println("You have found the strongest Armor suit in the realm -IronBattleArmor-, your defence will increase automatically when you meet the boss");
    }

    public void updateHP (Integer alterHP) {
        if (hp < maxHp) {
            this.hp = alterHP;
        }
        else {
            this.maxHp = alterHP;
            this.hp = alterHP;
        }
    }

    public void updateAttack (Integer alterAttack) {
        this.attack = alterAttack;
    }

    public void updateDefence (Integer alterDefence) {this.defence = alterDefence; }

    public SetRoom getLocation() {
        return location;
    }

    public void updateLocation(SetRoom location) {
        this.location = location;
    }

}