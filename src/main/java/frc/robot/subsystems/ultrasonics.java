package frc.robot.subsystems;


import edu.wpi.first.wpilibj.AnalogInput;


public abstract class ultrasonics {
	private AnalogInput sensor;
	private double voltsPerInch;
	private double zeroPos;
	
	
	 //@param
	 //@param 
	 
	public ultrasonics(AnalogInput device, double voltsPerInch){
		sensor = device;
		this.voltsPerInch = voltsPerInch;
		zeroPos = 0;
	}

	public void zero(){
		zeroPos = sensor.getVoltage();
	}
	
	public void resetZero(){
		zeroPos = 0;
	}
	

	 // @return

	public double getRange(){
		return (sensor.getVoltage() - zeroPos) / voltsPerInch;
	}
}