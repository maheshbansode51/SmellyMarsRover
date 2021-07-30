package explorer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UnitTest")
public class MarsRoverTest {

    @Test
    public void turnsRoverRightFromEastPointingToSouth()
    {
        //Given
        MarsRover.setX(3);
        MarsRover.setY(3);
        MarsRover.setDir("E");
        //When
        MarsRover.rove('R');
        //Then
        Assertions.assertEquals(3,MarsRover.getX());
        Assertions.assertEquals(3,MarsRover.getY());
        Assertions.assertEquals("S",MarsRover.getDir());
    }
}
