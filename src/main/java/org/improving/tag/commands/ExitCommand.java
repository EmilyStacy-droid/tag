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
        super(io, "exit", "e");
        this.io = io;
        this.saveFactory = saveFactory;
    }


    @Override
    public void childExecute(String input, Game game) {
        saveFactory.save(game);
        io.displayText("Goodbye.");
        // Right here you need to do something which will exit the game
        try {throw new RuntimeException();}
        catch(Exception ex)
        {game.getErrorMessage();}
        ;
    }
}
