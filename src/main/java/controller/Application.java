package controller;

import model.util.Constants;
import view.InputOutputHandler;

/**
 * Scotland Yard simulation with build-in tools to do positional analysis
 * @author Mathias
 * @version 1.0
 */
public class Application {

    public static void main(String[] args) {

        if (args.length <= 1) {
            InputOutputHandler.printError(Constants.INVALID_START_ARGS_MESSAGE);
            return;
        }

        ProgramHandler programHandler = new ProgramHandler(args);
        programHandler.run();
    }

}
