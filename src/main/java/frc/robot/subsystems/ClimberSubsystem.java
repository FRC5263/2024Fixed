package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ClimberSubsystem extends SubsystemBase{

private final MotorController Climber;

public ClimberSubsystem(){
    Climber =  new CANSparkMax(4, MotorType.kBrushless);
    System.out.println("Climber subsystem created; god save us");
}

@Override
public void periodic() {
  
}
}