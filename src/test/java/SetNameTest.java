

import org.improving.tag.Game;
import org.improving.tag.commands.MoveCommand;
import org.improving.tag.commands.setNameCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetNameTest {
    setNameCommand target;
    TestInputOutput io;
    @BeforeEach
    public void arrange(){
        //Arrange
        //DanceCommand(type) has been mentioned on the other side of operator, so use var instead
        io = new TestInputOutput();
        target = new setNameCommand (io);
    }
    @Test
    public void isValid_should_be_true_when_input_is_setName() {

        //Act
        var result = target.isValid("@set name=Fluefedor",new Game(null,null));
        //Assert
        assertTrue(result);
    }
    @Test
    public void execute_should_display_name(){

        //Act
        target.execute("@setName=Fluefedor",new Game(null,null));
        //Assert
        assertEquals("Your name is now Fluefedor.", io.lastText);
    }

    @Test
    public void execute_should_display_all_words_with_spaces(){
        //Act
        target.execute("  @setname=Fluefedor  ", new Game(null,null));
        //Assert
        assertEquals("Your name is now Fluefedor.", io.lastText);
    }

    @Test
    public void execute_should_display_equal_sign(){
        //Act
        var result =target.isValid("@setname Bob", new Game(null,null));
        //Assert
        assertFalse(result);
    }


}
