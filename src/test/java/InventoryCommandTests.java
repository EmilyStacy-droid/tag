import org.improving.tag.commands.InventoryCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryCommandTests {
    InventoryCommand target;
    TestInputOutput io;
    @BeforeEach
    public void arrange(){
        io = new TestInputOutput();
        target = new InventoryCommand (io);
    }
    @Test
    public void execute_should_return_phrase() {
        //Act
        target.execute(null, null);
        //Assert
        assertEquals("You are carrying nothing.", io.lastText);
    }

    @Test
    public void isValid_should_be_true_when_input_is_inventory() {

        //Act
        var result = target.isValid("inventory", null);
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
    public void isValid_should_be_true_when_input_is_inventory_with_spaces() {
        //Act
        var result = target.isValid("   inventory   ", null);
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_inventory_with_caps() {
        //Act
        var result = target.isValid("invenTORY", null);
        //Assert
        assertTrue(result);
    }
}
