package TeleOp;

/**
 * @Filename:Robot.java
 * @Purpose:This file contains the Robot class for Mecanum wheels
 * @Version:1.0
 * @Author: FTC TEAM 16798 Redhawk Robotics
 * @Date:12/03/22
 */

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {

    //Initializing the 4 motors
    public DcMotor frontRight;
    public DcMotor backRight;
    public DcMotor frontLeft;
    public DcMotor backLeft;

    //Initializing time for the SmartSleep constructor
    ElapsedTime runTime = new ElapsedTime();

    // mapping each motor/motor encoder if have so, the phone can read it for HardWare Mapping
    public void init(HardwareMap hwMap) {
        frontLeft = hwMap.dcMotor.get("front_left");
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        frontRight = hwMap.dcMotor.get("front_right");
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backLeft = hwMap.dcMotor.get("back_left");
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        backRight = hwMap.dcMotor.get("back_right");
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Reversing one side of the Mecanum drive
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        //Making forward absolute for the other side to go FORWARD
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
    }
        //Constructor for the Mecanum Drive Train
        public void mecDrive(double frontLeft, double frontRight, double  backLeft,  double backRight){
            this.frontLeft.setPower(frontLeft);
            this.frontRight.setPower(frontRight);
            this.backLeft.setPower(backLeft);
            this.backRight.setPower(backRight);
        }

    //converts the mili second to full seconds
    public double smartSleep (double secondsToSleep){
        runTime.reset(); //restart set the timer to 0
        double i = secondsToSleep;
        while ((runTime.seconds() < secondsToSleep)) {
            i--;
        }
        return i;
    }

    //Constructors for autonomous for all the possible configurations to move
    public void startDrive(double power, double second, Telemetry telemetry) {
        this.frontRight.setPower(power);
        this.frontLeft.setPower(power);
        this.backRight.setPower(power);
        this.backLeft.setPower(power);
        runTime.reset();//starts the time at 0
        while(runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void backward(double power, double second, Telemetry telemetry) {
        this.frontRight.setPower(-power);
        this.frontLeft.setPower(-power);
        this.backRight.setPower(-power);
        this.backLeft.setPower(-power);
        runTime.reset();//starts the time at 0
        while(runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void stopDrive(){
        this.frontRight.setPower(0);
        this.frontLeft.setPower(0);
        this.backRight.setPower(0);
        this.backLeft.setPower(0);
    }
    public void strafeRight(double power, double second, Telemetry telemetry) {
        this.frontLeft.setPower(power);
        this.backLeft.setPower(-power);
        this.backRight.setPower(power);
        this.frontRight.setPower(-power);
        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void strafeLeft(double power, double second,Telemetry telemetry) {
        this.frontLeft.setPower(-power);
        this.backLeft.setPower(power);
        this.backRight.setPower(-power);
        this.frontRight.setPower(power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void diagonaRight(double power, double second,Telemetry telemetry) {
        this.frontLeft.setPower(power);
        this.backRight.setPower(power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void diagonaLeft(double power, double second,Telemetry telemetry) {
        this.backLeft.setPower(power);
        this.frontRight.setPower(power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void turnAroundRight(double power, double second, Telemetry telemetry) {
        this.frontLeft.setPower(power);
        this.backLeft.setPower(power);
        this.backRight.setPower(-power);
        this.frontRight.setPower(-power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void turnAroundLeft(double power, double second, Telemetry telemetry) {
        this.frontLeft.setPower(-power);
        this.backLeft.setPower(-power);
        this.backRight.setPower(power);
        this.frontRight.setPower(power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void frontConcerning(double power, double second, Telemetry telemetry){
        this.frontLeft.setPower(power);
        this.backLeft.setPower(power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void frontCounterConcerning(double power, double second, Telemetry telemetry){
        this.backRight.setPower(power);
        this.frontRight.setPower(power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void backConcerning(double power, double second, Telemetry telemetry){
        this.frontLeft.setPower(-power);
        this.backLeft.setPower(-power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void backCounterConcerning(double power, double second, Telemetry telemetry){
        this.backRight.setPower(-power);
        this.frontRight.setPower(-power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void rearAxisLeft(double power, double second, Telemetry telemetry){
        this.frontLeft.setPower(power);
        this.frontRight.setPower(-power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void counterRearAxisLeft(double power, double second, Telemetry telemetry){
        this.backLeft.setPower(power);
        this.backRight.setPower(-power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void rearAxisRight(double power, double second, Telemetry telemetry){
        this.frontLeft.setPower(-power);
        this.frontRight.setPower(power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
    public void counterRearAxisRight(double power, double second, Telemetry telemetry){
        this.backLeft.setPower(-power);
        this.backRight.setPower(power);

        runTime.reset();//starts the time at 0
        while (runTime.seconds() < smartSleep(second)) {
            telemetry.addData("Path", "drive: %2.5f S Elapsed", runTime.seconds());
            telemetry.update();
        }
    }
}

