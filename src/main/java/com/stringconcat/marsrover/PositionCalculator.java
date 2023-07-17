package com.stringconcat.marsrover;

public class PositionCalculator {

    private final Area area;

    public PositionCalculator(Area area) {
        this.area = area;
    }

    public Position calculate(Position position, Command command) {
        return switch (command) {
            case MOVE -> move(position);
            case TURN_LEFT -> turnLeft(position);
            case TURN_RIGHT -> turnRight(position);
        };
    }

    private Position turnRight(Position position) {
        return new Position(position.getX(), position.getY(), position.getDirection().turnRight());
    }

    private Position turnLeft(Position position) {
        return new Position(position.getX(), position.getY(), position.getDirection().turnLeft());
    }

    private Position move(Position position) {
        var newPosition = switch (position.getDirection()) {
            case EAST -> new Position(position.getX() + 1, position.getY(), position.getDirection());
            case NORTH -> new Position(position.getX(), position.getY() + 1, position.getDirection());
            case WEST -> new Position(position.getX() - 1, position.getY(), position.getDirection());
            case SOUTH -> new Position(position.getX(), position.getY() - 1, position.getDirection());
        };

        return insideArea(newPosition) ? newPosition : position;
    }

    private boolean insideArea(Position position) {
        return position.getX() >= 0
                && position.getX() <= area.getMaxX()
                && position.getY() >= 0
                && position.getY() <= area.getMaxY();
    }
}
