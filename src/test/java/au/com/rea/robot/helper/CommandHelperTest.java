package au.com.rea.robot.helper;

import au.com.rea.robot.entity.Robot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

@RunWith(MockitoJUnitRunner.class)
public class CommandHelperTest {

    private CommandHelper commandHelper;

    @Mock
    private Robot mockRobot;

    @Before
    public void setup() {
        this.commandHelper = new CommandHelper(mockRobot);
    }

    @Test
    public void whenPlaceThenRobotPlaced() {
        commandHelper.parseCommand("PLACE 0,0,NORTH");
        verify(mockRobot, times(1)).place(anyInt(), anyInt(), any());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotANumberThenIllegalArgumentException() {
        commandHelper.parseCommand("PLACE a,b,NORTH");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotEnoughValuesThenIllegalArgumentException() {
        commandHelper.parseCommand("PLACE 0,0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotAValidDirectionThenIllegalArgumentException() {
        commandHelper.parseCommand("PLACE 0,0,WESTEROS");
    }

    @Test
    public void whenRobotNotPlacedThenIgnore() {
        when(mockRobot.hasBeenPlaced()).thenReturn(false);
        commandHelper.parseCommand("MOVE");
        verify(mockRobot, never()).move();
        commandHelper.parseCommand("LEFT");
        verify(mockRobot, never()).left();
        commandHelper.parseCommand("RIGHT");
        verify(mockRobot, never()).right();
        commandHelper.parseCommand("REPORT");
        verify(mockRobot, never()).report();
    }

    @Test
    public void whenRobotPlacedThenDoActionOnRobot() {
        when(mockRobot.hasBeenPlaced()).thenReturn(true);
        commandHelper.parseCommand("MOVE");
        verify(mockRobot, times(1)).move();
        commandHelper.parseCommand("LEFT");
        verify(mockRobot, times(1)).left();
        commandHelper.parseCommand("RIGHT");
        verify(mockRobot, times(1)).right();
        commandHelper.parseCommand("REPORT");
        verify(mockRobot, times(1)).report();
    }

    @Test
    public void whenNewCommandHelperThenIsReadyToParseTrue() {
        Assert.assertTrue(commandHelper.isReadyToParseCommand());
    }

    @Test
    public void whenQUITThenIsReadyToParseFalse() {
        commandHelper.parseCommand("QUIT");
        Assert.assertFalse(commandHelper.isReadyToParseCommand());
    }

}
