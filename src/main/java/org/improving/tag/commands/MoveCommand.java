package org.improving.tag.commands;

import org.improving.tag.Exit;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class MoveCommand extends BaseAliaseCommand {
    private InputOutput io;

    public MoveCommand(InputOutput io) {
        super(io,"move","m","mov");
        this.io = io;
    }

    @Override
    public String getCommandPart(String input) {
        var parts = input.split(" ");
        //if(parts.length ==1) return false;
        return parts[0];
    }


@Override
public String getErrorMessage() {
    return "The route is unavailable";
}
    @Override
    public void childExecute(String input, Game game) {
        input = input.trim();
        var parts = input.split(" ");
        var destination = input.substring(input.indexOf(" ") +1);//another way with substring
//        var parameters = new ArrayList<String>(Arrays.asList(parts)); //take array as a list
//        parameters.remove(0);
//        var destination = String.join(" ", parameters) ;
        Exit exit = null;
        for(var e: game.getPlayer().getLocation().getExits()){
            if(e.getName().equalsIgnoreCase(destination)){
                exit = e;
            }else if(game.getPlayer().getLocation().getAdversary() != null){
                io.displayText("You shall not pass");
                return;
            }
            else{
                for (var a : e.getAliases()){
                    if(a.equalsIgnoreCase(destination)){
                       exit = e; //out of inner loop
                        break;
                    }
                }
            }
            //out of outer loop
            if (exit != null) break;
        }
        if (exit == null) throw new UnsupportedOperationException();
        game.getPlayer().setLocation(exit.getDestination());
        io.displayText("You travel " + exit.getName() + ".");
    }
}
