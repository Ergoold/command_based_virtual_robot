package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.spikes2212.ftc.command.Scheduler;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.commands.ExampleCommand;

/**
 * An example op mode. Replace me with your own op mode.
 */
@Autonomous(name = "example")
public class ExampleOpMode extends OpMode {

    // The commands used in this op mode are defined here...
    ExampleCommand exampleCommand;

    // This function is run when the op mode begins.
    // Use it to initialize the commands and for any other initialization code.
    @Override
    public void init() {
        exampleCommand = new ExampleCommand(Robot.exampleSubsystem);
        Scheduler.getInstance().schedule(exampleCommand);
    }

    // This function is called periodically during the op mode.
    // Op modes should not perform much logic, so this function should usually just call the Scheduler.
    @Override
    public void loop() {
        Scheduler.getInstance().update();
        Scheduler.getInstance().run();
    }
}
