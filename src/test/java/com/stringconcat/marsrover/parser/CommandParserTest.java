package com.stringconcat.marsrover.parser;

import com.stringconcat.marsrover.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandParserTest {

    @Test
    public void parseCommands() {
        var strCommand = "MLR";
        var parser = new CommandParser();
        var commands = parser.parse(strCommand);
        assertArrayEquals(commands.toArray(), new Command[]{Command.MOVE, Command.TURN_LEFT, Command.TURN_RIGHT});
    }

    @Test
    public void wrongFormat() {
        var strCommand = "MLRs1";
        var parser = new CommandParser();
        assertThrows(IllegalArgumentException.class, () -> parser.parse(strCommand));
    }
}