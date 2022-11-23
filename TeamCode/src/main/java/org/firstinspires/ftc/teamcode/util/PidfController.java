package org.firstinspires.ftc.teamcode.util;
import com.qualcomm.robotcore.util.ElapsedTime;
public abstract class PidfController {
    ElapsedTime clock = new ElapsedTime();
    double kp, ki, kd;
    public abstract double kf(double input);
    double setPoint = 0;
    double e = 0;
    double i = 0;
    double d = 0;
    double f = kf(0);
    double lastTime = 0;
    double lastE = 0;
    public PidfController(double kp, double ki, double kd) {
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
    }
    public void reset() {
        i = 0;
    }
    public void setConstants(double kpNew, double kiNew, double kdNew) {
        kp = kpNew;
        ki = kiNew;
        kd = kdNew;
    }
    public void set(double newSetPoint) {
        setPoint = newSetPoint;
    }
    public double get() {
        return kp * e + ki * i + kd * d + f;
    }
    public void update(double input) {
        double dt = clock.seconds() - lastTime;
        e = setPoint - input;
        i += (e + lastE) *  dt / 2;
        d = (e - lastE) / dt;
        f = kf(input);
        lastTime += dt;
        lastE = e;
    }
}