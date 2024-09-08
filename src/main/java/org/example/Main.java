package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
  protected static String endGameMsg = "";
  protected static boolean isItSafe = true;

  public static void main(String[] args) {
    gameMaps gameMaps = new gameMaps();
    char[][] level = gameMaps.printMaze(gameMaps.LEVEL_1);

    ArrayList<Character> characters = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();
    generateItems(items, level,1);
    Player player = new Player("Player", 10,0, level);
//    player.setLocation(new Position().setRandomPos(level, characters));
    player.setLocation(new Position(1,0));
    player.setValidMovement(new ValidMovement(level, player.getLocation()));
    characters.add(player);

    ArrayList<Character> enemys = new ArrayList<>();
    Character mob1 = new Character("Mob 1", 1, 1, level);
    mob1.setLocation(new Position().setRandomPos(level, characters));
    enemys.add(mob1);

    Character mob2 = new Character("Mob 2", 1, 1, level);
    mob2.setLocation(new Position().setRandomPos(level, characters));
    enemys.add(mob2);

    Scanner sc = new Scanner(System.in);
    boolean renderFirstLoop = true;

    while(isItSafe){
      if(renderFirstLoop){
      runGame(level, characters, enemys, items);
      renderFirstLoop = false;
      }
      player.setValidMovement(new ValidMovement(level, player.getLocation()));
      askForDirections(player, level, sc);

      while(getValidEqual(player, level) && isItSafe){

        moveObject(player);
        runGame(level, characters, enemys, items);
        LazyComponent(250);
      };
    }
    System.out.println(endGameMsg);
  }

  public static Boolean getValidEqual(Character character, char[][] level) {
    System.out.println("prev dir: "+ character.getPrevDirection());
    if(!character.getPrevDirection()){
      character.setPrevDirection();
      return true;
    }
    return character.getValidMovement().isValidEqual(new ValidMovement(level, character.getLocation()), character.getDirection());
  }

  private static void generateItems(ArrayList<Item> items, char[][] level, int amount) {
    Random random = new Random();
    for (int i = 0; i < amount; i++) {
      Item newItem = new Treasure("Chest", random.nextInt(10));
      newItem.setLocation(new Position().setRandomPos(level));
      items.add(newItem);
    }

  }

  private static void runGame(char[][] level, ArrayList<Character> characters, ArrayList<Character> enemys, ArrayList<Item> items) {

    System.out.println("X <= This is you");
    System.out.println("E <= this is NOT you");


    renderGameLevel(level, characters, enemys, items);
  }

  private static void renderPlayerHealth(Character player) {
    for (int i = 0; i < player.getHealth(); i++) {
      System.out.print("<3 ");
    }
    System.out.println();
  }

  private static void renderGameLevel(char[][] level, ArrayList<Character> characters, ArrayList<Character> enemys, ArrayList<Item> items) {
    for (int y = 0; y < level.length; y++) {
      for (int x = 0; x < level[y].length; x++) {
        if(isPlayerHere(characters, y, x)) {
          System.out.print("X");
          if(isMobHere(enemys, y, x)){
            isItSafe = false;
            endGameMsg = "Game over man! game over!";
          }
          if(isItemHere(items, y, x)){
            isItSafe = false;
            endGameMsg = "CONGRATULATIONS!!";
          }
        }
        else if(isMobHere(enemys, y, x)) {
          System.out.print("E");

        }
        else if(isItemHere(items, y, x)){
          System.out.print("T");

        }
        else {
          invertMapStructure(level, y, x);
        }
      }
      System.out.println();
    }
  }

  private static boolean isItemHere(ArrayList<Item> items, int y, int x) {
    for (int i = 0; i < items.size(); i++) {
      if(items.get(i).getLocation().getY() == y && items.get(i).getLocation().getX() == x) {
        return true;
      }
    }
    return false;
  }

  private static boolean isMobHere(ArrayList<Character> characters, int y, int x) {
    for (int m = 0; m < characters.size(); m++) {
      if(characters.get(m).getLocation().getY() == y && characters.get(m).getLocation().getX() == x) {
        return true;
      }
    }
    return false;
  }

  private static boolean isPlayerHere(ArrayList<Character> characters, int y, int x) {
    return characters.getFirst().getLocation().getY() == y && characters.getFirst().getLocation().getX() == x;
  }

  private static void invertMapStructure(char[][] level, int y, int x) {
    if(level[y][x] == ' ') {
      System.out.print(" ");
    }  else  {
      System.out.print(".");
    }
  }

  private static void LazyComponent(int timesInMs){
    try {
      Thread.sleep(timesInMs);  // Pause execution for 300 milliseconds
    } catch (InterruptedException e) {
      e.printStackTrace();  // Handle the InterruptedException
    }
  }


  private static void askForDirections(Character obj, char[][] level, Scanner scanner) {
    ValidMovement newValidMove = new ValidMovement(level, obj.getLocation());

boolean canImove = false;
    while (!canImove) {
      System.out.print("Where to? (w/a/s/d): ");
      String newDirection = scanner.nextLine().toLowerCase();

      switch (newDirection) {
        case "w":
          if (newValidMove.isUp()) {
            obj.setDirection("up");
            System.out.println("Direction set to up.");
            canImove = true;
          } else {
            System.out.println("Can't move up!");
          }
          break;
        case "s":
          if (newValidMove.isDown()) {
            obj.setDirection("down");
            canImove = true;

            System.out.println("Direction set to down.");
          } else {
            System.out.println("Can't move down!");
          }
          break;
        case "a":
          if (newValidMove.isLeft()) {
            obj.setDirection("left");
            canImove = true;
            System.out.println("Direction set to left.");
          } else {
            System.out.println("Can't move left!");

          }
          break;
        case "d":
          if (newValidMove.isRight()) {
            canImove = true;
            obj.setDirection("right");
            System.out.println("Direction set to right.");
          } else {
            System.out.println("Can't move right!");
          }
          break;
        default:
          System.out.println("Invalid direction: " + newDirection);
          break;
      }
    }

  }

  private static void moveObject(Character obj){
    switch (obj.getDirection()) {
      case "up":
        obj.moveUp(obj);
        break;
        case "down":
          obj.moveDown(obj);
          break;
          case "left":
            obj.moveLeft(obj);
            break;
            case "right":
              obj.moveRight(obj);
              break;
    }
  }
}