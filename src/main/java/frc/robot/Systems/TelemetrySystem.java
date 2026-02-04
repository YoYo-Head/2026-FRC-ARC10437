package frc.robot.Systems;


import com.studica.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TelemetrySystem {

    private InstrumentSystem instrumentsystem = new InstrumentSystem();

    public void pushGyroInfo() {
        /* Display 6-axis Processed Angle Data */
        SmartDashboard.putBoolean("IMU_Connected", instrumentsystem.gyro.isConnected());
        SmartDashboard.putBoolean("IMU_IsCalibrating", instrumentsystem.gyro.isCalibrating());
        SmartDashboard.putNumber("IMU_Yaw", instrumentsystem.gyro.getYaw());
        SmartDashboard.putNumber("IMU_Pitch", instrumentsystem.gyro.getPitch());
        SmartDashboard.putNumber("IMU_Roll", instrumentsystem.gyro.getRoll());

        /* Display tilt-corrected, Magnetometer-based heading (requires */
        /* magnetometer calibration to be useful) */

        SmartDashboard.putNumber("IMU_CompassHeading", instrumentsystem.gyro.getCompassHeading());
     
         /* Display 9-axis Heading (requires magnetometer calibration to be useful) */
        SmartDashboard.putNumber("IMU_FusedHeading", instrumentsystem.gyro.getFusedHeading());

        /* These functions are compatible w/the WPI Gyro Class, providing a simple */
        /* path for upgrading from the Kit-of-Parts gyro to the navx MXP */

        SmartDashboard.putNumber("IMU_TotalYaw", instrumentsystem.gyro.getAngle());
        SmartDashboard.putNumber("IMU_YawRateDPS", instrumentsystem.gyro.getRate());
     
        /* Display Processed Acceleration Data (Linear Acceleration, Motion Detect) */
    
        SmartDashboard.putNumber("IMU_Accel_X", instrumentsystem.gyro.getWorldLinearAccelX());
        SmartDashboard.putNumber("IMU_Accel_Y", instrumentsystem.gyro.getWorldLinearAccelY());
        SmartDashboard.putBoolean("IMU_IsMoving", instrumentsystem.gyro.isMoving());
        SmartDashboard.putBoolean("IMU_IsRotating", instrumentsystem.gyro.isRotating());
    
        /* Display estimates of velocity/displacement. Note that these values are */
        /* not expected to be accurate enough for estimating robot position on a */
        /* FIRST FRC Robotics Field, due to accelerometer noise and the compounding */
        /* of these errors due to single (velocity) integration and especially */
        /* double (displacement) integration. */
    
        SmartDashboard.putNumber("Velocity_X", instrumentsystem.gyro.getVelocityX());
        SmartDashboard.putNumber("Velocity_Y", instrumentsystem.gyro.getVelocityY());
        SmartDashboard.putNumber("Displacement_X", instrumentsystem.gyro.getDisplacementX());
        SmartDashboard.putNumber("Displacement_Y", instrumentsystem.gyro.getDisplacementY());
    
        /* Display Raw Gyro/Accelerometer/Magnetometer Values */
        /* NOTE: These values are not normally necessary, but are made available */
        /* for advanced users. Before using this data, please consider whether */
        /* the processed data (see above) will suit your needs. */
    
        SmartDashboard.putNumber("RawGyro_X", instrumentsystem.gyro.getRawGyroX());
        SmartDashboard.putNumber("RawGyro_Y", instrumentsystem.gyro.getRawGyroY());
        SmartDashboard.putNumber("RawGyro_Z", instrumentsystem.gyro.getRawGyroZ());
        SmartDashboard.putNumber("RawAccel_X", instrumentsystem.gyro.getRawAccelX());
        SmartDashboard.putNumber("RawAccel_Y", instrumentsystem.gyro.getRawAccelY());
        SmartDashboard.putNumber("RawAccel_Z", instrumentsystem.gyro.getRawAccelZ());
        SmartDashboard.putNumber("RawMag_X", instrumentsystem.gyro.getRawMagX());
        SmartDashboard.putNumber("RawMag_Y", instrumentsystem.gyro.getRawMagY());
        SmartDashboard.putNumber("RawMag_Z", instrumentsystem.gyro.getRawMagZ());
        SmartDashboard.putNumber("IMU_Temp_C", instrumentsystem.gyro.getTempC());
        SmartDashboard.putNumber("IMU_Timestamp", instrumentsystem.gyro.getLastSensorTimestamp());
    
        /* Omnimount Yaw Axis Information */
        /* For more info, see http://navx-mxp.kauailabs.com/installation/omnimount */
        AHRS.BoardYawAxis yaw_axis = instrumentsystem.gyro.getBoardYawAxis();
        SmartDashboard.putString("YawAxisDirection", yaw_axis.up ? "Up" : "Down");
        SmartDashboard.putNumber("YawAxis", yaw_axis.board_axis.getValue());

        /* Sensor Board Information */
        SmartDashboard.putString("FirmwareVersion", instrumentsystem.gyro.getFirmwareVersion());

        /* Quaternion Data */
        /* Quaternions are fascinating, and are the most compact representation of */
        /* orientation data. All of the Yaw, Pitch and Roll Values can be derived */
        /* from the Quaternions. If interested in motion processing, knowledge of */
        /* Quaternions is highly recommended. */
        SmartDashboard.putNumber("QuaternionW", instrumentsystem.gyro.getQuaternionW());
        SmartDashboard.putNumber("QuaternionX", instrumentsystem.gyro.getQuaternionX());
        SmartDashboard.putNumber("QuaternionY", instrumentsystem.gyro.getQuaternionY());
        SmartDashboard.putNumber("QuaternionZ", instrumentsystem.gyro.getQuaternionZ());

        /* Connectivity Debugging Support */
        SmartDashboard.putNumber("IMU_Byte_Count", instrumentsystem.gyro.getByteCount());
        SmartDashboard.putNumber("IMU_Update_Count", instrumentsystem.gyro.getUpdateCount());

    }

}
