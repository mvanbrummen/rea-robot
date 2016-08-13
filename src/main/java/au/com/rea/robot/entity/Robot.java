package au.com.rea.robot.entity;

import au.com.rea.robot.enumeration.Direction;

public class Robot {

    private Point position;
    private Direction direction;
    private Table table;

    public Robot(Table table) {
        this.table = table;
    }

    public boolean hasBeenPlaced() {
        return position != null;
    }

    public void place(int x, int y, Direction direction) {
        Point newPoint = position == null ? new Point(x, y) : position.translate(x, y);
        if (table.isWithinBounds((newPoint))) {
            setPosition(newPoint);
            setDirection(direction);
        }
    }

    public void move() {
        Point newPoint = position.translate(direction.getDx(), direction.getDy());
        if (table.isWithinBounds(newPoint)) {
            setPosition(newPoint);
        }
    }

    public void left() {
        direction = direction.rotateLeft();
    }

    public void right() {
        direction = direction.rotateRight();
    }

    public String report() {
        return String.format("%s,%s\n", position.toString(), direction.toString());
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

}