package io.muzoo.ooc.homwork2.zork.creatures;

public class Boss extends Monsters {
    public Boss() {
        name = "Basilisk";
        hp = 600;
        maxHp = 600;
        maxAttack = 65;
        attack = 30;
        defence = 20;
    }

    public Boss(Integer hp, Integer attack, Integer defence) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
    }

    @Override
    public Integer strike() {
        double ProbAttack = Math.random();
        if (ProbAttack <= 0.02) { //2%
            System.out.println("Basilisk attacked you with its ***MAX*** damage");
            return maxAttack;

        } else if (ProbAttack <= 0.42) {  //40%
            System.out.println("Basilisk attacked you with its normal damage attack!!!!");
            return attack;

        } else if (ProbAttack <= 0.48) {  // 6%
            System.out.println("You are luck!!!!!, Basilisk were too tired to attack you but it will gain more defence system");
            defence += 2;
            return 0;

        } else if (ProbAttack <= 0.58) { //10%
            System.out.println("Basilisk attacked your weak point");
            double damageRange = 0.88 + 0.3 * Math.random();
            return Math.toIntExact(Math.round(attack * damageRange));

        } else if (ProbAttack <= 0.61) { //3%
            System.out.println("Basilisk healed itself");
            hp += 5;
            return 0;

        } else if (ProbAttack <= 0.91) { //30%
            System.out.println("Basilisk attacked you multiple times, be careful");
            int num = 0;
            double head = Math.random();
            while (head <= 0.85) {
                num++;
                head = Math.random();
            }
            return num * 8;

        } else {
            System.out.println("Basilisk looked at you and plotted evil plan");
            return 0;
        }
    }
}
