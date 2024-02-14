// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PWM;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;



public class DriveTrainSubsystem extends SubsystemBase {

  //init variables
    //CANSparkMax leftMotor1;

 PWMSparkMax frontRightDrive;
 PWMSparkMax backRightDrive;
 PWMSparkMax frontLeftDrive;
 PWMSparkMax backLeftDrive;
  Encoder frontRightDriveEncoder;
  Encoder backRightDriveEncoder;
  Encoder frontLeftDriveEncoder;
  Encoder backLeftDriveEncoder;
  DifferentialDrive differentialDriveTrain;
  Encoder[] encoders;

  public DriveTrainSubsystem(PWMSparkMax frontRightDrive, PWMSparkMax backRightDrive, PWMSparkMax frontLeftDrive, PWMSparkMax backLeftDrive){
    System.out.print("Creating new drivetrain subsystem");
    this.frontRightDrive = frontRightDrive;
    this.backRightDrive = backRightDrive;
    this.frontLeftDrive = frontLeftDrive;
    this.backLeftDrive = backLeftDrive;

    //Motor Controller groups
    frontRightDrive.addFollower(backRightDrive);
    frontLeftDrive.addFollower(backLeftDrive);
    
   
    this.differentialDriveTrain = new DifferentialDrive(frontRightDrive, frontLeftDrive);
    
    System.out.print("Drivetrain subsystem created");
  }

  public DriveTrainSubsystem(Encoder frontRightDriveEncoder, Encoder backRightDriveEncoder, Encoder frontLeftDriveEncoder, Encoder backLeftDriveEncoder){
    System.out.print("Creating drivetrain encoders");
    this.frontRightDriveEncoder = frontRightDriveEncoder;
    this.backRightDriveEncoder = backRightDriveEncoder;
    this.frontLeftDriveEncoder = frontLeftDriveEncoder;
    this.backLeftDriveEncoder = backLeftDriveEncoder;
    Encoder[] encoder = {frontRightDriveEncoder, backRightDriveEncoder, frontLeftDriveEncoder, backLeftDriveEncoder};
    this.encoders = encoder;
    System.out.print("Drivetrain encoders created");

  }

  public void DriveDifferentialCurvature(double xSpeed, double zRotation) {
    differentialDriveTrain.curvatureDrive(xSpeed, zRotation, true);
    SmartDashboard.putNumber("curvatureDrive Speed", xSpeed);
    SmartDashboard.putNumber("curvatureDrive Rotation", zRotation);
  }

  public int getEncoder (int encoder){
    if(encoders[encoder] !=null){
        return encoders[encoder].get();
     } else {
        System.out.print(encoders[encoder]);
        System.out.print( "isn't plugged in, cannot get encoder count\n");
        return -1;
     }
    }



  public void resetDriveTrainEncoders() {
    if (encoders != null) {
      for(int i = 0; i < encoders.length;  ++i) {
        encoders[i].reset();
      }
    } else {
      System.out.print("no encoders or no encoders defined\n");
    }
  }

  @Override
  public void periodic() {

  }

  /**
   * returns the set left side speed
   * @return left side speed
   */
  public double getLeftSpeed() {
    return frontLeftDrive.get();
  }

  /**
   * returns the set right side speed
   * @return right side speed
   */
  public double getRightSpeed() {
    return frontRightDrive.get();
  }
}

