package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class DanceCommand extends BaseEmoteCommand {
    //make a constructor w/super && take a parameter inputoutput io=>3 parameters in BaseEmoteCommand
    public DanceCommand(InputOutput io){
        super("dance", "you dance around",io, "d", "ance", "dance");
    }
}

