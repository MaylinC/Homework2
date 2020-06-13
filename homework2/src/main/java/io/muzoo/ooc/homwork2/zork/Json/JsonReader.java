//package io.muzoo.ooc.homwork2.zork.Json;
//
//import io.muzoo.ooc.homwork2.zork.Game;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import javax.imageio.IIOException;
//import java.io.FileReader;
//import java.io.IOException;
//
//public class JsonReader {
//    private Game game;
//    private JSONArray jsonArray;
//    public JsonReader(Game game){
//        this.game=game;
//    }
//
//    public void reader(String name) {
//        String defaultPath = "/Users/maylin/Desktop/ooc/homework2/src/main/resources/";
//        String path = defaultPath+name+".json";
//        JSONParser jsonParser = new JSONParser();
//        try (FileReader reader = new FileReader(path)) { //Read JSON file
//            Object obj = jsonParser.parse(reader);
//            jsonArray = (JSONArray) obj;
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void loader(String name) {
//        reader(name);
//        JSONObject
//    }
//}
