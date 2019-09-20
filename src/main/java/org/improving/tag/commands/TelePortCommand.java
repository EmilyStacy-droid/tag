package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class TelePortCommand extends BaseEmoteCommand {
    public TelePortCommand(InputOutput io) {
        super("teleport", "You phase out of existence", io);
    }

    }

