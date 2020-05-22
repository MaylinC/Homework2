package io.muzoo.ooc.homwork2.zork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Map {

    String fileName;

    Map<String,SetRoom> bigMap = new HashMap<String, SetRoom>();
    Map<String,SetRoom> keepDirection = new HashMap<String,SetRoom>();

    public Map(String fileName) {
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
            String roomDescription = line.split("-")[1];
            String[] separateNeigh = line.split(",");
            bigMap.put(currentRoom, new SetRoom(roomDescription));
            for (int inx = 0; inx < separateNeigh.length; inx++) {
                if (inx == 0)
                    keepDirection.put(currentRoom, separateNeigh[inx]);
                System.out.println(keepDirection);
            }

            bufferedReader.close();
        }
    }

    public static void main(String[] args) throws IOException{
        Map file = new Map("/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map1");
        file.readMap();
    }

}

