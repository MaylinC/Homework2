package io.muzoo.ooc.homwork2.zork.Json;

import io.muzoo.ooc.homwork2.zork.Game;
import io.muzoo.ooc.homwork2.zork.Participants;
import io.muzoo.ooc.homwork2.zork.item.WizardFuryTruffle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.IIOException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class JsonReader {
    private Game game;
    private JSONArray jsonArray;

    public JsonReader(Game game) {
        this.game = game;
    }

    public void reader(String name) { // just open and read file
        String defaultPath = "/Users/maylin/Desktop/ooc/homework2/src/main/resources/";
        String path = defaultPath + name + ".json";
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(path)) { //Read JSON file
            Object obj = jsonParser.parse(reader);
            jsonArray = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void loader(String name) throws IOException { //take object inside and construct with game
        reader(name);
        JSONObject mapInfo = (JSONObject) jsonArray.get(0);
        game.chooseMap((String) mapInfo.get("mapID"));

        JSONObject playerInfo = (JSONObject) jsonArray.get(1);

        Participants participants = new Participants(Math.toIntExact((Long) playerInfo.get("hp")),
                Math.toIntExact((Long) playerInfo.get("attack")),
                Math.toIntExact((Long) playerInfo.get("def")),
                Math.toIntExact((Long) playerInfo.get("MaxHp")),
                game.getBigMap().get((String) playerInfo.get("loc")));
        if ((boolean) playerInfo.get("sword")) {
            game.getPlayer().setFoundSword();
        }
        if ((boolean) playerInfo.get("stone")) {
            game.getPlayer().setFoundStone();
        }
        if ((boolean) playerInfo.get("armor")) {
            game.getPlayer().setFoundArmor();
        }
        if ((boolean) playerInfo.get("knife")) {
            game.getPlayer().getKnife().setFound();
        }

        game.setPlayer(participants);

        JSONObject inventoryInfo = (JSONObject) jsonArray.get(2);

        Integer numMush = Math.toIntExact((Long)inventoryInfo.get("numberOfMush"));

        int num = 0;
        while (num <= numMush) {
            game.getPlayer().getInventory().takeMushroom(new WizardFuryTruffle());
            num++;
        }

        JSONObject monsterInfo = (JSONObject) jsonArray.get(3);
        Set monsterRooms = monsterInfo.keySet();
        for (Object room : monsterRooms) {
            game.getMapCreation().assignMonster((String) monsterInfo.get(room),(String) room);
        }

        JSONObject itemInfo = (JSONObject) jsonArray.get(4);
        Set itemRooms = itemInfo.keySet();
        for (Object itRoom : itemRooms) {
            game.getMapCreation().assignItem((String) itemInfo.get(itRoom), (String) itRoom);
        }
        game.setLoaded();
    }
}


