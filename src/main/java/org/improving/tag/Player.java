package org.improving.tag;

public class Player {
    //the following three lines: default:so that the name value cannot be changed anytime;future-proofing
    private String name = "The player";
    private int hitPoints = 100;
    public String getName(){return name;}
    public void setName(String name) {this.name = name;}

    public int getHitPoints() { return hitPoints; }

    public void setHitPoints(int hitPoints) { this.hitPoints = hitPoints; }
}
