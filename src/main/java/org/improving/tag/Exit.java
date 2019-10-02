package org.improving.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exit {
    private String name;
    private Location destination;
    private List<String> aliases = new ArrayList<>();

    // ... cannot be in a middle; it needs to be at the end of the parameter
    public Exit(String name, Location destination, String... aliases) {
        this.name = name;
        this.destination = destination;
        this.aliases.addAll(Arrays.asList(aliases));
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    //no perfect answer to answer override equal; the only trustable one is java.lang.object
    public boolean equals(Object obj) {
        if (obj instanceof Exit) {
            Exit exit = (Exit) obj;
            return this.getName().equals(exit.getName()) &&
                    this.getDestination().equals(exit.getDestination());
        } else {
            return super.equals(obj);
        }
    }

    public boolean equalsLocation(Object obj){
        if(obj instanceof Location) {
            Location location = (Location) obj;
            return this.getName().equals(location.getName());
        }else {
            return super.equals(obj);
        }
    }
}
