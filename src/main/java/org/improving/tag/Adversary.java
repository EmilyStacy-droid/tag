package org.improving.tag;

public class Adversary {
    private String adversaryName;
    private int hitPoints;
    private int damageTakenProperty;
    private int attackDamageProperty;

    public Adversary(String adversaryName) {
        this.adversaryName = adversaryName;
        this.hitPoints = 100;
        this.damageTakenProperty = 0;
        this.attackDamageProperty = 30;
    }

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
}
