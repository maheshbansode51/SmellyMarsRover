package explorer;
import explorer.MarsRover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MarsRoverTest {

    @Test
    public void Should_Get_NewPosition()
    {
        //Arrange
        var marsRover=new MarsRover();
        String currentPosition = "3 3 E";
        String commands = "MMRMMRMRRM";
        String[] positions = currentPosition.split(" ");
        MarsRover.setX(Integer.valueOf(positions[0]));
        MarsRover.setY(Integer.valueOf(positions[1]));
        MarsRover.setDir(positions[2]);

        //Act

        for (char command : commands.toCharArray()) {
            MarsRover.rove(command);
        }
        //Assert

        Assertions.assertEquals(5,MarsRover.getX());
        Assertions.assertEquals(1,MarsRover.getY());
        Assertions.assertEquals("E",MarsRover.getDir());
    }
}
