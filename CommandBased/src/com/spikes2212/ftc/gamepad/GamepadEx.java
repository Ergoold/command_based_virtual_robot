package com.spikes2212.ftc.gamepad;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.spikes2212.ftc.command.Button;

/**
 * A gamepad that integrates with the command framework.
 */
public class GamepadEx {

    /**
     * The gamepad object.
     */
    private final Gamepad gamepad;

    /**
     * Whether or not inputs are squared.
     */
    private boolean squareInputs = true;

    public GamepadEx(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public void setDeadzone(float deadzone) {
        gamepad.setJoystickDeadzone(deadzone);
    }

    public void setSquareInputs(boolean squareInputs) {
        this.squareInputs = squareInputs;
    }

    public boolean isXPressed() {
        return gamepad.x;
    }

    public boolean isYPressed() {
        return gamepad.y;
    }

    public boolean isAPressed() {
        return gamepad.a;
    }

    public boolean isBPressed() {
        return gamepad.b;
    }

    public boolean isDPadUpPressed() {
        return gamepad.dpad_up;
    }

    public boolean isDPadDownPressed() {
        return gamepad.dpad_down;
    }

    public boolean isDPadLeftPressed() {
        return gamepad.dpad_left;
    }

    public boolean isDPadRightPressed() {
        return gamepad.dpad_right;
    }

    public boolean isBackPressed() {
        return gamepad.back;
    }

    public boolean isGuidePressed() {
        return gamepad.guide;
    }

    public boolean isStartPressed() {
        return gamepad.start;
    }

    public boolean isLeftBumperPressed() {
        return gamepad.left_bumper;
    }

    public boolean isRightBumperPressed() {
        return gamepad.right_bumper;
    }

    public boolean isLeftStickPressed() {
        return gamepad.left_stick_button;
    }

    public boolean isRightStickPressed() {
        return gamepad.right_stick_button;
    }

    public double getLeftTrigger() {
        return squareInputs ? squareInput(gamepad.left_trigger) : gamepad.left_trigger;
    }

    public double getRightTrigger() {
        return squareInputs ? squareInput(gamepad.right_trigger) : gamepad.right_trigger;
    }

    public double getLeftX() {
        return squareInputs ? squareInput(gamepad.left_stick_x) : gamepad.left_stick_x;
    }

    public double getLeftY() {
        return squareInputs ? squareInput(gamepad.left_stick_y) : gamepad.left_stick_y;
    }

    public double getRightX() {
        return squareInputs ? squareInput(gamepad.right_stick_x) : gamepad.right_stick_x;
    }

    public double getRightY() {
        return squareInputs ? squareInput(gamepad.right_stick_y) : gamepad.right_stick_y;
    }

    public Button getXButton() {
        return new Button(this::isXPressed);
    }

    public Button getYButton() {
        return new Button(this::isYPressed);
    }

    public Button getAButton() {
        return new Button(this::isAPressed);
    }

    public Button getBButton() {
        return new Button(this::isBPressed);
    }

    public Button getDPadUp() {
        return new Button(this::isDPadUpPressed);
    }

    public Button getDPadDown() {
        return new Button(this::isDPadDownPressed);
    }

    public Button getDPadLeft() {
        return new Button(this::isDPadLeftPressed);
    }

    public Button getDPadRight() {
        return new Button(this::isDPadRightPressed);
    }

    public Button getBackButton() {
        return new Button(this::isBackPressed);
    }

    public Button getGuideButton() {
        return new Button(this::isGuidePressed);
    }

    public Button getStartButton() {
        return new Button(this::isStartPressed);
    }

    public Button getLeftBumper() {
        return new Button(this::isLeftBumperPressed);
    }

    public Button getRightBumper() {
        return new Button(this::isRightBumperPressed);
    }

    public Button getLeftStickButton() {
        return new Button(this::isLeftStickPressed);
    }

    public Button getRightStickButton() {
        return new Button(this::isRightStickPressed);
    }

    /**
     * Squares an input without changing its sign.
     *
     * @param input the controller input
     * @return the squared input
     */
    private double squareInput(double input) {
        return Math.abs(input) * input;
    }
}
