package io.muzoo.ooc.homwork2.zork.item;

public class ExcaliburSword extends DeathlyItem {

    public ExcaliburSword() {
        foundItem = false;
        attackDamage = 50;
        name = "Excalibur Sword";
    }

    public ExcaliburSword(Boolean foundItem) {
        this.foundItem = foundItem;
    }
}