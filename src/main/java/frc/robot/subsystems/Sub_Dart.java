/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Servo;

/**
 * Add your docs here.
 */
public class Sub_Dart extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public WPI_TalonSRX dartMotor0 = new WPI_TalonSRX(RobotMap.ARM_DART0);
  DigitalInput encoder = new DigitalInput(RobotMap.ENCODER);
  Servo servo = new Servo(RobotMap.SERVO);

  public Sub_Dart(){
    dartMotor0.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    dartMotor0.config_kP(0, 2, 10);
    dartMotor0.config_kI(0, 0, 10);
    dartMotor0.config_kD(0, 2, 10);
  }

  public void resetArmPos(){
    dartMotor0.setSelectedSensorPosition(0);
  }

  public void dartDriveGoDown(){
    dartMotor0.set(-1);
  }

  public void dartDriveGoUp(){
    dartMotor0.set(1);
  }

  public void dartStop(){
    dartMotor0.set(0);
  }

  // -------- Velocity control
  public void dartVelocitySetUp(){
    dartMotor0.set(ControlMode.Velocity, 260);
  }

  public void dartVelocitySetDown(){
    dartMotor0.set(ControlMode.Velocity, -260);
  }

  public void dartVelocityStop(){
    dartMotor0.set(ControlMode.Velocity, 0);
  }
  // --------

  public void setArmPos(){
    dartMotor0.set(ControlMode.Position, 3600);
  }

  public void setServoAngle(double position){
    servo.setAngle(position);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
