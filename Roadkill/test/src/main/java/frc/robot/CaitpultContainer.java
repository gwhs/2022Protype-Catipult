// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.SpinMotor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

/** Add your docs here. */
public class CaitpultContainer {
    XboxController mXbox;
    private Motor motor;
    private final SpinMotor m_SpinMotor = new SpinMotor(motor, 0.5);

    public CaitpultContainer() {
        motor = new Motor(7);
        mXbox = new XboxController(0);
        configureButtonBindings();
        
    }

    private void configureButtonBindings() {
        JoystickButton buttonA = new JoystickButton(mXbox, XboxController.Button.kA.value);

        buttonA.whenPressed(new SpinMotor(motor, 0.7).withTimeout(0.1));

        
        //JoystickButton buttonA = new JoystickButton(xbox, XboxController.Button.kA.value);

        //buttonA.whenPressed(new commands(m_blue, m_white, 1.0));
    }

    public Object getAutonomousCommand() {
        return null;
    }
}
