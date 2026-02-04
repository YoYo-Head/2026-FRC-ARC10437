// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import frc.robot.Systems.DriveSystem;
import frc.robot.Systems.CameraSystem;
import frc.robot.Systems.InstrumentSystem;
import frc.robot.Systems.TelemetrySystem;

import frc.robot.Configs.ControlConfig;

public class Robot extends TimedRobot {

    private DriveSystem drivesystem = new DriveSystem();
    private CameraSystem camerasystem = new CameraSystem();
    private InstrumentSystem instrumentsystem = new InstrumentSystem();
    private TelemetrySystem telemetrysystem = new TelemetrySystem();

    private ControlConfig ControllerConfig = new ControlConfig();
    
    public Robot() {
       drivesystem.driveSystemInit();
       
    }

    public void robotInit() {
        camerasystem.cameraSystemInit();
        instrumentsystem.initGyro();

    }

    public void robotPereodic() {
        telemetrysystem.pushGyroInfo();

    }

    @Override
    public void teleopPeriodic() {
        drivesystem.drive(ControllerConfig.SpeedJoystick, ControllerConfig.TurnJoystick);

    }
  
}
