package ca.uwri3d.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import ca.uwri3d.robot.Config;

public class BigBaller extends Subsystem {

	private WPI_TalonSRX motor;
	
	public BigBaller() {
		motor = new WPI_TalonSRX(Config.CAN_ID_BIG_BALLER_MOTOR);
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