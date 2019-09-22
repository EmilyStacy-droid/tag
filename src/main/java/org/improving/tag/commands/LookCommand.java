package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component //telling Spring this is the object that I want to register with SpringContext
public class LookCommand extends BaseEmoteCommand {
    public LookCommand(InputOutput io) {
        super("look", "You look around.", io);
    }
}
