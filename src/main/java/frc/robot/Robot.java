// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.RobotContainer

public class Robot extends TimedRobot {

    private RobotContainer robotContainer = new RobotContainer();   

    
    public Robot() {
        
       
    }

    public void robotInit() {
        

    }

    public void robotPereodic() {
        

    }

    @Override
    public void teleopPeriodic() {
        

    }

    public void autonomousInit() {
        robotContainer.getAutonomousCommand();
    }
  
}
