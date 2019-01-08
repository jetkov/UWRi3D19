package ca.uwri3d.robot;

/**
 * This configuration is a for all constants that should be easily configurable.
 */

public class Config {

	// CAN IDs
	public final static int CAN_ID_PCM = 1;
	public final static int CAN_ID_RIGHT_DRIVE_MOTOR_A = 13;
	public final static int CAN_ID_RIGHT_DRIVE_MOTOR_B = 14;
	public final static int CAN_ID_LEFT_DRIVE_MOTOR_A = 15;
	public final static int CAN_ID_LEFT_DRIVE_MOTOR_B = 16;
	public final static int CAN_ID_BIG_SWING_MOTOR_A = 12;
	public final static int CAN_ID_BIG_SWING_MOTOR_B = 17;
	public final static int CAN_ID_BIGGER_SWING_MOTOR = 11;
	public final static int CAN_ID_BIG_BALLER_MOTOR = 18;

	// Solenoid IDs
	public final static int SOLENOID_ID_LITTLE_FISTS_A = 0;
	public final static int SOLENOID_ID_LITTLE_FISTS_B = 1;

	// USB ports
	public final static int CONTROLLER_PORT = 0; 
	
	// Drive sensitivity percentage modifiers (eg. controller rotate value multiplied by 70%)
	public final static double THROTTLE_PERCENTAGE = 100, ROTATE_PERCENTAGE = 100;	
				
}
