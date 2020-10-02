package com.spikes2212.ftc.command.commands;

import com.qualcomm.robotcore.util.ElapsedTime;
import com.spikes2212.ftc.command.Command;

public class WaitCommand extends Command {

    private final ElapsedTime elapsedTime;
    private final long millis;

    public WaitCommand(long millis) {
        this.millis = millis;
        this.elapsedTime = new ElapsedTime();
    }

    @Override
    public void init() {
        elapsedTime.reset();
    }

    @Override
    public boolean isDone() {
        return elapsedTime.milliseconds() >= millis;
    }
}
