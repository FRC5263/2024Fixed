package frc.robot.commands;

import frc.robot.subsystems.ClimberSubsystem;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class climber extends Command{
    private final Climber;
    public final controller0;
    public final controller1;

    Double ySpeed;
    public climber(){
        Climber = new ClimberSubsystem();
    }

  }
