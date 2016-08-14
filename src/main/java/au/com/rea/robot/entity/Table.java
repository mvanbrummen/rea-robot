package au.com.rea.robot.entity;

/**
 * Table is a class with bounding min and max points for entities to move within.
 *
 * @author Michael Van Brummen
 * @version 1.0
 */
public class Table {

    private final Point minPoint, maxPoint;

    /**
     * Construct a table with bounding min and max points.
     *
     * @param minPoint The origin of the table.
     * @param maxPoint The max boundary of the table.
     * @throws IllegalArgumentException When max point is less than min point.
     * @see IllegalArgumentException
     */
    public Table(Point minPoint, Point maxPoint) throws IllegalArgumentException {
        if (minPoint.x > maxPoint.x || minPoint.y > maxPoint.y) {
            throw new IllegalArgumentException("The co-ordinates of the min point must be less " +
                    "than the co-ordinates of the max point");
        }
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

    /**
     * Test if a point exists within the bounds of the table.
     *
     * @param point Point to test within boundaries of table.
     * @return If point is within bounds of table.
     */
    public boolean isWithinBounds(Point point) {
        if (point.x < minPoint.x || point.x > maxPoint.x) {
            return false;
        }
        if (point.y < minPoint.y || point.y > maxPoint.y) {
            return false;
        }
        return true;
    }

}
