package io.muzoo.ooc.homwork2.zork.item;

public class Knife extends DeathlyItem {

    public Knife() {
        foundItem = false;
        attackDamage = 5;
        name = "Knife Saver";
    }

    public Knife(Integer attackDestruction, Boolean foundItem) {
        this.attackDamage = attackDestruction;
        this.foundItem = foundItem;
    }
}
