package io.muzoo.ooc.homwork2.zork.command;

import java.io.IOException;

public interface Command {

    void execute(String arg) throws IOException;

    String getDescription();


}
