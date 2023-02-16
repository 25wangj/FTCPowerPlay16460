package org.firstinspires.ftc.teamcode.autonomous;
import static java.lang.Math.*;
import static org.firstinspires.ftc.teamcode.classes.ValueStorage.*;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
@Autonomous(name = "Null")
public class AutonomousNull extends AbstractAutonomous {
    @Override
    public void initialize() {}
    @Override
    public void run() {
        robot.setLiftPos(time, 0, armWait, wristNeutral);
        while (time < robot.restTime()) {
            time = clock.seconds();
            robot.update(time);
        }
    }
    @Override
    public Pose2d initPose() {
        return new Pose2d(-32, 64, -PI / 2);
    }
}
