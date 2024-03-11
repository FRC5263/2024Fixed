package frc.robot.Auton;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MacroMain{
    Scanner scanner;
    long startTime;

    boolean OnTime = true;
    double nextDouble;
    public MacroMain() throws FileNotFoundException{
        scanner = new Scanner();
    }
}