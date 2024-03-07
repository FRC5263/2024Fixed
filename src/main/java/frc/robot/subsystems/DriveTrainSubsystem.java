package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;


public class DriveTrainSubsystem extends SubsystemBase {
  private final CANSparkMax leftMotor;
  private final CANSparkMax leftMotor2;

  private final CANSparkMax rightMotor;
  private final CANSparkMax rightMotor2;

Encoder leftEncoder;
Encoder leftEncoder2;
Encoder rightEncoder;
Encoder right2Encoder;
Encoder[] encoders;
Encoder[] encoder = {leftEncoder, leftEncoder2, rightEncoder, right2Encoder};
 


  
  private final DifferentialDrive diffDrive;

  public DriveTrainSubsystem(){
    leftMotor = new CANSparkMax(1, MotorType.kBrushless);
    leftMotor2 = new CANSparkMax(2, MotorType.kBrushless);

    rightMotor = new CANSparkMax(5, MotorType.kBrushless);
    rightMotor2 = new CANSparkMax(6, MotorType.kBrushless);

 
    leftMotor.setInverted(false);
    leftMotor2.setInverted(false);
    
   
    Encoder[] encoders = {leftEncoder, leftEncoder2, rightEncoder, right2Encoder};


    rightMotor.setInverted(true);

    leftMotor2.follow(leftMotor);
    rightMotor2.follow(rightMotor);

    diffDrive = new DifferentialDrive(leftMotor, rightMotor);
    System.out.print("Drivetrain subsystem created");
    System.out.print("Drivetrain encoders created");
  }






  

  public void arcadeDrive(double throttle, double rotation){
    diffDrive.arcadeDrive(throttle, rotation);
  }

  @Override
  public void periodic() {
    
  }
}

