package com.spikes2212.ftc.motorgroup;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * A group of DcMotorSimple objects that operate as one motor.
 */
public class MotorGroupSimple implements DcMotorSimple {

    /**
     * The motors that are part of this motor group.
     */
    private final DcMotorSimple[] motors;

    public MotorGroupSimple(DcMotorSimple... motors) {
        this.motors = motors;
    }

    @Override
    public void setDirection(Direction direction) {
        for (DcMotorSimple motor : motors) {
            motor.setDirection(direction);
        }
    }

    @Override
    public Direction getDirection() {
        return motors[0].getDirection();
    }

    @Override
    public void setPower(double power) {
        for (DcMotorSimple motor : motors) {
            motor.setPower(power);
        }
    }

    @Override
    public double getPower() {
        return motors[0].getPower();
    }
}
