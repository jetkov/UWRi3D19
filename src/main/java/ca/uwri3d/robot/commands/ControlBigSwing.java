package ca.uwri3d.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.XboxController;
import ca.uwri3d.robot.Robot;

/**
 *
 */
public class ControlBigSwing extends Command {

	private XboxController controller;
	private int controllerAxis;
	private int boostButton;
	private double powerMultiplier = 0.40;

	public ControlBigSwing(XboxController inController, int inAxis, int inBoostButton) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.bigSwing);

		controller = inController;
		controllerAxis = inAxis;
		boostButton = inBoostButton;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (controller.getRawButtonPressed(boostButton))
		{
			powerMultiplier = 0.60;
		}
		else if (controller.getRawButtonReleased(boostButton))
		{
			powerMultiplier = 0.40;
		}

		Robot.bigSwing.setSpeed(-controller.getRawAxis(controllerAxis) * powerMultiplier);
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
