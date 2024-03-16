package frc.robot.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.XboxController;

public class MacroMain extends Command{
    boolean isworking = false;
    boolean isoff = false;
    boolean running = false;
    boolean isRecording = false;


    static final int autonumber = 1;

    private final Timer timer = new Timer();

    MacroPlayer player;

    MacroRecorder recorder;

    XboxController controller0 = new XboxController(0);

    static final String autoFile = new String("/java/src/robot/Auton" + autonumber + ".csv");

    public MacroMain(){
        try {
            player = new MacroPlayer(null, null, null, null);
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        }
    }
    
    public void autonomous(){
        MacroPlayer player = null;
    }
    public void execute(){
        while(isoff == false){
            if(player != null){
                player.play();
            }

        }
        if(player != null){
            player.end();
        }
    }
    public void Control(){

            try{
                recorder = new MacroRecorder();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        while(isworking){
            if(controller0.getLeftBumper()){
                isRecording = !isRecording;
            }
            if(isRecording){
                try {
                    recorder.Record();
                    }
                 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        try {
            if(recorder != null){
                recorder.end();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void end(boolean interrupted) {}
    
    public boolean isFinished() {
        return false;
      }
}