package com.spikes2212.ftc.command.commands;

import com.spikes2212.ftc.command.Command;
import com.spikes2212.ftc.command.Subsystem;

public class InstantCommand extends Command {

    Runnable runnable;

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
