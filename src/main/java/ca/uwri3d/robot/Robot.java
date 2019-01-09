package ca.uwri3d.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import ca.uwri3d.robot.subsystems.*;
import ca.uwri3d.robot.commands.Autonomous;
import ca.uwri3d.robot.IO;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

	// Declare the subsystems
	public static LittleWhip littleWhip;
	public static LittleFists littleFists;
	public static BigSwing bigSwing;
	public static BiggerSwing biggerSwing;
	public static BigBaller bigBaller;

	// Declare the IO
	public static IO io;

	// Declare the autonomous command
	Command autonomousCommand;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

		// Initialize the subsystems
		littleWhip = new LittleWhip();
		littleFists = new LittleFists();
		bigBaller = new BigBaller();

		// Initialize the IO
		io = new IO();

		// Initialize subsystems the depend on IO
		bigSwing = new BigSwing();
		biggerSwing = new BiggerSwing();

		// instantiate the command used for the autonomous period
		autonomousCommand = new Autonomous();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// schedule the autonomous command
	  	autonomousCommand.start();
	}
  
	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
	  	Scheduler.getInstance().run();
	}
  
	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {}
}
