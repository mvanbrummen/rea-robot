package au.com.rea.robotsimulation.helper;

import au.com.rea.robotsimulation.entity.TableTopGrid;
import au.com.rea.robotsimulation.enumeration.Direction;

public class CommandHelper {

    private TableTopGrid grid;
    private boolean isReadyToParseCommand;

    public CommandHelper(TableTopGrid grid) {
        this.isReadyToParseCommand = true;
        this.grid = grid;
    }

    public void parseCommand(String cmd) {
        if (cmd.startsWith("PLACE")) {
            cmd = cmd.replace("PLACE ", "");
            String[] params = cmd.split(",");
            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            grid.getRobot().place(x, y, Direction.valueOf(params[2]));
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
                    case "QUIT":
                        isReadyToParseCommand = false;
                        break;
                }
            }
        }
    }

    public boolean isReadyToParseCommand() {
        return isReadyToParseCommand;
    }

}
