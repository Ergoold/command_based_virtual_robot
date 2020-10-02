package com.spikes2212.ftc.command.groups;

import com.spikes2212.ftc.command.Command;

import java.util.Arrays;

public class SequentialCommandGroup extends CommandGroup {

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

    private void initCurrentCommand() {
        if (currentCommandIndex < commands.size()) commands.get(currentCommandIndex).init();
    }
}
