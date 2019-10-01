package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.TreasureChest;
import org.improving.tag.items.Item;
import org.improving.tag.items.UniqueItems;
import org.springframework.stereotype.Component;

@Component


public class OpenTreasureChestCommand extends BaseAliaseCommand {
    private InputOutput io;
    public OpenTreasureChestCommand(InputOutput io) {
        super(io,"open", "o");
        this.io = io;
    }
    @Override
    public void childExecute(String input, Game game) {
        Item item = game.getPlayer().getLocation().openTreasureChest();
        io.displayText("You found" + item);
//        else {
//            io.displayText(getErrorMessage());
//        }

    }
    @Override
    public String getErrorMessage(){
        return"No items found. There is no treasure chest to open here";
    }
}

