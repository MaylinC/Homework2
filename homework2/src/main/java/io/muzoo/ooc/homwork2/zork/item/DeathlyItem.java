package io.muzoo.ooc.homwork2.zork.item;

public abstract class DeathlyItem {

    public boolean foundItem;
    public Integer attackDamage;
    public Integer gainDefence;
    public Integer gainHp;
    public String name;

    public Integer getAttackDamage() {
        return attackDamage;
    }

    public Boolean getFound() {
        return foundItem;
    }

    public void setFound() {
        this.foundItem = true;
    }

    public Integer getGainDefence() {
        return gainDefence;
    }

    public String getName() { return name; }

    public Integer  getGainHp() {
        return gainHp;
    }
}
