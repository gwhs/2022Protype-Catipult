// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

//
//
//REVIEW: This creates motors, gives them speeds, and gets the position
// to create motors, pass in id to Motor, to give the speed, pass % speed as a decimal to  setMotorPercent, get position by calling getPosition
//
//
package frc.robot;
import java.sql.Time;
import frc.robot.SpinMotor;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase {
  private TalonFX motor;
  /** Creates a new motor. */
  public Motor(int id) {
    motor = new TalonFX(id);
    motor.config_kP(0, 2.0, 30);
    motor.config_kI(0, 0, 30);
    motor.config_kD(0, 0, 30);
    motor.config_kF(0, 0, 30);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler 

    }

  public TalonFX getMotor(){
    return motor;
  }

  public void current(double amps){
    motor.set(ControlMode.Current, amps);
  }


  }
