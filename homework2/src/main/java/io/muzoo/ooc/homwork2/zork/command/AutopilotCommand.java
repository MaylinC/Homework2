package io.muzoo.ooc.homwork2.zork.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AutopilotCommand implements Command {
    private CommandFactory commandFactory;

    public AutopilotCommand(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }
    @Override
    public void execute(String arg) throws IOException {
        List<String> scriptLst = new ArrayList<>();
        scriptLst.add("Script1");
        scriptLst.add("Script2");
        if(!scriptLst.contains(arg)) {
            System.out.println("Invalid script name");
        }
        else {
            String path = "/Users/maylin/Desktop/ooc/homework2/src/main/resources/"+arg;
            FileReader fileReader = new FileReader(new File(path));
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while((line = reader.readLine()) != null) {
                String[] stringArray=line.split(" ");
                if(commandFactory.checkContainCommand(stringArray[0])){
                    commandFactory.getCommand(stringArray[0]).execute(stringArray[1]);
                }
            }
        }
    }

    @Override
    public String getDescription() {
        return "Use this command for auto play the game";
    }
}
