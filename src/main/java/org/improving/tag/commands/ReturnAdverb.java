package org.improving.tag.commands;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component

public class ReturnAdverb implements Command {
    private InputOutput io;
    public ReturnAdverb(InputOutput io) {this.io = io;};
    @Override
    public boolean isValid(String input) {
        if(input == null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if(parts.length ==1) return false;
        //is it the correct way to ignore the case
        return parts[0].equalsIgnoreCase("pl");
    }

    @Override
    public void execute(String input) {
        input = input.trim();
        var parts = input.split(" ");
        /*there is a bug:
        input: pl   i love your cloth
        output:  iloveyourcloth ay
         */
        var destination = input.substring(3,4);
        //io.displayText (input.substring(4)+ destination + "ay");
            String remove2ndPartTrim = input.substring(4).replaceAll("\\s+", "");
            io.displayText(remove2ndPartTrim+destination+"ay");



    }
}
