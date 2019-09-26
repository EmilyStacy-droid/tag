package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;

public abstract class BaseEmoteCommand implements Command {
    private InputOutput io;
    private String cmdText;
    private String cmdResponse;
    //constructor to get value from two strings and io
    public BaseEmoteCommand(String cmdText, String cmdResponse, InputOutput io) {
        this.cmdText = cmdText;
        this.cmdResponse = cmdResponse;
        this.io = io;
    }
    //override two methods from Command
    @Override
    public boolean isValid(String input, Game game) {
       return (input == null?"":input).trim().equalsIgnoreCase(cmdText);
    }

    @Override
    public void execute(String input, Game game) {
        io.displayText(cmdResponse);
    }
}


