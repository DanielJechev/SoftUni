package models;

import models.cards.interfaces.Card;

public   abstract class BaseCard  implements Card {
    private String 	name;
    private  int damagePoints;
    private  int healthPoints;

    BaseCard(String name, int damagePoints, int healthPoints ) {
        setName(name);
        setDamagePoints(damagePoints);
        setHealthPoints(healthPoints);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDamagePoints() {
        return this.damagePoints;
    }

    @Override
    public void setDamagePoints(int damagePoints) {
        if (damagePoints<0){
            throw new IllegalArgumentException("Card's damage points cannot be less than zero.");
        }
    }

    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    private void setName(String name) {
        if (name==null||name.trim().isEmpty()){
            throw new IllegalArgumentException("Card's name cannot be null or an empty string.");
        }
        this.name = name;
    }

    private void setHealthPoints(int healthPoints) {
        if (healthPoints<0){
            throw new IllegalArgumentException("Card's HP cannot be less than zero.");
        }
        this.healthPoints = healthPoints;
    }
}


