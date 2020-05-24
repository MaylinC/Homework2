package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.item.*;

public class Participants implements GetProperties {

    private Integer hp;
    private Integer maxHp;
    private Integer currentLocation;
    private Integer attack;
    private Integer defence;
    private Knife knife;
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

    public Participants(Integer hp, Integer attack, Integer defence) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
    }

    @Override
    public Integer getHp() {
        return this.hp;
    }

    @Override
    public Integer getMaxHp() { return this.maxHp; }

    @Override
    public Integer getAttack() { return this.attack; }

    @Override
    public Integer getLocation() { return this.currentLocation; }

    @Override
    public Integer getDefence() {
        return this.defence;
    }

    public Integer getKnife() { return knife.getAttackDestruction(); }

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
        resurrectionStone.setFoundStone();
        System.out.println("Now you have found one of the third object -Resurrection Stone- you have gain extra more HP");
        this.hp += resurrectionStone.getGainHp();
    }

    public void setFoundSword() {
        excaliburSword.setFoundSword();
        System.out.println("Now you have found the most powerful sword -Sword of Excalibur- you can use this to defeat the boss");
        this.attack += excaliburSword.getAttackDamage();
    }

    public void setFoundArmor() {
        armor.setFoundArmor();
        System.out.println("You have found the strongest Armor suit in the realm -IronBattleArmor-, your defence have increase");
        this.defence += armor.getGainDefence() ;
    }

    public void updateHP (Integer alterHP) {
        this.hp = alterHP;
    }

}
