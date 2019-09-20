package org.improving.tag.commands;

import org.springframework.stereotype.Component;

@Component //telling Spring this is the object that I want to register with SpringContext
public class LookCommand extends BaseEmoteCommand {
    public LookCommand() {
        super("look", "You look around");
    }
}
