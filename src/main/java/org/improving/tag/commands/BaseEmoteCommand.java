package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//<<<<<<< HEAD
//    public BaseEmoteCommand(String cmdText,String cmdResponse, InputOutput io){
//        this.cmdText = cmdText;
//=======
public abstract class BaseEmoteCommand extends BaseAliaseCommand {
    private InputOutput io;
    //private String cmdText;
    private String cmdResponse;
//    private List<String> aliases = new ArrayList<>();
    //constructor to get value from two strings and io
    public BaseEmoteCommand (String cmdResponse, InputOutput io, String...aliases) {
        super(io, aliases);
        //this.cmdText = cmdText;
        this.cmdResponse = cmdResponse;
        this.io = io;

//        this.aliases.addA
//        ll(Arrays.asList(aliases));
    }
//<<<<<<< HEAD
//@Override
//  public boolean isValid(String input, Game game) {
//        //ternary operation <boolean>?<true>:<false>
//        //javascript: <variable>??<default>=> if variable is null, return default, if not, use variable
//       return (input==null?"":input).trim().equalsIgnoreCase(cmdText);
//    }
//=======


    @Override
    public void execute(String input, Game game) {
        io.displayText(cmdResponse);
    }


}

