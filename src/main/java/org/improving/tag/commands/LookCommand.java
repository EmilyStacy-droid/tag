package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component //telling Spring this is the object that I want to register with SpringContext
public class LookCommand extends BaseAliaseCommand {
    private InputOutput io;

    public LookCommand(InputOutput io) {
        super(io,"l", "look","whereami","where am I","?donde estoy?");
        this.io = io;
        //super("look", "You look around.", io);
    }

    @Override
    public void execute(String input, Game game) {
        var location = game.getPlayer().getLocation();
        io.displayText(location.getName());
        io.displayText(location.getDescription());
        io.displayText("");
        io.displayText("Exit:");

        for(var exit: location.getExits()){
            io.displayText("  "+ exit.getName());
        }
    }
}
