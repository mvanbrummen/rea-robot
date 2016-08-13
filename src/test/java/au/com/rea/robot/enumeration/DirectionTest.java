package au.com.rea.robot.enumeration;

import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void whenRotateDirectionRightThenCorrectDirection() {
        Assert.assertEquals(Direction.EAST, Direction.NORTH.rotateRight());
        Assert.assertEquals(Direction.SOUTH, Direction.EAST.rotateRight());
        Assert.assertEquals(Direction.WEST, Direction.SOUTH.rotateRight());
        Assert.assertEquals(Direction.NORTH, Direction.WEST.rotateRight());
    }

    @Test
    public void whenRotateDirectionLeftThenCorrectDirection() {
        Assert.assertEquals(Direction.WEST, Direction.NORTH.rotateLeft());
        Assert.assertEquals(Direction.NORTH, Direction.EAST.rotateLeft());
        Assert.assertEquals(Direction.EAST, Direction.SOUTH.rotateLeft());
        Assert.assertEquals(Direction.SOUTH, Direction.WEST.rotateLeft());
    }

    @Test
    public void whenGetTransformThenCorrectDxAndDy() {
        Assert.assertEquals(0, Direction.NORTH.getDx());
        Assert.assertEquals(1, Direction.EAST.getDx());
        Assert.assertEquals(0, Direction.SOUTH.getDx());
        Assert.assertEquals(-1, Direction.WEST.getDx());
        Assert.assertEquals(1, Direction.NORTH.getDy());
        Assert.assertEquals(0, Direction.EAST.getDy());
        Assert.assertEquals(-1, Direction.SOUTH.getDy());
        Assert.assertEquals(0, Direction.WEST.getDy());
    }

}
