package io.muzoo.ooc.homwork2.zork;


import io.muzoo.ooc.homwork2.zork.creatures.Boss;
import io.muzoo.ooc.homwork2.zork.creatures.CannibalTribe;
import io.muzoo.ooc.homwork2.zork.creatures.DrunkBaboon;

import io.muzoo.ooc.homwork2.zork.creatures.Skeleton;
import io.muzoo.ooc.homwork2.zork.item.*;

import java.util.*;

public abstract class AddMonsterMap {

    String fileName;
    String getFirstLine;
    public String startRoom;
    public Map<String, SetRoom> bigMap = new HashMap<String, SetRoom>();
    public ArrayList<String> lstRoom = new ArrayList<>(); // get list of 20 rooms out

//    public String checkMapFile() {
//        if (getFirstLine.equals("ID:Map1")) {
//            return "/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map1";
//        }
//        else {
//            return "/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map2";
//        }
//    }

    public ArrayList<String> randRoom(Integer numOfRoom) { //random room that we want to put monster in and input as how many room
        int num = 0;
        ArrayList<String> randRoomLst = new ArrayList<>();
        while (num <= numOfRoom) {
            Random rand = new Random();
            int indexRand = rand.nextInt(20);
            if (!randRoomLst.contains(lstRoom.get(indexRand)))
                randRoomLst.add(lstRoom.get(indexRand));
            num++;
        }
        return randRoomLst;
    }

    public void randMonster() { //random monster into 10 room but not in abyss
        double rand = Math.random();
        ArrayList<String> rmLst = randRoom(10);
        for (int num = 0; num <= 10; num++) {
            if (!rmLst.get(num).equals("abyssToHell")) {
                if (rand <= 0.33) {
                    bigMap.get(rmLst.get(num)).generateMonster(new Skeleton());
                    bigMap.get(rmLst.get(num)).setCheckMonster();
                } else if (rand <= 0.66) {
                    bigMap.get(rmLst.get(num)).generateMonster(new DrunkBaboon());
                    bigMap.get(rmLst.get(num)).setCheckMonster();
                } else {
                    bigMap.get(rmLst.get(num)).generateMonster(new CannibalTribe());
                    bigMap.get(rmLst.get(num)).setCheckMonster();
                }
            }
        }
    }

    public void randItem() { //random mushroom and knife into 14 room but not ......
        double rand = Math.random();
        ArrayList<String> rmLst = randRoom(14);
        for (int num = 0; num <= 14; num++) {
            if (!rmLst.get(num).equals("abyssToHell") && !rmLst.get(num).equals("crazyMazed")
                    && !rmLst.get(num).equals("the7Seas") && !rmLst.get(num).equals("bloodStream")) {
                if(rand <= 0.70) {
                    bigMap.get(rmLst.get(num)).generateItem(new WizardFuryTruffle());
                    bigMap.get(rmLst.get(num)).setCheckItem();
                }
                else {
                    bigMap.get(rmLst.get(num)).generateItem(new Knife());
                    bigMap.get(rmLst.get(num)).setCheckItem();
                }
            }
        }
    }

    public void setDeathlyHallow() { // set room for deathly hallow
        bigMap.get("crazyMazed").generateItem(new IronBattleArmor());
        bigMap.get("crazyMazed").setCheckItem();
        bigMap.get("the7Seas").generateItem(new ResurrectionStone());
        bigMap.get("the7Seas").setCheckItem();
        bigMap.get("bloodStream").generateItem(new ExcaliburSword());
        bigMap.get("bloodStream").setCheckItem();
    }

    public void setBoss() {
        bigMap.get("abyssToHell").generateMonster(new Boss());
        bigMap.get("abyssToHell").setCheckItem();
    }
}
