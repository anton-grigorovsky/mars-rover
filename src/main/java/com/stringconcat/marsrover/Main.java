package com.stringconcat.marsrover;

import com.stringconcat.marsrover.parser.CommandParser;
import com.stringconcat.marsrover.parser.PositionParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final PositionParser POSITION_PARSER = new PositionParser();
    private static final CommandParser COMMAND_PARSER = new CommandParser();
    private static final List<MarsRover> ROVERS = new ArrayList<>();
    private static PositionCalculator POSITION_CALCULATOR;

    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Введите размер поля: ");
        initPositionCalculator(in.nextLine());
        do {
            System.out.println("Введите текущее положение и направление камеры марсохода:");
            var position = in.nextLine();
            System.out.println("Управление положением марсохода:");
            addRover(position, in.nextLine());
            System.out.println("Добавить еще марсоход? [y/n]:");
        } while ("y".equals(in.nextLine()));

        in.close();

        ROVERS.stream()
                .peek(MarsRover::run)
                .map(MarsRover::getPosition)
                .forEach(System.out::println);
    }

    private static void addRover(String position, String nextLine) {
        var rover = new MarsRover(POSITION_PARSER.parsePosition(position), POSITION_CALCULATOR);
        COMMAND_PARSER.parse(nextLine).forEach(rover::addCommands);
        ROVERS.add(rover);
    }

    private static void initPositionCalculator(String nextLine) {
        var coordinates = POSITION_PARSER.parseCoordinates(nextLine);
        POSITION_CALCULATOR = new PositionCalculator(new Area(coordinates[0], coordinates[1]));
    }
}
