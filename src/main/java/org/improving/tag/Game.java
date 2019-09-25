package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Scanner;
@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] commands;
    private InputOutput io;
    private Player p;
    private Location startingLocation;
    private final SaveGameFactory saveFactory;

    public Game(Command[] commands, InputOutput io, SaveGameFactory saveFactory) {
        startingLocation = buildWorld();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);
        this.saveFactory = saveFactory;
    }
//get starting location
    public Location getStartingLocation() {
        return startingLocation;
    }

    public Player getPlayer() {
        return p;
    }

    public Date getStartTime() {
        return startTime;
    }

    private void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

   
    public Date getEndTime() {
        return endTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public void run ()  {
        this.setStartTime(new Date());


        boolean loop = true;
        while(loop) {
            io.displayPrompt("> ");
            String input = io.receiveInput();
            Command validCommand = getValidCommand(input);
            //put constant(something that always has certain value) first and whatever can change later
            if(null != validCommand) {
                validCommand.execute(input, this);
            }else if (input.equalsIgnoreCase("exit")) {
                saveFactory.save(this);
                io.displayText("Goodbye.");
                //create a class about how to save the game
                //create a class about a file system
                //create a class about how to test a file system
                loop =false;
            }else {
                io.displayText("Huh? I don't understand.");
            }
        }
        this.setEndTime(new Date());
    }

    private Command getValidCommand(String input) {
        for(Command command: commands) {
            if(command.isValid(input, this)) {
               return command;
            }
        }
        return null;
    }
private Location buildWorld() {
        var tdh = new Location();
        tdh.setName("The Deathly Hallows");

        var td = new Location();
        td.setName("The Desert");

        var ta = new Location();
        ta.setName("The Amazon");

        var tmcs = new Location();
        tmcs.setName("The Mac & Cheese shop");

        var tvm = new Location();
        tvm.setName("The Velvet Moose");

        tdh.getExits().add(new Exit("Heaven Ave", tmcs, "h", "heaven", "ave"));
        tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb","Brownie","deathly"));
        td.getExits().add(new Exit("Camel Path", ta, "cp", "camel", "path"));
        tmcs.getExits().add(new Exit("highway 121",ta, "121", "hwy", "hwy 121", "h121"));
        ta.getExits().add(new Exit("Amaz-ing Moose", tvm, "moose","AM", "Amazing","ing", "Amaz", "Amaz-ing"));


        return tdh;
}

}