/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTableEntry; 
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;

/**
 * Add your docs here.
 */

 //TODO: Setup the second Limelight to output to a netwrk table titled "limelight_secondary"

public class Sub_SecondaryLimelight extends Subsystem {
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight_secondary");


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public double getTargetOffsetXSecondary() {
    NetworkTableEntry tx = table.getEntry("tx");
    return  tx.getDouble(0); 
  }
  
  public double getTargetOffsetYSecondary() {
    NetworkTableEntry ty = table.getEntry("ty");
    return ty.getDouble(0);
  }
  
  public double getTargetAreaSecondary() {
    NetworkTableEntry ta = table.getEntry("ta");
    return ta.getDouble(0);
  }
}
