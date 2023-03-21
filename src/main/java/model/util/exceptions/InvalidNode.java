package model.util.exceptions;

import view.InputOutputHandler;

public class InvalidNode extends Exception {

    public InvalidNode(String message) {
        InputOutputHandler.printDebugMessage(message);
    }

}
