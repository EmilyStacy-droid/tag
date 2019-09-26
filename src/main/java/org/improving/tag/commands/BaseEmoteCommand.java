package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseEmoteCommand implements Command {
    private InputOutput io;
    private String cmdText;
    private String cmdResponse;
    private List<String> aliases = new ArrayList<>();
    //constructor to get value from two strings and io
    public BaseEmoteCommand (String cmdText, String cmdResponse, InputOutput io,String...aliases) {
        this.cmdText = cmdText;
        this.cmdResponse = cmdResponse;
        this.io = io;
        this.aliases.addAll(Arrays.asList(aliases));
    }

    //override two methods from Command
    @Override
    public boolean isValid(String input, Game game) {
        if(input == null) {
            return false;
        }
        var trimmedInput = input.trim();
        return aliases.stream().anyMatch(trimmedInput::equalsIgnoreCase);
    }

    @Override
    public void execute(String input, Game game) {
        io.displayText(cmdResponse);
    }


}
