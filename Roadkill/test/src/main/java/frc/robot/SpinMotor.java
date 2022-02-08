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
    private double amps;
    //used for creating the motor and setting the speed
    public SpinMotor(Motor moto, double amps) {
        this.motor = moto;
        // this.speed = speed;
        this.amps = amps;

        
    }

    @Override
    public void initialize() {
        motor.current(60.0);
    }


    @Override
    // keeps going until isFinished returns true, pretty much a while loop
    public void execute() {

    }

    @Override
    // executed when isfinished returns true (below)
    public void end(boolean interrupted) {

    }


    @Override
    public boolean isFinished() {
        return true;
    }
    }
