package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.item.ExcaliburSword;
import io.muzoo.ooc.homwork2.zork.item.Inventory;
import io.muzoo.ooc.homwork2.zork.item.Knife;
import io.muzoo.ooc.homwork2.zork.item.ResurrectionStone;

public class Participants implements GetProperties {

    private Integer hp;
    private Integer maxHp;
    private Inventory statScore;
    private Integer currentLocation;
    private Integer attack;
    private Integer defence;
    private Knife knife;
    private Inventory inventory;
    private ResurrectionStone resurrectionStone;
    private ExcaliburSword excaliburSword;

    public Participants() {
        this.hp = 100;
        this.maxHp = 100;
        this.attack = 15;
        this.defence = 10;
        knife = new Knife();
        resurrectionStone = new ResurrectionStone();
        excaliburSword = new ExcaliburSword();
        this.inventory = new Inventory();
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

    public Knife seeWeapon() { return this.knife; }

    public void setFoundStone() {
        boolean boo = resurrectionStone.getBooFound();
        boo = true;
        this.hp = maxHp;
    }

    public void setFoundSword() {
        boolean boo = excaliburSword.getBooFound();
        boo = true;
        this.attack = 50;
    }
}
