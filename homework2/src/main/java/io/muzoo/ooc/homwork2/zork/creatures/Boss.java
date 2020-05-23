package io.muzoo.ooc.homwork2.zork.creatures;

public class Boss extends Monsters {
    public Boss() {
        hp = 500;
        maxHp = 500;
        maxAttack = 65;
        attack = 40;
        defence = 30;
    }

    @Override
    public Integer Strike() {
        double ProbAttack = Math.random();
        if (ProbAttack <= 0.02) {
            System.out.println("Basilisk attacked you with its ***MAX*** damage");
            return maxAttack;
        }
        else if (ProbAttack <= 0.42){
            System.out.println("Basilisk attacked you with its normal damage attack!!!!");
            return attack;
        }
        else if ()

    }
}
