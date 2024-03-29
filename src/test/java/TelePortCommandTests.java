import org.improving.tag.commands.TelePortCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TelePortCommandTests {
    TelePortCommand target;
    TestInputOutput io;
    @BeforeEach
    public void arrange() {
        io = new TestInputOutput();
        target = new TelePortCommand(io);
    }
    @Test
    public void execute_should_return_phrase() {
        //Act
        target.execute(null, null);
        //Assert
        assertEquals("You phase out of existence.", io.lastText);
    }

    @Test
    public void isValid_should_be_true_when_input_is_teleport() {

        //Act
        var result = target.isValid("teleport", null);
        //Assert
        assertTrue(result);
    }
    @Test
    public void isValid_should_be_false_when_input_is_foobar(){
        //Act
        var result = target.isValid("foobar", null);
        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_null(){
        //Act
        var result = target.isValid(null, null);
        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_teleport_with_spaces() {
        //Act
        var result = target.isValid("   teleport   ", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_teleport_with_caps() {
        //Act
        var result = target.isValid("TElePORT", null);
        //Assert
        assertTrue(result);
    }

}
