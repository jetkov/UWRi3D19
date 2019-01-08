package ca.uwri3d.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import ca.uwri3d.robot.Config;
import ca.uwri3d.robot.commands.ControlBigSwing;

import edu.wpi.first.wpilibj.command.Subsystem;
public class BiggerSwing extends Subsystem {

	private WPI_TalonSRX motor;
    
    public BiggerSwing() {
		motor = new WPI_TalonSRX(Config.CAN_ID_BIGGER_SWING_MOTOR);
    }
    
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ControlBigSwing());
    }
    
	public void setSpeed(double speed) {
		speed = Math.max(0, speed);
		motor.set(speed);
    }
    
	public void stop() {
		motor.set(0);
	}

}