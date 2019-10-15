package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity (name = "location")
public class Location {
    @ManyToOne
    @JoinColumn (name= "AdversaryId")
    private Adversary adversary;

    @Id
    int id;
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Name")
    private String name="";

    @Column(name = "Description")
    private String description = "";
    //declaration                 appointment
    @OneToMany(mappedBy = "origin")
    private List<Exit> exits = new ArrayList<>();
    @Transient
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;
    @Transient
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
@Override
    public String toString(){
        return this.getName();
}

@Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location location = (Location) obj;
            return this.getName().equals(location.getName());
        }
        return super.equals(obj);
}

}


