package org.improving.tag.commands;

import org.improving.tag.Game;


public interface Command {
public boolean isValid(String cmdText);

public void execute (String prompt);


}
