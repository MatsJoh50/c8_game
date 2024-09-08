package org.example;

    interface movable{

        default void moveUp(Character character) {
            Position pos = character.getLocation();
            character.setLocation(new Position(pos.getY() - 1, pos.getX()));
        }


        default void moveDown(Character character) {
            Position pos = character.getLocation();
            character.setLocation(new Position(pos.getY() + 1, pos.getX()));
        }

        default void moveRight(Character character) {
            Position pos = character.getLocation();
            character.setLocation(new Position(pos.getY() , pos.getX() + 1));
        }

        default void moveLeft(Character character) {
            Position pos = character.getLocation();
            character.setLocation(new Position(pos.getY()  , pos.getX() - 1));
        }

    }

