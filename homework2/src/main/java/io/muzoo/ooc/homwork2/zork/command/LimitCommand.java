package io.muzoo.ooc.homwork2.zork.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LimitCommand {
    private Map<String, ArrayList<String>> canBeUsedCommand;

    public LimitCommand() {
        canBeUsedCommand = new HashMap<>();
    }

    public void setCanBeUsedCommand() {
        ArrayList<String> menu = new ArrayList<>();
        ArrayList<String> duringGame = new ArrayList<>();
        ArrayList<String> attack = new ArrayList<>();
        menu.add("help");
        menu.add("play");
        menu.add("load");
        menu.add("quit");
        attack.add("drop");
        attack.add("attack");
        attack.add("eat");
        attack.add("leave");
        attack.add("info");
        attack.add("take");
        duringGame.add("exist");
        duringGame.add("eat");
        duringGame.add("drop");
        duringGame.add("take");
        duringGame.add("map");
        duringGame.add("info");
        duringGame.add("go");
        duringGame.add("save");
        duringGame.add("initiateBattle");
        duringGame.add("help");
        duringGame.add("auto");
        canBeUsedCommand.put("MainMenu", menu);
        canBeUsedCommand.put("Game", duringGame);
        canBeUsedCommand.put("Attack", attack);

    }

    public Map<String, ArrayList<String>> getCanBeUsedCommand() {
        setCanBeUsedCommand();
        return canBeUsedCommand;
    }

}
