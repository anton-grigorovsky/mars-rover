package com.stringconcat.marsrover;

import org.junit.jupiter.api.Test;

import static com.stringconcat.marsrover.TestData.AREA_5X5;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionCalculatorTest {

    @Test
    public void doOneStep() {
        var positionCalculator = new PositionCalculator(AREA_5X5);
        var position = new Position(1, 2, Direction.NORTH);
        var newPosition = positionCalculator.calculate(position, Command.MOVE);
        assertEquals(new Position(1, 3, Direction.NORTH), newPosition);
    }

    @Test
    public void doTurnLeft() {
        var positionCalculator = new PositionCalculator(AREA_5X5);
        var position = new Position(1, 2, Direction.NORTH);
        var newPosition = positionCalculator.calculate(position, Command.TURN_LEFT);
        assertEquals(new Position(1, 2, Direction.WEST), newPosition);
    }

    @Test
    public void doTurnRight() {
        var positionCalculator = new PositionCalculator(AREA_5X5);
        var position = new Position(1, 2, Direction.NORTH);
        var newPosition = positionCalculator.calculate(position, Command.TURN_RIGHT);
        assertEquals(new Position(1, 2, Direction.EAST), newPosition);
    }

    @Test
    public void crossBorder()
    {
        var positionCalculator = new PositionCalculator(AREA_5X5);
        var position = new Position(0, 0, Direction.WEST);
        var newPosition = positionCalculator.calculate(position, Command.MOVE);
        assertEquals(position, newPosition);
    }
}