// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Drive;
import frc.robot.commands.ElbowActuate;
import frc.robot.commands.TeleOp;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.Elbow;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.commands.climberCommand;
import frc.robot.commands.ElbowControl;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer{
  private final DriveTrainSubsystem m_drivetrainSubsystem = new DriveTrainSubsystem();
  private final Elbow m_elbow = new Elbow();
  private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
 
  XboxController  m_driveController = new XboxController(0);
  XboxController  m_elbowController = new XboxController(1);
  private final Command m_teleOp;

  public RobotContainer() {
        
    m_climberSubsystem.setDefaultCommand(new climberCommand(m_climberSubsystem));
    m_drivetrainSubsystem.setDefaultCommand(new Drive(m_drivetrainSubsystem, ()-> m_driveController.getLeftY(), ()-> m_driveController.getRightX()));

    m_teleOp = new TeleOp(m_drivetrainSubsystem, m_driveController, m_elbow, m_elbowController, m_climberSubsystem);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    new JoystickButton(m_elbowController, Button.kB.value).onTrue(new ElbowActuate(m_elbow));
  }

  // public Command getTelOpCommand() {
  //   return m_teleOp;
  // } 
}

