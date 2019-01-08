package ca.uwri3d.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import ca.uwri3d.robot.Config;
import ca.uwri3d.robot.commands.ControllerArcadeDrive;

/**
 * The DriveTrain subsystem currently includes the two pairs of drive motors (controllers).
 * 
 */
public class LittleWhip extends Subsystem {

	// Declare the drive TalonSRX CAN drive motor controllers
	private WPI_TalonSRX m_leftDriveMotorA;
	private WPI_TalonSRX m_leftDriveMotorB;
	private WPI_TalonSRX m_rightDriveMotorA;
	private WPI_TalonSRX m_rightDriveMotorB;
	
	// Declare the left and right drive speed controller groups
	private SpeedControllerGroup m_leftDriveMotors;
	private SpeedControllerGroup m_rightDriveMotors;

	// Declare the drive system
	private DifferentialDrive drive;
	
	public LittleWhip() {

		// Initialize the drive speed controllers
		m_leftDriveMotorA = new WPI_TalonSRX(Config.CAN_ID_LEFT_DRIVE_MOTOR_A);
		m_leftDriveMotorB = new WPI_TalonSRX(Config.CAN_ID_LEFT_DRIVE_MOTOR_B);
		m_rightDriveMotorA = new WPI_TalonSRX(Config.CAN_ID_RIGHT_DRIVE_MOTOR_A);
		m_rightDriveMotorB = new WPI_TalonSRX(Config.CAN_ID_RIGHT_DRIVE_MOTOR_B);
	
		// Initialize the drive speed controller groups
		m_leftDriveMotors = new SpeedControllerGroup(m_leftDriveMotorA, m_leftDriveMotorB);
		m_rightDriveMotors = new SpeedControllerGroup(m_rightDriveMotorA, m_rightDriveMotorB);

		// Defining the drive system.
		drive = new DifferentialDrive(m_leftDriveMotors, m_rightDriveMotors);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ControllerArcadeDrive());
	}
	
	public void arcadeDrive(XboxController controller) {
		double moveValue = controller.getTriggerAxis(GenericHID.Hand.kRight);
		double rotateValue = controller.getX(GenericHID.Hand.kLeft);
		drive.arcadeDrive(moveValue, rotateValue, true);
	}
	
	public void arcadeDrive(double moveValue, double rotateValue){
		drive.arcadeDrive(-moveValue, rotateValue, false);
	}
	
	public void arcadeDrive(double moveValue, double rotateValue, boolean squaredInputs){
		drive.arcadeDrive(moveValue, rotateValue, squaredInputs);
	}
}