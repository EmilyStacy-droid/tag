package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class DemoCommand implements Command {
    private int ingCounts = 0;
    //final here means "cannot be modified"; read-only after the constructor
    private final InputOutput io;

    //build up a constructor; it won't work without a constructor!
    public DemoCommand(InputOutput io) {
        this.io = io;
    }
    @Override
    public boolean isValid(String input, Game game) {
        return input.trim().endsWith("ing");
    }

    @Override
    public void execute(String input, Game game) {
        ingCounts = ingCounts +1;
        io.displayText("We have 'ing'ed " +ingCounts + " times.");
    }
}
