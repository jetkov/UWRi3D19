package ca.uwri3d.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;

import ca.uwri3d.robot.commands.LittleFistsPunch;
import ca.uwri3d.robot.commands.BallIn;
import ca.uwri3d.robot.commands.BallOut;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands
 * and command groups that allow control of the robot.
 */
public class IO {

	private XboxController driverController = new XboxController(Config.DRIVER_CONTROLLER_PORT);
	private XboxController operatorController = new XboxController(Config.OPERATOR_CONTROLLER_PORT);

	public IO() {

		// Button mappings
		JoystickButton driverA = new JoystickButton(driverController, 1); // Eject hatch cover
		JoystickButton driverX = new JoystickButton(driverController, 3); // Intake ball
		JoystickButton driverY = new JoystickButton(driverController, 4); // Eject ball
		JoystickButton operatorA = new JoystickButton(operatorController, 1); // Eject hatch cover
		// B IS FOR BOOST
		JoystickButton operatorX = new JoystickButton(operatorController, 3); // Intake ball
		JoystickButton operatorY = new JoystickButton(operatorController, 4); // Eject ball

		// Button actions
		driverA.whileHeld(new LittleFistsPunch());
		driverX.whileHeld(new BallIn());
		driverY.whileHeld(new BallOut());
		operatorA.whileHeld(new LittleFistsPunch());
		operatorX.whileHeld(new BallIn());
		operatorY.whileHeld(new BallOut());
	}

	// Publicly returns the Xbox controller object
	public XboxController getDriverController() {
		return driverController;
	}

	// Publicly returns the Xbox controller object
	public XboxController getOperatorController() {
		return operatorController;
	}
}
