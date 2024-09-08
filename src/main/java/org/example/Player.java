package org.example;

import java.util.ArrayList;

public class Player extends Character  {

    public Player(String name, int health, int power, char[][] level) {
        super(name, health, power, level);
        this.setLocation(new Position(2, 6));
    }
        private ArrayList<Item> inventory = new ArrayList<>();
        private int experience;


    public int getExperience() {
        return experience;
    }
    public void getExperience(int experience) {
        this.experience += experience;
    }
    public void addItem(Item item) {
        inventory.add(item);
    }
    public void removeItem(Item item) {
        inventory.remove(item);
    }
    public void showInventory(){
        inventory.forEach(System.out::println);
    }


}
