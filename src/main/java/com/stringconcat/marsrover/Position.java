package com.stringconcat.marsrover;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {
    private int x;
    private int y;
    private Direction direction;

    public String getPosition() {
        return x + " " + y + " " + direction.getCode();
    }
}
