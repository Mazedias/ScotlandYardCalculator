package model.util.exceptions;

import view.InputOutputHandler;

public class ToMuchMatches extends Exception {

    public ToMuchMatches(String message) {
        InputOutputHandler.printDebugMessage(message);
    }

}
