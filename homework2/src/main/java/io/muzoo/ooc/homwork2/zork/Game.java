package io.muzoo.ooc.homwork2.zork;

import io.muzoo.ooc.homwork2.zork.command.CommandFactory;
import io.muzoo.ooc.homwork2.zork.command.GetCommand;
import io.muzoo.ooc.homwork2.zork.command.Parser;
import io.muzoo.ooc.homwork2.zork.creatures.Monsters;

import java.io.IOException;


public class Game {

    private CommandFactory commandFactory;
    private MapCreation map;
    private Monsters monsters;
    private Boolean quit;
    private Boolean existGame;
    private Parser parser;
    private GetCommand command;
    private Boolean bossDestroyed;
    private Participants player;
    private SetRoom currentRoom;

    public void Game(CommandFactory commandFactory) {
        parser = new Parser();
        this.commandFactory = commandFactory;
        this.quit = false;
        this.existGame = false;
        this.bossDestroyed = false;
        command = new GetCommand();
    }

    public void printWelcome() {
        System.out.println("Welcome to Zork, enjoy your game !!!");
    }

    public String currentLocationData() {

        StringBuilder data = new StringBuilder();
        data.append("You are in " + player.getLocation().getDescription());
        if (player.getLocation().getCheckMonster()) {
            data.append("There is a " + player.getLocation().getMonsters().getName() + "in this current room");
        }
        else {
            data.append("You are lucky! there's no Monster in this current room");
        }
        if (player.getLocation().getCheckItem()) {
            data.append(player.getLocation().getItem().getName() + "appear in this room");
        }
        else {
            data.append("Too bad there's not item in this room");
        }

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

        while(!existGame) {

            map.readMap("/Users/maylin/Desktop/ooc/homework2/src/main/resources/Map1");
            command.getCommand(parser,commandFactory);
            commandFactory.allCommand(player, monsters);

            // quit – end the current game and return to command prompt to let user choose the map or load from saved point again.

            while (quit) {

                currentRoom = map.bigMap.get(map.startRoom);
                player.updateLocation(currentRoom);
                map.randMonster();
                map.randItem();
                map.setDeathlyHallow();
                map.setBoss();
                currentLocationData();

                command.getCommand(parser,commandFactory);
                commandFactory.allCommand(player, monsters);

                if (player.getHp() <= 0) {
                    System.out.println("You loss and been defeated by Basilisk!!");
                    quit = false;
                }

                if (monsters.getName().equals("Basilisk")) {
                    if(monsters.getHp() <= 0) {
                        System.out.println("You win, Basilisk has been defeated");
                    }

                }
            }
        }

        System.out.println("Thank you for playing. Good bye.");

    }
}
