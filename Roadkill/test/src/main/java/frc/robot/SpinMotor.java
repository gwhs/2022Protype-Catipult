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
    private double speed; // perscent output -1 -> 1

    public SpinMotor(Motor moto, double speed) {
        this.motor = moto;
        this.speed = speed;
    }

    @Override
    public void initialize() {

        motor.setSelectedSensorPosition();
        motor.setMotorPercent(speed);
    }


    @Override
    public void execute() {
        System.out.println(motor.getPosition());
        double position = motor.getPosition();
        if (position > 240){
            //put motor in reverse
            motor.setMotorPercent(-0.06);
        } 
        SmartDashboard.putNumber("Spinner Pos", motor.getPosition());

    }

    @Override
    public void end(boolean interrupted) {
        motor.setSelectedSensorPosition();
        motor.setMotorPercent(0);
        System.out.println("Goodbye World");

    }


    @Override
    public boolean isFinished() {
        if (motor.getPosition() < 0){
            return true;
        }
        return false;
    }
}
