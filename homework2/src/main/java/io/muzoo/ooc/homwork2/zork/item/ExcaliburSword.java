package io.muzoo.ooc.homwork2.zork.item;

public class ExcaliburSword extends DeathlyItem {

    public ExcaliburSword() {
        foundItem = false;
        attackDamage = 50;
    }

    public ExcaliburSword(Boolean foundItem, Integer attackDamage) {
        this.foundItem = foundItem;
        this.attackDamage = attackDamage;
    }
}