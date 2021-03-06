package io.muzoo.ooc.homwork2.zork.item;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<WizardFuryTruffle> bag;
    private Integer countMushroom;

    public Inventory() {
        bag = new ArrayList<>();
        countMushroom = 0;
    }

    public Inventory(ArrayList<WizardFuryTruffle> bag) {
        this.bag = bag;
    }

    public String displayInventory() {
        return "Wizard's Fury Truffle in your bag = " + countMushroom.toString();
    }

    public void takeMushroom(WizardFuryTruffle mushroom) {
        countMushroom += 1;
        bag.add(mushroom);
    }

    public void dropMushroom() {
        boolean emp = bag.isEmpty();
        if (!emp) {
            bag.remove(bag.size() - 1);
            countMushroom -= 1;
            System.out.println("You have dropped your healing mushroom");
        } else {
            System.out.println("Your bag is empty, mushroom can't be remove!! (Get more Mushrooms)");
        }
    }

    public Integer getCountMushroom() {
        return countMushroom;
    }

    public Integer getMushroom() {
        boolean emp = bag.isEmpty();
        if (!emp) {
            DeathlyItem mushroom = bag.get(bag.size() - 1);
            countMushroom -= 1;
            bag.remove(bag.size() - 1);
            System.out.println("Your HP is increase by 5");
            return mushroom.getGainHp();

        } else {
            System.out.println("Your bag is empty, can't get mushroom !! (Get more Mushrooms)");
            return 0;
        }
    }
}

