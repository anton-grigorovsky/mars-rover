package com.stringconcat.marsrover;

public enum Direction {
    NORTH("N"),
    WEST("W"),
    SOUTH("S"),
    EAST("E");

    private String code;

    Direction(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public Direction turnLeft() {
        return switch (this) {
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case NORTH -> WEST;
        };
    }

    public Direction turnRight() {
        return switch (this) {
            case WEST -> NORTH;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case NORTH -> EAST;
        };
    }
}
