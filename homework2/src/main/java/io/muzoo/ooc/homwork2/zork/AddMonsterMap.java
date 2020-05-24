package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.command.InfoCommand;
import io.muzoo.ooc.homwork2.zork.creatures.CannibalTribe;
import io.muzoo.ooc.homwork2.zork.creatures.DrunkBaboon;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;
import io.muzoo.ooc.homwork2.zork.creatures.Skeleton;

import java.rmi.MarshalledObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class AddMonsterMap {
    private MapCreation map;
    private SetRoom setRoom;
    private Integer boss;
    private Integer generate;
    private ArrayList<String> roomLst;


    public String checkMapFile() {
        if (map.getFirstLine.equals("ID:Map1")) {
            return "/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map1";
        }
        else {
            return "/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map2";
        }
    }

    public AddMonsterMap(MapCreation map, SetRoom setRoom) {
        map = new MapCreation(checkMapFile());
        this.setRoom = setRoom;
        ArrayList<String> lstRm = map.lstRoom;
    }

    public ArrayList<String> randRoom(ArrayList<String> lst) {

        Random rand = new Random();
        int indexRand = rand.nextInt(20);
        roomLst.add(lst.get(indexRand));
        return roomLst;
    }

    public void randMonster(ArrayList) {
        int num = 0;
        while() {
        double rand = Math.random();
        if(rand <= 0.33) {
            map.bigMap.get()
            setRoom.generateMonster(new Skeleton());
            setRoom.
        }
        if(rand <= 0.66) {
            setRoom.generateMonster(new DrunkBaboon());
        }
        else {
            setRoom.generateMonster(new CannibalTribe());
        }
        num++;
    }





}
