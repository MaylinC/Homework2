package io.muzoo.ooc.homwork2.zork.item;

public class ExcaliburSword {

    private boolean foundSword;
    private Integer attackDamage;

    public ExcaliburSword() {

        foundSword = false;
        attackDamage = 50;
    }

    public ExcaliburSword(boolean foundSword) {
        this.foundSword = foundSword;
    }

    public Integer getAttackDamage() {
        return attackDamage;
    }

    public boolean getBooFound() {
        return foundSword;
    }

    public void setFoundSword() {
        this.foundSword = true;
    }
}
