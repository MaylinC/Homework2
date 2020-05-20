package io.muzoo.ooc.homwork2.zork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Room {
    String fileName;
    Map<String, String> keepDirection = new HashMap<String, String>();

    public Room(String fileName) {
        this.fileName = fileName;
    }

    private void readFile() throws IOException {

        FileReader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        bufferedReader.readLine();

        String line = null;

        while ((line = bufferedReader.readLine()) != null) {
            String currentRoom = line.split("-")[0];
            System.out.println(currentRoom);
            String neighborRoom = line.split("-")[1];
            String[] separateNeigh = line.split(",");
            for (int inx = 0; inx < separateNeigh.length; inx++) {
                keepDirection.put(currentRoom,separateNeigh[inx]);
                System.out.println(keepDirection);
            }
        }

        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException {
        Room file = new Room("/Users/maylin/Desktop/Map1");
        file.readFile();
    }
}
