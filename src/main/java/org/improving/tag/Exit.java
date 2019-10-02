package org.improving.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

//IDE intelli j can generate it=>don't lose objects in collection
// if there is an equal, use hashcode
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Exit exit = (Exit) o;
//        return name.equals(exit.name) &&
//                destination.equals(exit.destination);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, destination);
//    }

    public boolean equalsLocation(Object obj){
        if(obj instanceof Location) {
            Location location = (Location) obj;
            return this.getName().equals(location.getName());
        }else {
            return super.equals(obj);
        }
    }
}
