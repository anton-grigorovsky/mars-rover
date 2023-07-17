package com.stringconcat.marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    public void turnLeft() {
        assertEquals(Direction.NORTH, Direction.EAST.turnLeft());
        assertEquals(Direction.WEST, Direction.NORTH.turnLeft());
        assertEquals(Direction.NORTH, Direction.EAST.turnLeft());
        assertEquals(Direction.EAST, Direction.SOUTH.turnLeft());
    }

    @Test
    public void turnRight() {
        assertEquals(Direction.SOUTH, Direction.EAST.turnRight());
        assertEquals(Direction.WEST, Direction.SOUTH.turnRight());
        assertEquals(Direction.NORTH, Direction.WEST.turnRight());
        assertEquals(Direction.EAST, Direction.NORTH.turnRight());
    }
}