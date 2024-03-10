package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




public class Elbow extends SubsystemBase {


private final CANSparkMax elbow;
Encoder elbowEncoder;

private boolean elbowOn = false;


public Elbow() {

  elbow = new CANSparkMax(9, MotorType.kBrushless);
  elbow.restoreFactoryDefaults();
System.out.print("Elbow Subsystem Created\n");
System.out.print("Elbow Encoder Created\n");

elbow.setIdleMode(IdleMode.kCoast);

elbow.setInverted(true);

}

public void ySpeed(double power) {

elbow.set(power);


SmartDashboard.putNumber("ElbowSpeed Power", power);

}




  @Override
  public void periodic() {
    
  }

  public void toggleElbow() {
    elbowOn = !elbowOn;
  }

  public boolean getElbowOn() {
    return elbowOn;
  }
}

