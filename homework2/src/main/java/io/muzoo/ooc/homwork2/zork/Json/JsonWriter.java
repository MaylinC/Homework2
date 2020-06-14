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

        JSONObject playerInfo = new JSONObject();
        playerInfo.put("hp", game.getPlayer().getHp());
        playerInfo.put("attack", game.getPlayer().getAttack());
        playerInfo.put("def", game.getPlayer().getDefence());
        playerInfo.put("sword", game.getPlayer().getExcaliburSword().getFound());
        playerInfo.put("stone", game.getPlayer().getStone().getFound());
        playerInfo.put("armor", game.getPlayer().getArmor().getFound());
        playerInfo.put("knife", game.getPlayer().getKnife().getFound());
        playerInfo.put("loc", game.getCurrentRoom());
        playerInfo.put("MaxHp", game.getPlayer().getMaxHp());


        JSONObject inventory = new JSONObject();
        inventory.put("numberOfMush", game.getPlayer().getInventory().getCountMushroom());


        JSONObject monsterLocation = new JSONObject();
        for (String room : game.getMapCreation().getMonsterLocation()) {
            if(game.getBigMap().get(room).getMonsters()!=null) {
                monsterLocation.put(room, game.getBigMap().get(room).getMonsters().getName());
            }
        }

        JSONObject itemLocation = new JSONObject();
        for (String room : game.getMapCreation().getItemLocation()) {
            if(game.getBigMap().get(room).getItem()!=null) {
                itemLocation.put(room, game.getBigMap().get(room).getItem().getName());
            }
        }

        JSONArray main = new JSONArray();
        main.add(mapID);
        main.add(playerInfo);
        main.add(inventory);
        main.add(monsterLocation);
        main.add(itemLocation);

        try (FileWriter file = new FileWriter("../homework2/src/main/resources/" + name + ".json")) {
            file.write(main.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}