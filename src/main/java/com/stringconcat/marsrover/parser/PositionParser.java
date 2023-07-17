package com.stringconcat.marsrover.parser;

import com.stringconcat.marsrover.Direction;
import com.stringconcat.marsrover.Position;

public class PositionParser {

    public Position parsePosition(String stringPosition) {
        var values = stringPosition.split("\\s");
        try {
            return new Position(Integer.parseInt(values[0]), Integer.parseInt(values[1]), Direction.fromString(values[2]).orElseThrow());
        } catch (Exception e) {
            throw new IllegalArgumentException("Неверный формат положения и направления камеры марсохода");
        }
    }

    public int[] parseCoordinates(String coordinates) {
        var values = coordinates.split("\\s");
        try {
            return new int[] {Integer.parseInt(values[0]), Integer.parseInt(values[1])};
        } catch (Exception e) {
            throw new IllegalArgumentException("Неверный формат координат");
        }
    }
}
