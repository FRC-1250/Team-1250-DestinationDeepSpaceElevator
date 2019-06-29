/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static final int ARM_DART0 = 20;
  public static final int ENCODER = 1;
  public static final int SERVO = 1;

  // Solenoid PCM Channel
  public static final int COL_SOL_HATCH = 0;
  public static final int COL_SOL_DROPINTAKEMOTORS = 1;
  public static final int COL_SOL_POKEEYES = 2;
// Collector Sensor IDs
  public static final int COL_SENSE_HATCH = 1;
  public static final int COL_SENSE_BALL = 0;
// Drop Motor Victors IDs
  public static final int COL_DROPINTAKEMOTOR_0 = 18;
  public static final int COL_DROPINTAKEMOTOR_1 = 19;
// Arm Collector ID

  public static final int COL_ARMINTAKEMOTOR_0 = 20;
  public static final int COL_ARMINTAKEMOTOR_1 = 21;
}
