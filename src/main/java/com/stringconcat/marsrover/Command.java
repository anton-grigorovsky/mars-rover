package com.stringconcat.marsrover;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public enum Command {
    MOVE("M"),
    TURN_LEFT("L"),
    TURN_RIGHT("R");

    private String code;

    Command(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Optional<Command> fromString(String code) {
        return Stream.of(Command.values()).filter(c -> Objects.equals(code, c.code)).findFirst();
    }
}
