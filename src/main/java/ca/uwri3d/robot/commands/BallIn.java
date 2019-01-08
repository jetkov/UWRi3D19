package ca.uwri3d.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.XboxController;
import ca.uwri3d.robot.Robot;

/**
 *
 */
public class BallIn extends Command {

	private XboxController controller = Robot.io.getXboxDrive();

	public BallIn() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.bigBaller);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.bigSwing.setSpeed(-0.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.bigBaller.setSpeed(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
