package io.muzoo.ooc.homwork2.zork.creatures;

import io.muzoo.ooc.homwork2.zork.GetProperties;
import sun.nio.cs.ext.IBM037;

public abstract class Monsters {   /// monster and boss

    public Integer hp;
    public Integer location; // where is the monster
    public Integer maxHp;
    public Integer maxAttack;
    public Integer attack;
    public Integer defence;
    public String description;
    public String name;

    public Integer getHp() {
        return this.hp;
    }

    public Integer getLocation() {
        return this.location;
    }

    public Integer getDefence() {
        return this.defence;
    }

    public String getDescription(String name) {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    abstract public Integer strike();

    public void updateHP(Integer alterHP) {
            this.hp = alterHP;
        }
    }
