/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CmdG_FullCollect extends CommandGroup {
  /**
   * Add your docs here.
   */
  public CmdG_FullCollect() {
    addParallel(new CmdI_BarOut());
    addParallel(new CmdI_ClawOpen());
    addParallel(new CmdI_BarMotorOn());
    addParallel(new CmdI_ClawMotorsIn());
    addSequential(new Cmd_ClawSensor());
    addSequential(new CmdI_BarIn());
    addParallel(new CmdI_BarMotorStop());
    addParallel(new CmdI_ClawMotorsOff());
  }
}
