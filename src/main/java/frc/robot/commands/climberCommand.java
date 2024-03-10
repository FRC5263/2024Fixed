package frc.robot.commands;

import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class climberCommand extends Command{
    private final ClimberSubsystem climber;
    

    Double ySpeed;
    public climberCommand(ClimberSubsystem climber){
        this.climber = climber;
        addRequirements(climber);
    }
        @Override
        public void initialize() {}
        @Override
        public void execute() {
        
        }
        
        @Override
        public void end(boolean interrupted) {}
        @Override
        public boolean isFinished() { return false; }
  }
  
