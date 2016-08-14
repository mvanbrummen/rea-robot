package au.com.rea.robot.helper;

import au.com.rea.robot.entity.Robot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class CommandHelperTest {

    private CommandHelper commandHelper;
    private Robot mockRobot;

    @Before
    public void setup() {
        this.mockRobot = mock(Robot.class);
        this.commandHelper = new CommandHelper(mockRobot);
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
