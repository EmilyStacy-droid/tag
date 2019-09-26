package org.improving.tag;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component
public class SaveGameFactory {
    private final FileSystemAdapter fsa;
    private final InputOutput io;
//constructor
    public SaveGameFactory(FileSystemAdapter fsa, InputOutput io) {
        this.fsa = fsa;
        this.io = io;
    }

    public String save(Game game) {
        var locationName=game.getPlayer().getLocation().getName();
        Map<String, String> saveContents = new HashMap<>();
        saveContents.put("location",locationName);
        String path = null;
        try {
            path = fsa.saveToFile(saveContents);
            io.displayText("Saved: " + path);
        }catch(IOException ex) {
            io.displayText(ex.toString());
        }
        return path;
    }

    public void load( final String path, final Game game) {
        Map<String, String> saveContents;
        try {
           saveContents = fsa.loadFile(path);
        }catch(IOException ex){
            io.displayText(ex.toString());
            io.displayText("Failed to load File");
            return;
        }

        Location newLocation = game.getLocationOf(saveContents.get("location"));
    }
}