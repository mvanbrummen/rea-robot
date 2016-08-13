package au.com.rea.robot;

import au.com.rea.robot.entity.Point;
import au.com.rea.robot.entity.Robot;
import au.com.rea.robot.entity.Table;
import au.com.rea.robot.helper.CommandHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RobotSimulationTest {

    private Table table;
    private Robot robot;
    private CommandHelper commandHelper;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        this.table = new Table(new Point(0, 0), new Point(4, 4));
        this.robot = new Robot(table);
        this.commandHelper = new CommandHelper(robot);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void scenario1() {
        assertCommands("0,1,NORTH\n", "PLACE 0,0,NORTH", "MOVE", "REPORT");
    }

    @Test
    public void scenario2() {
        assertCommands("0,0,WEST\n", "PLACE 0,0,NORTH", "LEFT", "REPORT");
    }

    @Test
    public void scenario3() {
        assertCommands("3,3,NORTH\n", "PLACE 1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT");
    }

    @Test
    public void scenario4() {
        assertCommands("0,0,SOUTH\n", "PLACE 0,0,SOUTH", "MOVE", "MOVE", "MOVE", "REPORT");
    }

    @After
    public void cleanup() {
        System.setOut(null);
    }

    private void assertCommands(String expected, String... commands) {
        for (String command : commands) {
            commandHelper.parseCommand(command);
        }
        Assert.assertEquals(expected, outContent.toString());
    }

}