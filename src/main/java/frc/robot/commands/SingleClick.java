/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.Robot;

public class SingleClick extends Command {
  public SingleClick() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.clickable);
  }
public static boolean checking = true;
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //System.out.println("Click detected");
    //Scheduler.getInstance().add(new PneumaticsToggleCommand(1));
    //System.out.println("Preparing to check");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //System.out.println("Checking...");
    /*if(Robot.m_oi.getMenuDrive() && checking) {
      Scheduler.getInstance().add(new DoubleClick());
      checking = !checking; 
    } */
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !checking;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
