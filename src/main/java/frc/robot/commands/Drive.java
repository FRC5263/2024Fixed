// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.Encoder;

import java.lang.ModuleLayer.Controller;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;


public class Drive extends Command {
  /** Creates a new Drive. */
  public Drive() {
    // Use addRequirements() here to declare subsystem dependencies.
  }
  
  DriveTrainSubsystem driveTrain;
  MotorController leftMotor;
  MotorController rightMotor;
  DifferentialDrive differentialDriveTrain;

  Joystick controller1 = new Joystick(0);
  Joystick controller2 = new Joystick(1);

   /**
   * Creates a new DriverOperated.
   * @return 
   */
  public void DriverOperated(DriveTrainSubsystem driveTrain, MotorController leftmotor, MotorController rightMotor) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveTrain = driveTrain;
  }

  /*public void drive(double horizontalSpeed, double forwardSpeed, double rotation) {
    driveTrain.driveCartesian(horizontalSpeed, forwardSpeed, rotation);
  }*/


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}
    // driving: left stick
    double forwardSpeed = controller1.getRawAxis(5);
    double horizontalSpeed = controller1.getRawAxis(4);
    double rotation = controller1.getRawAxis(0);
    boolean slowButton = controller1.getRawButton(2);

    Double slowDownFactor = .3;{
    /*if(slowButton){
      driveTrain.drive(slowDownFactor * horizontalSpeed, slowDownFactor * -forwardSpeed, slowDownFactor * rotation);
    }else{
      driveTrain.drive(horizontalSpeed, -forwardSpeed, rotation);
    }*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
