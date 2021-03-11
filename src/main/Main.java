package main;

import game.Game;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 6;
        final int MIN = 1;
        final int MAX = 10;

        var game = new Game(SIZE, MIN, MAX);
        System.out.println(game);

        System.out.println(game.isLuckyNumber(5));
    }
}
