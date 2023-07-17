package com.stringconcat.marsrover;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

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

    public static Optional<Direction> fromString(String code) {
        return Stream.of(Direction.values()).filter(c -> Objects.equals(code, c.code)).findFirst();
    }
}
