package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;

import java.sql.PseudoColumnUsage;

public class AttackCommand implements Command{

    private Participants participants;
    private Monsters monster;
    private String description;

    public AttackCommand(Participants participants, Monsters monster) {
        this.participants = participants;
        this.monster = monster;
    }

    public Integer damageDealt() {
        return participants.getAttack();
    }

    @Override
    public void execute(String arg) {
        if (monster.getName().equals("Basilisk")) {
            if (participants.getStone().getFound()) {
                Integer maxHPStone = participants.getStone().getGainHp();
                participants.updateHP(maxHPStone);
                System.out.println("Your Resurrection Stone is now come into effect");
            }

            if (participants.getArmor().getFound()) {
                participants.updateDefence(participants.getAttack() + participants.getArmor().getGainDefence());
                System.out.println("Your Iron Armor is now come into effect ");
            }

            if (participants.getExcaliburSword().getFound()) {
                participants.updateAttack(participants.getAttack() + participants.getExcaliburSword().getAttackDamage());
                System.out.println("Your Excalibur Sword is now come into effect");
            }

            System.out.println("You attacked Basilisk!!!!");
            double defencePercent = Math.toIntExact(Math.round(1 - (double) monster.getDefence() / 100));
            Integer monsterCurrentHp = (monster.getHp() - (damageDealt() * (int) defencePercent));
            monster.updateHP(monsterCurrentHp);
            System.out.println(monster.getName() + "'s current HP: " + monsterCurrentHp);
        }

        else if (monster.getName().equals("Drunk Baboon") || monster.getName().equals("Shallow Skeleton")) {
            if (participants.getKnife().getFound()) {
                participants.updateAttack(participants.getAttack() + participants.getKnife().getAttackDamage());
            }

            System.out.println("You attacked a " + monster.getName());
            double defencePercent = Math.toIntExact(Math.round(1 - (double) monster.getDefence() / 100));
            Integer monsterCurrentHp = (monster.getHp() - (damageDealt() * (int) defencePercent));
            monster.updateHP(monsterCurrentHp);
            System.out.println(monster.getName() + "'s current HP: " + monsterCurrentHp);
            participants.updateAttack(participants.getAttack() - participants.getKnife().getAttackDamage());
        }

        else {
            if (participants.getKnife().getFound()) {
                participants.updateAttack(participants.getAttack() + participants.getKnife().getAttackDamage());
            }
            System.out.println("You attacked a " + monster.getName());
            Integer monsterCurrentHp = (monster.getHp() - damageDealt());
            monster.updateHP(monsterCurrentHp);
            System.out.println(monster.getName() + "'s current HP: " + monsterCurrentHp);
        }
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
