package org.improving.tag;

import java.util.Scanner;
/* example of polymorphism
      Object bar = new Game(); => cannot access to the methods of Game because bar = Object
      System.out.println((Game).bar.getStartTime()); => just in this moment make bar = Game
    */

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of main");
        Game game = new Game();
        System.out.println("Declare game");
        game.run();
        System.out.println("After run()");
        long elapsedTicks = game.getEndTime().getTime() -
            game.getStartTime().getTime();
        double elapsedSeconds = elapsedTicks / 1000.0;
        System.out.println("We were running for " + elapsedSeconds + "s.");


    }
}
