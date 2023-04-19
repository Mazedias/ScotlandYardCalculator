package controller;

import model.game.GameHandler;
import model.graph.GraphHandler;
import model.util.Constants;
import model.util.exceptions.InvalidNode;
import view.InputOutputHandler;

/**
 * Contains logic and controls program flow
 * @author Mathias
 */
public class ProgramHandler {

    private final GameHandler gameHandler;
    private final GraphHandler graphHandler;
    private boolean running;

    public ProgramHandler(String[] args) {
        this.gameHandler = new GameHandler();
        this.graphHandler = GraphHandler.getINSTANCE();

        this.running = true;

        this.evaluateArguments(args);
    }

    public void run() {
        // Print welcome message
        InputOutputHandler.printMessage(Constants.WELCOME_MESSAGE);

        while (this.running) {
            // Program loop

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

        if (args.length < 2) { // Only a MrX is added
            try {
                this.gameHandler.addMrX(graphHandler.findNode(Integer.parseInt(args[0])));
            } catch (InvalidNode | NumberFormatException ex) {
                ex.printStackTrace();
                InputOutputHandler.printError(Constants.INVALID_START_ARGS_MESSAGE);
                this.exit();
                return;
            }
        }

        if (args.length == 2) {
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

        }
    }

    public void exit() {
        InputOutputHandler.printMessage(Constants.EXIT_MESSAGE);
        this.running = false;
    }
}
