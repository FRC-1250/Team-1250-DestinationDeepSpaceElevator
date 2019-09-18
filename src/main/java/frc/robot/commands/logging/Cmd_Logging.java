/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Cmd_Logging extends Command {

  public String logFileName;
  public double leftMotorTemp;
  public String leftMotorString;
  public double rightMotorTemp;
  public String rightMotorString;
  public double matchTime;

  public Cmd_Logging() {
    //Do not state the requires for other subsystems, it may mess with commands running in the foreground
    requires(Robot.s_logging);
  }

  @Override
  protected void initialize() {

  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
  LocalDateTime now = LocalDateTime.now();  
  logFileName = "General Gator Log" + dtf.format(now);
  Robot.s_logging.createFile(logFileName);
  }

  @Override
  protected void execute() {

    matchTime = DriverStation.getInstance().getMatchTime();

    //Values for file logging
    leftMotorTemp = Robot.s_drivetrain.leftDriveTempMax();
    rightMotorTemp = Robot.s_drivetrain.rightDriveTempMax();

    //Cast to trings and add extra information
    leftMotorString = (Double.toString(leftMotorTemp) + "LeftMotorTemp" + matchTime);
    rightMotorString = (Double.toString(rightMotorTemp) + "RightMotorTemp" + matchTime);

    //File writing
    Robot.s_logging.writeToFile(leftMotorString);
    Robot.s_logging.writeToFile(rightMotorString);


  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.s_logging.flushWriteBuffer();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
