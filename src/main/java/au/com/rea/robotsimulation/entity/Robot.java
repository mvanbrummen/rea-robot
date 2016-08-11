package au.com.rea.robotsimulation.entity;

import au.com.rea.robotsimulation.enumeration.Direction;

import java.awt.Point;

public class Robot {

    private Point currentPosition;
    private Direction currentHeading;

    public boolean isMoveValid() {
        return true;
    }

    public boolean hasBeenPlaced() {
        return currentPosition != null;
    }

    public void place(int x, int y, Direction heading) {
        this.currentPosition = new Point(x, y);
        this.currentHeading = heading;
    }

    public void move() {
        if (isMoveValid()) {
            if (currentHeading == Direction.NORTH || currentHeading == Direction.SOUTH) {
                currentPosition.y *= currentHeading.getTransform();
            } else {
                currentPosition.x *= currentHeading.getTransform();
            }
        }
    }

    public void left() {
        currentHeading = currentHeading.rotateLeft();
    }

    public void right() {
        currentHeading = currentHeading.rotateRight();
    }

    public void report() {
        System.out.printf("%d,%d,%s\n", currentPosition.x, currentPosition.y, currentHeading.name());
    }

}
