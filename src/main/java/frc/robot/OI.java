/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AbortCommand;
import frc.robot.commands.DriveByCommand;
import frc.robot.commands.GettingDownFromTheStep;
import frc.robot.commands.GettingUpToLaSteppe;
import frc.robot.commands.HonkCommand;
import frc.robot.commands.KillScheduler;
import frc.robot.commands.PneumaticsToggleCommand;
import frc.robot.commands.ToggleDriveCommand;
import frc.robot.commands.ToggleDriveDirection;
import frc.robot.commands.TurnByCommand;
import frc.robot.commands.ElevatorMoveCommand;
import frc.robot.commands.testingCommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.IntakeOffsetCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
  public boolean original = true;
  public XboxController driveJoyStick = new XboxController(0);
  public XboxController gameJoyStick = new XboxController(1);
  public double intakeOffset = 0.25;

  public OI() {
    //X button toggles drive command
    JoystickButton driveXButton = new JoystickButton(driveJoyStick, 3);
    driveXButton.toggleWhenActive(new ToggleDriveCommand());
    driveXButton.close();

    //JoystickButton driveMenuButton = new JoystickButton(driveJoyStick, 8);
    //driveMenuButton.toggleWhenActive(new testingCommandGroup());
    //driveMenuButton.close(); 
    
    //JoystickButton driveAButton = new JoystickButton(driveJoyStick, 1);
    //driveAButton.toggleWhenActive(new GettingDownFromTheStep());
    //Scheduler.getInstance().add(new GettingDownFromTheStep());
 //   driveAButton.close();

    //JoystickButton driveBButton = new JoystickButton(driveJoyStick, 2);
     //driveBButton.toggleWhenActive(new DriveByCommand(-5));
    //driveBButton.toggleWhenActive(new GettingUpToLaSteppe());
    //driveBButton.close();

    //JoystickButton honkButton = new JoystickButton(driveJoyStick, 10);
    //honkButton.toggleWhenActive(new HonkCommand());
    //honkButton.close();


    //killScheduler.toggleWhenActive(new KillScheduler());
    //killScheduler.close();
    
    JoystickButton killSchedulerDrive = new JoystickButton(driveJoyStick, 8);
    killSchedulerDrive.toggleWhenActive(new KillScheduler());
    killSchedulerDrive.close();
    

   // JoystickButton honkButton = new JoystickButton(driveJoyStick, 10);
   // honkButton.toggleWhenActive(new HonkCommand());
   // honkButton.close();

   //Y button toggles drive direction
   JoystickButton driveYButton = new JoystickButton(driveJoyStick, 4);
   driveYButton.toggleWhenActive(new ToggleDriveDirection());
   driveYButton.close();

  JoystickButton leftBumper = new JoystickButton(driveJoyStick, 5);
  leftBumper.whenPressed(new TurnByCommand(-90));
  leftBumper.close();

  JoystickButton rightBumper = new JoystickButton(driveJoyStick, 6);
  rightBumper.whenPressed(new TurnByCommand(90));
  rightBumper.close();

  /*  if(original) {
      JoystickButton mmmtasty = new JoystickButton(gameJoyStick, 7);
      mmmtasty.whenPressed(new AbortCommand());
      mmmtasty.close();
   //   driveJoyStick = gameJoyStick;
   //   gameJoyStick = driveJoyStick;
    }
    if(original == false) {
      JoystickButton mmmtasty = new JoystickButton(gameJoyStick, 7);
      mmmtasty.whenPressed(new AbortCommand());
      mmmtasty.close();
   //   driveJoyStick = gameJoyStick;
   //   gameJoyStick = driveJoyStick;
    } */
  }
 
  
 
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
  
  public double getRightXDrive() {
    return (driveJoyStick.getX(Hand.kRight));
  }
  public double getRightYDrive() {
    return (driveJoyStick.getY(Hand.kRight));
  }
  public double getRightYGame() {
    return (gameJoyStick.getY(Hand.kRight));
  }
  public double getLeftYDrive() {
    return (driveJoyStick.getY(Hand.kLeft));
  }
  public double getLeftXDrive() {
    return (driveJoyStick.getX(Hand.kLeft));
  }
  public double getLeftTrigger() {
    return (driveJoyStick.getTriggerAxis(Hand.kLeft));
  }
  public double getRightTrigger() {
    return (driveJoyStick.getTriggerAxis(Hand.kRight));
  }
  public double getRightTriggerGame() {
    return (gameJoyStick.getTriggerAxis(Hand.kRight));
  }
  public boolean getAGame() {
    return (gameJoyStick.getAButton());
  }
  public boolean getADrive() {
    return (driveJoyStick.getAButton());
  }
  public boolean getBGame() {
    return (gameJoyStick.getBButton());
  }
  public boolean getBDrive() {
    return (driveJoyStick.getBButton());
  }
  public boolean getXGame() {
    return (gameJoyStick.getXButton());
  }
  public boolean getYGame() {
    return (gameJoyStick.getYButton());
  }
  public boolean getLeftBumperDrive() {
    return (driveJoyStick.getBumper(Hand.kLeft));
  }
  public boolean getRightBumperDrive() {
    return (driveJoyStick.getBumper(Hand.kRight));
  }
  public boolean getRightBumperGame() {
    return (gameJoyStick.getBumper(Hand.kRight));
  }
  public boolean getXClickDrive() {
    return (driveJoyStick.getXButtonReleased());
  }
  public double getTriggerDrive() {
    double RightAxis = driveJoyStick.getTriggerAxis(Hand.kRight);
    if (driveJoyStick.getTriggerAxis(Hand.kRight) < 0.3 && driveJoyStick.getTriggerAxis(Hand.kRight) > 0.1) {
      RightAxis += 0.3;
    }
    return ((driveJoyStick.getTriggerAxis(Hand.kRight)) - (driveJoyStick.getTriggerAxis(Hand.kLeft)));
  }

  public double getGameTriggerDrive() {
    double RightAxis = gameJoyStick.getTriggerAxis(Hand.kRight);
    double LeftAxis = gameJoyStick.getTriggerAxis(Hand.kLeft);
    //BEGIN DEBUG (ADD TENSION TO THE INTAKE ON LEFT SIDE)
   // LeftAxis += intakeOffset;
    if (LeftAxis > 1.0)
    {
      LeftAxis = 1.0;
    }

    return (-RightAxis+LeftAxis+intakeOffset);
  }
  public boolean getYClickGame() {
    return (gameJoyStick.getYButtonReleased());
  }
  public int getDpad() {
    return (driveJoyStick.getPOV());
  }
  public int getDpadGame() {
    return (gameJoyStick.getPOV());
  }

  public boolean getMenuDrive() {
    return (driveJoyStick.getStartButtonReleased());
  }

  
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
}