package com.stringconcat.marsrover;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class MarsRover {

    private PositionCalculator processor;
    private Position position;
    private final LinkedList<Command> commands = new LinkedList<>();

    public MarsRover(int x, int y, Direction direction) {
        this.position = new Position(x, y, direction);
    }

    public String getPosition() {
        return position.getPosition();
    }

    public void addCommands(Command... commands) {
        this.commands.addAll(Arrays.stream(commands).collect(Collectors.toList()));
    }

    public void run() {
        while (!commands.isEmpty())
            execute(this.commands.poll());
    }

    private void execute(Command command) {
        position = processor.calculate(position, command);
    }
}
