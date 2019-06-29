/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private Joystick Gamepad;
  private TalonSRX dartMotor;

  @Override
  public void robotInit() {
    Gamepad = new Joystick(0);
    dartMotor = new TalonSRX(20);

    dartMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    dartMotor.config_kP(0, 10, 10);
    dartMotor.config_kI(0, 0, 10);
    dartMotor.config_kD(0, 2, 10);
  }

  @Override
  public void teleopPeriodic() {
    if (Gamepad.getY() > 0.2) {
      dartMotor.set(ControlMode.Velocity, 260);
    }
    else if (Gamepad.getY() < -0.2) {
      dartMotor.set(ControlMode.Velocity, -260);
    }
    else {
      dartMotor.set(ControlMode.Velocity, 0);
      dartMotor.
    }

  }

  

}
