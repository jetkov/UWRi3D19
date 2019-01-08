package ca.uwri3d.robot.commands;

import ca.uwri3d.robot.Config;
import ca.uwri3d.robot.Robot;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command allows the robot to be controlled by an Xbox controller. The
 * right trigger controls forward motion, the left trigger controls reverse, and
 * the left stick controls turning. If 'X' is held, the left and right trigger
 * controls or swapped (the right controls reverse).
 */
public class ControllerArcadeDrive extends Command {

	private XboxController controller = Robot.io.getXboxDrive();
	private double lTrig, rTrig, moveValue, rotateValue;

	public ControllerArcadeDrive() {
		// Use requires() here to declare subsystem dependencies.
		requires(Robot.littleWhip);
	}

	// Called just before this Command runs the first time.
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run.
	@Override
	protected void execute() {
		// Getting the Xbox controller trigger values.
		lTrig = controller.getTriggerAxis(GenericHID.Hand.kLeft);
		rTrig = controller.getTriggerAxis(GenericHID.Hand.kRight);

		// Subtracts the value of the left trigger from the value of the right
		// one.
		// This effectively makes the right trigger forward control and left
		// trigger reverse.
		moveValue = rTrig - lTrig;
		moveValue = moveValue * (Config.THROTTLE_PERCENTAGE / 100);

		// Grabs the left stick 'x' value.
		rotateValue = controller.getX(GenericHID.Hand.kRight);
		// Squares and multiplies this value by the set sensitivity value in
		// 'Config'.
		// This makes turning easier to control.
		rotateValue = (rotateValue * Math.abs(rotateValue)) * (Config.ROTATE_PERCENTAGE / 100);

		// Drive the robot
		Robot.littleWhip.arcadeDrive(moveValue, rotateValue, true);

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		// Stops power to the drive train when this commend is finished
		Robot.littleWhip.arcadeDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
