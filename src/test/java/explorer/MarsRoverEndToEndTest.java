package explorer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("EndToEndTest")
public class MarsRoverEndToEndTest {

    @Test
    public void navigatesTheTerrain()
    {
        //Arrange
        String commands = "MMRMMRMRRMLM";
        MarsRover.setX(3);
        MarsRover.setY(3);
        MarsRover.setDir("E");

        //Act

        for (char command : commands.toCharArray()) {
            MarsRover.rove(command);
        }
        //Assert

        Assertions.assertEquals(5,MarsRover.getX());
        Assertions.assertEquals(2,MarsRover.getY());
        Assertions.assertEquals("N",MarsRover.getDir());
    }
}
