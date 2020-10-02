package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.spikes2212.ftc.command.Scheduler;
import org.firstinspires.ftc.teamcode.subsystems.ExampleSubsystem;

/**
 * This class is where the subsystems of the robot live.
 */
public class Robot {

    // The robot's subsystems are defined here...
    public final ExampleSubsystem exampleSubsystem;

    /**
     * An empty constructor that initializes and registers all of the subsystems.
     *
     * @param hardwareMap the robot's hardware map, used to construct the hardware
     */
    public Robot(HardwareMap hardwareMap) {
        exampleSubsystem = new ExampleSubsystem();
        Scheduler.getInstance().register(exampleSubsystem);
    }
}
