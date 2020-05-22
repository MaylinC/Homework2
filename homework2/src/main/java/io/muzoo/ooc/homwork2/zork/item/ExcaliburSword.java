package io.muzoo.ooc.homwork2.zork.item;

public class ExcaliburSword {
    private String name;
    private boolean foundSword;
    private Integer attackDamage;

    public ExcaliburSword() {
        foundSword = false;
        name = "Excalibur Sword";
        attackDamage = 50;
    }

    public Integer getAttackDamage() {
        return attackDamage;
    }

    public boolean getBooFound() {
        return foundSword;
    }
}
