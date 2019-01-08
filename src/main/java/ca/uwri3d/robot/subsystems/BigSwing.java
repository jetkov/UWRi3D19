package ca.uwri3d.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import ca.uwri3d.robot.Config;
import edu.wpi.first.wpilibj.command.Subsystem;
public class BigSwing extends Subsystem {

	private WPI_TalonSRX motorA;
	private WPI_TalonSRX motorB;
	
	public BigSwing() {
		motorA = new WPI_TalonSRX(Config.CAN_ID_BIG_SWING_MOTOR_A);
		motorB = new WPI_TalonSRX(Config.CAN_ID_BIG_SWING_MOTOR_B);

		motorB.setInverted(true);
	}
	
	@Override
	public void initDefaultCommand() {}

	public void setSpeed(double speed) {
		motorA.set(speed);
		motorB.set(speed);
	}
	public void stop() {
		motorA.set(0);
		motorB.set(0);
	}

}