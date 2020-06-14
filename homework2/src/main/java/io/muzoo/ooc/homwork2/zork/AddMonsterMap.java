package io.muzoo.ooc.homwork2.zork;


import io.muzoo.ooc.homwork2.zork.creatures.*;

import io.muzoo.ooc.homwork2.zork.item.*;

import java.util.*;

public abstract class AddMonsterMap {

    String fileName;
    String getFirstLine;
    public String startRoom;
    public String mapId;
    public Map<String, SetRoom> bigMap = new HashMap<String, SetRoom>();
    public ArrayList<String> lstRoom = new ArrayList<>(); // get list of 20 rooms out
    public ArrayList<String> monsterLocation = new ArrayList<>();
    public ArrayList<String> itemLocation = new ArrayList<>();

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
            int indexRand = rand.nextInt(20);  // not include 20 , 0-19

            if (!randRoomLst.contains(lstRoom.get(indexRand))) {
                randRoomLst.add(lstRoom.get(indexRand));
                num++;
            }
        }
        return randRoomLst;
    }

    public void randMonster() { //random monster into 10 room but not in abyss
        ArrayList<String> tmp = randRoom(11);  // 11 room
        for (int num = 0; num < 11; num++) { //0-10;
            double rand = Math.random();
            if (!tmp.get(num).equals("abyssToHell")) {
                if (rand <= 0.33) {
                    bigMap.get(tmp.get(num)).generateMonster(new Skeleton());
                    bigMap.get(tmp.get(num)).setCheckMonster();
                } else if (rand <= 0.66) {
                    bigMap.get(tmp.get(num)).generateMonster(new DrunkBaboon());
                    bigMap.get(tmp.get(num)).setCheckMonster();
                } else {
                    bigMap.get(tmp.get(num)).generateMonster(new CannibalTribe());
                    bigMap.get(tmp.get(num)).setCheckMonster();
                }
                monsterLocation.add(tmp.get(num));
            }
        }
    }

    public ArrayList<String> getMonsterLocation() {
        return monsterLocation;
    }

    public ArrayList<String> getItemLocation() {return itemLocation; }

    public void assignItem(String item, String location) {
        if (item.equals("Knife Saver")) {
            bigMap.get(location).generateItem(new Knife());
            bigMap.get(location).setCheckItem();
        }
        else {
            bigMap.get(location).generateItem(new WizardFuryTruffle());
            bigMap.get(location).setCheckItem();
        }
        itemLocation.add(location);
    }

    public void assignMonster(String monsters, String location) {

        if (monsters.equals("Cannibal Tribe")) {
            bigMap.get(location).generateMonster(new CannibalTribe());
            bigMap.get(location).setCheckMonster();
        }
        else if (monsters.equals("Drunk Baboon")) {
            bigMap.get(location).generateMonster(new DrunkBaboon());
            bigMap.get(location).setCheckMonster();
        }
        else {
            bigMap.get(location).generateMonster(new Skeleton());
            bigMap.get(location).setCheckMonster();
        }
        monsterLocation.add(location);
    }

    public void randItem() { //random mushroom and knife into 14 room but not ......

        ArrayList<String> tmp = randRoom(14);
        for (int num = 0; num < 14; num++) {
            double rand = Math.random();
            if (!tmp.get(num).equals("abyssToHell") && !tmp.get(num).equals("crazyMazed")
                    && !tmp.get(num).equals("the7Seas") && !tmp.get(num).equals("bloodStream")) {
                if(rand <= 0.75) {
                    bigMap.get(tmp.get(num)).generateItem(new WizardFuryTruffle());
                }
                else {
                    bigMap.get(tmp.get(num)).generateItem(new Knife());
                }
                itemLocation.add(tmp.get(num));
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
        bigMap.get("abyssToHell").setCheckMonster();
    }
}
