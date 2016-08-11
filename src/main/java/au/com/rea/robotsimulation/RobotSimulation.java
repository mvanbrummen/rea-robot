package au.com.rea.robotsimulation;

import au.com.rea.robotsimulation.entity.Robot;
import au.com.rea.robotsimulation.entity.TableTopGrid;
import au.com.rea.robotsimulation.helper.CommandHelper;

import java.util.Scanner;

public class RobotSimulation {
    public static void main(String[] args) {
        final String PROMPT = "> ";
        Robot robot = new Robot();
        TableTopGrid grid = new TableTopGrid(robot);

        CommandHelper commandHelper = new CommandHelper(grid);
        Scanner input = new Scanner(System.in);

        while (commandHelper.isReadyToParseCommand()) {
            System.out.print(PROMPT);
            commandHelper.parseCommand(input.nextLine());
        }
    }

}
