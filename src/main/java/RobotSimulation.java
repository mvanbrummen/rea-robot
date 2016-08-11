import java.util.Scanner;

public class RobotSimulation {
    public static void main(String[] args) {
        Robot robot = new Robot();
        TableTopGrid grid = new TableTopGrid(robot);

        Scanner input = new Scanner(System.in);
        String cmd;
        boolean simulationRunning = true;
        while (simulationRunning) {
            cmd = input.nextLine();
            if (cmd.startsWith("PLACE")) {
                cmd = cmd.replace("PLACE ", "");
                String[] params = cmd.split(",");
                int x = Integer.parseInt(params[0]);
                int y = Integer.parseInt(params[1]);
                grid.getRobot().place(x, y, Robot.Heading.valueOf(params[2]));
            } else {
                if (grid.getRobot().hasBeenPlaced()) {
                    switch (cmd) {
                        case "MOVE":
                            grid.getRobot().move();
                            break;
                        case "LEFT":
                            grid.getRobot().left();
                            break;
                        case "RIGHT":
                            grid.getRobot().right();
                            break;
                        case "REPORT":
                            grid.getRobot().report();
                            break;
                    }
                }
            }
        }
    }
}
