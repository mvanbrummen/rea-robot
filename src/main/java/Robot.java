import java.util.Arrays;
import java.util.List;

public class Robot {

    public enum Heading {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

    private Point currentPosition;
    private Heading currentHeading;

    public boolean isMoveValid() {
        return true;
    }

    public boolean hasBeenPlaced() {
        return currentPosition != null;
    }

    public void place(int x, int y, Heading heading) {
        this.currentPosition = new Point(x, y);
        this.currentHeading = heading;
    }

    public void move() {
        if (isMoveValid()) {
            switch (currentHeading) {
                case NORTH:
                    currentPosition.setY(currentPosition.getY() + 1);
                    break;
                case SOUTH:
                    currentPosition.setY(currentPosition.getY() - 1);
                    break;
                case EAST:
                    currentPosition.setX(currentPosition.getX() + 1);
                    break;
                case WEST:
                    currentPosition.setX(currentPosition.getX() - 1);
                    break;
            }
        }
    }

    public void left() {
        List headings = Arrays.asList(Heading.values());
        int idx = headings.indexOf(currentHeading);
        currentHeading = idx == 0 ? (Heading) headings.get(headings.size() - 1) : (Heading) headings.get(idx - 1);
    }

    public void right() {
        List headings = Arrays.asList(Heading.values());
        int idx = headings.indexOf(currentHeading);
        currentHeading = idx == headings.size() - 1 ? (Heading) headings.get(0) : (Heading) headings.get(idx + 1);
    }

    public void report() {
        System.out.printf("%d,%d,%s\n", currentPosition.getX(), currentPosition.getY(), currentHeading.name());
    }

}
