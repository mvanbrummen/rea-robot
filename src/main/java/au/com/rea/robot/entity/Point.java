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
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        if (p.x != this.x) return false;
        if (p.y != this.y) return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%d,%d", this.x, this.y);
    }

}
