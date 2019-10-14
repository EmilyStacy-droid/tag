package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import java.util.ArrayList;
import java.util.List;

public class Location {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String name="";
    private String description = "";
    //declaration                 appointment
    private List<String> tags = new ArrayList<>();
    private List<Exit> exits = new ArrayList<>();
    private Adversary adversary;
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;
    private Inventory inventory;


    public Adversary getAdversary() {
        return adversary;
    }


    public Item openTreasureChest(){
        if(TreasureChest.NO_TREASURE.equals(treasureChest)) {
            throw new UnsupportedOperationException();
        }
        Item treasure = treasureChest.getItem();
        treasureChest = TreasureChest.NO_TREASURE;
        return treasure;
    }

    public Item openAdversaryItem(){
        Item adversaryItem = adversary.getItem();
        //remove the adversary
        //get adversaryItem to inventory
        return adversaryItem;
    }


    public void setAdversary(Adversary adversary) {
        this.adversary = adversary;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }


    public List<Exit> getExits() {
        return exits;
    }


    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }


    public TreasureChest gettreasureChest() {
        return treasureChest;
    }

    public Item getTreasure(){
        return  treasureChest.getItem();
    }


    public void addExit(Exit exit) {
        this.exits.add(exit);
    }


}


