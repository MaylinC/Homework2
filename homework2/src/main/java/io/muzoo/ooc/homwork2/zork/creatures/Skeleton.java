package io.muzoo.ooc.homwork2.zork.creatures;

public class Skeleton extends Monsters {

    public Skeleton() {
        hp = 40;
        maxHp = 40;
        attack = 15;
        defence = 2;
    }

    public Skeleton(Integer hp, Integer attack, Integer defence) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
    }

    @Override
    public Integer Strike() {
        double ProbAttack = Math.random(); //0-1;
        if (ProbAttack <= 0.03) {
            System.out.println("Skeletons resurrected itself, recovered and have all full HP");
            hp = maxHp;
            return 0;
        } else if (ProbAttack <= 0.53) {
            System.out.println("Skeletons attacked you with its normal damage attack!!");
            return attack;

        } else {
            System.out.println("Skeletons attacked your weak point");
            double damageRange = 0.75+0.35*Math.random(); // damage range strike stronger or lower
            return Math.toIntExact(Math.round(attack*damageRange));
        }

    }
}
