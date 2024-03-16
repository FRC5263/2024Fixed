// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;

public class AutonBad extends Command {
  Timer timer;
  DriveTrainSubsystem drivetrain;
  boolean autonCompleted = false;
  /** Creates a new Auton. */
  public AutonBad(DriveTrainSubsystem drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    Timer timer = new Timer();
    this.timer = timer;
    timer.start();
    System.out.print("Auton Timer Started");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      System.out.print("Execute\n");
      if (autonCompleted == false) {
        if (timer.get() >= 1 && timer.get() <= 2) {
          drivetrain.arcadeDrive(.3, 0);
        }
        else if (timer.get() >= 2 && timer.get() <3) {
          System.out.print("2 seconds\n");
          drivetrain.arcadeDrive(.1, 0);

        }
        else if (timer.get() >= 3 && timer.get() <= 4) {
          System.out.print("3 seconds\n");
          drivetrain.arcadeDrive(-.3, 0);
        }
        else if (timer.get() >= 4) {
          drivetrain.arcadeDrive(0, 0);
          autonCompleted = true;
          System.out.print("Auton Completed\n");
        }
      }
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