package com.stringconcat.marsrover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    @Test
    public void createAndSetOnStartPositionRover() {
        var rover = new MarsRover(1,2, Direction.NORTH);
        assertEquals("1 2 N", rover.getPosition());
    }

    @Test
    public void moveOneStep() {
        var rover = new MarsRover(1,2, Direction.NORTH);
        rover.addCommands(Command.MOVE);
        rover.run();
        assertEquals("1 3 N", rover.getPosition());
    }

    @Test
    public void turnRover() {
        var rover = new MarsRover(1,2, Direction.NORTH);
        rover.addCommands(Command.TURN_LEFT);
        rover.run();
        assertEquals("1 2 W", rover.getPosition());
    }
}
