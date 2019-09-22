import org.improving.tag.commands.ReturnAdverb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReturnAdverbTests {
    ReturnAdverb target;
    TestInputOutput io;
    @BeforeEach
    public void arrange(){
        //Arrange
        //DanceCommand(type) has been mentioned on the other side of operator, so use var instead
        io = new TestInputOutput();
        target = new ReturnAdverb (io);
    }

    @Test
    public void execute_should_display_pig_Latin(){
        //Act
        target.execute("pl roll");
        //Assert
        assertEquals("ollray", io.lastText);
    }
    @Test
    public void execute_should_display_pig_Latin_two_words_above(){
        target.execute("pl have fun y'all");
        assertEquals("avefuny'allhay", io.lastText);
    }
    @Test
    public void isValid_should_be_true_when_input_is_pl_with_a_word() {

        //Act
        var result = target.isValid("pl roll");
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar(){
        //Act
        var result = target.isValid("foobar");
        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_null(){
        //Act
        var result = target.isValid(null);
        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_pl_with_spaces() {
        //Act
        var result = target.isValid("   pl fun   ");
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_pl_with_caps() {
        //Act
        var result = target.isValid("pL FUN");
        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_only_one_word(){
        //Act
        var result = target.isValid("pl");
        //Assert
        assertFalse(result);
    }

}

