package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseEmoteCommand extends BaseAliaseCommand {
    private InputOutput io;
    private String cmdText;
    private String cmdResponse;
    private String aliases;
//    private List<String> aliases = new ArrayList<>();
    //constructor to get value from two strings and io
    public BaseEmoteCommand (String cmdText, String cmdResponse, InputOutput io) {
        super(...aliases);
        this.cmdText = cmdText;
        this.cmdResponse = cmdResponse;
          this.io = io;

//        this.aliases.addA
//        ll(Arrays.asList(aliases));
    }


    @Override
    public void execute(String input, Game game) {
        io.displayText(cmdResponse);
    }


}
