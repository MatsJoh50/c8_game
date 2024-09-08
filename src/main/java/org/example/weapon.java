package org.example;

public class weapon extends Item {
    public weapon(String name, int power, int defence, int value) {
        this.name = name;
        this.power = power;
        this.defence = defence;
        this.value = value;
    }

    public weapon dagger = new weapon("dagger", 1, 0, 0);
    public weapon sword = new weapon("Sword", 2, 0, 0);
    public weapon axe = new weapon("Axe", 3, 0, 0);
    public weapon greatSword = new weapon("Great Sword", 4, 0, 0);
}

