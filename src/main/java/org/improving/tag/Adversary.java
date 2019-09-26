package org.improving.tag;

public class Adversary {
    private String name;
    private int hitPoints;
    private int damageTokenProperty;
    private int attackDamageProperty;

//    public Adversary(String name, int hitPoints, int damageTokenProperty, int attackDamageProperty) {
//        this.name = name;
//        this.hitPoints = hitPoints;
//        this.damageTokenProperty = damageTokenProperty;
//        this.attackDamageProperty = attackDamageProperty;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamageTokenProperty() {
        return damageTokenProperty;
    }

    public void setDamageTokenProperty(int damageTokenProperty) {
        this.damageTokenProperty = damageTokenProperty;
    }

    public int getAttackDamageProperty() {
        return attackDamageProperty;
    }

    public void setAttackDamageProperty(int attackDamageProperty) {
        this.attackDamageProperty = attackDamageProperty;
    }
}
