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
                participants.updateAttack(participants.getMaxHp());
                participants.updateAttack(participants.getAttack() + participants.getStone().getGainHp());
            }

            if (participants.getArmor().getFound()) {
                participants.updateAttack(participants.getAttack() + participants.getArmor().getGainDefence());
            }

            if (participants.getExcaliburSword().getFound()) {
                participants.updateAttack(participants.getAttack() + participants.getExcaliburSword().getAttackDamage());
            }

            System.out.println("You attacked Basilisk!!!!");
            double defencePercent = (1 - (double) monster.getDefence() / 100);
            Integer monsterCurrentHp = (monster.getHp() - (damageDealt() * (int) defencePercent));
            System.out.println(monster.getName() + "'s current HP: " + monsterCurrentHp);
            monster.updateHP(monsterCurrentHp);
        }

        else if (monster.getName().equals("Drunk Baboon") || monster.getName().equals("Shallow Skeleton")) {
            if (participants.getKnife().getFound()) {
                participants.updateAttack(participants.getAttack() + participants.getKnife().getAttackDamage());
            }

            System.out.println("You attacked a " + monster.getName());
            double defencePercent = (1 - (double) monster.getDefence() / 100);
            Integer monsterCurrentHp = (monster.getHp() - (damageDealt() * (int) defencePercent));
            System.out.println(monster.getName() + "'s current HP: " + monsterCurrentHp);
            monster.updateHP(monsterCurrentHp);
            participants.updateAttack(participants.getAttack() - participants.getKnife().getAttackDamage());
        }

        else {
            if (participants.getKnife().getFound()) {
                participants.updateAttack(participants.getAttack() + participants.getKnife().getAttackDamage());
            }

            System.out.println("You attacked a " + monster.getName());
            Integer monsterCurrentHp = (monster.getHp() - damageDealt());
            System.out.println(monster.getName() + "'s current HP: " + monsterCurrentHp);
            monster.updateHP(monsterCurrentHp);
        }
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
