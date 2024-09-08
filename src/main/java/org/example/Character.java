package org.example;

import java.util.ArrayList;

public class Character implements movable{
    private String name;
    private int health;
    private int power;
    private Position location;
    private ValidMovement validMovement;
    private String direction;
    private String prevDirection;


    public Character(String name, int health, int power, char[][] level) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.location = new Position(0, 0);
        this.prevDirection = "";
        setValidMovement(new ValidMovement(level, this.location));
    }

    public Position getLocation() {
        return location;
    }
    public void setLocation(Position location) {
        this.location = location;
    }
    public void setPrevDirection(){
        this.prevDirection = this.direction;
    }
    public boolean getPrevDirection(){
        return prevDirection.equals(direction);
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getDirection() {
        return direction;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getPower() {
        return power;
    }

    public void heal(int heal) {
        this.health += heal;
    }
    public void takeDmg(int dmg) {
        health -= dmg;
    }

    public ValidMovement getValidMovement() {
        return validMovement;
    }
    public void setValidMovement(ValidMovement validMovement) {
        this.validMovement = validMovement;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // Same object reference
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // Different classes
        }
//        ValidMovement other = (ValidMovement) obj;
//        return this.level.equals(other.level) && this.location.equals(other.location); // Assuming level and location have properly overridden equals methods
        return true;
    }
}

