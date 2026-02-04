package frc.robot.Systems;

import com.studica.frc.AHRS;
import com.studica.frc.AHRS.NavXComType;

public class InstrumentSystem {
    public AHRS gyro;

    public void initGyro() {
        try {
            gyro = new AHRS(NavXComType.kMXP_SPI);

        } catch (RuntimeException ex) {
            gyro = null;

        }

    }
    
}
