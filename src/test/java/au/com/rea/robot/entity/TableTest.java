package au.com.rea.robot.entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TableTest {

    private Table table;

    @Before
    public void setup() {
        this.table = new Table(new Point(0, 0), new Point(4, 4));
    }

    @Test
    public void whenMinMaxCorrectThenObjectCreated() {
        new Table(new Point(0, 0), new Point(4, 4));
        Assert.assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMaxXLessThanThenException() {
        new Table(new Point(0, 0), new Point(-1, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMaxYLessThanThenException() {
        new Table(new Point(0, 0), new Point(4, -1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMinXGreaterThanThenException() {
        new Table(new Point(10, 0), new Point(4, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMinYGreaterThanThenException() {
        new Table(new Point(0, 10), new Point(4, 4));
    }

    @Test
    public void whenPointWithinBoundsThenTrue() {
        Assert.assertTrue(table.isWithinBounds(new Point(1, 1)));
    }

    @Test
    public void whenPointEqualToLowerBoundThenTrue() {
        Assert.assertTrue(table.isWithinBounds(new Point(0, 0)));
    }

    @Test
    public void whenPointEqualToUpperBoundThenTrue() {
        Assert.assertTrue(table.isWithinBounds(new Point(4, 4)));
    }

    @Test
    public void whenXGreaterThanUpperBoundThenFalse() {
        Assert.assertFalse(table.isWithinBounds(new Point(5, 0)));
    }

    @Test
    public void whenYGreaterThanUpperBoundThenFalse() {
        Assert.assertFalse(table.isWithinBounds(new Point(0, 5)));
    }

    @Test
    public void whenXLessThanLowerBoundThenFalse() {
        Assert.assertFalse(table.isWithinBounds(new Point(-1, 0)));
    }

    @Test
    public void whenYLessThanLowerBoundThenFalse() {
        Assert.assertFalse(table.isWithinBounds(new Point(0, -1)));
    }

}
