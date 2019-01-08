package ca.uwri3d.robot.commands;

import ca.uwri3d.robot.Robot;
import edu.wpi.first.wpilibj.command.InstantCommand;

public class LittleFistsIn extends InstantCommand {
	public LittleFistsIn() {
		requires(Robot.littleFists);
	}

	@Override
	protected void initialize() {
		Robot.littleFists.reverse();
	}
	
	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}
}

