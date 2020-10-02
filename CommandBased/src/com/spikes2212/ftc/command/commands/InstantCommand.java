package com.spikes2212.ftc.command.commands;

import com.spikes2212.ftc.command.Command;
import com.spikes2212.ftc.command.Subsystem;

/**
 * A command that runs instantly.
 */
public class InstantCommand extends Command {

    /**
     * The function that this command runs.
     */
    private final Runnable runnable;

    public InstantCommand(Runnable runnable, Subsystem... requirements) {
        this.runnable = runnable;
        require(requirements);
    }

    @Override
    public void init() {
        runnable.run();
    }

    @Override
    public boolean isDone() {
        return true;
    }
}
