package io.muzoo.ooc.homwork2.zork.item;

public class Knife {

    private Integer attackDestruction;


    public Knife() {
        attackDestruction = 15;
    }

    public Knife(Integer attackDestruction) {

        this.attackDestruction=attackDestruction;
    }

    public Integer getAttackDestruction() {
        return attackDestruction;
    }

//    public static void main(String[] args) {
//        Sword sword = new Sword();
//        System.out.println(sword.getAttackDestruction());
//
//    }

}
