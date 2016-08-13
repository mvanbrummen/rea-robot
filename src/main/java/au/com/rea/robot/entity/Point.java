package au.com.rea.robot.entity;

public class Point {

    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point translate(int dx, int dy) {
        return new Point(this.x + dx, this.y + dy);
    }

    @Override
    public String toString() {
        return String.format("%d,%d", this.x, this.y);
    }

}
