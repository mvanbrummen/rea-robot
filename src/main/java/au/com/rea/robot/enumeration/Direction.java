package au.com.rea.robot.enumeration;

/**
 * Enum for the cardinal directions North, East, South and West.
 *
 * @author Michael Van Brummen
 * @version 1.0
 */
public enum Direction {
    NORTH(0, 1), EAST(1, 0), SOUTH(0, -1), WEST(-1, 0);

    private int dx, dy;

    /**
     * Constructor for direction accepts dy and dx integers to associate
     * a translation to a direction.
     *
     * @param dx The dx for this direction.
     * @param dy The dy for this direction.
     */
    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Getter for dx property.
     *
     * @return Return the dx of this direction.
     */
    public int getDx() {
        return dx;
    }

    /**
     * Getter for dy property.
     *
     * @return Return the dy of this direction.
     */
    public int getDy() {
        return dy;
    }

    /**
     * Rotate the current direction left and return new instance.
     *
     * @return Return the rotated direction.
     */
    public Direction rotateLeft() {
        switch (this) {
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                return null;
        }
    }

    /**
     * Rotate the current direction right and return new instance.
     *
     * @return Return the rotated direction.
     */
    public Direction rotateRight() {
        switch (this) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                return null;
        }
    }

}