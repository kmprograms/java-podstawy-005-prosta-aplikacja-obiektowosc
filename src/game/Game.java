package game;

import generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    // TODO napraw ten program tak zeby miec gwarancje ze te liczby tutaj nie beda sie powtarzac
    private List<Integer> numbers;
    private int min;
    private int max;

    public Game(int size, int min, int max) {
        init(size, min, max);
    }

    /**
     *
     * @param number
     * @return
     */
    public boolean isLuckyNumber(int number) {
        if (number < min || number > max) {
            return false;
        }

        // sposob 1
        /*
        for (var num : numbers) {
            if (num == number) {
                return true;
            }
        }
        return false;
        */

        // sposob 2
        return numbers
                .stream()
                .anyMatch(num -> num == number);

        // sposob 3
        // return numbers.contains(number);
    }

    /**
     *
     * @param size
     * @param min
     * @param max
     */
    private void init(int size, int min, int max) {
        if (size <= 0) {
            throw new IllegalArgumentException("The game must have array with at least one element");
        }

        if (min > max) {
            throw new IllegalArgumentException("Range is not correct: [" + min + ", " + max + "]");
        }

        if (min <= 0) {
            throw new IllegalArgumentException("Numbers must have only positive values");
        }

        this.min = min;
        this.max = max;

        numbers = new ArrayList<>();

        // sposob 1
        /*
        for (int i = 0; i < size; i++) {
            // TODO zastosuj static import
            numbers.add(NumberGenerator.intValue(min, max));
        }
        */

        // sposob 2
        numbers = IntStream
                .range(0, size)
                .mapToObj(index -> NumberGenerator.intValue(min, max))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {

        // sposob 1
        // return numbers.toString();

        return numbers
                .stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (min != game.min) return false;
        if (max != game.max) return false;
        return numbers != null ? numbers.equals(game.numbers) : game.numbers == null;
    }

    @Override
    public int hashCode() {
        int result = numbers != null ? numbers.hashCode() : 0;
        result = 31 * result + min;
        result = 31 * result + max;
        return result;
    }
}
