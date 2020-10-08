package com.spikes2212.ftc.command.drivetrains;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.spikes2212.ftc.motorgroup.*;

/**
 * A tank drivetrain, also known as a differential drive, skid-steer or west coast.
 *
 * <p>This class takes one DcMotorSimple per side. For drivetrains with more motors on each side, use a
 * {@link MotorGroupSimple}, {@link MotorGroup} or {@link MotorGroupEx}.</p>
 */
public class TankDrivetrain extends DrivetrainBase {

    public TankDrivetrain(DcMotorSimple left, DcMotorSimple right) {
        super(left, right);
    }

    /**
     * Drives this TankDrivetrain with the given speeds for the left and the right motors.
     *
     * @param leftSpeed  the left side speed
     * @param rightSpeed the right side speed
     */
    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive(leftSpeed, rightSpeed);
    }

    /**
     * Drives this TankDrivetrain with the given forward speed and rotation rate.
     *
     * @param speed    the forward speed
     * @param rotation the rotation rate
     */
    public void arcadeDrive(double speed, double rotation) {
        tankDrive(speed + rotation, speed - rotation);
    }

    /**
     * Drives this TankDrivetrain with the given forward speed and path curvature.
     *
     * @param speed     the forward speed
     * @param curvature the path curvature
     */
    public void curvatureDrive(double speed, double curvature) {
        arcadeDrive(speed, Math.abs(speed) * curvature);
    }
}
