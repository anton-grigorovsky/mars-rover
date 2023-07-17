package com.stringconcat.marsrover;

import lombok.Value;

@Value
public class Position {
    int x;
    int y;
    Direction direction;
}
