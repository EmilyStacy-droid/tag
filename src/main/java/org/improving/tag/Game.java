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

    //constructor
    public Game(Command[] commands, InputOutput io) {
        startingLocation = buildWorld();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);
    }

//set methods to get data from the fields
    public Location getStartingLocation(){
        return startingLocation;
}

public Player getPlayer(){
        return p;
}

public Date getStartTime(){
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
    public void run ()  {
        


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

        var tap = new Location();
        tap.setName("The Airport");

        var tit = new Location();
        tit.setName("The Ice Cream Truck");

        var tms = new Location();
        tms.setName("The Mountains");

        var tm = new Location();
        tm.setName("The Mall");

        var md = new Location();
        md.setName("Mount Doom");

        var tr = new Location();
        tr.setName("The Reef");

        var tvd = new Location();
        tvd.setName("The Volcano of Death");

        tdh.getExits().add(new Exit("Heaven Ave", tmcs, "h", "heaven", "ave"));
        tdh.getExits().add(new Exit("The Deathly Brownie", td, "tdb","Brownie","deathly"));
        td.getExits().add(new Exit("Camel Path", ta, "cp", "camel", "path"));
        td.getExits().add(new Exit("The Dock", tap, "td", "dock"));
        td.getExits().add(new Exit("Rocky Road", tit, "rr", "Rocky", "Road"));
        tit.getExits().add(new Exit("Magic Portal", md, "mp", "portal", "magic"));
        tms.getExits().add(new Exit("bike trail", tr, "bt", "trail", "bike"));
        tms.getExits().add(new Exit("The Plane", ta, "tp", "plane"));
        tms.getExits().add(new Exit("The narrow Trail", md, "tat", "narrow trail", "trail","narrow"));
        tms.getExits().add(new Exit("The Lava Flow", tvd, "tlf", "lava", "flow", "Lava Flow"));
        tmcs.getExits().add(new Exit("highway 121",ta, "121", "hwy", "hwy 121", "h121"));
        tmcs.getExits().add(new Exit("Paradise Rd",tr, "pr", "paradise", "rd"));
        tmcs.getExits().add(new Exit("Higway 21",tvd, "h21", "21", "hwy 21", "higway"));
        md.getExits().add(new Exit("The Cab",tm, "cab", "tc"));
        md.getExits().add(new Exit("Jump into Lava",tvd, "jil", "jump", "into lava"));
        tm.getExits().add(new Exit("Path to Doom",md, "ptd", "path"));
        tr.getExits().add(new Exit("The City Walk",tm, "tcw", "city walk", "city", "walk"));
        tr.getExits().add(new Exit("The Scenic Route",tvm, "tsr", "scenic", "route", "scenic route", "sr"));
        tm.getExits().add(new Exit("An escalator of doom",tvd, "asd", "escalator"));
        ta.getExits().add(new Exit("Amaz-ing Moose", tvm, "moose","AM", "Amazing","ing", "Amaz", "Amaz-ing"));
        tvm.getExits().add(new Exit("The pudding Slide", tap, "tps","pudding", "slide", "pudding slide"));
        tvm.getExits().add(new Exit("The front door", ta, "tfd","front", "door", "front door"));
        tap.getExits().add(new Exit("flight to the mall", tms, "fttm", "to the mall"));
        tap.getExits().add(new Exit("flight 121", tm, "f121", "121"));


        return tdh;
}

}