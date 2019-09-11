/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Cmd_TrackingApproach extends Command {
    double upperSpeed;
    double lowerSpeed;
    float sign;
    double distance;
    double height = 0.125;
    private double xTarget;
    private double yTarget;
    private double Kp = -0.035;
    private double min_command = 0.03;

    public Cmd_TrackingApproach(double upperSpeed, double lowerSpeed) {
      requires(Robot.s_drivetrain);
      requires(Robot.s_limelight);

        this.upperSpeed = upperSpeed;
        this.lowerSpeed = upperSpeed;
    }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    //Derives the distance of the target based on angle of camera to the angle of target
    //Returns distances in inches and gets fed into auto driving for auto steering and approach

    yTarget = Robot.s_limelight.getTargetOffsetY();
    double camera_angle = yTarget;

    distance = height/ Math.tan(camera_angle);

    Robot.s_drivetrain.drivePosReset();
    Robot.s_drivetrain.resetGyro();
    Robot.s_drivetrain.setSetpointPos(distance);
    setTimeout(15);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    xTarget = Robot.s_limelight.getTargetOffsetX();
      double heading_error = -xTarget;
      double steering_adjust = 0.0;

          if(xTarget > 1){
              steering_adjust = Kp * heading_error + min_command;
          }
          if(xTarget < 1){
              steering_adjust = Kp * heading_error - min_command;
    }

      Robot.s_drivetrain.driveToPosTrack(upperSpeed, lowerSpeed, steering_adjust);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
      sign = Math.signum((float)distance);

      if (sign == 1){
          return Robot.s_drivetrain.isDoneDriving() || isTimedOut();
      }
      if (sign == -1){
          return Robot.s_drivetrain.isDoneDrivingBack() || isTimedOut();
      }
      else{
          return false;
      }
    }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.s_drivetrain.driveStop();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.s_drivetrain.driveStop();

  }
}
