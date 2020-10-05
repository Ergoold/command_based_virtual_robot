package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.spikes2212.ftc.command.CommandOpMode;
import com.spikes2212.ftc.command.Scheduler;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.commands.ExampleCommand;

/**
 * An example autonomous op mode. Replace me with your own autonomous op mode.
 */
@Autonomous(name = "autonomous", group = "example")
public class ExampleAutonomousMode extends CommandOpMode {

    // The robot instance through which this op mode interacts with subsystems.
    private Robot robot;

    // The commands used in this op mode are defined here...
    private ExampleCommand exampleCommand;

    // This function is run when the op mode begins.
    // Use it to initialize the commands and for any other initialization code.
    @Override
    public void init() {
        robot = new Robot(hardwareMap);

        exampleCommand = new ExampleCommand(robot.exampleSubsystem);
        Scheduler.getInstance().schedule(exampleCommand);
    }
}
