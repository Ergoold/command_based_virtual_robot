package org.firstinspires.ftc.teamcode.commands;

import com.spikes2212.ftc.command.Command;
import org.firstinspires.ftc.teamcode.subsystems.ExampleSubsystem;

/**
 * An example command. Replace me with your own command.
 */
public class ExampleCommand extends Command {

    public ExampleCommand(ExampleSubsystem subsystem) {
        // Use require() here to declare subsystem dependencies.
        require(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void init() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void exec() {
    }

    // Returns true when the command should end.
    @Override
    public boolean isDone() {
        return false;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean done) {
    }
}
