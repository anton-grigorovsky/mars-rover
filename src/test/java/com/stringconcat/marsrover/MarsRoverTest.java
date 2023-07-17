package com.stringconcat.marsrover;

import org.junit.jupiter.api.Test;

import static com.stringconcat.marsrover.TestData.AREA_5X5;
import static com.stringconcat.marsrover.TestData.POSITION_X1_Y2_N;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MarsRoverTest {

    @Test
    public void createAndSetOnStartPositionRover() {
        var rover = new MarsRover(POSITION_X1_Y2_N, new PositionCalculator(AREA_5X5));
        assertEquals("1 2 N", rover.getPosition());
    }

    @Test
    public void moveOneStep() {
        var positionCalculator = new PositionCalculator(AREA_5X5);
        var rover = new MarsRover(POSITION_X1_Y2_N, positionCalculator);
        rover.addCommands(Command.MOVE);
        rover.run();
        assertEquals("1 3 N", rover.getPosition());
    }

    @Test
    public void turnRoverLeft() {
        var positionCalculator = new PositionCalculator(AREA_5X5);
        var rover = new MarsRover(POSITION_X1_Y2_N, positionCalculator);
        rover.addCommands(Command.TURN_LEFT);
        rover.run();
        assertEquals("1 2 W", rover.getPosition());
    }

    @Test
    public void turnRoverRight() {
        var positionCalculator = new PositionCalculator(AREA_5X5);
        var rover = new MarsRover(POSITION_X1_Y2_N, positionCalculator);
        rover.addCommands(Command.TURN_RIGHT);
        rover.run();
        assertEquals("1 2 E", rover.getPosition());
    }

    @Test
    public void driveSomeWay() {
        var positionCalculator = new PositionCalculator(AREA_5X5);
        var rover = new MarsRover(POSITION_X1_Y2_N, positionCalculator);
        rover.addCommands(Command.MOVE, Command.TURN_LEFT, Command.MOVE, Command.MOVE, Command.TURN_RIGHT, Command.MOVE);
        rover.run();
        assertEquals("0 4 N", rover.getPosition());
    }
}
