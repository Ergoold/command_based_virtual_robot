package com.spikes2212.ftc.command.commands;

import com.spikes2212.ftc.command.Command;
import com.spikes2212.ftc.command.Subsystem;

public class PerpetualCommand extends Command {

    private Command command;

    public PerpetualCommand(Command command) {
        this.command = command;
        require(command.getRequirements().toArray(new Subsystem[0]));
    }

    @Override
    public void init() {
        command.init();
    }

    @Override
    public void exec() {
        command.exec();
    }

    @Override
    public void end(boolean done) {
        command.end(done);
    }
}
