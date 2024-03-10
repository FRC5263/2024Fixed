package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase{
    public CANSparkMax rightshooter;
    public CANSparkMax leftshooter;
    public ShooterSubsystem(){
        leftshooter = new CANSparkMax(3, MotorType.kBrushless);
        rightshooter = new CANSparkMax(7, MotorType.kBrushless);
    }

    public void shoottheshooter(double shooterpower){
        rightshooter.set(shooterpower);
        leftshooter.set(shooterpower);
    }
    //40
}
