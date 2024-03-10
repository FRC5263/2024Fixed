// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;
import java.util.function.DoubleSupplier;


public class Drive extends Command{

  private final DriveTrainSubsystem drivetrain;
  private final DoubleSupplier throttle;
  private final DoubleSupplier rotation;

  public Drive(DriveTrainSubsystem drivetrain, DoubleSupplier throttle, DoubleSupplier rotation) {
    this.drivetrain = drivetrain;

    this.throttle = throttle;
    this.rotation = rotation;

    addRequirements(this.drivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    drivetrain.arcadeDrive(
    -throttle.getAsDouble(),
    rotation.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0.0, 0.0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
