package com.spikes2212.ftc.command.commands;

import com.spikes2212.ftc.command.Command;
import com.spikes2212.ftc.command.Subsystem;

/**
 * A command that runs a function continuously.
 */
public class RunCommand extends Command {

    /**
     * The function that this command runs.
     */
    private final Runnable runnable;

    public RunCommand(Runnable runnable, Subsystem... requirements) {
        this.runnable = runnable;
        require(requirements);
    }

    @Override
    public void exec() {
        runnable.run();
    }
}
