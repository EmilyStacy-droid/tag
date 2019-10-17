package org.improving.tag;

import org.improving.tag.items.ListOfStrings;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
@Entity(name = "exits" )
public class Exit {

    @Id
    int Id;

    @ManyToOne
    @JoinColumn(name = "OriginId")
    private Location origin;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "DestinationId")
    private Location destination;

//    @Column (name = "Aliases")
//    private String csvAliases;

    @Column (name = "Aliases")
    @Convert()
    private ListOfStrings aliases = new ListOfStrings();

    private int destinationId;

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }



    // ... cannot be in a middle; it needs to be at the end of the parameter
    public Exit(String name, Location destination, String... aliases) {
        this.name = name;
        this.destination = destination;
        this.aliases.addAll(Arrays.asList(aliases));
    }

    public Exit () {

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

    public void addAlias(String alias) {
        this.aliases.add(alias);

    }

    public List<String> getAliases() {
        return aliases;
    }

    //@Override
    public boolean equalsLocation(Object obj) {
        if (obj instanceof Exit) {
            Exit exit = (Exit) obj;
            return this.getName().equals(exit.getName()) && this.getDestination().equals(exit.getDestination());

        }
        return super.equals(obj);
    }

        @Override
        public String toString() {
            return this.getName();
        }

//IDE intelli j can generate it=>don't lose objects in collection
// if there is an equal, use hashcode
    @Override
  public int hashCode() {
        return Objects.hash(name, destination);
    }
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Exit exit = (Exit) o;
//        return name.equals(exit.name) &&
//                destination.equals(exit.destination);
//    }



//    public Location findExitDestination(Location location, Exit exit){
//        locations.filter (location.getId() == exit.getDestinationId()
//    }

//    @PostLoad
//    public void postLoad() {
//        if(null !=aliases) {
//           this.getAliases(Arrays.stream(aliases.replace(" ","").split(",")
//                   .forEach(alias->this.addAlias(alias))));
//        }
//    }


//@PostLoad
//    public void postLoad() {
//
//        if(null !=csvAliases) {
//            aliases.addAll(Arrays.asList(csvAliases.replace(" ", "").split(",")));
//        }
//    }

}
