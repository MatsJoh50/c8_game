package org.example;

import java.util.ArrayList;

public class ValidMovement {
  private boolean up;
  private boolean down;
  private boolean left;
  private boolean right;

  public ValidMovement(char[][] level, Position position) {
    int x = position.getX();
    int y = position.getY();

    this.up = (y > 0) && (level[y - 1][x] == '#');
    this.down = (y < level.length - 1) && (level[y + 1][x] == '#');
    this.left = (x > 0) && (level[y][x - 1] == '#');
    this.right = (x < level[0].length - 1) && (level[y][x + 1] == '#');
  }

  public ArrayList<Boolean> getValidMovement() {
    ArrayList<Boolean> validMovement = new ArrayList<>();
    validMovement.add(this.up);
    validMovement.add(this.down);
    validMovement.add(this.left);
    validMovement.add(this.right);
    return validMovement;
  }

  public boolean isUp() {
    return up;
  }
  public boolean isDown() {
    return down;
  }
  public boolean isLeft() {
    return left;
  }
  public boolean isRight() {
    return right;
  }

public Boolean isValidEqual (ValidMovement input, String direction){
    boolean up = this.up == input.up;
    boolean down =  this.down == input.down;
    boolean left = this.left == input.left;
    boolean right = this.right == input.right;

  switch (direction.toLowerCase()) { // Normalize direction to lower case for consistency
    case "up":
      return left && right && up; // Return directly when the condition is met
    case "down":
      return left && right && down;
    case "left":
      return up && down && left;
    case "right":
      return up && down && right;
    default:
      return false; // In case of an invalid direction
  }
}

public void printValidMovment(){
  System.out.println("down: " + this.down);
  System.out.println("up: " + this.up);
  System.out.println("left: " + this.left);
  System.out.println("right: " + this.right);
}


}
