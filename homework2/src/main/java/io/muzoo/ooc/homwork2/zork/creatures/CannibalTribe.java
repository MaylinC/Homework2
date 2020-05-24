package io.muzoo.ooc.homwork2.zork.creatures;

public class CannibalTribe extends Monsters {
    public CannibalTribe() {
        name = "Cannibal Tribe";
        hp = 85;
        maxHp = 85;
        attack = 10;
        defence = 0;
    }

    public CannibalTribe(Integer hp, Integer attack, Integer defence) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
    }

    @Override
    public Integer strike() {
        double ProbAttack = Math.random();
        if (ProbAttack <= 0.5) {
            System.out.println("Cannibal Tribe attacked you with its normal damage attack");
            return attack;
        }
        else {
            System.out.println("Cannibal Tribe drank out your blood, your hp lower by 13 point");
            return 13;
        }
    }
}
