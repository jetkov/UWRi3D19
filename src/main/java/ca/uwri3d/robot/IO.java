package ca.uwri3d.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;

import ca.uwri3d.robot.commands.LittleFistsPunch;
import ca.uwri3d.robot.commands.LittleFistsIn;
import ca.uwri3d.robot.commands.BallIn;
import ca.uwri3d.robot.commands.BallOut;
import ca.uwri3d.robot.commands.ControlBigSwing;
import ca.uwri3d.robot.commands.ControlBiggerSwing;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands
 * and command groups that allow control of the robot.
 */
public class IO {

	private XboxController xboxController = new XboxController(Config.CONTROLLER_PORT);

	public IO() {

		// Button mappings
		JoystickButton a = new JoystickButton(xboxController, 1); // Eject hatch cover
		JoystickButton b = new JoystickButton(xboxController, 2); // Switch from hatch cover arm to cargo arm control
		JoystickButton x = new JoystickButton(xboxController, 3); // Intake ball
		JoystickButton y = new JoystickButton(xboxController, 4); // Eject ball

		// Button actions
		a.whileHeld(new LittleFistsPunch());
		a.whileHeld(new LittleFistsIn());
		x.whileHeld(new BallIn());
		y.whileHeld(new BallOut());
		b.toggleWhenPressed(new ControlBiggerSwing());

	}

	// Publicly returns the Xbox controller object
	public XboxController getXboxDrive() {
		return xboxController;
	}
}
