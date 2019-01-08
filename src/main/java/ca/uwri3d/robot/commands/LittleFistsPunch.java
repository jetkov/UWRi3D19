package ca.uwri3d.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;

import ca.uwri3d.robot.Robot;

/**
 *
 */
public class LittleFistsPunch extends InstantCommand {
	public LittleFistsPunch() {
		requires(Robot.littleFists);
	}

	@Override
	protected void initialize() {
		Robot.littleFists.forward();
	}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}
}
