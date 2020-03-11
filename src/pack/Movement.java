package pack;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class Movement extends UltrasonicDistance implements Runnable {
	
	StoppingFactor stop;
	UltrasonicDistance us;
	
	
	public Movement(StoppingFactor s) {
		stop = s;
	}
	
	public Movement() {
		
	}
	
	//Stop method 
	public void Stop() {		
		Motor.B.setSpeed(0);
		Motor.C.setSpeed(0);
		Motor.B.stop();
		Motor.C.stop();
	}
	
	//Forward method. You can determine the speed of the robot with the parameter.
		
	//Overloading the forward method if we need delay on it
	public void Forward(int speed) {
		Motor.B.setSpeed(speed);
		Motor.C.setSpeed(speed);
		Motor.B.forward();
		Motor.C.forward();
		
	}
	//Turning method. Turns 90 degrees to the right. 
	public void TurnL() {
		Motor.B.setSpeed(165);
		Motor.C.setSpeed(0);
		Motor.C.stop();
		Motor.B.forward();
		Delay.msDelay(1650);
		Motor.B.stop();
	}
	
	public void TurnL(int speed) {
		Motor.B.setSpeed(speed);
		Motor.C.setSpeed(0);
		Motor.C.stop();
		Motor.B.forward();
		
	}
	
	//Turning method. Turns 90 degrees to the left, but backwards
	public void TurnLback() {
		Motor.B.setSpeed(165);
		Motor.C.setSpeed(0);
		Motor.C.stop();
		Motor.B.backward();
		Delay.msDelay(1650);
		Motor.B.stop();
	}
	
	//Turning method. Turns 90 degrees to the left. 
	public void TurnR() {
		Motor.B.setSpeed(0);
		Motor.C.setSpeed(165);
		Motor.B.stop();
		Motor.C.forward();
		Delay.msDelay(1650);
		Motor.C.stop();
	}
	
	public void TurnR(int speed) {
		Motor.B.setSpeed(0);
		Motor.C.setSpeed(speed);
		Motor.B.stop();
		Motor.C.forward();
		Delay.msDelay(1650);
		Motor.C.stop();
	}
	//Turning method. Turns 90 degrees to the right, but backwards
	public void TurnRback() {
		Motor.B.setSpeed(0);
		Motor.C.setSpeed(165);
		Motor.B.stop();
		Motor.C.backward();
		Delay.msDelay(1650);
		Motor.C.stop();
	}
	//Drives backwards
	public void Reverse() {
		Motor.B.setSpeed(90);
		Motor.C.setSpeed(90);
		Motor.B.backward();
		Motor.C.backward();
		Delay.msDelay(1600);
		Motor.B.setSpeed(0);
		Motor.C.setSpeed(0);
		Motor.B.stop();
		Motor.C.stop();
	}
	
	public void Reverse(int speed) {
		Motor.B.setSpeed(speed);
		Motor.C.setSpeed(speed);
		Motor.B.backward();
		Motor.C.backward();
		Delay.msDelay(1600);
		Motor.B.setSpeed(0);
		Motor.C.setSpeed(0);
		Motor.B.stop();
		Motor.C.stop();
	}
	
	public void run() {
		
		while(!stopper.stop) {			
		//If the float is above 1, which will never happen. Back up. (this is put in to avoid the program from doing the wrong thing when the sensor detects nothing.)
			Forward(200);
			if (us.measure() >= 1.0) {
			Stop();
			Reverse();
			TurnL();
		//If the distance is below this value then back up. Basically if it's too close to the wall.
		}else if (us.measure() <= 0.070) {
			Reverse();
			Stop();
		}else if (us.measure() >= 0.071 & us.measure() <= 0.13) {
				TurnL();
	}
	}

}
}
