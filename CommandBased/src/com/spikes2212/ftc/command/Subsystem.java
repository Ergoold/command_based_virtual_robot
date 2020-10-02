package com.spikes2212.ftc.command;

/**
 * A robot subsystem.
 *
 * <p>Subsystems are the basic unit of robot organization. They encapsulate components and provide methods which can be
 * used by {@link Command}s.</p>
 */
public interface Subsystem {

    /**
     * This method is called periodically while the robot runs.
     *
     * <p>Useful for updating this subsystem's components and other state.</p>
     */
    default void update() {
    }

    /**
     * Returns the default command that will be automatically scheduled when no other scheduled command requires this
     * subsystem.
     *
     * @return the default command
     */
    default Command getDefaultCommand() {
        return null;
    }
}
