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

xboxController.getPOV();


// Eject hatch cover
// Intake ball
// Shoot ball

		// Button mappings
		JoystickButton a = new JoystickButton(xboxController, 1); // Eject hatch cover
		JoystickButton b = new JoystickButton(xboxController, 2); 
		JoystickButton x = new JoystickButton(xboxController, 3); // Intake ball
		JoystickButton y = new JoystickButton(xboxController, 4); // Eject ball
		JoystickButton lStickButton = new JoystickButton(xboxController, 9); // Switch from hatch cover arm to cargo arm control

		// Button actions
		a.whenPressed(new LittleFistsPunch());
		a.whenReleased(new LittleFistsIn());
		x.whileHeld(new BallIn());
		y.whileHeld(new BallOut());
		lStickButton.whenPressed(new ControlBiggerSwing());
		lStickButton.whenReleased(new ControlBigSwing());

	}

	// Publicly returns the Xbox controller object
	public XboxController getXboxDrive() {
		return xboxController;
	}
}
