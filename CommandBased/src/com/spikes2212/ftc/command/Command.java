package com.spikes2212.ftc.command;

import java.util.*;

/**
 * A state machine representing a complete action to be performed by the robot.
 */
public abstract class Command {

    /**
     * The set of {@link Subsystem}s used by this command.
     */
    private final Set<Subsystem> requirements = new HashSet<>();

    /**
     * Adds subsystems to the requirements set.
     *
     * @param subsystems the new subsystems
     */
    protected void require(Subsystem... subsystems) {
        require(Arrays.asList(subsystems));
    }

    /**
     * Adds subsystems to the requirements set.
     *
     * @param subsystems the new subsystems
     */
    protected void require(Collection<Subsystem> subsystems) {
        requirements.addAll(subsystems);
    }

    /**
     * The initial subroutine of a command.
     *
     * <p>Called once when the command is scheduled.</p>
     */
    public void init() {
    }

    /**
     * The main body of a command.
     *
     * <p>Called periodically while the command is scheduled.</p>
     */
    public void exec() {
    }

    /**
     * Tests whether the command is done running.
     *
     * <p>Once a command is done, the {@link #end} method is called with the value true.</p>
     *
     * @return whether the command is done running
     */
    public boolean isDone() {
        return false;
    }

    /**
     * The action to take when the command ends.
     *
     * @param done {@code true} when the command is done, and {@code false} when it was interrupted or canceled
     */
    public void end(boolean done) {
    }

    public Set<Subsystem> getRequirements() {
        return requirements;
    }
}
