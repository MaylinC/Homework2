package io.muzoo.ooc.homwork2.zork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class MapCreation extends AddMonsterMap {

    private String cornerRoom;

    public MapCreation(String fileName) {
        this.fileName = fileName;
    }

    public void readMap(String fileName) throws IOException {

        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        getFirstLine = bufferedReader.readLine();
        System.out.println(getFirstLine);

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {

            int count = 0;
            String currentRoom = line.split(":")[0];
            lstRoom.add(currentRoom); // put every room into the list

            if (currentRoom.equals("startRoom")) { // keep the start room to use later
                String start = line.split(":")[1].split("-")[0];
                startRoom = start;
            } else {
                String roomDescription = line.split(":")[1].split("-")[0];
                String[] separateNeigh = line.split(":")[1].split("-")[1].split(",");
                SetRoom tmp = new SetRoom(roomDescription);
                for (int inx = 0; inx < separateNeigh.length; inx++) {
                    if (separateNeigh[inx].equals("#")) {
                        count += 1;
                        if (count == 2) {
                            cornerRoom = currentRoom;
                        }
                    }
                    if (!separateNeigh[inx].equals("#") && !separateNeigh[inx].equals("*")) {
                        count = 0;
                        if (inx == 0) {
                            tmp.setWay("north", separateNeigh[0]);
                        }
                        if (inx == 1) {
                            tmp.setWay("west", separateNeigh[1]);
                        }
                        if (inx == 2) {
                            tmp.setWay("east", separateNeigh[2]);
                        }
                        if (inx == 3) {
                            tmp.setWay("south", separateNeigh[3]);
                        }
                    }
                }
                bigMap.put(currentRoom, tmp);
            }
        }
        bufferedReader.close();
    }

    public Map<String, SetRoom> getMap() {
        return bigMap;
    }

    public String getStartRoom() {
        return startRoom;
    }

    public String getMapID() {
        String idMap = getFirstLine.split(":")[1];
        return mapId = idMap;
    }

    public void asciiMap() {

        String nextEastRoom;
        String leftConnerRoom;
        String topConnerRoom = cornerRoom;

        for (int row = 0; row < 5; row++) {
            String line = topConnerRoom + "  ";
            leftConnerRoom = bigMap.get(cornerRoom).getNeighbor("south");
            for (int col = 0; col <= 4; col++) {
                nextEastRoom = bigMap.get(cornerRoom).getNeighbor("east");
                if (nextEastRoom != null) {
                    cornerRoom = nextEastRoom;
                    line += " || " + cornerRoom;
                }
            }
            if (leftConnerRoom != null) {
                topConnerRoom = leftConnerRoom;
                cornerRoom = leftConnerRoom;
                line += "  ";
            }

            line += " || ";
            System.out.println(line);
        }
    }

//    public static void main(String[] args) throws IOException{
//        MapCreation file = new MapCreation("/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map1");
//        file.readMap("/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map1");
////        file.asciiMap();
//
//    }
}

