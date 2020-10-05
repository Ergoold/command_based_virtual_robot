package com.spikes2212.ftc.command;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * A command based op mode.
 *
 * <p>Automatically calls the scheduler functions {@link Scheduler#update}, {@link Scheduler#run},
 * {@link Scheduler#poll} and {@link Scheduler#clear} at the appropriate times.</p>
 */
public abstract class CommandOpMode extends OpMode {

    /**
     * {@inheritDoc}
     *
     * <p>When overriding this method, make sure to call {@code super.loop()} or call the {@link Scheduler#update},
     * {@link Scheduler#run} and {@link Scheduler#poll} functions yourself. The command framework will not work
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
     * <p>When overriding this method, make sure to call {@code super.stop()} or call the {@link Scheduler#clear}
     * function yourself. The command framework may cause exceptions otherwise.</p>
     */
    @Override
    public void stop() {
        Scheduler.getInstance().clear();
    }
}
