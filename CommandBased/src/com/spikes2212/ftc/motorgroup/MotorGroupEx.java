package com.spikes2212.ftc.motorgroup;

import com.qualcomm.robotcore.hardware.*;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

/**
 * A group of DcMotorEx objects that operate as one DcMotorEx.
 */
public class MotorGroupEx implements DcMotorEx {

    /**
     * The motors that are part of this motor group.
     */
    private final DcMotorEx[] motors;

    public MotorGroupEx(DcMotorEx... motors) {
        this.motors = motors;
    }

    @Override
    public void setMotorEnable() {
        for (DcMotorEx motor : motors) {
            motor.setMotorEnable();
        }
    }

    @Override
    public void setMotorDisable() {
        for (DcMotorEx motor : motors) {
            motor.setMotorDisable();
        }
    }

    @Override
    public boolean isMotorEnabled() {
        return motors[0].isMotorEnabled();
    }

    @Override
    public void setVelocity(double angularRate) {
        for (DcMotorEx motor : motors) {
            motor.setVelocity(angularRate);
        }
    }

    @Override
    public void setVelocity(double angularRate, AngleUnit unit) {
        for (DcMotorEx motor : motors) {
            motor.setVelocity(angularRate, unit);
        }
    }

    @Override
    public double getVelocity() {
        return motors[0].getVelocity();
    }

    @Override
    public double getVelocity(AngleUnit unit) {
        return motors[0].getVelocity(unit);
    }

    @Override
    @Deprecated
    public void setPIDCoefficients(RunMode mode, PIDCoefficients pidCoefficients) {
        for (DcMotorEx motor : motors) {
            motor.setPIDCoefficients(mode, pidCoefficients);
        }
    }

    @Override
    public void setPIDFCoefficients(RunMode mode, PIDFCoefficients pidfCoefficients)
            throws UnsupportedOperationException {
        for (DcMotorEx motor : motors) {
            motor.setPIDFCoefficients(mode, pidfCoefficients);
        }
    }

    @Override
    public void setVelocityPIDFCoefficients(double p, double i, double d, double f) {
        for (DcMotorEx motor : motors) {
            motor.setVelocityPIDFCoefficients(p, i, d, f);
        }
    }

    @Override
    public void setPositionPIDFCoefficients(double p) {
        for (DcMotorEx motor : motors) {
            motor.setPositionPIDFCoefficients(p);
        }
    }

    @Override
    @Deprecated
    public PIDCoefficients getPIDCoefficients(RunMode mode) {
        return motors[0].getPIDCoefficients(mode);
    }

    @Override
    public PIDFCoefficients getPIDFCoefficients(RunMode mode) {
        return motors[0].getPIDFCoefficients(mode);
    }

    @Override
    public void setTargetPositionTolerance(int tolerance) {
        for (DcMotorEx motor : motors) {
            motor.setTargetPositionTolerance(tolerance);
        }
    }

    @Override
    public int getTargetPositionTolerance() {
        return motors[0].getTargetPositionTolerance();
    }

    @Override
    public double getCurrent(CurrentUnit unit) {
        return motors[0].getCurrent(unit);
    }

    @Override
    public double getCurrentAlert(CurrentUnit unit) {
        return motors[0].getCurrentAlert(unit);
    }

    @Override
    public void setCurrentAlert(double current, CurrentUnit unit) {
        for (DcMotorEx motor : motors) {
            motor.setCurrentAlert(current, unit);
        }
    }

    @Override
    public boolean isOverCurrent() {
        return motors[0].isMotorEnabled();
    }

    @Override
    public void setMode(RunMode mode) {
        for (DcMotorEx motor : motors) {
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
        for (DcMotorEx motor : motors) {
            motor.setTargetPosition(pos);
        }
    }

    @Override
    public int getTargetPosition() {
        return motors[0].getTargetPosition();
    }

    @Override
    public boolean isBusy() {
        return motors[0].isMotorEnabled();
    }

    @Override
    public void setZeroPowerBehavior(ZeroPowerBehavior zeroPowerBehavior) {
        for (DcMotorEx motor : motors) {
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
        for (DcMotorEx motor : motors) {
            motor.setDirection(direction);
        }
    }

    @Override
    public Direction getDirection() {
        return motors[0].getDirection();
    }

    @Override
    public void setPower(double power) {
        for (DcMotorEx motor : motors) {
            motor.setPower(power);
        }
    }

    @Override
    public double getPower() {
        return motors[0].getPower();
    }
}
