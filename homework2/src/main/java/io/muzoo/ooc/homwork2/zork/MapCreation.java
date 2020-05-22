package io.muzoo.ooc.homwork2.zork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapCreation {

    String fileName;

    Map<String,SetRoom> bigMap = new HashMap<String,SetRoom>();

    public MapCreation(String fileName) {
        this.fileName = fileName;
    }

    private void readMap() throws IOException {

        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        bufferedReader.readLine();

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            String currentRoom = line.split(":")[0];
            System.out.println(currentRoom);
            String roomDescription = line.split(":")[1].split("-")[0];
            String[] separateNeigh = line.split(":")[1].split("-")[1].split(",");
            SetRoom tmp = new SetRoom(roomDescription);
            for(int inx = 0; inx < separateNeigh.length; inx++) {
                if (!separateNeigh[inx].equals("#")) {
                    if (inx == 0) {
                        tmp.setWay("North", separateNeigh[0]);
                    }
                    if (inx == 1) {
                        tmp.setWay("West", separateNeigh[1]);
                    }
                    if (inx == 2) {
                        tmp.setWay("East", separateNeigh[2]);
                    }
                    if (inx == 3) {
                        tmp.setWay("South", separateNeigh[3]);
                    }
                }
            }

            bigMap.put(currentRoom,tmp);
        }

        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException{
        MapCreation file = new MapCreation("/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map1");
        file.readMap();
    }

}

