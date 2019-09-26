package org.improving.tag.commands;

import org.improving.tag.FileSystemAdapter;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class LoadFileCommand implements Command {
    private InputOutput io;
    private SaveGameFactory saveFactory;
    private FileSystemAdapter fsa;


    public LoadFileCommand(InputOutput io, SaveGameFactory saveFactory){
        this.io = io;
        this.saveFactory = saveFactory;
    }


    @Override
    public boolean isValid(String input, Game game) {
        if(input == null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if(parts.length == 2) {
            return parts[0].equalsIgnoreCase("load");
        }
        return false;
    }

    @Override
    public void execute(String input, Game game) {
        //load + path <- type the path
        var name = input.split(" ")[1].trim();
        saveFactory.load(name, game);
        io.displayText( "Your game is loaded. You are now at " + game.getPlayer().getLocation().getName());
    }
}
