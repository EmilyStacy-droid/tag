package org.improving.tag;

import java.util.Date;
import java.util.Scanner;

public class Game {
    private Date startTime;
    private Date endTime;
    //constructor is invoked by keyword New
    public Game(int maxInventory){
        this(maxInventory,21);

    }

    public Game (int maxInventory, int playerAge) {

        System.out.println("Ran the constructor, Maximum inventory is " + maxInventory);
        System.out.println("The player's age is " + playerAge);
    }

    public Date getStartTime() {
        return startTime;
    }

    private void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void run ()  {
        Scanner scanner = new Scanner(System.in);
        this.setStartTime(new Date());

        boolean loop = true;
        while(loop) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            //conditional statement
            if (input.equals("look")) {
                System.out.println("You look around.");
            }else if (input.equals("inventory")) {
                System.out.println("You are carrying nothing.");
            }else if (input.equalsIgnoreCase("dance")) {
                System.out.println("You dance around.");
            } else if (input.equalsIgnoreCase("jump")) {
                System.out.println("You jump in the air.");
            }else if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye.");
                loop =false;
            }else {
                System.out.println("Huh? I don't understand.");
            }
        }
        this.setEndTime(new Date());
    }



}