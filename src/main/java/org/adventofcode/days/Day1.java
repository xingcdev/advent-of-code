package org.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day1 {

    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    public Day1() throws IOException, URISyntaxException {
        parseTheInput();
    }

    public void parseTheInput() throws IOException, URISyntaxException {
        Path path = Paths.get(getClass().getClassLoader().getResource("day1/input.txt").toURI());
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                String[] parts = line.split("   ", 2);
                try {
                    left.add(Integer.parseInt(parts[0]));
                    right.add(Integer.parseInt(parts[1]));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number in input.txt.");
                }

            });
        }
    }

    public int part1() throws URISyntaxException, IOException {
        // 1. Read the file and store the content into 2 lists: left & right.
        // 2. Sort these two lists.
        // 3. Loop over these lists and calculate the distance.
        // 4. Print the total distance

        int totalDistance = 0;

        var sortedLeft = left.stream().sorted().toList();
        var sortedRight = right.stream().sorted().toList();

        for(int i = 0; i < sortedLeft.size(); i++) {
            int distance = Math.abs(sortedLeft.get(i) - sortedRight.get(i));
            totalDistance += distance;
        }

        return totalDistance;
    }

    public int part2() {
        // Loop over the left list
        // Loop over the right list
        // If the number of the left list == the one from the right list
        //      increase the number of times it appears
        // End loop
        // If appear time == 0 don't do the operation of adding.
        // Add the similarity score by (the number of the left list * the number of times it appears)
        // Reset the appear time
        // End loop
        // Return the similarity score

        int similarityScore = 0;
        int appear = 0;

        for(int leftNumber : left) {
            for (int rightNumber : right) {
                if (leftNumber == rightNumber) {
                    appear += 1;
                }
            }
            if (appear != 0) {
                similarityScore += (leftNumber * appear);
                appear = 0;
            }
        }
        return similarityScore;
    }
}
