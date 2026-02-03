package frc.robot.Systems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;

import frc.robot.Configs.CameraSystemConfig;

public class CameraSystem {

    private UsbCamera camera;

    public void cameraSystemInit() {
        camera = CameraServer.startAutomaticCapture();

        camera.setFPS(CameraSystemConfig.cameraFPS);
        camera.setResolution(CameraSystemConfig.cameraResWidth, CameraSystemConfig.cameraResHeight);

    }
    
}
