package au.com.rea.robot.helper;

import au.com.rea.robot.entity.Robot;
import au.com.rea.robot.enumeration.Direction;

public class CommandHelper {

    private Robot robot;
    private boolean isReadyToParseCommand;
    private final String usage = "Usage:\n" +
            "    PLACE X,Y,{NSEW}\n" +
            "    MOVE\n" +
            "    LEFT\n" +
            "    RIGHT\n" +
            "    REPORT\n" +
            "    QUIT\n";

    public CommandHelper(Robot robot) {
        this.isReadyToParseCommand = true;
        this.robot = robot;
    }

    public void parseCommand(String cmd) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (cmd.equals("QUIT")) {
            isReadyToParseCommand = false;
        } else if (cmd.startsWith("PLACE")) {
            cmd = cmd.replace("PLACE ", "");
            String[] params = cmd.split(",");
            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            robot.place(x, y, Direction.valueOf(params[2]));
        } else {
            if (robot.hasBeenPlaced()) {
                switch (cmd) {
                    case "MOVE":
                        robot.move();
                        break;
                    case "LEFT":
                        robot.left();
                        break;
                    case "RIGHT":
                        robot.right();
                        break;
                    case "REPORT":
                        System.out.print(robot.report());
                        break;
                }
            }
        }
    }

    public boolean isReadyToParseCommand() {
        return isReadyToParseCommand;
    }

    public void printUsage() {
        System.out.print(usage);
    }

}
