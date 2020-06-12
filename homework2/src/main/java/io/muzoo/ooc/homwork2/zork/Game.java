package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.command.*;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Game {

    private CommandFactory commandFactory;
    private Boolean quit;
    private MapCreation mapCreation;
    private Boolean mapExist;
    private Boolean existGame;
    private Parser parser;
    private String mapId;
    private Integer count;
    private Map<String,SetRoom> map;
    private GetCommand command;
    private LimitCommand limitCommand;
    private Participants player;
    private SetRoom currentRoom;
    private SetRoom previousRoom;
    private Boolean defeatedBoss;


    public Game(CommandFactory commandFactory) {
        parser = new Parser();
        limitCommand = new LimitCommand();
        this.commandFactory = commandFactory;
        this.quit = false;
        this.defeatedBoss = false;
        this.existGame = false;
        this.mapExist = false;
        this.defeatedBoss = false;
        command = new GetCommand();
    }

    public void bossDeathYet() {
        if(player.getLocation().getCheckMonster()) {
            Monsters monster = player.getLocation().getMonsters();
            if(monster.getName().equals("Basilisk")) {
                if (monster.getHp() <= 0) {
                    defeatedBoss = true;
                    player.getLocation().takeOutMonster();
                }
            }
            else {
                if (monster.getHp() <= 0) {
                    player.getLocation().takeOutMonster();
                }
            }
        }
    }

    public void chooseMap(String filePath) throws IOException {
        String path = "/Users/maylin/Desktop/ooc/homework2/src/main/resources/";
        String combine = path + filePath;
        mapCreation = new MapCreation(combine);
        mapCreation.readMap(combine);
        currentRoom = mapCreation.bigMap.get(mapCreation.startRoom);
        mapId = mapCreation.mapId;
        commandFactory.getCommandMap().put("map", new MapCommand(mapCreation));
        mapExist = true;
        map = mapCreation.getMap();
        mapCreation.randMonster();
        mapCreation.randItem();
        mapCreation.setDeathlyHallow();
        mapCreation.setBoss();
    }

    public Map<String, SetRoom> getBigMap() {
        return map;
    }

    public SetRoom getCurrentRoom() {
        return currentRoom;
    }

    public String getCurrentStringRoom() {
        return mapCreation.startRoom;
    }

    public Boolean getMapExist() {
        return mapExist;
    }

    public void existGame() {
        mapExist = false;
    }

    public void quiteGame() {
        quit = true;
    }

    public Boolean getQuit() {
        return quit;
    }

    public SetRoom getPreviousRoom() {
        currentRoom = previousRoom;
        return previousRoom;
    }

    public void setQuit(boolean bol) {
        quit = bol;
    }

    public Boolean getDefeatedBoss() {
        return defeatedBoss;
    }

    public void setPlayer(Participants player) {
        this.player = player;
    }

    public Participants getPlayer() {
        return player;
    }

    public MapCreation getMapCreation() {
        return mapCreation;
    }

    public CommandFactory getCommandFactory(){
        return commandFactory;
    }

    public LimitCommand getLimitCommand(){
        return limitCommand;
    }

    public void printWelcome() {
        System.out.println("Welcome to Zork, enjoy your game !!!");
    }


    public String currentLocationData() {

        StringBuilder data = new StringBuilder();
        data.append("You are in " + player.getLocation().getDescription() + "\n");
        if (player.getLocation().getCheckMonster()) {
            data.append("There is a " + player.getLocation().getMonsters().getName() + " in this current room \n");
            data.append("Type -initiateBattle- to start the battle with this monster \n");
        }
        else {
            data.append("You are lucky! there's no Monster in this current room \n");
        }
        if (player.getLocation().getCheckItem()) {
            data.append(player.getLocation().getItem().getName()).append(" appear in this room \n");
            data.append("Type -take- get the item \n");
        }
        else {
            data.append("Too bad there's not item in this room \n");
        }
        data.append("Available Direction: \n");
        for (String direction: player.getLocation().setDirectionMap.keySet()) {
            if (player.getLocation().getWayInfo(direction) != null) {
                data.append(direction);
                data.append(" ");
            }
        }
        return data.toString();
    }

    public void play() throws IOException {

        printWelcome();

        System.out.println("Which map you want to play?");
        System.out.println("Type the world play and follow with your map > Map1 , Map2");

        while(!quit) {

            command.getCommand(parser,commandFactory, limitCommand.getCanBeUsedCommand(), "MainMenu");

            while (mapExist||defeatedBoss) {

                command.getCommand(parser,commandFactory, limitCommand.getCanBeUsedCommand(), "Game");
                System.out.println(" ");
                System.out.println(currentLocationData());
                bossDeathYet();
                if (player.getHp() <= 0) {
                    System.out.println("You loss and been defeated by Basilisk!!");
                    mapExist = false;
                }
            }
        }
    }
}
