import org.improving.tag.FileSystemAdapter;
import org.improving.tag.Game;
import org.improving.tag.SaveGameFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SaveGameFactoryTests {
    private TestInputOutput io;
    private FileSystemAdapter fsa;
    private SaveGameFactory target;
    private Game g;
@BeforeEach
public void setup() {
    io = new TestInputOutput();
    fsa = mock(FileSystemAdapter.class);
    target = new SaveGameFactory(fsa, io);
    g = new Game(null, io, target);
}
    @Test
    public void save_should_perserve_location_name() throws IOException {
        //Arrange

        Class<Map<String,String>> dictClass =
                (Class<Map<String, String>>)(Class)Map.class;
        ArgumentCaptor<Map<String,String>> contentCaptor =
                ArgumentCaptor.forClass(dictClass);
        when(fsa.saveToFile(any())).thenReturn("this is dumb");


        //Act
        String path = target.save(g);

        //Assert
        verify(fsa).saveToFile(contentCaptor.capture());
        var loc = contentCaptor.getValue().get("location");
        assertEquals("The Deathly Hallows", loc);
        assertNotNull(path);
        assertNotEquals(" ",path);
    }

    @Test
    public void load_should_load_save_file() throws IOException {
        //arrange
        String path = "thisisafakepath";
        //Map of == testingMap.put(key,value)
        when(fsa.loadFile(path)).thenReturn(Map.of("location","The Amazon"));
        //act
        target.load(path, g);
        //assert
        assertEquals("The Amazon",g.getPlayer().getLocation().getName());
    }
}
