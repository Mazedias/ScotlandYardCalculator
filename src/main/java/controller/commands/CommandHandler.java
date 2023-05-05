package controller.commands;

import model.annotation.AnnotationFinder;
import model.annotation.annotations.Command;
import model.util.abstracts.AbstractCommand;
import model.util.exceptions.ToMuchMatches;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandHandler {

    private List<Object> commands;

    public CommandHandler() {
        commands = new AnnotationFinder()
                .getAnnotatedClasses("controller.commands", Command.class, AbstractCommand.class);
    }

    /**
     * Matches user input to known command prefixes and finds instance of command class
     * @param input Entered command prefix of user without arguments
     * @return Returns instance of command class
     */
    public AbstractCommand getCommand(String input) throws ToMuchMatches {

        List<AbstractCommand> foundCommands = new ArrayList<>();

        for (Object command : commands) {
            AbstractCommand c = (AbstractCommand) command;

            Pattern p = Pattern.compile(c.getCommandPrefix());
            Matcher m = p.matcher(input);

            if (m.find()) {
                foundCommands.add(c);
            }
        }

        if (foundCommands.size() != 1) {
            throw new ToMuchMatches("More than one or none command matches to your input.");
        }

        return foundCommands.get(0);
    }
}
