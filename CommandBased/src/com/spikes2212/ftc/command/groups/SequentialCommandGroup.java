package com.spikes2212.ftc.command.groups;

import com.spikes2212.ftc.command.Command;

import java.util.Arrays;

/**
 * A command group that runs all commands in sequence, in the order they were passed into the constructor.
 */
public class SequentialCommandGroup extends CommandGroup {

    /**
     * The index of the currently running command.
     */
    private int currentCommandIndex = 0;

    public SequentialCommandGroup(Command... commands) {
        super(Arrays.asList(commands));
    }

    @Override
    public void init() {
        currentCommandIndex = 0;
        initCurrentCommand();
    }

    @Override
    public void exec() {
        if (commands.isEmpty()) return;
        Command current = commands.get(currentCommandIndex);
        current.exec();
        if (current.isDone()) {
            current.end(true);
            currentCommandIndex++;
            initCurrentCommand();
        }
    }

    @Override
    public boolean isDone() {
        return currentCommandIndex == commands.size();
    }

    @Override
    public void end(boolean done) {
        if (!done && !commands.isEmpty()) commands.get(currentCommandIndex).end(false);
    }

    /**
     * Calls the {@link Command#init} function of the command at the index {@link #currentCommandIndex} if it exists.
     */
    private void initCurrentCommand() {
        if (currentCommandIndex < commands.size()) commands.get(currentCommandIndex).init();
    }
}
