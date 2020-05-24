package io.muzoo.ooc.homwork2.zork.command;

import java.util.Scanner;

public class Parser {
    private Scanner reader;// source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() {
        reader = new Scanner(System.in);
    }


    public String getCommand() {
        String inputLine;   // will hold the full input line
        String cmd1 = null;
        String cmd2 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            cmd1 = tokenizer.next();// get first word
            if (tokenizer.hasNext()) {
                cmd2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        return cmd1+"/"+cmd2;
    }
}

