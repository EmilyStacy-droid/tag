package org.improving.tag;

public class Adversary {
    private String adversaryName = "Sauron";
    private int hitPoints = 100;
    private int damageTokenProperty;
    private int attackDamageProperty;



    public String getName() {
        return adversaryName;
    }

    public void setName(String adversaryName) {
        this.adversaryName = adversaryName;
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
