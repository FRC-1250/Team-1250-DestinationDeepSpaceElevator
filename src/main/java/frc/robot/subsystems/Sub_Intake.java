/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Sub_Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_VictorSPX intakeBarMotor0 = new WPI_VictorSPX(RobotMap.COL_BARINTAKEMOTOR_0);
  WPI_VictorSPX intakeBarMotor1 = new WPI_VictorSPX(RobotMap.COL_BARINTAKEMOTOR_1);
  WPI_VictorSPX intakeClawMotor0 = new WPI_VictorSPX(RobotMap.COL_CLAWMOTOR_0);
  WPI_VictorSPX intakeClawMotor1 = new WPI_VictorSPX(RobotMap.COL_CLAWMOTOR_1);
  DigitalInput ballSensor = new DigitalInput(RobotMap.COL_SENSE_BALL);
  Solenoid solenoidClaw = new  Solenoid(RobotMap.COL_SOL_CLAW);
  Solenoid solenoidBar = new Solenoid(RobotMap.COL_SOL_BAR);

  public Sub_Intake(){

    intakeBarMotor.setNeutralMode(NeutralMode.Brake);
    intakeClawMotor0.setNeutralMode(NeutralMode.Brake);
    intakeClawMotor1.setNeutralMode(NeutralMode.Brake);

  }

  public void setBarMotorSpeed(double speed){
    intakeBarMotor.set(speed);
  }

  public void setClawMotor0Speed(double speed){
    intakeClawMotor0.set(speed);
  }

  public void setClawMotor1Speed(double speed){
    intakeClawMotor1.set(speed);
  }

  public boolean getBallSensor(){
    return ballSensor.get();
  }

  public void setSolenoidClawStatus(boolean status){
    solenoidClaw.set(status);
  }

  public void setSolenoidBarStatus(boolean status){
    solenoidBar.set(status);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
