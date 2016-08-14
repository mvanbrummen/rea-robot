package au.com.rea.robot;

import au.com.rea.robot.entity.Point;
import au.com.rea.robot.entity.Robot;
import au.com.rea.robot.entity.Table;
import au.com.rea.robot.helper.CommandHelper;

import java.util.Scanner;

/**
 * The main class and entry point for the RobotSimulation program.
 *
 * @author Michael Van Brummen
 * @version 1.0
 */
public class RobotSimulation {

    /**
     * This is the main method that provides an overarching
     * view of the main loop and instantiates all the entities needed.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        final String PROMPT = "> ";
        Table table = new Table(new Point(0, 0), new Point(4, 4));
        Robot robot = new Robot(table);

        CommandHelper commandHelper = new CommandHelper(robot);
        Scanner input = new Scanner(System.in);

        while (commandHelper.isReadyToParseCommand()) {
            System.out.print(PROMPT);
            try {
                commandHelper.parseCommand(input.nextLine());
            } catch (IllegalArgumentException ex) {
                commandHelper.printUsage();
            } catch (ArrayIndexOutOfBoundsException ex) {
                commandHelper.printUsage();
            }
        }
    }

}
