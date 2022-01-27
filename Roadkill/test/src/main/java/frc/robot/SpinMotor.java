//
///
// REVIEW: RUns the motor, uses methods from motor.java





package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.sensors.CANCoder;
import frc.robot.Motor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SpinMotor extends CommandBase {
    private Motor motor;
    private double speed; // percent output -1 -> 1 double
    private double offset; // motor keeps moving after end, so we get an offset to make sure the motor returns to the same position each time
    private boolean ran; // ensures the motor shoots, otherwise, it will not run after one shot, needed for isFinished

    //used for creating the motor and setting the speed
    public SpinMotor(Motor moto, double speed) {
        this.motor = moto;
        this.speed = speed;
        
    }

    @Override
    public void initialize() {
        //sets the offset, not done at end because motor can stil be moving
        offset = motor.getPosition();
        //resets position to 0
        motor.setSelectedSensorPosition();
        ran = false;
        System.out.println("Round 1 pos:"+motor.getPosition());
        System.out.println("Round 2 pos: "+motor.getPosition());
        //sets speed
        motor.setMotorPercent(speed);
    }


    @Override
    // keeps going until isFinished returns true, pretty much a while loop
    public void execute() {
        double position = motor.getPosition();
        //position is ~11000 for 52 degrees of rotation
        if (position > 11000 - offset){
            //put motor in reverse to reset
            motor.setMotorPercent(-0.06);
            ran = true;
        }
        System.out.println("check position" + motor.getPosition());
      //  SmartDashboard.putNumber("Spinner Pos", motor.getPosition());

    }

    @Override
    // executed when isfinished returns true (below)
    public void end(boolean interrupted) {
        //stops motor
        motor.setMotorPercent(0);
        System.out.println("Goodbye World");
    }


    @Override
    public boolean isFinished() {
        // makes sure arm is at bottom and has shot before ending.
        if (motor.getPosition() < 0 && ran){
            return true;
        }
        return false;
    }
}
