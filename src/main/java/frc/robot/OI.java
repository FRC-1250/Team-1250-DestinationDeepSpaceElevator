/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Cmd_DartDown;
import frc.robot.commands.Cmd_DartStop;
import frc.robot.commands.Cmd_DartUp;
import frc.robot.commands.Cmd_ElevatorGo;
import frc.robot.commands.Cmd_ResetPosition;
import frc.robot.commands.Cmd_ServoAngle;
import frc.robot.commands.Cmd_VelocityDown;
import frc.robot.commands.Cmd_VelocityStop;
import frc.robot.commands.Cmd_VelocityUp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  Joystick Gamepad = new Joystick(0);

  JoystickButton a = new JoystickButton(Gamepad, 2);
  JoystickButton b = new JoystickButton(Gamepad, 3);
  JoystickButton y = new JoystickButton(Gamepad, 4);
  JoystickButton x = new JoystickButton(Gamepad, 1);
  JoystickButton rt = new JoystickButton(Gamepad, 8);
  JoystickButton lt = new JoystickButton(Gamepad, 7);
  
  public OI() {
    a.whenActive(new Cmd_DartDown());
    b.whenActive(new Cmd_DartStop());
    y.whenActive(new Cmd_DartUp());
    x.whenActive(new Cmd_ResetPosition());
    rt.whenActive(new Cmd_ElevatorGo());
    lt.whenActive(new Cmd_ServoAngle(90));
  }
}
