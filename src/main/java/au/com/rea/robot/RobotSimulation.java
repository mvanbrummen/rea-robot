package au.com.rea.robot;

import au.com.rea.robot.entity.Point;
import au.com.rea.robot.entity.Robot;
import au.com.rea.robot.entity.Table;
import au.com.rea.robot.helper.CommandHelper;

import java.util.Scanner;

public class RobotSimulation {
    public static void main(String[] args) {
        final String PROMPT = "> ";
        Table table = new Table(new Point(0, 0), new Point(4, 4));
        Robot robot = new Robot(table);

        CommandHelper commandHelper = new CommandHelper(robot);
        Scanner input = new Scanner(System.in);

        while (commandHelper.isReadyToParseCommand()) {
            System.out.print(PROMPT);
            commandHelper.parseCommand(input.nextLine());
        }
    }

}
