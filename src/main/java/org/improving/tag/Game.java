package org.improving.tag;

import org.improving.tag.commands.*;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] commands; //created by Spring
    private InputOutput io;
    private Player p;
    private Location startingLocation;
    private List<Location> locationList = new ArrayList<>(100);
    private final SaveGameFactory saveFactory;


    //constructor
    public Game(Command[] commands, InputOutput io, SaveGameFactory saveFactory, WorldBuilder worldBuilder) {
        startingLocation = worldBuilder.buildWorld();
        locationList = worldBuilder.getLocationList();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);
        this.saveFactory = saveFactory;
    }

    //set methods to get data from the fields
    public Location getStartingLocation() {
        return startingLocation;
    }

    public Player getPlayer() {
        return p;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    //set private start time because it shouldn't be changed
    private void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void childExecute(String input, Game game) {
    }

    ;


    public String getErrorMessage() {
        return "There is an error";
    }

    public void run() {

        this.setStartTime(new Date());
        boolean loop = true;
        while (loop) {
            io.displayPrompt("> ");
            String input = io.receiveInput();
            Command validCommand = getValidCommand(input);
            //put constant(something that always has certain value) first and whatever can change later

            if (null != validCommand) {
                try {
                    validCommand.execute(input, this);
                } catch (GameExitException ex) {
                    loop = false;
                }catch(AdversaryRemoveException ex) {
                    io.displayText("You shall proceed.");
                    this.getPlayer().getLocation().setAdversary(null);

                }
            } else {
                io.displayText("Huh? I don't understand.");
            }

        }

        //else if (
        //input.equalsIgnoreCase("exit")) {
        //saveFactory.save(this);
        //io.displayText("Goodbye.");
        //create a class about how to save the game
        //create a class about a file system
        //create a class about how to test a file system
        //loop =false;
        //}

        this.setEndTime(new Date());
    }

    private Command getValidCommand(String input) {
        //List <Commands> commands = commands;
       Arrays.asList(commands).stream().filter(c -> c.isValid(input,this));
//           for (Command command : commands) {
//         if (command.isValid(input, this)) {
//               return command;
//            }
//        }

      //  return null;
        //Array.asList(command)
        //return null;
         return Stream.of(commands).filter(c -> c.isValid(input,this)).findFirst().orElseGet(null);
    }

    public Location getLocationOf(final String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }
        return null;
    }



}

//for (var command:commands){
//            System.out.println(command);
//        }