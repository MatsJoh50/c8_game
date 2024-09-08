package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Position {
    private int y;
    private int x;

    public Position() {
    }
    public Position(int y, int x) {
        this.y = y;
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getX() {
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }


    public Position setRandomPos(char[][] map, ArrayList<Character> characters){
        Random random = new Random();
        int width = random.nextInt(map[0].length);
        int height = random.nextInt(map.length);
        width = getWidthLocationWithPathing(map, width, height, characters);
        return new Position(height,width);
    }
    public Position setRandomPos(char[][] map){
        Random random = new Random();
        int width = random.nextInt(map[0].length);
        int height = random.nextInt(map.length);
        width = getWidthLocationWithPathing(map, width, height);
        return new Position(height,width);
    }

    private static int getWidthLocationWithPathing(char[][] map, int width, int height, ArrayList<Character> characters) {
        try {
            for (int x = width; x < map[0].length; x++) {
                int finalX = x;
                boolean isUniquePosition = (map[height][x] == '#') || characters.stream().anyMatch(character -> character.getLocation().equals(new Position(height, finalX)));
                if(isUniquePosition){
                    width = x;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return width;
    }
    private static int getWidthLocationWithPathing(char[][] map, int width, int height) {
        try {
            for (int x = width; x < map[0].length; x++) {
                boolean isValidPosition = (map[height][x] == '#');
                if(isValidPosition){
                    width = x;
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return width;
    }


}

