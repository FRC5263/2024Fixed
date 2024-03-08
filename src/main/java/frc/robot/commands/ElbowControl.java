// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Elbow;

import edu.wpi.first.wpilibj.XboxController;



public class ElbowControl extends Command {
  Elbow elbow;
  XboxController controller1;
private final double ySpeed;


  /** Creates a new armControl object */
  public ElbowControl(Elbow elbow, double ySpeed) {
    this.elbow = elbow;
    this.ySpeed = ySpeed;

    addRequirements(this.elbow);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //checks if the buttons are pressed down
    if (controller1.getRawButton(1) == true) {
      elbow.ySpeed(.5);
    } else if (controller1.getRawButton(1) == true) {
      elbow.ySpeed(.5);
    } else if (controller1.getRawButton(1) == true && (controller1.getRawButton(1) == true)) {
      elbow.ySpeed(0);
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