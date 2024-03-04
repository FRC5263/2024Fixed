// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
//import frc.robot.Constants;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.DriveTrainSubsystem;



/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  //init variables

  public static class OperatorConstants {
    //controllers
    public static final XboxController controller0 = new XboxController(0);
    public static final XboxController controller1 = new XboxController(1);

    //Encoder
    
    public static CANSparkMax leftMotorEncoder;
    public static CANSparkMax leftMotor2Encoder;
    public static CANSparkMax rightMotorEncoder;
    public static CANSparkMax rightMotor2Encoder;
    public static CANSparkMax shooterRightEncoder;
    public static CANSparkMax shooterLeftEncoder;
    public static CANSparkMax elbowEncoder;
    
    // CAN Channel Assignments
    public final int CAN_Drive_R = 6;
    public final int CAN_Drive_R2 = 5;
    public final int CAN_Drive_L = 1;
    public final int CAN_Drive_L2 = 2;
    public final int CAN_Shooter_R = 3;
    public final int CAN_Shooter_L = 7;
    public final int CAN_Elbow = 8;
   

    // Drivetrain
    public MotorController RightDrive = new Spark(CAN_Drive_R);
    public MotorController Right2Drive = new Spark(CAN_Drive_R2);
    public MotorController LeftDrive = new Spark(CAN_Drive_L);
    public MotorController Left2Drive = new Spark(CAN_Drive_L2);

    //Other
    public MotorController shooterRight = new Spark(CAN_Shooter_R);
    public MotorController shooterLeft = new Spark(CAN_Shooter_L);
    public MotorController elbow = new Spark(CAN_Elbow);



    //shuffleboard
    ShuffleboardTab mainTab = Shuffleboard.getTab("Main Tab");
    ShuffleboardTab systemTab = Shuffleboard.getTab("System");

  }

  public static void ConstantsInit() {
    //sends contants initialization status update
    System.out.println("\n\ninitialising constants\n\n");

    //selects the main tab in the dashboard
    Shuffleboard.selectTab("Main Tab");

    //adds the sparks to the system tab
    Shuffleboard.getTab("System").add("Spark 1", OperatorConstants.leftMotorEncoder);
    Shuffleboard.getTab("System").add("Spark 2", OperatorConstants.leftMotor2Encoder);
    Shuffleboard.getTab("System").add("Spark 3", OperatorConstants.shooterRightEncoder);
    //Shuffleboard.getTab("System").add("Spark 4", OperatorConstants.climber);
    Shuffleboard.getTab("System").add("Spark 5", OperatorConstants.rightMotorEncoder);
    Shuffleboard.getTab("System").add("Spark 6", OperatorConstants.rightMotor2Encoder);
    Shuffleboard.getTab("System").add("Spark 7", OperatorConstants.shooterLeftEncoder);
    Shuffleboard.getTab("System").add("Spark 8", OperatorConstants.elbowEncoder);
    

    //current limits for sparks
    OperatorConstants.rightMotorEncoder.setSmartCurrentLimit(45);
    OperatorConstants.rightMotor2Encoder.setSmartCurrentLimit(45);
    OperatorConstants.leftMotorEncoder.setSmartCurrentLimit(45);
    OperatorConstants.leftMotor2Encoder.setSmartCurrentLimit(45);
    
  }
}
