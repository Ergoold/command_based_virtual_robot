package com.spikes2212.ftc.gamepad.keys;

/**
 * A gamepad key that can either be pressed or not.
 */
public enum Button {
    X, Y, A, B, BACK, START;

    public enum Bumper {
        LEFT, RIGHT
    }

    public enum DPad {
        UP, DOWN, LEFT, RIGHT
    }

    public enum Stick {
        LEFT, RIGHT
    }
}
