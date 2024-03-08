package frc.robot.commands;

import frc.robot.subsystems.ClimberSubsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

public class climber extends Command{
    private final ClimberSubsystem Climber;
    public final XboxController controller1;

    Double ySpeed;
    public climber(){
        Climber = new ClimberSubsystem();
        controller1 = new XboxController(1);

    }
        @Override
        public void initialize() {}
        @Override
        public void execute() {
            if(controller1.getBButton() == true){ Climber.ySpeed(.5); }
            else if(controller1.getBButton() == true){ Climber.ySpeed(.5);}
            else if(controller1.getBButton() == true && controller1.getBButton() == true) { Climber.ySpeed(.5);}
        }
        @Override
        public void end(boolean interrupted) {}
        @Override
        public boolean isFinished() { return false; }
  }
