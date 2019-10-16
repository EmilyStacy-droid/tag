package org.improving.tag;

import org.improving.tag.items.Item;

import org.improving.tag.items.UniqueItemConverter;
import org.improving.tag.items.UniqueItems;

import javax.persistence.*;

@Entity(name = "adversary" )
public class Adversary {
    @Id
    long Id;
    @Column(name = "Name")
    private String adversaryName;
    @Column(name = "HitPoints")
    private int hitPoints;
    @Column(name = "DamageTaken")
    private int damageTakenProperty;
    @Column(name = "AttackDamage")
    private int attackDamageProperty;

    @Column (name = "DropItem")
    @Convert(converter = UniqueItemConverter.class)
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

//public String getDropItemDb() {
//        return dropItemDb;
//}
//
//    public void setDropItemDb(String dropItemDb) {
//        this.dropItemDb = dropItemDb;
//    }
////
//    @PostLoad
//
//    public void postLoad() {
//        if (null != dropItemDb) {
//
//            this.setAdversaryItem(Arrays.stream(UniqueItems.values())
//                    .filter(item -> item.getName().equals(dropItemDb))
//                    .findFirst()
//                    .orElse(null));
//        }
//    }


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
