package frc.robot.subsystems;


import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ultrasonics extends TimedRobot {
  Ultrasonic m_rangeFinder = new Ultrasonic(3, 2);

  @Override
  public void robotInit() {
    Shuffleboard.getTab("Sensors").add(m_rangeFinder);
  }

  @Override
  public void teleopPeriodic() {
    double distanceInches = m_rangeFinder.getRangeInches();
    SmartDashboard.putNumber("Distance[inch]", distanceInches);
  }

  @Override
  public void testInit() {

    m_rangeFinder.ping();
  }

  @Override
  public void testPeriodic() {
    if (m_rangeFinder.isRangeValid()) {
      SmartDashboard.putNumber("Distance[mm]", m_rangeFinder.getRangeMM());
      SmartDashboard.putNumber("Distance[inch]", m_rangeFinder.getRangeInches());

      m_rangeFinder.ping();
    }
  }

  @Override
  public void testExit() {
    Ultrasonic.setAutomaticMode(true);
  }
}