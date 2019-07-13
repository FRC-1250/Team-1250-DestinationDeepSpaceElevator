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
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.Cmd_HoldElevator;
import edu.wpi.first.wpilibj.Servo;

/**
 * Add your docs here.
 */
public class Sub_Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // public WPI_TalonSRX elevatorMotor0 = new WPI_TalonSRX(RobotMap.ELEVATOR_MOTOR_0);
  public CANSparkMax elevatorMotor0 = new CANSparkMax(RobotMap.ELEVATOR_MOTOR_0, MotorType.kBrushless);

  public CANPIDController pid0 = new CANPIDController(elevatorMotor0);
  public CANEncoder encoder0 = new CANEncoder(elevatorMotor0);

  public double rev_math = -0.75;
  public double lastpos;

  public Sub_Elevator(){
    pid0.setP(1);
    pid0.setI(0);
    pid0.setD(0);
    pid0.setOutputRange(-0.4, 0.4);

    elevatorMotor0.setIdleMode(IdleMode.kBrake);

  }

  public void resetArmPos(){
    encoder0.setPosition(0);
  }

  public void elevatorDriveGoDown(){
    elevatorMotor0.set(-0.3);
  }

  public void elevatorDriveGoUp(){
    elevatorMotor0.set(0.3);
  }

  public void elevatorStop(){
    elevatorMotor0.set(0);
  }

  public double elevatorRotations(){
    return encoder0.getPosition();
  }

  public void keepTrack(){
    lastpos = encoder0.getPosition();
  }

  public void holdPos(){
    pid0.setReference(lastpos, ControlType.kPosition);
  }

  // -------- Velocity control
  // public void elevatorVelocitySetUp(){
  //   elevatorMotor0.set(ControlMode.Velocity, 260);
  // }

  // public void elevatorVelocitySetDown(){
  //   elevatorMotor0.set(ControlMode.Velocity, -260);
  // }

  // public void elevatorVelocityStop(){
  //   elevatorMotor0.set(ControlMode.Velocity, 0);
  // }
  // --------

  public void setArmPos(double inches){
    pid0.setReference(inches * rev_math, ControlType.kPosition);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Cmd_HoldElevator());
  }
}
