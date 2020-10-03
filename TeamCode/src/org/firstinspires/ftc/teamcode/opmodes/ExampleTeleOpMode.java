package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.*;
import com.spikes2212.ftc.command.Button;
import com.spikes2212.ftc.command.Scheduler;
import com.spikes2212.ftc.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.commands.ExampleCommand;

/**
 * An example teleop op mode. Replace me with your own teleop op mode.
 */
@TeleOp(name = "teleop", group = "example")
public class ExampleTeleOpMode extends OpMode {

    // The robot instance through which this op mode interacts with subsystems.
    private Robot robot;

    // The commands used in this op mode are defined here...
    private ExampleCommand exampleCommand;

    // The gamepads used by this op mode are defined here...
    private GamepadEx gamepad;

    // This function is run when the op mode begins.
    // Use it to initialize the commands and for any other initialization code.
    @Override
    public void init() {
        robot = new Robot(hardwareMap);

        gamepad = new GamepadEx(gamepad1);

        exampleCommand = new ExampleCommand(robot.exampleSubsystem);

        gamepad.getXButton().whenPressed(exampleCommand);
    }

    // This function is called periodically during the op mode.
    // Op modes should not perform much logic, so this function should usually just call the Scheduler.
    @Override
    public void loop() {
        Scheduler.getInstance().update();
        Scheduler.getInstance().run();
        Scheduler.getInstance().poll();
    }
}
