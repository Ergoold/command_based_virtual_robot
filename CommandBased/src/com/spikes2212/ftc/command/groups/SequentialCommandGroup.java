package com.spikes2212.ftc.command.groups;

import com.spikes2212.ftc.command.Command;

import java.util.Arrays;
import java.util.List;

public class SequentialCommandGroup extends CommandGroup {

    private int currentCommandIndex = 0;

    public SequentialCommandGroup(Command... commands) {
        super(Arrays.asList(commands));
    }

    @Override
    public void init() {
        currentCommandIndex = 0;
        if (!commands.isEmpty()) get(0).init();
    }

    @Override
    public void exec() {
        if (commands.isEmpty()) return;
        Command current = get(currentCommandIndex);
        current.exec();
        if (current.isDone()) {
            current.end(true);
            currentCommandIndex++;
            if (currentCommandIndex < commands.size()) get(currentCommandIndex).init();
        }
    }

    @Override
    public boolean isDone() {
        return currentCommandIndex == commands.size();
    }

    @Override
    public void end(boolean done) {
        if (!done && !commands.isEmpty()) get(currentCommandIndex).end(false);
    }

    private Command get(int index) {
        return ((List<Command>)commands).get(index);
    }
}
