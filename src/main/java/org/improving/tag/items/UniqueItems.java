package org.improving.tag.items;

import java.util.HashMap;
import java.util.Map;

public enum UniqueItems implements Item{
    BLUE_SHELL("A blue shell with wings", "Mario blue shell",1),
    EDIBLE_MUSHROOM("A mushroom that can be eaten", "Edible mushroom",2),
    EGGO_WAFFLE("a balanced breakfast", "EGGO waffle",10),
    EVERLASTING_GOBSTOPPER("A gobstopper that never loses its flavor", "Jawbreaker gobstopper",5),
    Meowing("Meowing power", "Cat's meowing",Integer.MAX_VALUE),
    NOTHING("", "",0) {
    } //        @Override
    //        public String getDescription() {
    //            throw new UnsupportedOperationException();
    //        }
    ,
    Sauron_Fire("Sauron's fire", "Sauron's everlasting fire",1),
    THE_ONE_RING("A golden ring", "One ring",1);
    private String description;
    private final String name;
    private final int ID;

    UniqueItems(String description, String name, int ID) {
        this.description = description;
        this.name = name;
        this.ID = ID;

    }

    @Override

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return name + ":" + description + " " + ID + " pieces";
    }

    @Override
    public int getID(){
        return ID;
    }

}


