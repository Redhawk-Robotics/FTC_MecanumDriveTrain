package Autons;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import TeleOp.Robot;

@Autonomous(name = "Backward" , group = "Autons")
public class Backward extends LinearOpMode {

    Robot robot = new Robot();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        robot.backward(.5,.5,telemetry);
        //robot.stopDrive();//Not needed if the top constructor works

        telemetry.update();
    }
}
