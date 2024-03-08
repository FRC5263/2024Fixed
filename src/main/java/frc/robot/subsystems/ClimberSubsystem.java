package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ClimberSubsystem extends SubsystemBase{

private final CANSparkMax climberEncoder;

public ClimberSubsystem(){
    climberEncoder =  new CANSparkMax(9, MotorType.kBrushless);
    System.out.println("Climber subsystem created; god save us");
}

@Override
public void periodic() {
  
}
public void ySpeed(double Power){
    climberEncoder.set(Power);



SmartDashboard.putNumber("Climber Power", Power);

}

}