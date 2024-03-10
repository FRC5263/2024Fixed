package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
public class intake extends SubsystemBase{
    public final Spark intakemotor;

    public intake(){
        intakemotor = new Spark(0);
    }

    public void DriveIntake(double intakespeed){
        intakemotor.set(intakespeed);
    }
}
