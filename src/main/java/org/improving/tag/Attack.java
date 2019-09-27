package org.improving.tag;

import org.improving.tag.commands.Command;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Attack implements Command {
    private InputOutput io;

    public Attack(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        return (input==null?"":input).trim().equalsIgnoreCase("attack");
    }

    @Override
    public void execute(String input, Game game) {
        var adversary = game.getPlayer().getLocation().getAdversary();
        var damage = adversary.getDamageTakenProperty();

        if (adversary == null) {
            io.displayText("Attack what?");
        } else {
            Random r = new Random();
            int ranN = r.nextInt(101);
            ranN +=1;
            if(ranN <=20) {
                adversary.setHitPoints(adversary.getHitPoints() - 10);
                damage = damage +10;
                io.displayText("Sauron's remaining point is " + adversary.getHitPoints());

            }else {
                io.displayText("Attack has missed");
            }

        }
    }
}
