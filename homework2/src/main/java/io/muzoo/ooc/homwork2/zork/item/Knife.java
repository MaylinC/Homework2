package io.muzoo.ooc.homwork2.zork.item;

public class Knife extends DeathlyItem {

    public Knife() {
        attackDamage = 5;
        name = "Knife Saver";
    }

    public Knife(Integer attackDestruction) {
        this.attackDamage = attackDestruction;
    }

}
