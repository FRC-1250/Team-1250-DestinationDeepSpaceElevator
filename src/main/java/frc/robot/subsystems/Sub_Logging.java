/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Sub_Logging extends Subsystem {
 
  public BufferedWriter loggingOut;
  
  public void createFile() throws IOException {
  loggingOut = new BufferedWriter(new FileWriter("loggingoutput.txt"));
  }

  public void writeToFile(String loggingInput) throws IOException {
    loggingOut.write(loggingInput);
  }

  public void flushWriteBuffer() throws IOException {
    loggingOut.flush();
  }
  
  public void newBufferedLine() throws IOException {
    loggingOut.newLine();
  }

  @Override
  public void initDefaultCommand() {
    //TODO Create a logging command here
    // setDefaultCommand(new MySpecialCommand());
  }
}
