package au.com.rea.robot.entity;

import au.com.rea.robot.enumeration.Direction;

/**
 * The Robot class has a point and direction to hold the current state and has
 * a reference to a Table object which is what the robot is moving across.
 *
 * @author Michael Van Brummen
 * @version 1.0
 */
public class Robot {

    private Point position;
    private Direction direction;
    private Table table;

    /**
     * Constructs an instance of Robot and accepts a reference to a Table object.
     *
     * @param table The surface that this robot is moving across.
     */
    public Robot(Table table) {
        this.table = table;
    }

    /**
     * Returns if the robot has been placed on the surface.
     *
     * @return Returns the hasBeenPlaced state flag
     */
    public boolean hasBeenPlaced() {
        return position != null;
    }

    /**
     * Place the robot at point (x, y), facing direction.
     *
     * @param x         Place at x coordinate.
     * @param y         Place at y coordinate.
     * @param direction Face in direction.
     */
    public void place(int x, int y, Direction direction) {
        Point newPoint;
        if (hasBeenPlaced()) {
            newPoint = position.translate(x, y);
        } else {
            newPoint = new Point(x, y);
        }
        if (table.isWithinBounds(newPoint)) {
            setPosition(newPoint);
            setDirection(direction);
        }
    }

    /**
     * Move the robot in the direction it's facing.
     */
    public void move() {
        Point newPoint = position.translate(direction.getDx(), direction.getDy());
        if (table.isWithinBounds(newPoint)) {
            setPosition(newPoint);
        }
    }

    /**
     * Rotate the direction of the robot to the left.
     */
    public void left() {
        setDirection(direction.rotateLeft());
    }

    /**
     * Rotate the direction of the robot to the right.
     */
    public void right() {
        setDirection(direction.rotateRight());
    }

    /**
     * Returns the position and direction of the robot in the form x,y,{NSEW}.
     *
     * @return The position and direction of the robot.
     */
    public String report() {
        String report = "";
        if (hasBeenPlaced()) {
            report = String.format("%s,%s\n", position.toString(), direction.toString());
        }
        return report;
    }

    /**
     * Getter for Direction.
     *
     * @return Return the current direction.
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Setter for Direction.
     *
     * @param direction Set Direction to direction.
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Getter for Position.
     *
     * @return Return the current Position.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Setter for Position.
     *
     * @param position Set Position to position.
     */
    public void setPosition(Point position) {
        this.position = position;
    }

}
