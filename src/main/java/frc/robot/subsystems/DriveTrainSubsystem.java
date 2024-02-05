// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


public class DriveTrainSubsystem extends SubsystemBase {

  //init variables
  CANSparkMax leftMotor1;
  CANSparkMax rightMotor1;
  CANSparkMax leftMotor2;
  CANSparkMax rightMotor2;
  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;
  Encoder leftEncoder1;
  Encoder rightEncoder1;
  Encoder leftEncoder2;
  Encoder rightEncoder2;
  DifferentialDrive differentialDriveTrain;
  Encoder[] encoders;

  public DriveTrainSubsystem(CANSparkMax leftMotor1, CANSparkMax leftMotor2, CANSparkMax rightMotor1, CANSparkMax rightMotor2){
    System.out.print("Creating new drivetrain subsystem");
    this.leftMotor1 = leftMotor1;
    this.rightMotor1 = rightMotor1;
    this.leftMotor2 = leftMotor2;
    this.rightMotor2 = rightMotor2;
    this.leftMotors = new MotorControllerGroup(leftMotor1, leftMotor2);
    this.rightMotors = new MotorControllerGroup(rightMotor1, rightMotor2);
    this.differentialDriveTrain = new DifferentialDrive(leftMotors, rightMotors);
    System.out.print("Drivetrain subsystem created");
  }

  public DriveTrainSubsystem(Encoder rightEncoder1, Encoder leftEncoder1, Encoder rightEncoder2, Encoder leftEncoder2){
    System.out.print("Creating drivetrain encoders");
    this.leftEncoder1 = leftEncoder1;
    this.rightEncoder1 = rightEncoder1;
    this.rightEncoder2 = rightEncoder2;
    this.leftEncoder2 = leftEncoder2;
    Encoder[] encoder = {leftEncoder1, rightEncoder1, leftEncoder2, rightEncoder2};
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
    return leftMotors.get();
  }

  /**
   * returns the set right side speed
   * @return right side speed
   */
  public double getRightSpeed() {
    return rightMotors.get();
  }
}

