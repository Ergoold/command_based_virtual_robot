package com.spikes2212.ftc.command.groups;

import com.spikes2212.ftc.command.Command;

import java.util.List;

public abstract class CommandGroup extends Command {

    protected List<Command> commands;

    public CommandGroup(List<Command> commands) {
        this.commands = commands;
        for (Command command : commands) {
            require(command.getRequirements());
        }
    }
}
