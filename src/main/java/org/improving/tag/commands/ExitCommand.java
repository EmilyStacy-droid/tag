package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

@Component

public class ExitCommand extends BaseAliaseCommand {
    private InputOutput io;
    private final SaveGameFactory saveFactory; //add final to make sure errors occur when it is not called

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
        throw new RuntimeException();
    }
}
