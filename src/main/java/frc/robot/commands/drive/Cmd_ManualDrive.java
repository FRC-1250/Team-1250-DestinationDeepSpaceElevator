/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Cmd_ManualDrive extends Command {

  private double xTarget;
  private double Kp = -0.025;
  private double min_command = 0.03;

  public Cmd_ManualDrive() {
    requires(Robot.s_drivetrain);
    requires(Robot.s_limelight);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    //This method is used for protecting motor under high heat
    Robot.s_drivetrain.linearDrivingAmpControl();
    
    //This if statement looks for buttons to switch into vision assisted driving
    if (Robot.m_oi.getButtonState(7) && Robot.m_oi.getButtonState(8)) {
      xTarget = Robot.s_limelight.getTargetOffsetX();
      double heading_error = -xTarget;
      double steering_adjust = 0.0;

          if(xTarget > 1){
              steering_adjust = Kp * heading_error + min_command;
          }
          if(xTarget < 1){
              steering_adjust = Kp * heading_error - min_command;
          }
          Robot.s_drivetrain.slowBoy();
      Robot.s_drivetrain.trackCubeManualSpeed(steering_adjust, -Robot.m_oi.getGamepad().getThrottle());
      }

      //These statements are used for switching between differnt driver configurations
      //slowBoy is the method that is used for normal driving ramps
      //speedRacer sets curves to 1/8th as agressive = more accel
      //drive is normal 2 stick tank drive
      //driveArcade is a 1 stick arcade style drive

        else if (Robot.m_oi.getButtonState(8)){
          Robot.s_drivetrain.slowBoy();
            Robot.s_drivetrain.driveArcade(Robot.m_oi.getGamepad());
        }
        else if (Robot.m_oi.getButtonState(12)){
          Robot.s_drivetrain.driveArcade(Robot.m_oi.getGamepad());
          Robot.s_drivetrain.speedRacer();

        }
        else if (Robot.m_oi.getButtonState(9)){
          Robot.s_drivetrain.driveSlow(Robot.m_oi.getGamePad2());
        }
          else {
              Robot.s_drivetrain.drive(Robot.m_oi.getGamepad());
              Robot.s_drivetrain.slowBoy();
          }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}