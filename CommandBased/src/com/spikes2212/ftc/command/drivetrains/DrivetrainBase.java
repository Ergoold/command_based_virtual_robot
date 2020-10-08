package com.spikes2212.ftc.command.drivetrains;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.spikes2212.ftc.command.Subsystem;

/**
 * A base class for drivetrain systems.
 */
public class DrivetrainBase implements Subsystem {

    /**
     * The motors on this drivetrain.
     */
    private final DcMotorSimple[] motors;

    protected DrivetrainBase(DcMotorSimple... motors) {
        this.motors = motors;
    }

    /**
     * Drives this drivetrain with the given speed on each motor.
     *
     * <p>If any of the speeds is greater than 1, the speeds are normalized.</p>
     *
     * <p>The order of the speeds is the same as the order of the motors, as given in the constructor.</p>
     *
     * @param speeds an variable-length argument with the speed each motor should be driven with
     */
    public void drive(double... speeds) {
        double factor = Math.max(max(speeds), 1);
        for (int i = 0; i < speeds.length; i++) {
            motors[i].setPower(speeds[i] / factor);
        }
    }

    /**
     * Stops this drivetrain completely.
     */
    public void stop() {
        for (DcMotorSimple motor : motors) {
            motor.setPower(0);
        }
    }

    /**
     * Finds the maximum of an array of motor speeds.
     *
     * @param speeds the speeds
     * @return the highest speed
     */
    private double max(double... speeds) {
        double max = Double.NEGATIVE_INFINITY;
        for (double speed : speeds) {
            if (max < speed) max = speed;
        }
        return max;
    }
}
