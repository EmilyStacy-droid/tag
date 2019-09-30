package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

@Component

public class ExitCommand extends BaseAliaseCommand {
    private InputOutput io;
    private final SaveGameFactory saveFactory;

    public ExitCommand(InputOutput io, SaveGameFactory saveFactory) {
        super(io,"exit","e");
        this.io = io;
        this.saveFactory =saveFactory;
    }

    public String getExitMessage(InputOutput io, Game game) {
        this.io = io;
        saveFactory.save(game);
        return io.displayText("Goodbye.");
    }
    @Override
    public String getCommandPart(String input) {
        var parts = input.split(" ");
        //if(parts.length ==1) return false;
        return parts[0];
    }
   @Override
    public void childExecute(String input, Game game) {




    };


}
