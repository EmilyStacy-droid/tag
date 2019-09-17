package org.improving.tag;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //[type] [name]; => var declaration in Java
        //[type] [name] = [value]; => assigned an initial value
        //In Java class starts with a uppercase (convention)
        //primitive type don't follow upper case convention like char, int (better with memory management for computers)
        //String and Scanner for example are NOT primitive type
        //input = input.trim() => set all input with a trimmed value
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
                System.out.println("Huh? I don't understand");
            }
            // equalsIgnoreCase():https://www.w3resource.com/java-tutorial/string/string_equalsignorecase.php



/*break won't run codes after the break line in the loop; return will directly run the last line of the code;boolean will run all the codes until the method ends
 System.out.println("Command processed"); continue will jump back to the condition*/
        }
    }
}
