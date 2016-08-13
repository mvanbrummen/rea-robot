package au.com.rea.robot.entity;

public class Table {

    private final Point minPoint, maxPoint;

    public Table(Point minPoint, Point maxPoint) throws IllegalArgumentException {
        if (minPoint.x > maxPoint.x || minPoint.y > maxPoint.y) {
            throw new IllegalArgumentException("The co-ordinates of the min point must be less " +
                    "than the co-ordinates of the max point");
        }
        this.minPoint = minPoint;
        this.maxPoint = maxPoint;
    }

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
