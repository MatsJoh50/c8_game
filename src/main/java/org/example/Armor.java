package org.example;

public class Armor extends Item{
    public Armor(String name, int power, int defence, int value) {
        this.name = name;
        this.power = power;
        this.defence = defence;
        this.value = value;
    }
    public Armor leatherArmor = new Armor("Leather Armor", 0, 1, 0);
    public Armor chainmail = new Armor("Chainmail", 0, 2, 0);
    public Armor plateArmor = new Armor("Plate Armor", 0, 3, 0);
    public Armor fullPlate = new Armor("Full Plate", 0, 4, 0);

}
