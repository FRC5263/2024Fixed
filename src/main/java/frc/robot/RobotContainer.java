// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.AutonBad;
import frc.robot.commands.Drive;
import frc.robot.commands.TeleOp;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.Elbow;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ClimberSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer{
  private final DriveTrainSubsystem m_drivetrainSubsystem = new DriveTrainSubsystem();
  private final Elbow m_elbow = new Elbow();
  private final intake m_intakemotor = new intake();
  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();
  private final ClimberSubsystem m_ClimberSubsystem = new ClimberSubsystem();
 
  XboxController  m_driveController = new XboxController(0);
  XboxController  m_elbowController = new XboxController(1);
  private final Command m_teleOp;
  private final Command m_autonBad;

  public RobotContainer() {
    m_drivetrainSubsystem.setDefaultCommand(new Drive(m_drivetrainSubsystem, ()-> m_driveController.getLeftY(), ()-> m_driveController.getRightX()));

    m_teleOp = new TeleOp(m_drivetrainSubsystem, m_driveController, m_elbow, m_elbowController, m_intakemotor, m_ShooterSubsystem, m_ClimberSubsystem);
    m_autonBad = new AutonBad(m_drivetrainSubsystem);

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    //new JoystickButton(m_elbowController, Button.kB.value).onTrue(new ElbowActuate(m_elbow));
  }

  public Command getTeleOpCommand() {
    return m_teleOp;
  } 

  public Command getAutonBadCommand() {
    return m_autonBad;
  }
}

