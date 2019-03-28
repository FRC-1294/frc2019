/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DelayCommand extends Command {
  double delay;
  Timer m_time;
  boolean isFinished = false;
  public DelayCommand(double timeToDelay) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.delay = timeToDelay;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_time = new Timer();
    m_time.reset();
    m_time.start();
    isFinished = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(m_time.get() > delay) {
      isFinished = true;
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
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
