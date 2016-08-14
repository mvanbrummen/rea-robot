package au.com.rea.robot.entity;

/**
 * Point is a class with an x and y component used to position.
 *
 * @author Michael Van Brummen
 * @version 1.0
 */
public class Point {

    /**
     * Publicly accessible and immutable x and y components of a point.
     */
    public final int x, y;

    /**
     * Construct a point at x and y position.
     *
     * @param x x component of the point.
     * @param y y component of the point.
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Translate a point with dx and dy values and return a new point.
     *
     * @param dx Change in x.
     * @param dy Change in y.
     * @return Return a new point with the translation applied.
     */
    public Point translate(int dx, int dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    /**
     * Overridden equals method to compare points based on x and y components.
     *
     * @param o Object to test for equality.
     * @return If the object is equal to this.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        if (p.x != this.x) return false;
        if (p.y != this.y) return false;
        return true;
    }

    /**
     * Overridden toString method to return the x and y components of the
     * point as a string.
     *
     * @return X and Y components of the point as a string.
     */
    @Override
    public String toString() {
        return String.format("%d,%d", this.x, this.y);
    }

}
