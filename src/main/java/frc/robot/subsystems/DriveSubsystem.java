/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.ToggleDriveCommand;

public class DriveSubsystem extends Subsystem {
  public static WPI_TalonSRX leftFront;
  public static WPI_TalonSRX rightFront;
  public static WPI_TalonSRX rightRear;
  public static WPI_TalonSRX leftRear;
  public DifferentialDrive treads;
  public XboxController m_mainJoyStick;
  public static boolean isBackward;

  public double leftRaw;
  public double rightRaw;
  private final AHRS navX;
/**
   * Add your docs here.
   */
  public DriveSubsystem() {
    leftFront = new WPI_TalonSRX(RobotMap.leftFront);
    leftRear = new WPI_TalonSRX(RobotMap.leftRear);
    rightFront = new WPI_TalonSRX(RobotMap.rightFront);
    rightRear = new WPI_TalonSRX(RobotMap.rightRear);
    leftRear.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    isBackward = false;
    
    //rightRear.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);


    
  //  System.out.println(rightRear.getSelectedSensorPosition(0));

    navX = new AHRS(SPI.Port.kMXP);

    SpeedControllerGroup leftSide = new SpeedControllerGroup(leftFront, leftRear);
    SpeedControllerGroup rightSide = new SpeedControllerGroup(rightFront, rightRear);
    
    
    treads = new DifferentialDrive(leftSide, rightSide);

  }
  public double getHeading() {
    double heading = navX.getAngle();
    if (heading < 0) {
        return 360 - (Math.abs(heading) % 360);
    } else {
        return Math.abs(heading) % 360;
    }
  }

public void resetGyro() {
  navX.reset();
}
  @Override
  public void periodic() {
<<<<<<< HEAD
    //SmartDashboard.putNumber("/left/raw", 1);
   // SmartDashboard.putNumber("/right/raw", rightRaw);

    //SmartDashboard.putNumber("Drive/Encoders/Encoder R", this.getEncoderRight());
    //SmartDashboard.putNumber("Drive/Encoders/Encoder L", this.getEncoderLeft());
   // SmartDashboard.putNumber("Drive/Encoders/left/raw", leftFront.getRaw());
    // SmartDashboard.putNumber("/right/raw", rightRaw);
    SmartDashboard.putNumber("Drive/Gyro/Angle", getHeading());
=======
   SmartDashboard.putNumber("Drive/Gyro/Angle", getHeading());
   SmartDashboard.putNumber("Drive/Encoders/Right", rightRear.getSelectedSensorPosition());
   SmartDashboard.putData("ToggleDriveCommand", new ToggleDriveCommand());
   System.out.println(rightRear.getSelectedSensorPosition(0));
>>>>>>> 2d37573ef9e08b4c6a2e5de3827bcb3ff1e6cd6f
  }

  @Override
  protected void initDefaultCommand() {
    //setDefaultCommand(new ArcadeDriveCommand());
  }

  public double getEncoderLeft() {
    return leftRear.getSelectedSensorPosition();
  }
  public double getEncoderRight() {
    return rightRear.getSelectedSensorPosition();
  } 
  
  public void arcadeDrive(double forward, double turn) {

    if(isBackward) {
      treads.arcadeDrive(forward, turn);
    } else {
      treads.arcadeDrive(-forward, turn);
    }
    //FORWARD: treads.arcadeDrive(-forward, turn);
    
  }
  public void flipDrive() {
    isBackward = !isBackward;
  }

  public void stop() {
    treads.stopMotor();
  }
}
