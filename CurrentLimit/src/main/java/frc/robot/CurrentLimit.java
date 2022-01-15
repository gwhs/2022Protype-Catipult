// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;


public class CurrentLimit extends CommandBase {
  private TalonFX talon;
  private double targetPosition;
  private double initPos;
  /** Creates a new CurrentLimit. */
  public CurrentLimit() {
    // Use addRequirements() here to declare subsystem dependencies.
    // s
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  
  //
  
  public void changeMotorAngle(TalonFX talon){

    talon.set(TalonFXControlMode.Velocity,100); // NUMBERS DONT MATTER
    
    try {
      Thread.sleep(10);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    
    talon.set(TalonFXControlMode.Velocity,0);

  }
}
