package org.example;

public abstract class Item {
    protected String name;
    protected int power;
    protected int defence;
    protected int value;
    protected Position location;


    public Position getLocation() {
        return location;
    }
    public void setLocation(Position location) {
        this.location = location;
    }
    public int getValue() {
        return value;
    }
    public int getDefence() {
        return defence;
    }
    public String getName() {
        return name;
    }
    public int getPower() {
        return power;
    }

}
