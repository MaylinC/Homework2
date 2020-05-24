package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Participants;

public class InfoCommand implements Command {

    private Participants participants;

    public InfoCommand(Participants participants) {
        this.participants = participants;
    }
    @Override
    public void execute(String arg) {

        System.out.println("Your current HP: " + participants.getHp());
        System.out.println("Your current Attack Damage: " + participants.getAttack());
        System.out.println("Your current Defence: " + participants.getDefence());
        System.out.println(participants.getInventory().displayInventory());

        System.out.println("Deathly hollows:");
        if (participants.getArmor().getBooFound()) {
            System.out.println("Iron Battle Armor - Founded");
        }
        else {
            System.out.println("Iron Battle Armor - Not Found");
        }
        if (participants.getExcaliburSword().getBooFound()) {
            System.out.println("Excalibur Sword - Founded");
        }
        else {
            System.out.println("Excalibur Sword - Not Found");
        }
        if (participants.getStone().getBooFound()) {
            System.out.println("Resurrection Stone - Founded");
        }
        else {
            System.out.println("Resurrection Stone - Not Found");
        }
    }

    @Override
    public String getDescription() {
        return "Use this info command to get information about player";
    }

}
