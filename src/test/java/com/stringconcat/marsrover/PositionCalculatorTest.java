package com.stringconcat.marsrover;

import org.junit.jupiter.api.Test;

class PositionCalculatorTest {

    @Test
    public void doOneStep() {
        var area = new Area(5, 5);
        var movementProcessor = new PositionCalculator();
        var position = new Position(1, 2, Direction.NORTH);
        movementProcessor.calculate(position, Command.MOVE);
    }

}