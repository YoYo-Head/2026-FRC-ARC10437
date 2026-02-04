package frc.robot.AutonomousPrograms;

import java.util.Arrays;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Systems.InstrumentSystem;
import frc.robot.Systems.DriveSystem;

public class AutoDrive {
    private InstrumentSystem instrumentsystem = new InstrumentSystem();
    private DriveSystem drivesystem = new DriveSystem();
    private Timer autoTimer = new Timer();
    private double speed = -0.4;
    private double turn = 0;


    private void forward(double metresTarget) {
        autoTimer.reset();
        autoTimer.start();
        double time = (metresTarget + 0.66) / 0.565;
        double kp = 1; //Proportional constant for the yaw correction.
        int[] yawList = {85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95};

        // Check if yaw is in the list
        

        while (autoTimer.get() <= time) {
            double yaw = instrumentsystem.gyro.getYaw();
            boolean yawInLimit = Arrays.stream(yawList).anyMatch(y -> y == (int) yaw);
            double correction =  kp * -yaw / 180;

            if (!yawInLimit && autoTimer.get() <= time)   {
                drivesystem.drive(speed, correction);
                DriverStation.reportWarning("The turn is being corrected automatically!", false);
     
            } else {
                drivesystem.drive(speed, 0);

            } 

        }

        drivesystem.drive(0, 0);
        
        autoTimer.stop();
        
    }

    private void turn(int degreesTarget) {
        // REMEMBER, 90 IS STRAIGHT, 0 IS 90DE LEFT AND 180 IS 90DE RIGHT  
        if (degreesTarget > 180) return;

        double yaw = instrumentsystem.gyro.getYaw();

        if (degreesTarget <= 89) {
            turn = -0.4;

        } else if (degreesTarget >= 91) {
            turn = 0.4;

        }

        while (yaw != degreesTarget) {
            drivesystem.drive(0, turn);

        }

        drivesystem.drive(0, 0);

    }

    // PUT PATHWAY INSTRUCTIONS HERE
    public void beginPathway() {
        forward(2);
        turn(45);
        forward(5);
        turn(180);

    }

}
