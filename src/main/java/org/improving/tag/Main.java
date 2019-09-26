package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
/* example of polymorphism
      Object bar = new Game(); => cannot access to the methods of Game because bar = Object
      System.out.println((Game).bar.getStartTime()); => just in this moment make bar = Game
    */

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =  // this is a class from SpringContext
                new AnnotationConfigApplicationContext(SpringContext.class); //.class helps to pass around to cookie cutter=>LOOK AT SpringContext itself


        Game game = context.getBean(Game.class); //hand in the cookie cutter;Look at Game=>constructor=>parameter=>find out what they need

        game.run();

        long elapsedTicks = game.getEndTime().getTime() -
            game.getStartTime().getTime();
        double elapsedSeconds = elapsedTicks / 1000.0;
        System.out.println("We were running for " + elapsedSeconds + "s.");
        game.run();
    }
}
