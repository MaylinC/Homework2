package io.muzoo.ooc.homwork2.zork.item;

public class Knife {

    private Integer attackDestruction;
    private String name;

    public Knife() {
        attackDestruction = 5;
        name = "Knife Saver";
    }

    public String getName() {
        return name;
    }

    public Knife(Integer attackDestruction) {
        this.attackDestruction=attackDestruction;
    }

    public Integer getAttackDestruction() {
        return attackDestruction;
    }
}
