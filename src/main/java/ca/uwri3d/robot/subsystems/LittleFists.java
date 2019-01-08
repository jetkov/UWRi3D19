package ca.uwri3d.robot.subsystems;

import ca.uwri3d.robot.Config;
import ca.uwri3d.robot.commands.LittleFistsIn;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class LittleFists extends Subsystem {

	private DoubleSolenoid fistsDoubleSolenoid;

	public LittleFists() {
		fistsDoubleSolenoid = new DoubleSolenoid(1, 0, 1);
	}
	public void initDefaultCommand() {
		setDefaultCommand(new LittleFistsIn());
	}

	public void forward() {
		fistsDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void reverse() {
		fistsDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	public void off() {
		fistsDoubleSolenoid.set(DoubleSolenoid.Value.kOff);
	}
}