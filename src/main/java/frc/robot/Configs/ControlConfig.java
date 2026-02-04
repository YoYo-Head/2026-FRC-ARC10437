package frc.robot.Configs;

import edu.wpi.first.wpilibj.XboxController;

public class ControlConfig {
    private XboxController controller = new XboxController(0);

    public double SpeedJoystick = controller.getLeftY();
    public double TurnJoystick = controller.getRightX();

}
