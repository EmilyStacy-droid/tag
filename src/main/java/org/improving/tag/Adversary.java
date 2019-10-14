package org.improving.tag;

import org.improving.tag.items.Item;

import org.improving.tag.items.UniqueItems;

public class Adversary {
    private String adversaryName;
    private int hitPoints;
    private int damageTakenProperty;
    private int attackDamageProperty;
    private UniqueItems adversaryItem;

    public Adversary() {
    }

    public Adversary(String adversaryName, UniqueItems adversaryItem)  {
        this.adversaryName = adversaryName;
        this.hitPoints = 100;
        this.damageTakenProperty = 0;
        this.attackDamageProperty = 30;
        this.adversaryItem = adversaryItem;
    }




    public String getName() {
        return adversaryName;
    }

    public String getAdversaryItemDescription() {return adversaryItem.toString();}

    public void setName(String adversaryName) {
        this.adversaryName = adversaryName;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamageTakenProperty() {
        return damageTakenProperty;
    }

    public void setDamageTakenProperty(int damageTakenProperty) {
        this.damageTakenProperty = damageTakenProperty;
    }

    public int getAttackDamageProperty() {
        return attackDamageProperty;
    }

    public void setAttackDamageProperty(int attackDamageProperty) {
        this.attackDamageProperty = attackDamageProperty;
    }


    public Item getItem() {
        return adversaryItem;
    }

    public void setAdversaryItem(UniqueItems adversaryItem) {
        this.adversaryItem = adversaryItem;
    }
}
