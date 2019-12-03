/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class CmdI_ClawMotorsOut extends InstantCommand {
  /**
   * Add your docs here.
   */
  public CmdI_ClawMotorsOut() {
    super();
    requires(Robot.s_intake);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    Robot.s_intake.setClawMotor0Speed(-1);
    Robot.s_intake.setClawMotor1Speed(1);
  }

}