package au.com.rea.robot.helper;

import au.com.rea.robot.entity.Robot;
import au.com.rea.robot.enumeration.Direction;

/**
 * Helper class to interpret user input and control an instance of robot.
 *
 * @author Michael Van Brummen
 * @version 1.0
 */
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

    /**
     * The constructor for CommandHelper class that accepts an instance of Robot
     * and sets the isReadyToParseCommand state to true.
     *
     * @param robot An instance of Robot to be controlled.
     */
    public CommandHelper(Robot robot) {
        this.isReadyToParseCommand = true;
        this.robot = robot;
    }

    /**
     * Accepts a command string that gets interpreted as behaviour for the Robot.
     *
     * @param cmd Command to be interpreted.
     * @throws IllegalArgumentException       Thrown from interpretPlaceCommand()
     * @throws ArrayIndexOutOfBoundsException Thrown from interpretPlaceCommand()
     */
    public void parseCommand(String cmd) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (cmd.equals("QUIT")) {
            isReadyToParseCommand = false;
        } else if (cmd.startsWith("PLACE")) {
            interpretPlaceCommand(cmd);
        } else {
            interpretSubsequentCommand(cmd);
        }
    }

    /**
     * Interpret place command to place robot on table.
     *
     * @param cmd The command to be interpreted.
     * @throws IllegalArgumentException       When Place arguments are incorrect.
     * @throws ArrayIndexOutOfBoundsException When incorrect number of arguments passed to Place.
     * @see IllegalArgumentException
     * @see ArrayIndexOutOfBoundsException
     */
    private void interpretPlaceCommand(String cmd) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        cmd = cmd.replace("PLACE ", "");
        String[] params = cmd.split(",");
        int x = Integer.parseInt(params[0]);
        int y = Integer.parseInt(params[1]);
        robot.place(x, y, Direction.valueOf(params[2]));
    }

    /**
     * Interpret subsequent commands that are not place.
     *
     * @param cmd The command to be interpreted.
     */
    private void interpretSubsequentCommand(String cmd) {
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

    /**
     * Returns the state flag of the CommandHelper to accept commands.
     *
     * @return Returns the state flag isReadyToParseCommand.
     */
    public boolean isReadyToParseCommand() {
        return isReadyToParseCommand;
    }


    /**
     * Prints usage statement to standard out.
     */
    public void printUsage() {
        System.out.print(usage);
    }

}
