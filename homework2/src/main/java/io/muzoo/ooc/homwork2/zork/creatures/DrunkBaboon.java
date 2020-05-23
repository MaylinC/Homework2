package io.muzoo.ooc.homwork2.zork.creatures;

public class DrunkBaboon extends Monsters {
    public DrunkBaboon() {
        hp = 100;
        maxHp = 100;
        attack = 10;
        defence = 5;
    }

    public DrunkBaboon(Integer hp, Integer attack, Integer defence) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
    }

    @Override
    public Integer Strike() {
        double ProbAttack = Math.random();
        if (ProbAttack <= 0.1) {
            System.out.println("Baboon is too drunk to attack you");
            return 0;
        }
        else if (ProbAttack <= 0.21){
            System.out.println("Baboon became buffer because of the alcohol and increase it defence system");
            defence += 3;
            return 0;
        }
        else if (ProbAttack <= 0.71) {
            System.out.println("Baboon was drunk and angry, it attacked you with anger and dizziness");
            double damageRange = 0.80+0.5*Math.random();
            return Math.toIntExact(Math.round(attack*damageRange));
        }
        else {
            System.out.println("Baboon attacked you with its normal damage attack!");
            return attack;
        }
    }
}

