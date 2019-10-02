package org.improving.tag.commands;

import org.improving.tag.AdversaryRemoveException;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.commands.BaseAliaseCommand;
import org.improving.tag.commands.Command;
import org.improving.tag.items.Item;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand extends BaseAliaseCommand {
    private InputOutput io;

    public AttackCommand(InputOutput io) {
        super(io, "attack", "a");
        this.io = io;
    }

    @Override
    public void childExecute(String input, Game game) {
        var adversary = game.getPlayer().getLocation().getAdversary();

        if (adversary == null) {
            io.displayText("Attack what?");
            return;
        }

        var damage = adversary.getDamageTakenProperty();
        Random r = new Random();
        int ranN = r.nextInt(100);
        ranN += 1;
        if (ranN <= 20) {
            adversary.setHitPoints(adversary.getHitPoints() - 50);
            damage = damage + 50;
            io.displayText("Sauron's remaining point is " + adversary.getHitPoints());
            if (adversary.getHitPoints() <= 0) {
                io.displayText("You got an item: " + adversary.getAdversaryItemDescription());
                game.getPlayer().getInventory().addItem(adversary.getItem());
                throw new AdversaryRemoveException();
            }

        } else {
            io.displayText("Attack has missed");
        }


    }
}


