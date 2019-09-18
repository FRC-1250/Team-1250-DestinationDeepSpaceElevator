/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Cmd_ElevatorJog extends Command {
  public Cmd_ElevatorJog() {
    requires(Robot.s_elevator);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if ((int)Robot.m_oi.getGamePad2().getRawAxis(4) < 0.1){
      Robot.s_elevator.elevatorDriveGoDown();
    }
    else if((int)Robot.m_oi.getGamePad2().getRawAxis(4) > -0.1)
    {
      Robot.s_elevator.elevatorDriveGoUp();
    }
    else{
      Robot.s_elevator.elevatorStop();
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
