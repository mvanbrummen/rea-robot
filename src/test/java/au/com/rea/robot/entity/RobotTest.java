package au.com.rea.robot.entity;

import au.com.rea.robot.enumeration.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RobotTest {

    private Robot robot;
    private Table table;

    @Before
    public void setup() {
        this.table = new Table(new Point(0, 0), new Point(4, 4));
        this.robot = new Robot(table);
    }

    @Test
    public void whenHasBeenPlacedThenTrue() {
        robot.place(0, 0, Direction.NORTH);
        Assert.assertTrue(robot.hasBeenPlaced());
    }

    @Test
    public void whenHasBeenPlacedOutOfBoundsThenFalse() {
        robot.place(-1500, 2500, Direction.NORTH);
        Assert.assertFalse(robot.hasBeenPlaced());
    }

    @Test
    public void whenHasNotBeenPlacedThenFalse() {
        Assert.assertFalse(robot.hasBeenPlaced());
    }

    @Test
    public void whenMovedWithinBoundsThenPositionChanged() {
        robot.place(0, 0, Direction.NORTH);
        robot.move();
        Assert.assertEquals(new Point(0, 1), robot.getPosition());
    }

    @Test
    public void whenMovedOutOfBoundsThenPositionUnchanged() {
        robot.place(0, 0, Direction.SOUTH);
        robot.move();
        Assert.assertEquals(new Point(0, 0), robot.getPosition());
    }

    @Test
    public void whenRightThenDirectionChanged() {
        robot.place(0, 0, Direction.NORTH);
        robot.right();
        Assert.assertEquals(Direction.EAST, robot.getDirection());
        robot.right();
        Assert.assertEquals(Direction.SOUTH, robot.getDirection());
        robot.right();
        Assert.assertEquals(Direction.WEST, robot.getDirection());
        robot.right();
        Assert.assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void whenReportThenCorrectPositionReported() {
        robot.place(0, 0, Direction.NORTH);
        Assert.assertEquals("0,0,NORTH\n" , robot.report());
        robot.move();
        Assert.assertEquals("0,1,NORTH\n" , robot.report());
        robot.left();
        Assert.assertEquals("0,1,WEST\n" , robot.report());
        robot.move();
        Assert.assertEquals("0,1,WEST\n" , robot.report());
    }

}
