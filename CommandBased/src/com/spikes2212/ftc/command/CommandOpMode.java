package com.spikes2212.ftc.command;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * A command based op mode.
 *
 * <p>The command framework will not work correctly when using any other op mode base class.</p>
 */
public abstract class CommandOpMode extends OpMode {

    /**
     * {@inheritDoc}
     *
     * <p>When overriding this method, make sure to call {@code super.loop()}. The command framework will not work
     * otherwise.</p>
     */
    @Override
    public void loop() {
        Scheduler.getInstance().update();
        Scheduler.getInstance().run();
        Scheduler.getInstance().poll();
    }

    /**
     * {@inheritDoc}
     *
     * <p>When overriding this method, make sure to call {@code super.stop()}. The command framework may cause
     * exceptions otherwise.</p>
     */
    @Override
    public void stop() {
        Scheduler.getInstance().clear();
    }
}
