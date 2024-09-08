package org.example;

import java.util.Random;

interface AutoMove {
  //Check direction
  //is direction +1 == "." => continue
  //if sidedirection == "." => recheck moving direction with mathRandom.
  default Position Automatic(Character enemy, char[][] map) {
    Random random = new Random();
    Position changeToThis = new Position(0, 0);
    ValidMovement moveWhere = new ValidMovement(map, enemy.getLocation());

    return null;
  };

}

