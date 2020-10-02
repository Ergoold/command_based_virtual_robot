package org.firstinspires.ftc.teamcode;

import com.spikes2212.ftc.command.Scheduler;
import org.firstinspires.ftc.teamcode.subsystems.ExampleSubsystem;

/**
 * This class is where the subsystems of the robot live.
 */
public class Robot {

    private static final Robot instance = new Robot();

    public static Robot getInstance() {
        return instance;
    }

    // The robot's subsystems are defined here...
    public ExampleSubsystem exampleSubsystem;

    /**
     * An empty constructor that initializes and registers all of the subsystems.
     */
    public Robot() {
        exampleSubsystem = new ExampleSubsystem();
        Scheduler.getInstance().register(exampleSubsystem);
    }
}
