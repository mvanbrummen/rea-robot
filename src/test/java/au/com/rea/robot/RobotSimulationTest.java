package au.com.rea.robot;

import au.com.rea.robot.entity.Point;
import au.com.rea.robot.entity.Robot;
import au.com.rea.robot.entity.Table;
import au.com.rea.robot.helper.CommandHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/* Unit tests to exercise the application */
public class RobotSimulationTest {

    private Table table;
    private Robot robot;
    private CommandHelper commandHelper;

    @Before
    public void setup() {
        this.table = new Table(new Point(0, 0), new Point(4, 4));
        this.robot = new Robot(table);
        this.commandHelper = new CommandHelper(robot);
    }

    @Test
    public void whenPlacedAndMovedThenMovePosition() {
        assertCommands("0,1,NORTH\n", "PLACE 0,0,NORTH", "MOVE", "REPORT");
    }

    @Test
    public void whenPlacedAndRotatedThenChangeDirection() {
        assertCommands("0,0,WEST\n", "PLACE 0,0,NORTH", "LEFT", "REPORT");
    }

    @Test
    public void whenPlacedMultipleTimesThenPositionAtLastPlace() {
        assertCommands("4,2,WEST\n", "PLACE 0,0,NORTH", "PLACE 4,2,WEST", "REPORT");
    }

    @Test
    public void whenMoveOutOfBoundsThenPositionUnchanged() {
        assertCommands("0,0,SOUTH\n", "PLACE 0,0,SOUTH", "MOVE", "REPORT");
    }

    @Test
    public void whenMultipleMoveOutOfBoundsThenPositionUnchanged() {
        assertCommands("4,4,NORTH\n", "PLACE 4,4,NORTH", "MOVE", "MOVE", "MOVE", "MOVE", "REPORT");
    }

    @Test
    public void whenNotPlacedThenIgnore() {
        assertCommands("", "MOVE", "LEFT", "RIGHT", "MOVE", "REPORT");
    }

    private void assertCommands(String expected, String... commands) {
        for (String command : commands) {
            commandHelper.parseCommand(command);
        }
        Assert.assertEquals(expected, robot.report());
    }

}