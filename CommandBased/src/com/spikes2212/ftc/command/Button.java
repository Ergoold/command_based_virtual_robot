package com.spikes2212.ftc.command;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/**
 * An input that activates a {@link Command}.
 */
public class Button {

    /**
     * The current value of the input.
     */
    private final BooleanSupplier value;

    public Button(BooleanSupplier value) {
        this.value = value;
    }

    /**
     * Starts the given command whenever the button is pressed.
     *
     * @param command the command to start
     * @return this button, so calls can be chained
     */
    public Button whenPressed(Command command) {
        Scheduler.getInstance().addButton(
                new Supplier<Command>() {

                    boolean last = value.getAsBoolean();

                    @Override
                    public Command get() {
                        boolean pressed = value.getAsBoolean();
                        Command result = null;
                        if (!last && pressed) result = command;
                        last = pressed;
                        return result;
                    }
                }
        );

        return this;
    }

    /**
     * Constantly starts the command while the button is held.
     *
     * @param command the command to start
     * @return this button, so calls can be chained
     */
    public Button whileHeld(Command command) {
        Scheduler.getInstance().addButton(
                new Supplier<Command>() {

                    boolean last = value.getAsBoolean();

                    @Override
                    public Command get() {
                        boolean pressed = value.getAsBoolean();
                        Command result = null;
                        if (pressed) {
                            result = command;
                        } else if (last) {
                            Scheduler.getInstance().cancel(command);
                        }
                        last = pressed;
                        return result;
                    }
                }
        );

        return this;
    }

    /**
     * Starts the given command when the button is first pressed, and cancels it when it is released, but does not start
     * it again if it ends or is canceled ot interrupted.
     *
     * @param command the command to start
     * @return this button, so calls can be chained
     */
    public Button whenHeld(Command command) {
        Scheduler.getInstance().addButton(
                new Supplier<Command>() {

                    boolean last = value.getAsBoolean();

                    @Override
                    public Command get() {
                        boolean pressed = value.getAsBoolean();
                        Command result = null;
                        if (!last && pressed) {
                            result = command;
                        } else if (last && !pressed) {
                            Scheduler.getInstance().cancel(command);
                        }
                        last = pressed;
                        return result;
                    }
                }
        );

        return this;
    }

    /**
     * Starts the command when the button is released.
     *
     * @param command the command to start
     * @return this button, so calls can be chained
     */
    public Button whenReleased(Command command) {
        Scheduler.getInstance().addButton(
                new Supplier<Command>() {

                    boolean last = value.getAsBoolean();

                    @Override
                    public Command get() {
                        boolean pressed = value.getAsBoolean();
                        Command result = null;
                        if (last && !pressed) result = command;
                        last = pressed;
                        return result;
                    }
                }
        );

        return this;
    }

    /**
     * Composes this button with another button, returning a new button that is pressed when both buttons are pressed.
     *
     * @param button the button to compose with
     * @return a button that is pressed when both buttons are pressed
     */
    public Button and(Button button) {
        return new Button(() -> value.getAsBoolean() && button.value.getAsBoolean());
    }

    /**
     * Composes this button with another button, returning a new button that is pressed when either button is pressed.
     *
     * @param button the button to compose with
     * @return a button that is pressed when either button is pressed
     */
    public Button or(Button button) {
        return new Button(() -> value.getAsBoolean() || button.value.getAsBoolean());
    }

    /**
     * Creates a new button that is pressed when this button is unpressed, i.e. acts as the negation of this button.
     *
     * @return the negated button
     */
    public Button negate() {
        return new Button(() -> !value.getAsBoolean());
    }
}
