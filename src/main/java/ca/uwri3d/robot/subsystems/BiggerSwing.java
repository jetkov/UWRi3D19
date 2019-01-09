package ca.uwri3d.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import ca.uwri3d.robot.Config;
import ca.uwri3d.robot.Robot;
import ca.uwri3d.robot.commands.ControlBiggerSwing;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
public class BiggerSwing extends Subsystem {

	private WPI_TalonSRX motor;
	private XboxController controller = Robot.io.getOperatorController();
		
	public BiggerSwing() {
		motor = new WPI_TalonSRX(Config.CAN_ID_BIGGER_SWING_MOTOR);
		motor.setInverted(true);
	}
	
	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ControlBiggerSwing(controller, 5));
	}
		
	public void setSpeed(double speed) {
		motor.set(speed);
	}
		
	public void stop() {
		motor.set(0);
	}

}