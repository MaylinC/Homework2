package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.item.WizardFuryTruffle;

public class TakeCommand implements Command {

    private Participants player;
    private WizardFuryTruffle mushroom;

    TakeCommand(Participants player) {
        this.player = player;
    }

    @Override
    public void execute(String cmd2) {
        if (player.getLocation().getCheckItem()) {
            if (player.getLocation().getItem().getName().equals("Excalibur Sword")) {
                player.setFoundSword();
                player.getLocation().takeOutItem();
            }

            else if (player.getLocation().getItem().getName().equals("IronBattle Armor")) {
                player.setFoundArmor();
                player.getLocation().takeOutItem();
            }

            else if (player.getLocation().getItem().getName().equals("Resurrection Stone")) {
                player.setFoundStone();
                player.getLocation().takeOutItem();
            }
            else if(player.getLocation().getItem().getName().equals("Wizard's Fury Truffle")) {
                player.getInventory().takeMushroom((WizardFuryTruffle) player.getLocation().getItem());
                player.getLocation().takeOutItem();
            }
            else {
                player.getLocation().getItem().setFound();
                player.getLocation().takeOutItem();
            }
        }
        else  {
            System.out.println("There is not item in this room");
        }
    }

    @Override
    public String getDescription() {
        return "Use take command to pick up an item in the room";
    }
}
