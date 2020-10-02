package com.spikes2212.ftc.command.groups;

import com.spikes2212.ftc.command.Command;
import com.spikes2212.ftc.command.Subsystem;

import java.util.Collection;

public abstract class CommandGroup extends Command {
    protected Collection<Command> commands;

    public CommandGroup(Collection<Command> commands) {
        this.commands = commands;
        for (Command command : commands) {
            require(command.getRequirements().toArray(new Subsystem[0]));
        }
    }
}
