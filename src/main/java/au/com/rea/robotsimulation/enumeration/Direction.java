package au.com.rea.robotsimulation.enumeration;

public enum Direction {
    NORTH(1), EAST(1), SOUTH(-1), WEST(-1);

    private int transform;

    Direction(int transform) {
        this.transform = transform;
    }

    public int getTransform() {
        return this.transform;
    }

    public Direction rotateLeft() {
        switch (this) {
            case NORTH: return WEST;
            case EAST: return NORTH;
            case SOUTH: return EAST;
            case WEST: return SOUTH;
            default: return null;
        }
    }

    public Direction rotateRight() {
        switch (this) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: return null;
        }
    }

}