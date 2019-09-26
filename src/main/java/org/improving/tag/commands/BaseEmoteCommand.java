package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;

public abstract class BaseEmoteCommand implements Command {
    private InputOutput io;
    private Game game;
    @Override
    public boolean isValid(String input, Game game, InputOutput io) {
       this.game = game;
       this.io = io;
    }

    @Override
    public void execute(String input, Game game, InputOutput io) {

    }
}
