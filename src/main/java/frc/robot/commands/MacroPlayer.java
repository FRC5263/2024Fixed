package frc.robot.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import frc.robot.subsystems.DriveTrainSubsystem;

public class MacroPlayer{
    Scanner scanner;
    long startTime;

    DriveTrainSubsystem leftMotor;
    DriveTrainSubsystem leftMotor2;
    DriveTrainSubsystem rightMotor;
    DriveTrainSubsystem rightMotor2;


    double xSpeed;
    double zSpeed;


    boolean OnTime = true;
    double nextDouble;
    public MacroPlayer(DriveTrainSubsystem leftMotor, DriveTrainSubsystem rightMotor, DriveTrainSubsystem leftMotor2, DriveTrainSubsystem rightMotor2) throws FileNotFoundException{

        this.leftMotor = leftMotor;
        this.leftMotor2 = leftMotor2;
        this.rightMotor = rightMotor;
        this.rightMotor2 = rightMotor2;





        scanner = new Scanner(new File (MacroMain.autoFile));

        scanner.useDelimiter(",|\\n");

        startTime = System.currentTimeMillis();
    }

    public void play(){
        if((scanner) != null && (scanner.hasNextDouble())){
            double t_delta;

            if(OnTime){
                nextDouble = scanner.nextDouble();
            }

            t_delta = nextDouble - (System.currentTimeMillis()-startTime);

            if (t_delta <= 0){

                leftMotor.arcadeDrive(nextDouble, nextDouble);
                leftMotor2.arcadeDrive(nextDouble, nextDouble);
                rightMotor.arcadeDrive(nextDouble, nextDouble);
                rightMotor.arcadeDrive(nextDouble, nextDouble);
                OnTime = true;
            }

            else{
                OnTime = false;
            }
        }
        else{
            if(scanner != null){
                scanner.close();
                scanner = null;
            }
        }
    }
    public void end(){
        leftMotor.arcadeDrive(0, 0);
        leftMotor2.arcadeDrive(0, 0);
        rightMotor.arcadeDrive(0, 0);
        rightMotor.arcadeDrive(0, 0);
        if(scanner != null){
            scanner.close();
        }
    }
}