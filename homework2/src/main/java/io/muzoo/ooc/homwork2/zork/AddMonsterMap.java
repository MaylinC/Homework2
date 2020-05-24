package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.command.InfoCommand;
import io.muzoo.ooc.homwork2.zork.creatures.CannibalTribe;
import io.muzoo.ooc.homwork2.zork.creatures.DrunkBaboon;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;
import io.muzoo.ooc.homwork2.zork.creatures.Skeleton;

import java.rmi.MarshalledObject;
import java.util.*;

public abstract class AddMonsterMap {

    public MapCreation map;
    public SetRoom setRoom;
    public Integer boss;
    public Integer generate;
    String fileName;
    String getFirstLine;
    public Map<String, SetRoom> bigMap = new HashMap<String, SetRoom>();
    public ArrayList<String> lstRoom = new ArrayList<>();


    public String checkMapFile() {
        if (map.getFirstLine.equals("ID:Map1")) {
            return "/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map1";
        }
        else {
            return "/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map2";
        }
    }

    public ArrayList<String> randRoom(Integer number) {
        int num = 0;
        while ( num <= number) {
            Random rand = new Random();
            int indexRand = rand.nextInt(20);
            roomLst.add(lst.get(indexRand));
            return roomLst;
        }
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
