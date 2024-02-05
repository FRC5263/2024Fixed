// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;



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

    //drivetrain motors
    public static final CANSparkMax leftMotor1 = new CANSparkMax(1, MotorType.kBrushless);
    public static final CANSparkMax leftMotor2 = new CANSparkMax(3, MotorType.kBrushless);
    public static final CANSparkMax rightMotor1 = new CANSparkMax(4, MotorType.kBrushless);
    public static final CANSparkMax rightMotor2 = new CANSparkMax(10, MotorType.kBrushless);

    //drivetrain encoders
    //public static final Encoder leftEncoder1 = new SparkMaxAbsoluteEncoder(leftMotor1,);

    //arm motors
    public static final CANSparkMax leftArmMotor = new CANSparkMax(9, MotorType.kBrushless);
    public static final CANSparkMax rightArmMotor = new CANSparkMax(8, MotorType.kBrushless);
    public static final CANSparkMax winchMotor = new CANSparkMax(7, MotorType.kBrushless);

    //wrist motors
    public static final CANSparkMax intakeMotor1 = new CANSparkMax(2, MotorType.kBrushless);
    public static final CANSparkMax intakeMotor2 = new CANSparkMax(5, MotorType.kBrushless);
    public static final CANSparkMax wristMotor = new CANSparkMax(6, MotorType.kBrushless);

    //shuffleboard
    ShuffleboardTab mainTab = Shuffleboard.getTab("Main Tab");
    ShuffleboardTab systemTab = Shuffleboard.getTab("System");

    //networktable entries

  }

  public static void ConstantsInit() {
    //sends contants initialization status update
    System.out.println("\n\ninitialising constants\n\n");

    //selects the main tab in the dashboard
    Shuffleboard.selectTab("Main Tab");

    //adds the sparks to the system tab
    Shuffleboard.getTab("System").add("Spark 1", OperatorConstants.leftMotor1);
    Shuffleboard.getTab("System").add("Spark 2", OperatorConstants.intakeMotor1);
    Shuffleboard.getTab("System").add("Spark 3", OperatorConstants.leftMotor2);
    Shuffleboard.getTab("System").add("Spark 4", OperatorConstants.rightMotor1);
    Shuffleboard.getTab("System").add("Spark 5", OperatorConstants.intakeMotor2);
    Shuffleboard.getTab("System").add("Spark 6", OperatorConstants.wristMotor);
    Shuffleboard.getTab("System").add("Spark 7", OperatorConstants.winchMotor);
    Shuffleboard.getTab("System").add("Spark 8", OperatorConstants.rightArmMotor);
    Shuffleboard.getTab("System").add("Spark 9", OperatorConstants.leftArmMotor);
    Shuffleboard.getTab("System").add("Spark 10", OperatorConstants.rightMotor2);

    //current limits for sparks
    OperatorConstants.leftMotor1.setSmartCurrentLimit(45);
    OperatorConstants.leftMotor2.setSmartCurrentLimit(45);
    OperatorConstants.rightMotor1.setSmartCurrentLimit(45);
    OperatorConstants.rightMotor2.setSmartCurrentLimit(45);
  }
}
