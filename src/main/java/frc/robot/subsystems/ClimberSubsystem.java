package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ClimberSubsystem extends SubsystemBase{
    public CANSparkMax climbermotor;

    public ClimberSubsystem(){
        climbermotor = new CANSparkMax(4, MotorType.kBrushless);
    }
    public void climb(double climbpower){
        climbermotor.set(climbpower);
    }
}