package io.muzoo.ooc.homwork2.zork.item;

public class Knife {

    private Integer attackDestruction = 15;
    private String name = "Knife Saver";

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
