package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class BaseAliaseCommand implements Command {
    private List<String> aliases = new ArrayList<>();
    private final InputOutput io;

    public BaseAliaseCommand(InputOutput io, String...aliases){
        this.io = io;
        this.aliases.addAll(Arrays.asList(aliases));
    }

    @Override
    public boolean isValid(String input, Game game) {

        var trimmedInput = getCommandPart(input).trim();
        return aliases.stream().anyMatch(trimmedInput::equalsIgnoreCase);//for each loop works too
    }
    public void childExecute(String input, Game game) { };

    public String getErrorMessage() {
        return "Huh? I don't understand";
    }
    @Override
    public void execute(String input, Game game) {
        try {
            childExecute(input, game);
        }catch(Exception ex) {
            io.displayText(getErrorMessage());
        }
    }
//execute is not needed because it is an abstract class
//do some change for move=> get a pure return first
public String getCommandPart(String input){
    return input;
}
}



