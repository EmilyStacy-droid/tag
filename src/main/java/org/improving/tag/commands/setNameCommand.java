package org.improving.tag.commands;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.Player;
import org.springframework.stereotype.Component;

@Component
public class setNameCommand implements Command {
    private InputOutput io;
    public setNameCommand(InputOutput io) {
        this.io = io;
    }
    @Override
    public boolean isValid(String input, Game game) {
        if(input == null) return false;
        var parts = input.split("=");
        input = input.trim();
        if(input.contains("=")) {
            //parts = input.split("=");
            return parts[0].equalsIgnoreCase("@set name");
        }if(parts.length ==1){
            return false;
        } else if(input.contains("=") == false) {
            return false;
        }

        return false;
    }

    @Override
    public void execute(String input, Game game) {
            //input = input.trim();
            var name = input.split("=")[1].trim();
            game.getPlayer().setName(name);
            io.displayText("Your name is now " + name + ".");

    }


}

