package com.stringconcat.marsrover.parser;

import com.stringconcat.marsrover.Command;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandParser {

    public List<Command> parse(String strCommand) {
        try {
            return Stream.of(strCommand.split(""))
                    .map(Command::fromString)
                    .map(Optional::get)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("Неверный формат команд управления");
        }
    }
}
