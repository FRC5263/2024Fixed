// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;


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
    public static final PWMSparkMax frontRightDriveEncoder = new PWMSparkMax(6);
    public static final PWMSparkMax backRightDriveEncoder = new PWMSparkMax(5);
    public static final PWMSparkMax frontLeftDriveEncoder = new PWMSparkMax(1);
    public static final PWMSparkMax backLeftDriveEncoder = new PWMSparkMax(2);
    public static final PWMSparkMax shooterRightEncoder = new PWMSparkMax(3);
    public static final PWMSparkMax shooterLeftEncoder = new PWMSparkMax(7);
    public static final PWMSparkMax elbowEncoder = new PWMSparkMax(8);
    
    // PWM Channel Assignments
    public final int PWM_Drive_FR = 6;
    public final int PWM_Drive_BR = 5;
    public final int PWM_Drive_FL = 1;
    public final int PWM_Drive_BL = 2;
    public final int PWM_Shooter_R = 3;
    public final int PWM_Shooter_L = 7;
    public final int PWM_Elbow = 8;

    // Drivetrain
    public MotorController frontRightDrive = new Spark(PWM_Drive_FR);
    public MotorController backRightDrive = new Spark(PWM_Drive_BR);
    public MotorController frontLeftDrive = new Spark(PWM_Drive_FL);
    public MotorController backLeftDrive = new Spark(PWM_Drive_BL);

    //Other
    public MotorController shooterRight = new Spark(PWM_Shooter_R);
    public MotorController shooterLeft = new Spark(PWM_Shooter_L);
    public MotorController elbow = new Spark(PWM_Elbow);



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
    Shuffleboard.getTab("System").add("Spark 1", OperatorConstants.frontLeftDriveEncoder);
    Shuffleboard.getTab("System").add("Spark 2", OperatorConstants.backLeftDriveEncoder);
    Shuffleboard.getTab("System").add("Spark 3", OperatorConstants.shooterRightEncoder);
    //Shuffleboard.getTab("System").add("Spark 4", OperatorConstants.climber);
    Shuffleboard.getTab("System").add("Spark 5", OperatorConstants.frontRightDriveEncoder);
    Shuffleboard.getTab("System").add("Spark 6", OperatorConstants.backRightDriveEncoder);
    Shuffleboard.getTab("System").add("Spark 7", OperatorConstants.shooterLeftEncoder);
    Shuffleboard.getTab("System").add("Spark 8", OperatorConstants.elbowEncoder);
    

/*    //current limits for sparks
    OperatorConstants.frontRightDriveEncoder.setSmartCurrentLimit(45);
    OperatorConstants.backRightDriveEncoder.setSmartCurrentLimit(45);
    OperatorConstants.frontLeftDriveEncoder.setSmartCurrentLimit(45);
    OperatorConstants.backLeftDriveEncoder.setSmartCurrentLimit(45);
    */
  }
}
