package ca.uwri3d.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import ca.uwri3d.robot.Config;

import edu.wpi.first.wpilibj.command.Subsystem;
public class BiggerSwing extends Subsystem {

	private WPI_TalonSRX motor;
		
	public BiggerSwing() {
		motor = new WPI_TalonSRX(Config.CAN_ID_BIGGER_SWING_MOTOR);
		motor.setInverted(true);
	}
	
	@Override
	public void initDefaultCommand() {}
		
	public void setSpeed(double speed) {
		motor.set(speed);
	}
		
	public void stop() {
		motor.set(0);
	}

}