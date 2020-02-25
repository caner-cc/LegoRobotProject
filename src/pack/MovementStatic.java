package pack;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class MovementStatic implements Runnable {	
	public void run() {	
			
			Motor.B.setSpeed(150);
			Motor.C.setSpeed(150);
			Motor.B.forward();
			Motor.C.forward();
	
		
	}

}
