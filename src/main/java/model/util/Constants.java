package model.util;

import view.InputOutputHandler;

public class Constants {

    // --------------------------------------------------------------------------------------------- \\
    // ----------------------------------------- Instances ----------------------------------------- \\

    /**
     * Instance of the I/O operation class
     */
    public static final InputOutputHandler INPUT_OUTPUT_HANDLER = new InputOutputHandler();

    // ----------------------------------------- Instances ----------------------------------------- \\
    // --------------------------------------------------------------------------------------------- \\



    // -------------------------------------------------------------------------------------------- \\
    // ----------------------------------------- Messages ----------------------------------------- \\

    public static final String WELCOME_MESSAGE =
            "Welcome to the Scotland-Yard-Position-Calculator. Enter 'help' for a command list";
    public static final String EXIT_MESSAGE = "Good bye";
    public static final String HELP_MESSAGE =
            "Commands: \n" +
                    Constants.COMMAND_QUIT + " : exit the program\n" +
                    Constants.COMMAND_HELP + " : get this help message\n" +
                    Constants.COMMAND_GET_ALL_PATHS + " : prints every possible path path from MrX\n" +
                    Constants.COMMAND_GET_POSSIBLE_LOCATIONS + " : prints every possible location of MrX";

    // ----------------------------------------- Messages ----------------------------------------- \\
    // -------------------------------------------------------------------------------------------- \\


    // ---------------------------------------------------------------------------------------------------- \\
    // ----------------------------------------- AbstractCommand prefixes ----------------------------------------- \\

    public static final String COMMAND_QUIT = "quit";
    public static final String QUIT_PREFIX = "^(?<commandPrefix>quit)$";
    public static final int QUIT_ARGUMENT_AMOUNT = 0;

    public static final String COMMAND_HELP = "help";
    public static final String HELP_PREFIX = "^(?<commandPrefix>help)$";
    public static final int HELP_ARGUMENT_AMOUNT = 0;

    public static final String COMMAND_GET_ALL_PATHS = "getAllPaths";
    public static final String GET_ALL_PATHS_PREFIX = "^(?<commandPrefix>getAllPaths)$";
    public static final int GET_ALL_PATHS_ARGUMENT_AMOUNT = 0;

    public static final String COMMAND_GET_POSSIBLE_LOCATIONS = "getLocations";
    public static final String GET_POSSIBLE_LOCATIONS_PREFIX = "getLocations";
    public static final int GET_POSSIBLE_LOCATIONS_ARGUMENT_AMOUNT = 0;


    // ----------------------------------------- AbstractCommand prefixes ----------------------------------------- \\
    // ---------------------------------------------------------------------------------------------------- \\



    private Constants() {
        throw new IllegalCallerException();
    }
}
