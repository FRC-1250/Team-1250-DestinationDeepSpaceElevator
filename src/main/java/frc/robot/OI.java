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

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  Joystick Gamepad = new Joystick(0);
  Joystick BoardController = new Joystick(1);
  Joystick BoardLeftField = new Joystick(2);
  Joystick BoardRightField = new Joystick(3);

  JoystickButton a = new JoystickButton(Gamepad, 2);
  JoystickButton b = new JoystickButton(Gamepad, 3);
  JoystickButton y = new JoystickButton(Gamepad, 4);
  JoystickButton x = new JoystickButton(Gamepad, 1);
  JoystickButton rt = new JoystickButton(Gamepad, 8);
  JoystickButton lt = new JoystickButton(Gamepad, 7);
  
  public OI() {
    a.whenActive(new Cmd_ElevatorDown());
    b.whenActive(new Cmd_ElevatorStop());
    y.whenActive(new Cmd_ElevatorUp());
    x.whenActive(new Cmd_ResetPosition());
    rt.whenActive(new Cmd_ElevatorGo());
  }

  public Joystick getGamepad(){
    return Gamepad;
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

