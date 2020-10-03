package com.spikes2212.ftc.command.groups;

import com.spikes2212.ftc.command.Command;

import java.util.List;

/**
 * Base class for command groups, that run a group of commands in a coordinated manner.
 */
public abstract class CommandGroup extends Command {

    /**
     * The commands this command group coordinates.
     */
    protected final List<Command> commands;

    public CommandGroup(List<Command> commands) {
        this.commands = commands;
        for (Command command : commands) {
            require(command.getRequirements());
        }
    }
}
