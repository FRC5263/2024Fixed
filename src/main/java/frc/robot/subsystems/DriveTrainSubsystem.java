package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;



public class DriveTrainSubsystem extends SubsystemBase {
  private final CANSparkMax leftMotor;


  private final DifferentialDrive diffDrive;

  public DriveTrainSubsystem(){
    leftMotor = new CANSparkMax(1, MotorType.kBrushless);


    leftMotor.setInverted(false);

    diffDrive = new DifferentialDrive(leftMotor, leftMotor);
  }

  public void arcadeDrive(double throttle, double rotation){
    diffDrive.arcadeDrive(throttle, rotation);
  }

  @Override
  public void periodic() {
    
  }
}

