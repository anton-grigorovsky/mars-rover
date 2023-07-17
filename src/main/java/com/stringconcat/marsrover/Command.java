package com.stringconcat.marsrover;

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
}
