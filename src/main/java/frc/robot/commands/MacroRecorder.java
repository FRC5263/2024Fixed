package frc.robot.commands;

import java.io.FileWriter;
import java.io.IOException;

import edu.wpi.first.wpilibj.PowerDistribution;


public class MacroRecorder{
    FileWriter writer;

    long startTime;

    PowerDistribution PD;

    public MacroRecorder() throws IOException{
        startTime = System.currentTimeMillis();

        PD = new PowerDistribution();

        writer = new FileWriter(MacroMain.autoFile);
    }
    public void Record() throws IOException{
        if (writer != null){
            writer.append("" + (System.currentTimeMillis()-startTime));       
            double current0 = PD.getCurrent(0);
            double current1 = PD.getCurrent(1);
            double current2 = PD.getCurrent(2);
            double current3 = PD.getCurrent(3);
            double current4 = PD.getCurrent(4);
            double current5 = PD.getCurrent(5);
            double current6 = PD.getCurrent(6);
            double current7 = PD.getCurrent(7);
            double current8 = PD.getCurrent(8);
        }
    }

    public void end() throws IOException{
        if(writer != null){
            writer.flush();
            writer.close();
        }
    }
}