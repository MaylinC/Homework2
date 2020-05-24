package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.command.InfoCommand;
import io.muzoo.ooc.homwork2.zork.creatures.CannibalTribe;
import io.muzoo.ooc.homwork2.zork.creatures.DrunkBaboon;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;
import io.muzoo.ooc.homwork2.zork.creatures.Skeleton;

import java.rmi.MarshalledObject;
import java.util.*;

public abstract class AddMonsterMap {

    public Integer boss;
    public Integer generate;
    String fileName;
    String getFirstLine;
    public Map<String, SetRoom> bigMap = new HashMap<String, SetRoom>();
    public ArrayList<String> lstRoom = new ArrayList<>();


    public String checkMapFile() {
        if (getFirstLine.equals("ID:Map1")) {
            return "/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map1";
        }
        else {
            return "/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map2";
        }
    }

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

    public void randMonster(Integer numOfMonsters) {
        double rand = Math.random();
        ArrayList<String> rmLst = randRoom(numOfMonsters);
        for (int num = 0; num <= numOfMonsters; num++)
            if(rand <= 0.33) {
                bigMap.get(rmLst.get(num)).generateMonster(new Skeleton());
            }
            else if(rand <= 0.66) {
                bigMap.get(rmLst.get(num)).generateMonster(new DrunkBaboon());
            }
            else {
                bigMap.get(rmLst.get(num)).generateMonster(new CannibalTribe());
            }
    }

    public void randItem(Integer numOfItems) {
        double rand = Math.random();
        ArrayList<String> rmLst = randRoom(numOfItems);
        for (int num = 0; num <= numOfItems; num++) {
            if(rand <= 0.33)  {
                bigMap.get(rmLst.get(num)).generateItem();
            }
            else if (rand <= 0.66) {
                bigMap.
            }
            else {

            }
        }
    }











}
