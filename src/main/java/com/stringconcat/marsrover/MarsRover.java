package com.stringconcat.marsrover;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MarsRover {

    private final PositionCalculator calculator;
    private final LinkedList<Command> commands = new LinkedList<>();
    private Position position;

    public MarsRover(Position startPosition, PositionCalculator calculator) {
        this.position = startPosition;
        this.calculator = calculator;
    }

    public String getPosition() {
        return position.getX() + " " + position.getY() + " " + position.getDirection().getCode();
    }

    public void addCommands(Command... commands) {
        this.commands.addAll(Arrays.stream(commands).collect(Collectors.toList()));
    }

    public void run() {
        while (!commands.isEmpty())
            execute(this.commands.poll());
    }

    private void execute(Command command) {
        position = calculator.calculate(position, command);
    }
}
