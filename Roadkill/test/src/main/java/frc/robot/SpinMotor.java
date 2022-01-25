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
    private double speed; // percent output -1 -> 1
    private double offset;
    private boolean ran;

    public SpinMotor(Motor moto, double speed) {
        this.motor = moto;
        this.speed = speed;
        
    }

    @Override
    public void initialize() {
        offset = motor.getPosition();
        motor.setSelectedSensorPosition();
        ran = false;
        System.out.println("Round 1 pos:"+motor.getPosition());
        System.out.println("Round 2 pos: "+motor.getPosition());
        motor.setMotorPercent(speed);
        
    }


    @Override
    public void execute() {

        double position = motor.getPosition();
        if (position > 11000 - offset){
            //put motor in reverse
            motor.setMotorPercent(-0.06);
            ran = true;
        }
        System.out.println("check position" + motor.getPosition());
      //  SmartDashboard.putNumber("Spinner Pos", motor.getPosition());

    }

    @Override
    public void end(boolean interrupted) {
        motor.setMotorPercent(0);
        System.out.println("Goodbye World");
    }


    @Override
    public boolean isFinished() {
        
        
        if (motor.getPosition() < 0 && ran){
            return true;
        }
        return false;
    }
}
