package com.spikes2212.ftc.command.groups;

import com.spikes2212.ftc.command.Command;

import java.util.*;

/**
 * A command group that runs all commands in parallel until they are all done.
 */
public class ParallelCommandGroup extends CommandGroup {

    /**
     * A list that keeps track of which commands are running (via index coordination).
     */
    private final List<Boolean> running = new ArrayList<>();

    public ParallelCommandGroup(Command... commands) {
        super(new ArrayList<>(new HashSet<>(Arrays.asList(commands))));
    }

    @Override
    public void init() {
        for (Command command : commands) {
            command.init();
            running.add(true);
        }
    }

    @Override
    public void exec() {
        for (int i = 0; i < commands.size(); i++) {
            if (running.get(i)) commands.get(i).exec();
        }
    }

    @Override
    public boolean isDone() {
        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).isDone()) running.set(i, false);
        }
        return !running.contains(true);
    }

    @Override
    public void end(boolean done) {
        if (done) return;
        for (int i = 0; i < commands.size(); i++) {
            if (running.get(i)) commands.get(i).end(false);
        }
    }
}
