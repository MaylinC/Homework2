package io.muzoo.ooc.homwork2.zork.command;

import java.util.Scanner;

public class Parser {
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() {
        reader = new Scanner(System.in);
    }


    public String getCommand() {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
//        if(commands.isCommand(word1)) {
//            return new Command(word1, word2);
//        }
//        else {
//            return new Command(null, word2);
//        }
        return "......";
    }
}
