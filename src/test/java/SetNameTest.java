

import org.improving.tag.Game;
import org.improving.tag.Player;
import org.improving.tag.WorldBuilder;
import org.improving.tag.commands.MoveCommand;
import org.improving.tag.commands.setNameCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class SetNameTest {
    setNameCommand target;
    TestInputOutput io;
    Game game;



    @BeforeEach
    public void arrange(){
        //Arrange
        //DanceCommand(type) has been mentioned on the other side of operator, so use var instead
        io = new TestInputOutput();
        target = new setNameCommand (io);
        game = mock(Game.class);

    }
    @Test
    public void isValid_should_be_true_when_input_is_setName() {

        //Act
        var result = target.isValid("@set name=Fluefedor", game);
        //Assert
        //verify(player).setName(anyString());
        //verify(game,times(2)).getPlayer();
        assertTrue(result);
    }
    @Test
    public void execute_should_display_name(){
        //in the test we don't need to worry about the location yet, so put "null here"
        Player player = new Player(null);
        player.setName("hi");
        player.setHitPoints(50);
        player = spy(player);//get back a child object ;
        //decorator: get an object and talk through the frame
        when(game.getPlayer()).thenReturn(player);
        //Act
        target.execute("@setName=Fluefedor", game);
        //Assert
        verify(player).setName("Fluefedor");
        //verify(game, times(2)).getPlayer();=>getPlayer twice is not what the test is measured
        //assertEquals("Your name is now Fluefedor.", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_with_spaces(){
        //Act
        target.execute("  @setname=Fluefedor  ", new Game(null,null, null, null));
        //Assert
        assertEquals("Your name is now Fluefedor.", io.lastText);
    }

    @Test
    public void execute_should_display_equal_sign(){
        //Act
        var result =target.isValid("@setname Bob", game);
        //Assert
        assertFalse(result);
    }


}
