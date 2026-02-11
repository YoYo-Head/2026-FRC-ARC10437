// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

    private RobotContainer robotContainer;
    private Command m_AutonomousComamnd; 

    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();

        HAL.report(tResourceType.kResourceType_Framework, 10);
        
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
        

    }

    @Override
    public void teleopInit() {
        if (m_AutonomousComamnd != null) {
            m_AutonomousComamnd.cancel();
        }
    }

    @Override
    public void autonomousInit() {
        m_AutonomousComamnd = robotContainer.getAutonomousCommand();
        
        if (m_AutonomousComamnd != null) {
            m_AutonomousComamnd.schedule();

        }
    }
  
}
