
public class TableTopGrid {

    private Robot robot;
    private final int MaxX = 5;
    private final int MaxY = 5;
    private Point[][] points;

    public TableTopGrid(Robot robot) {
        this.robot = robot;
        this.points = new Point[MaxX][MaxY];
        initGrid();
    }

    public void initGrid() {
        for (int i = 0; i < MaxX; i++) {
            for (int y = 0; y < MaxY; y++) {
                points[i][y] = new Point(i, y);
            }
        }
    }

    public Robot getRobot() {
        return this.robot;
    }

}
