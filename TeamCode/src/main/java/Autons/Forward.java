package Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import TeleOp.Robot;

@Autonomous(name = "Forward" , group = "Autons")
public class Forward extends LinearOpMode {

    Robot robot = new Robot();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        robot.startDrive(.5,.5,telemetry);
        //robot.stopDrive();//Not needed if the top constructor works

        telemetry.update();
    }
}
