package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




public class Elbow extends SubsystemBase {


private final CANSparkMax elbow;
Encoder elbowEncoder;


public Elbow() {

elbow = new CANSparkMax(8, MotorType.kBrushless);

System.out.print("Elbow Subsystem Created\n");
System.out.print("Elbow Encoder Created\n");

}

public void ySpeed(double power) {

elbow.set(power);



SmartDashboard.putNumber("ElbowSpeed Power", power);

}



  @Override
  public void periodic() {
    
  }


}

