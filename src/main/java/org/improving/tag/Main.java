package org.improving.tag;

import java.util.Scanner;
/* example of polymorphism
      Object bar = new Game(); => cannot access to the methods of Game because bar = Object
      System.out.println((Game).bar.getStartTime()); => just in this moment make bar = Game
    */

public class Main {
    public static void main(String[] args) {
    Game game =new Game();
//    try {
//     game.run();
//    }catch(Exception ex) {
//        System.out.println("Caught an Exception");
//    }finally{
//        System.out.println("Hit the finally");
//    }
    game.run();
    long elapsedTicks = game.getEndTime().getTime() -
            game.getStartTime().getTime();
    double elapsedSeconds = elapsedTicks / 1000.0;
    System.out.println("We were running for " + elapsedSeconds + "s.");


    }
}
