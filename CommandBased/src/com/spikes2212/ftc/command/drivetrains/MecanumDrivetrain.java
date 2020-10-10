package com.spikes2212.ftc.command.drivetrains;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * A mecanum drivetrain.
 *
 * <p>This class can also be used to drive holonomic four-wheel drivetrains, also called x-drive.</p>
 */
public class MecanumDrivetrain extends DrivetrainBase {

    public MecanumDrivetrain(DcMotorSimple frontLeft, DcMotorSimple frontRight,
                             DcMotorSimple backLeft, DcMotorSimple backRight) {
        super(frontLeft, frontRight, backLeft, backRight);
    }

    /**
     * Drives this MecanumDrivetrain with the given speeds along all axis relative to the given angle while rotating at
     * the given rotation rate.
     *
     * @param xSpeed   the speed along the x axis
     * @param ySpeed   the speed along the y axis
     * @param rotation the rotation rate
     * @param angle    the current angle
     */
    public void cartesianDrive(double xSpeed, double ySpeed, double rotation, double angle) {
        double cosAngle = Math.cos(-angle);
        double sinAngle = Math.sin(-angle);
        cartesianDrive(xSpeed * cosAngle - ySpeed * sinAngle,
                xSpeed * sinAngle + ySpeed * cosAngle, rotation);
    }

    /**
     * Drives this MecanumDrivetrain with the given speeds along all axis relative to its forward direction while
     * rotating at the given rotation rate.
     *
     * @param xSpeed   the speed along the x axis
     * @param ySpeed   the speed along the x axis
     * @param rotation the rotation rate
     */
    public void cartesianDrive(double xSpeed, double ySpeed, double rotation) {
        drive(ySpeed + xSpeed + rotation, ySpeed - xSpeed - rotation,
                ySpeed - xSpeed + rotation, ySpeed + xSpeed - rotation);
    }
}
