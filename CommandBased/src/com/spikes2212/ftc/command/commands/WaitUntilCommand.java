package com.spikes2212.ftc.command.commands;

import com.spikes2212.ftc.command.Command;

import java.util.function.BooleanSupplier;

public class WaitUntilCommand extends Command {

    private final BooleanSupplier condition;

    public WaitUntilCommand(BooleanSupplier condition) {
        this.condition = condition;
    }

    @Override
    public boolean isDone() {
        return condition.getAsBoolean();
    }
}
