package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.Modules.MotorModule;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="8606 Sample", group="Pushbot")
public class Sample_8606 extends BaseOp {
    private MotorModule _extender = new MotorModule();
    private MotorModule _retractor = new MotorModule();

    @Override
    public void init() {
        _driveModule.initialize(hardwareMap);

        _extender.initialize(hardwareMap, "extender", DcMotorSimple.Direction.FORWARD);
        _extender.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        _retractor.initialize(hardwareMap, "retractor", DcMotorSimple.Direction.FORWARD);
        _retractor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        _extender.setMaxPower(1.0d);
        _retractor.setMaxPower(1.0d);

        _extender.setPower(0.0d);
        _retractor.setPower(0.0d);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            _driveModule.setMaxPower(0.25d);
        }
        else if (gamepad1.b) {
            _driveModule.setMaxPower(0.50d);
        }
        else if (gamepad1.x) {
            _driveModule.setMaxPower(0.75d);
        }
        else if (gamepad1.y) {
            _driveModule.setMaxPower(1.0d);
        }

        if (gamepad2.y) {
            _extender.setPower(1.0d);
        }
        else if (gamepad2.a) {
            _retractor.setPower(1.0d);
        }
        else {
            _extender.setPower(0.0d);
            _retractor.setPower(0.0d);
        }

        _driveModule.move(gamepad1);
    }
}