// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.climberCommand;


import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.Elbow;
import frc.robot.subsystems.ClimberSubsystem;

public class TeleOp extends Command {
  //init variables
  DriveTrainSubsystem differentialDriveTrain;
  DriveTrainSubsystem driveTrainEncoders;
  Elbow elbow;
  ClimberSubsystem climberEncoder;
 
  XboxController controller0;
  XboxController controller1;
  
  boolean driveTrainOnly;
  double xSpeed;
  double zSpeed;
  double ySpeed;

  //docstring
  /**
   * creates the teleop command for the teleop period of the robot
   * @param differentialDriveTrain  the robots drive train motors
   * @param driveTrainEncoders  the robots drive train encoders
   * @param Elbow the arm motors
   * @param claw  the claw motors
   */
  public TeleOp(DriveTrainSubsystem differentialDriveTrain, XboxController controller0, Elbow elbow, XboxController controller1, ClimberSubsystem climber, XboxController controller3) {
    System.out.print("Creating new Teleop\n");

    //assingning method inputs to class variables
    this.differentialDriveTrain = differentialDriveTrain;
   
    this.controller0 = controller0;
    this.controller1 = controller1;
    

    System.out.print("Teleop created\n");

    //setting drive train only to false
    driveTrainOnly = false;
  }

  //docstring
  /**
   * creates a teleop command for the teleop period that only has the drive train
   * @param differentialDriveTrian the robots drive train motors 
   * @param driveTrainEncoders the robots drive train encoders
   * @param controller0 driver controller
   * @param controller1 operator controller
   */


// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.print("Teleop initialized\n");
    xSpeed = 0;
    zSpeed = 0;
    ySpeed = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //deadzones x dircetion
    if (controller0.getRawAxis(1) < .301 && controller0.getRawAxis(1) > -.301) {
      xSpeed = 0;
    } else {
      xSpeed = controller0.getRawAxis(1) - (controller0.getRawAxis(3)*.5);
    }

    //deadzones y direction
    if (controller0.getRawAxis(0) < .301 && controller0.getRawAxis(0) > -.301) {
      zSpeed = 0;
    } else {
      zSpeed = controller0.getRawAxis(0) - (controller0.getRawAxis(3)*.5);
    }
    if(controller1.getBButton() == true){ climberEncoder.ySpeed(-.5); }
            else if(controller1.getBButton() == true){ climberEncoder.ySpeed(.5);}
            else if(controller1.getBButton() == true && controller1.getBButton() == true) { climberEncoder.ySpeed(.5);
            }
        

    //drive train uses curvature drive, one stick operation
    differentialDriveTrain.arcadeDrive(xSpeed, zSpeed);

    //left vibrator indicates robot is rotating
    controller0.setRumble(RumbleType.kRightRumble, controller0.getRawAxis(0) * 2);

    //checks if drive train only is true and the decidies wether or not to execute code for the other subsystems
    if (driveTrainOnly == false) {

       
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //indicates teleop is over
    System.out.print("TeleOp ended");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

