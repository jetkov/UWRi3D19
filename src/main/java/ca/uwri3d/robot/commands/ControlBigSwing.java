package ca.uwri3d.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.XboxController;
import ca.uwri3d.robot.Robot;

/**
 *
 */
public class ControlBigSwing extends Command {

	private XboxController controller;
	private double powerMultiplier = 0.40;

	public ControlBigSwing() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.bigSwing);
		requires(Robot.biggerSwing);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		controller = Robot.io.getXboxDrive();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (controller.getRawButtonPressed(9))
		{
			powerMultiplier = 0.60;
		}
		else if (controller.getRawButtonReleased(9))
		{
			powerMultiplier = 0.40;
		}

		Robot.bigSwing.setSpeed(-controller.getRawAxis(1) * powerMultiplier);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.bigSwing.setSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
