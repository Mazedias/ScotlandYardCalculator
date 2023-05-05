package controller;

import controller.commands.CommandHandler;
import model.game.GameHandler;
import model.graph.GraphHandler;
import model.util.Constants;
import model.util.abstracts.AbstractCommand;
import model.util.exceptions.InvalidNode;
import model.util.exceptions.ToMuchMatches;
import view.InputOutputHandler;

import java.util.Arrays;

/**
 * Contains logic and controls program flow
 * @author Mathias
 */
public class ProgramHandler {

    private final GameHandler gameHandler;
    private final GraphHandler graphHandler;
    private final CommandHandler commandHandler;
    private boolean running;

    public ProgramHandler(String[] args) {
        this.gameHandler = new GameHandler();
        this.commandHandler = new CommandHandler();
        this.graphHandler = GraphHandler.getINSTANCE();

        this.running = true;

        this.evaluateArguments(args);
    }

    public void run() {
        // Print welcome message
        InputOutputHandler.printMessage(Constants.WELCOME_MESSAGE);

        // Program loop
        while (this.running) {
            // Get command
            String input = InputOutputHandler.collectInput();
            String[] splitInput = input.split(" ");
            AbstractCommand command;
            try {
                command = this.commandHandler.getCommand(splitInput[0]);
            } catch (ToMuchMatches ex) {
                ex.printStackTrace();
                InputOutputHandler.printError(Constants.INVALID_REGEX_MATCHES);
                continue;
            }


            // Execute command
            String executeMessage;
            if (splitInput.length > 1) {
                executeMessage = command.execute(
                        Arrays.copyOfRange(splitInput, 1, splitInput.length-1)
                );
            } else {
                executeMessage = command.execute();
            }

            // Print output
            if (!(executeMessage.isEmpty() || executeMessage.isBlank())) {
                System.out.println(executeMessage);
            }
        }

    }

    /**
     * Evaluates the start arguments and adds Mr X and the players to the game.
     * @param args Start arguments
     */
    private void evaluateArguments(String[] args) {

        if (args.length < 1) {
            InputOutputHandler.printError(Constants.INVALID_START_ARGS_MESSAGE);
            this.exit();
            return;
        }

        if (args.length < 2) { // Only add MrX
            try {
                this.gameHandler.addMrX(graphHandler.findNode(Integer.parseInt(args[0])));
            } catch (InvalidNode | NumberFormatException ex) {
                ex.printStackTrace();
                InputOutputHandler.printError(Constants.INVALID_START_ARGS_MESSAGE);
                this.exit();
            }
        } else if (args.length == 2) { // Add MrX and players
            String[] players = args[1].split(";");

            for (String player : players) {
                try {
                    this.gameHandler.addPlayer(graphHandler.findNode(Integer.parseInt(player)));
                } catch (InvalidNode | NumberFormatException ex) {
                    ex.printStackTrace();
                    InputOutputHandler.printError(Constants.INVALID_START_ARGS_MESSAGE);
                    this.exit();
                    return;
                }
            }
        } else { // Invalid start arguments
            InputOutputHandler.printError(Constants.INVALID_START_ARGS_MESSAGE);
            this.exit();
        }
    }

    public void exit() {
        InputOutputHandler.printMessage(Constants.EXIT_MESSAGE);
        this.running = false;
    }
}
