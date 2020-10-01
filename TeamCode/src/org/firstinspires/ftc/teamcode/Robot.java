package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.subsystems.ExampleSubsystem;

/**
 * This class is where the subsystems of the robot live.
 */
public class Robot {

    // The robot's subsystems are defined here...
    public static ExampleSubsystem exampleSubsystem;

    /**
     * An empty constructor that initializes all of the subsystems.
     */
    public Robot() {
        exampleSubsystem = new ExampleSubsystem();
    }
}
