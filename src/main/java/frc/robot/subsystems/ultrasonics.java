package frc.robot.subsystems;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;

public class ultrasonics {
    static final int kUltrasonicPingPort = 0;
    static final int kUltrasonicEchoPort = 1;

    // Ultrasonic sensors tend to be quite noisy and susceptible to sudden outliers,
    // so measurements are filtered with a 5-sample median filter
    private final static MedianFilter m_filter = new MedianFilter(5);

    private final static Ultrasonic m_ultrasonic = new Ultrasonic(kUltrasonicPingPort, kUltrasonicEchoPort);

    public static double GetMeasurement(){
    //get measurement and filter it
    double measurement = m_ultrasonic.getRangeMM();
    double filteredMeasurement = m_filter.calculate(measurement);
    return filteredMeasurement;
    }
}