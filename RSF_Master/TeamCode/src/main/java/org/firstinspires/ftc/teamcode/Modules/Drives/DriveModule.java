package org.firstinspires.ftc.teamcode.Modules.Drives;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.Modules.MotorModule;


public class DriveModule {
    public enum DriveMotor {
        BackLeft,
        BackRight,
        FrontLeft,
        FrontRight
    }

    private MotorModule _backLeftMotor = new MotorModule();
    private MotorModule _backRightMotor = new MotorModule();
    private MotorModule _frontLeftMotor = new MotorModule();
    private MotorModule _frontRightMotor = new MotorModule();

    public int getAveragePosition() {
        return (_backLeftMotor.getCurrentPosition() + _backRightMotor.getCurrentPosition() + _frontLeftMotor.getCurrentPosition() + _frontRightMotor.getCurrentPosition()) / 4;
    }

    public int getCurrentPosition(DriveMotor motor) {
        switch (motor) {
            case BackLeft:
                return _backLeftMotor.getCurrentPosition();
            case BackRight:
                return _backRightMotor.getCurrentPosition();
            case FrontLeft:
                return _frontLeftMotor.getCurrentPosition();
            case FrontRight:
                return _frontRightMotor.getCurrentPosition();
            default:
                return 0;
        }
    }

    public boolean getMode(DcMotor.RunMode mode) {
        return (_backLeftMotor.getMode() == mode && _backRightMotor.getMode() == mode
            && _frontLeftMotor.getMode() == mode && _frontRightMotor.getMode() == mode);
    }

    public void initialize(HardwareMap hardwareMap) {
        _backLeftMotor.initialize(hardwareMap, "backLeft", DcMotor.Direction.FORWARD);
        _backRightMotor.initialize(hardwareMap, "backRight", DcMotor.Direction.REVERSE);
        _frontLeftMotor.initialize(hardwareMap, "frontLeft", DcMotor.Direction.FORWARD);
        _frontRightMotor.initialize(hardwareMap, "frontRight", DcMotor.Direction.REVERSE);

        setMaxPower(1.0d);
        setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        stop();
    }

    public void setMaxPower(double power) {
        _backLeftMotor.setMaxPower(power);
        _backRightMotor.setMaxPower(power);
        _frontLeftMotor.setMaxPower(power);
        _frontRightMotor.setMaxPower(power);
    }

    public void setMode(DcMotor.RunMode mode) {
        _backLeftMotor.setMode(mode);
        _backRightMotor.setMode(mode);
        _frontLeftMotor.setMode(mode);
        _frontRightMotor.setMode(mode);
    }

    public void setPower(double power) {
        setPower(power, power);
    }

    public void setPower(double left, double right) {
        setPower(left, left, right, right);
    }

    public void setPower(double backLeft, double frontLeft, double backRight, double frontRight) {
        _backLeftMotor.setPower(backLeft);
        _backRightMotor.setPower(backRight);
        _frontLeftMotor.setPower(frontLeft);
        _frontRightMotor.setPower(frontRight);
    }

    public void stop() {
        setPower(0.0d);
    }
}
