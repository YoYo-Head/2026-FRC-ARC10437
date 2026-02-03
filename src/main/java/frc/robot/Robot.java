// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Systems.DriveSystem;

public class Robot extends TimedRobot {

    private DriveSystem drivesystem = new DriveSystem();
    private XboxController controller = new XboxController(0);
    
    public Robot() {
       drivesystem.driveSystemInit();

    }

    @Override
    public void teleopPeriodic() {
        drivesystem.drive(controller.getLeftY(), controller.getRightX());

    }
  
}
