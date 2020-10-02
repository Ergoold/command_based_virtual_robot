package com.spikes2212.ftc.command;

import java.util.*;
import java.util.function.Supplier;

/**
 * A singleton mediator that handles all of the interactions between {@link Command}s and {@link Subsystem}s.
 */
public class Scheduler {

    /**
     * The singleton instance.
     */
    private static final Scheduler instance = new Scheduler();

    public static Scheduler getInstance() {
        return instance;
    }

    /**
     * The set of currently scheduled commands.
     */
    private final Set<Command> scheduledCommands = new HashSet<>();

    /**
     * A map from subsystems to the commands that require them.
     *
     * <p>Also used as a set of currently registered subsystems.</p>
     */
    private final Map<Subsystem, Command> requirements = new HashMap<>();

    /**
     * The set of currently-registered buttons that will be polled every iteration.
     */
    private final Set<Supplier<Command>> buttons = new HashSet<>();

    /**
     * Private constructor so that only one instance (the singleton) is possible.
     */
    private Scheduler() {
    }

    /**
     * Registers a new subsystem with no command if it is not yet registered.
     *
     * @param subsystem the subsystem to register
     */
    public void register(Subsystem subsystem) {
        requirements.putIfAbsent(subsystem, null);
    }

    /**
     * Schedules a new command.
     *
     * <p>If the command is currently scheduled, it will not be scheduled again.</p>
     *
     * <p>If the command requires a subsystem that is not yet registered, it is registered here.</p>
     *
     * <p>If another command requires a subsystem that is also required by the new command, it is interrupted (its
     * {@link Command#end} function is called with {@code done = false}) here.</p>
     *
     * @param command the new command to schedule
     */
    public void schedule(Command command) {
        if (scheduledCommands.contains(command)) return;
        scheduledCommands.add(command);
        for (Subsystem requirement : command.getRequirements()) {
            Command interruptedCommand = requirements.get(requirement);
            if (interruptedCommand != null) interruptedCommand.end(false);
            requirements.put(requirement, command);
        }
        command.init();
    }

    /**
     * Adds a new button that will be polled every iteration.
     *
     * @param button the button to add
     */
    /* package-private */ void addButton(Supplier<Command> button) {
        buttons.add(button);
    }

    /**
     * Updates all registered subsystem.
     */
    public void update() {
        for (Subsystem subsystem : requirements.keySet()) {
            subsystem.update();
            requirements.putIfAbsent(subsystem, subsystem.getDefaultCommand());
        }
    }

    /**
     * Runs or ends all scheduled commands as needed.
     */
    public void run() {
        for (Command command : scheduledCommands) {
            command.exec();
            if (command.isDone()) {
                finish(command, true);
            }
        }
    }

    /**
     * Polls all {@link Button}s and schedules any new commands.
     */
    public void poll() {
        for (Supplier<Command> button : buttons) {
            Command command = button.get();
            if (command != null) schedule(command);
        }
    }

    /**
     * Cancels a command, causing an interrupt if it is scheduled.
     *
     * @param command the command to cancel
     */
    public void cancel(Command command) {
        finish(command, false);
    }

    /**
     * Finishes the command.
     *
     * <p>Automatically removes the command from all of the subsystems which it requires.</p>
     *
     * @param command the command to finish
     * @param done    {@code true} when the command is done, and {@code false} when it was interrupted or canceled
     */
    private void finish(Command command, boolean done) {
        command.end(done);
        for (Subsystem requirement : command.getRequirements()) {
            requirements.put(requirement, null);
        }
        scheduledCommands.remove(command);
    }
}
