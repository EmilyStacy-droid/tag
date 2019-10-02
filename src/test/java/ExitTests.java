import org.improving.tag.Exit;
import org.improving.tag.Location;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExitTests {
    @Test
    public void toString_should_include_name() {
        //Arrange
        var target = new Exit("Door", new Location());
        //Act
        var result = target.toString();
        //Assert
        assertTrue(result.contains("Door"));
    }

    @Test
    public void equals_should_be_true_when_name_and_destination_match_of_course() {
        //Arrange
        var exit1 = new Exit("Door", new Location());
        var exit2 = new Exit("Door", new Location(),"this", "intention");
        //Act
        var result = exit1.equals(exit2);
        //Assert
        assertTrue(result);
    }

    @Test
    public void equals_should_be_true_when_name_destination_match() {
        //if there are two doors with same name and destination they are equal
        //arrange
        var destination = new Location();
        //act
        var exit1 = new Exit("Door", destination);
        var exit2 = new Exit("Door", destination,"this", "intention");
        var result =exit1.equals(exit2);

        //assert
        assertTrue(result);

    }
    @Test
    public void equals_should_be_false_when_compared_to_non_exit() {
        //if there are two doors with same name and destination they are equal
        //arrange
        var destination = new Location();
        //act
        var exit1 = new Exit("Door", destination);

        var result =exit1.equals("Door");

        //assert
        assertFalse(result);

    }
}


