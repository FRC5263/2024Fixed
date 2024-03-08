package frc.robot.commands;

import frc.robot.subsystems.ClimberSubsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class climberCommand extends Command{
    private final ClimberSubsystem climber;
    public final XboxController controller3;

    Double ySpeed;
    public climberCommand(ClimberSubsystem climberSubsystem){
        climber = climberSubsystem;
        controller3 = new XboxController(3);

    }
        @Override
        public void initialize() {}
        @Override
        public void execute() {
        if(controller3.getBButton() == true){ climber.ySpeed(.5); }
            else if(controller3.getBButton() == true){ climber.ySpeed(.5);}
            else if(controller3.getBButton() == true && controller3.getBButton() == true) { climber.ySpeed(.5);}
        
        }
        
        @Override
        public void end(boolean interrupted) {}
        @Override
        public boolean isFinished() { return false; }
  }
  
