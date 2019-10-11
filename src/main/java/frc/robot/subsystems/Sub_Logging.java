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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.logging.Cmd_Logging;

/**
 * Add your docs here.
 */
public class Sub_Logging extends Subsystem {
 
  public BufferedWriter loggingOut;

  public String logFileName;
  
  public void createFile(String fileName){    
    try {
      loggingOut = new BufferedWriter(new FileWriter(fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeToFile(String loggingInput){
    try {
      loggingOut.write(loggingInput);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void flushWriteBuffer(){
    try {
      loggingOut.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public void newBufferedLine(){
    try {
      loggingOut.newLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addToLogDouble(double addDouble){
    String addDoubleString = Double.toString(addDouble);
    

  }

  @Override
  public void initDefaultCommand() {
      setDefaultCommand(new Cmd_Logging());
  }
}
