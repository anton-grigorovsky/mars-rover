package com.stringconcat.marsrover.parser;

import com.stringconcat.marsrover.Direction;
import com.stringconcat.marsrover.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionParserTest {

    @Test
    public void parsePosition() {
        var stringPosition = "1 2 N";
        var parser = new PositionParser();
        var position = parser.parsePosition(stringPosition);
        assertEquals(position, new Position(1, 2, Direction.NORTH));
    }

    @Test
    public void wrongPositionFormat() {
        var stringPosition = "1 2 sd";
        var parser = new PositionParser();
        assertThrows(IllegalArgumentException.class, () -> parser.parsePosition(stringPosition));
    }

    @Test
    public void parseCoordinates() {
        var stringPosition = "1 2";
        var parser = new PositionParser();
        var coordinates = parser.parseCoordinates(stringPosition);
        assertEquals(coordinates[0], 1);
        assertEquals(coordinates[1], 2);
    }

    @Test
    public void wrongCoordinatesFormat() {
        var stringPosition = "1 s";
        var parser = new PositionParser();
        assertThrows(IllegalArgumentException.class, () -> parser.parseCoordinates(stringPosition));
    }
}