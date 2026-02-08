package frc.robot.Configs;

import edu.wpi.first.wpilibj.XboxController;

public class ControlConfig {
    private static XboxController controller = new XboxController(0);
    
    public static double SpeedJoystick = controller.getLeftY();
    public static double TurnJoystick = controller.getRightX();

    public double IntakeJoystick = controller.getLeftTriggerAxis();
    public double FeederJoystick = controller.getRightTriggerAxis();

}
