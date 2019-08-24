/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Cmd_ElevatorDown;
import frc.robot.commands.Cmd_ElevatorStop;
import frc.robot.commands.Cmd_ElevatorUp;
import frc.robot.commands.Cmd_ElevatorGo;
import frc.robot.commands.Cmd_ResetPosition;
import frc.robot.commands.collector.CmdG_CollectorFullCollectWithTiming;
import frc.robot.commands.collector.CmdI_CollectorArmIntakeOff;
import frc.robot.commands.collector.CmdI_CollectorHatchFullPlace;
import frc.robot.commands.collector.CmdI_CollectorHatchTongueExtend;
import frc.robot.commands.collector.CmdI_CollectorHatchTongueRetract;
import frc.robot.commands.collector.CmdT_CollectorArmIntakeSpit;
import frc.robot.commands.collector.Cmd_CollectorInput;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick Gamepad = new Joystick(0);
  Joystick Gamepad2 = new Joystick(4);
  Joystick BoardController = new Joystick(1);
  Joystick BoardLeftField = new Joystick(2);
  Joystick BoardRightField = new Joystick(3);

  JoystickButton a = new JoystickButton(Gamepad, 2);
  JoystickButton b = new JoystickButton(Gamepad, 3);
  JoystickButton y = new JoystickButton(Gamepad, 4);
  JoystickButton x = new JoystickButton(Gamepad, 1);
  JoystickButton rt = new JoystickButton(Gamepad, 8);
  JoystickButton lt = new JoystickButton(Gamepad, 7);
  
  JoystickButton a2 = new JoystickButton(Gamepad2, 2);
  JoystickButton b2 = new JoystickButton(Gamepad2, 3);
  JoystickButton y2 = new JoystickButton(Gamepad2, 4);
  JoystickButton x2 = new JoystickButton(Gamepad2, 1);
  JoystickButton rb = new JoystickButton(Gamepad, 5);
  JoystickButton rt2 = new JoystickButton(Gamepad2, 8);
  JoystickButton lt2 = new JoystickButton(Gamepad2, 7);

  public double highest_pos = 32;
  public double lowest_pos = 2;

  public OI() {
    a2.whenActive(new Cmd_ElevatorDown());
    b2.whenActive(new Cmd_ElevatorStop());
    y2.whenActive(new Cmd_ElevatorUp());
    x2.whenActive(new Cmd_ResetPosition());
    rt2.whenActive(new Cmd_ElevatorGo(lowest_pos));
    lt2.whenActive(new Cmd_ElevatorGo(highest_pos));

    lt.whenActive(new CmdI_CollectorHatchTongueExtend());
    rt.whenActive(new CmdI_CollectorHatchFullPlace());
    rb.whenActive(new CmdI_CollectorArmIntakeOff());
    a.whenActive(new CmdI_CollectorHatchTongueRetract());
    y.whenActive(new Cmd_CollectorInput());
    x.whenActive(new CmdG_CollectorFullCollectWithTiming());
    b.whenActive(new CmdT_CollectorArmIntakeSpit(1));
  }

  public Joystick getGamepad(){
    return Gamepad;
  }

  public Joystick getGamePad2(){
    return Gamepad2;
  }

  public Joystick getBoardController(){
    return BoardController;
  }

  public Joystick getLeftField(){
    return BoardLeftField;
  }

  public boolean getButtonState(int btn) {
    return Gamepad.getRawButton(btn);
  }
  
  public boolean getButtonStateBoard(int btn) {
    return BoardController.getRawButton(btn);
  }
}

