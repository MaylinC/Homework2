package io.muzoo.ooc.homwork2.zork.item;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<WizardFuryTruffle> bag;
    private Integer countMushroom;
    private WizardFuryTruffle mushroom;


    public Inventory() {
        bag = new ArrayList<>();
        countMushroom = 0;
    }

    public Inventory(ArrayList<WizardFuryTruffle> bag){
        this.bag = bag;
    }

    public void displayInventory (ArrayList<WizardFuryTruffle> bag) {
        for (WizardFuryTruffle item : bag) {
            System.out.println(item);
        }
    }

    public void addMushroom(WizardFuryTruffle mushroom) {
        countMushroom += 1;
        bag.add(mushroom);
        System.out.println("You have added a healing mushroom in your bag");
    }

    public void dropMushroom() {
        boolean emp = bag.isEmpty();
        if (!emp){
            bag.remove(bag.size()-1);
            countMushroom -= 1;
        }
        else {
            System.out.println("Your bag is empty, mushroom can't be remove!! (Get more Mushrooms)");
        }
    }

    public Integer getCountMushroom(){
        return countMushroom;
    }

    public Integer getMushroom(){

        mushroom = new WizardFuryTruffle();
        boolean emp = bag.isEmpty();
        if (!emp){
            bag.get(bag.size()-1);
            countMushroom -= 1;



        }
        else {

        }
    }




}
