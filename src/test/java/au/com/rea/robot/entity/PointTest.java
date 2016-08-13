package au.com.rea.robot.entity;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void whenTranslatedPointPositivelyThenPointMovedUp() {
        assertTranslate(new Point(1, 1), 1, 1);
    }

    @Test
    public void whenTranslatedPointNegativelyThenPointMovedDown() {
        assertTranslate(new Point(-1, -1), -1, -1);
    }

    @Test
    public void whenTranslatedZeroThenPointUnmoved() {
        assertTranslate(new Point(0, 0), 0, 0);
    }

    @Test
    public void whenTranslatedXThenXMoved() {
        assertTranslate(new Point(1, 0), 1, 0);
    }

    @Test
    public void whenTranslatedYThenYMoved() {
        assertTranslate(new Point(0, 1), 0, 1);
    }

    @Test
    public void whenEqualPointComparedThenTrue() {
        Assert.assertTrue(new Point(0, 0).equals(new Point(0, 0)));
    }

    @Test
    public void whenUnequalPointComparedThenFalse() {
        Assert.assertFalse(new Point(0, 0).equals(new Point(666, 666)));
    }

    @Test
    public void whenToStringThenCorrectString() {
        Assert.assertEquals("123,456", new Point(123, 456).toString());
    }

    private void assertTranslate(Point expected, int dx, int dy) {
        Point point = new Point(0, 0);
        point = point.translate(dx, dy);
        Assert.assertEquals(expected, point);
    }

}
