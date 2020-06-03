package io.muzoo.ooc.homwork2.zork.command;

import io.muzoo.ooc.homwork2.zork.MapCreation;
import javafx.beans.binding.MapBinding;

public class MapCommand implements Command{

    private MapCreation mapCreation;

    public MapCommand(MapCreation mapCreation) {
        this.mapCreation = mapCreation;
    }

    @Override
    public void execute(String arg) {
        mapCreation.asciiMap();
    }

    @Override
    public String getDescription() {
        return "This command will display the game's map";
    }
}
