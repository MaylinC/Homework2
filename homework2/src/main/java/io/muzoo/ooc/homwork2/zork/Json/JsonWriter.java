package io.muzoo.ooc.homwork2.zork.Json;

import io.muzoo.ooc.homwork2.zork.Game;
import io.muzoo.ooc.homwork2.zork.SetRoom;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    public Game game;

    public JsonWriter(Game game) {
        this.game = game;
    }

    public void writer(String name) {

        JSONObject mapID = new JSONObject();
        mapID.put("mapID", game.getMapCreation().getMapID());

        JSONObject heroInfo = new JSONObject();
        heroInfo.put("hp", game.getPlayer().getHp());
        heroInfo.put("attack", game.getPlayer().getAttack());
        heroInfo.put("def", game.getPlayer().getDefence());
        heroInfo.put("sword", game.getPlayer().getExcaliburSword().getFound());
        heroInfo.put("stone", game.getPlayer().getStone().getFound());
        heroInfo.put("armor", game.getPlayer().getArmor().getFound());
        heroInfo.put("knife", game.getPlayer().getKnife().getFound());
        heroInfo.put("loc", game.getCurrentStringRoom());
        heroInfo.put("MaxHp", game.getPlayer().getMaxHp());

        JSONObject inventory = new JSONObject();
        inventory.put("numberOfMush", game.getPlayer().getInventory().getCountMushroom());

        JSONObject monsterLocation = new JSONObject();
        for (String room : game.getMapCreation().getMonsterLocation()) {
            heroInfo.put(room, game.getCurrentRoom().getMonsters().getName());
        }

        JSONObject itemLocation = new JSONObject();
        for (String room : game.getMapCreation().getItemLocation()) {
            heroInfo.put(room, game.getCurrentRoom().getItem().getName());
        }

        JSONArray main = new JSONArray();
        main.add(mapID);
        main.add(heroInfo);
        main.add(inventory);
        main.add(monsterLocation);
        main.add(itemLocation);

        try (FileWriter file = new FileWriter("/Users/maylin/Desktop/ooc/homework2/src/main/resources/" + name + ".json")) {
            file.write(main.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}