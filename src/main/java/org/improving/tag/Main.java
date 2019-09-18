package org.improving.tag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    /* example of polymorphism
      Object bar = new Game(); => cannot access to the methods of Game because bar = Object
      System.out.println((Game).bar.getStartTime()); => just in this moment make bar = Game
    */

        Game game = new Game();
        System.out.println(game.getStartTime());
        scanner.nextLine();
        Game g2  = new Game();
        System.out.println(g2.getStartTime());
        System.out.println(game.getStartTime());
        System.out.println(g2.getStartTime().equals(game.getStartTime()));
        return;


//        boolean loop = true;
//        while(loop) {
//            System.out.print("> ");
//            String input = scanner.nextLine().trim();
//            //conditional statement
//            if (input.equals("look")) {
//                System.out.println("You look around.");
//            }else if (input.equals("inventory")) {
//                System.out.println("You are carrying nothing.");
//            }else if (input.equalsIgnoreCase("dance")) {
//                System.out.println("You dance around.");
//            } else if (input.equalsIgnoreCase("jump")) {
//                System.out.println("You jump in the air.");
//            }else if (input.equalsIgnoreCase("exit")) {
//                System.out.println("Goodbye.");
//                loop =false;
//            }else {
//                System.out.println("Huh? I don't understand");
//            }
//        }
    }
}
