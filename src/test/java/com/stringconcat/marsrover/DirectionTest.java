package com.stringconcat.marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    public void turnLeft() {
        assertEquals(Direction.NORTH, Direction.WEST.turnLeft());
        assertEquals(Direction.EAST, Direction.NORTH.turnLeft());
        assertEquals(Direction.SOUTH, Direction.EAST.turnLeft());
        assertEquals(Direction.WEST, Direction.SOUTH.turnLeft());
    }

    @Test
    public void turnRight() {
        assertEquals(Direction.NORTH, Direction.EAST.turnLeft());
        assertEquals(Direction.EAST, Direction.SOUTH.turnLeft());
        assertEquals(Direction.SOUTH, Direction.WEST.turnLeft());
        assertEquals(Direction.WEST, Direction.NORTH.turnLeft());
    }

}