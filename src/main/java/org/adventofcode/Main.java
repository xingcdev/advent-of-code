package org.adventofcode;

import org.adventofcode.days.Day1;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("Advent of Code 2024!");
        var day1 = new Day1();
        System.out.println(day1.part1());
        System.out.println(day1.part2());
    }
}