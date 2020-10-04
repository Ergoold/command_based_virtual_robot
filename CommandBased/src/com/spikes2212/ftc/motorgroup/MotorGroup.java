package com.spikes2212.ftc.motorgroup;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

/**
 * A group of DcMotor objects that operate as one DcMotor.
 */
public class MotorGroup implements DcMotor {

    /**
     * The motors that are part of this motor group.
     */
    private final DcMotor[] motors;

    public MotorGroup(DcMotor... motors) {
        this.motors = motors;
    }

    @Override
    public void setMode(RunMode mode) {
        for (DcMotor motor : motors) {
            motor.setMode(mode);
        }
    }

    @Override
    public RunMode getMode() {
        return motors[0].getMode();
    }

    @Override
    public int getCurrentPosition() {
        return motors[0].getCurrentPosition();
    }

    @Override
    public void setTargetPosition(int pos) {
        for (DcMotor motor : motors) {
            motor.setTargetPosition(pos);
        }
    }

    @Override
    public int getTargetPosition() {
        return motors[0].getTargetPosition();
    }

    @Override
    public boolean isBusy() {
        return motors[0].isBusy();
    }

    @Override
    public void setZeroPowerBehavior(ZeroPowerBehavior zeroPowerBehavior) {
        for (DcMotor motor : motors) {
            motor.setZeroPowerBehavior(zeroPowerBehavior);
        }
    }

    @Override
    public ZeroPowerBehavior getZeroPowerBehavior() {
        return motors[0].getZeroPowerBehavior();
    }

    @Override
    public MotorConfigurationType getMotorType() {
        return motors[0].getMotorType();
    }

    @Override
    public void setDirection(Direction direction) {
        for (DcMotor motor : motors) {
            motor.setDirection(direction);
        }
    }

    @Override
    public Direction getDirection() {
        return motors[0].getDirection();
    }

    @Override
    public void setPower(double power) {
        for (DcMotor motor : motors) {
            motor.setPower(power);
        }
    }

    @Override
    public double getPower() {
        return motors[0].getPower();
    }
}
