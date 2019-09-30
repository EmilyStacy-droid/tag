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

    @Override
    public String getCommandPart(String input) {
        var parts = input.split(" ");
        //if(parts.length ==1) return false;
        return parts[0];
    }

    public void childExecute(String input, Game game) {
        game.setLoop(false);
        saveFactory.save(game);
        io.displayText("Goodbye.");


    };


}
