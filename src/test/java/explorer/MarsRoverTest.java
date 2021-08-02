package explorer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@Tag("UnitTest")
public class MarsRoverTest {

    @ParameterizedTest
    @MethodSource("provideRoverInput")
    public void turnsRover(String testName,String currentDir,char command,String expectedDir)
    {
        //Given
        MarsRover.setX(3);
        MarsRover.setY(3);
        MarsRover.setDir(currentDir);
        //When
        MarsRover.rove(command);
        //Then
        Assertions.assertEquals(3,MarsRover.getX());
        Assertions.assertEquals(3,MarsRover.getY());
        Assertions.assertEquals(expectedDir,MarsRover.getDir());
    }

    @ParameterizedTest
    @MethodSource("provideRoverInputForMovement")
    public void MoveRover(String testName,int x,int y,String currentDir,char command,int expectedX,int expectedY,String expectedDir)
    {
        //Given
        MarsRover.setX(x);
        MarsRover.setY(y);
        MarsRover.setDir(currentDir);
        //When
        MarsRover.rove(command);
        //Then
        Assertions.assertEquals(expectedX,MarsRover.getX());
        Assertions.assertEquals(expectedY,MarsRover.getY());
        Assertions.assertEquals(expectedDir,MarsRover.getDir());
    }
    private static Stream<Arguments> provideRoverInputForMovement() {
        return Stream.of(
                Arguments.of("moveRoverFromOriginEastward",0,0,"E",'M',1,0,"E"),
                Arguments.of("moveRoverFromOriginWestward",0,0,"W",'M',-1,0,"W"),
                Arguments.of("moveRoverFromOriginSouthward",0,0,"S",'M',0,-1,"S"),
                Arguments.of("moveRoverFromOriginNorthward",0,0,"N",'M',0,1,"N")
        );
    }

    private static Stream<Arguments> provideRoverInput() {
        return Stream.of(
                Arguments.of("turnsRoverLeftFromEastPointingToNorth","E",'L',"N"),
                Arguments.of("turnsRoverLeftFromSouthPointingToEast","S",'L',"E"),
                Arguments.of("turnsRoverLeftFromWestPointingToSouth","W",'L',"S"),
                Arguments.of("turnsRoverLeftFromNorthPointingToWest","N",'L',"W"),

                Arguments.of("turnsRoverRightFromEastPointingToSouth","E",'R',"S"),
                Arguments.of("turnsRoverRightFromSouthPointingToWest","S",'R',"W"),
                Arguments.of("turnsRoverRightFromWestPointingToNorth","W",'R',"N"),
                Arguments.of("turnsRoverRightFromNorthPointingToEast","N",'R',"E")
        );
    }
}
