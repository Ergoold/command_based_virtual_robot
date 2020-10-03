package com.spikes2212.ftc.command.commands;

import com.spikes2212.ftc.command.Command;

import java.util.function.BooleanSupplier;

/**
 * A command that does nothing but end once a specified condition is {@link true}.
 */
public class WaitUntilCommand extends Command {

    /**
     * The condition that determines when this command should end.
     */
    private final BooleanSupplier condition;

    public WaitUntilCommand(BooleanSupplier condition) {
        this.condition = condition;
    }

    @Override
    public boolean isDone() {
        return condition.getAsBoolean();
    }
}
