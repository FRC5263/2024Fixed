// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Drive;
import frc.robot.commands.TeleOp;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer{
  private final DriveTrainSubsystem m_drivetrainSubsystem;
  private final XboxController m_driveController;


  private final Command m_DriveCommand;
  private final Command m_teleOp;
  public RobotContainer() {
    
    m_driveController = new XboxController(0);
    m_drivetrainSubsystem = new DriveTrainSubsystem();
    m_DriveCommand = new Drive(m_drivetrainSubsystem, null, null);
    m_teleOp = new TeleOp(m_drivetrainSubsystem, m_driveController);
  }
  public Command getTelOpCommand() {
    return m_teleOp;
  } 
}

