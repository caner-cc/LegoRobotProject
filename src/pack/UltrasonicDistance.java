package pack;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;

public class UltrasonicDistance implements Runnable {

	Ultrasonic1 ultrasonic;

	public void run() {
		
		
		//declaring 
		Brick b = BrickFinder.getDefault();
		EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S4);
		//enabling the sensor
		us.enable();
		ultrasonic = new Ultrasonic1(us.getDistanceMode());
		//using the movement class
		Movement move1 = new Movement();

		
		float leftdistance = 0;
		float rightdistance = 0;

		Delay.msDelay(2);
		//scans in front of the robot and puts it into float value
		
		do {
		float distance = ultrasonic.distance();
		System.out.println(distance);
		Delay.msDelay(500);

		//If the float is above 1, which will never happen. Back up. (this is put in to avoid the program from doing the wrong thing when the sensor detects nothing.)
		if (distance >= 1.0) {
			move1.Reverse();
			move1.Stop();
		//If the distance is below this value then back up. Basically if it's too close to the wall.
		}else if (distance <= 0.070) {
			move1.Reverse();
			move1.Stop();
		} // The robot will check both sides when the distance hits these conditions
		else if (distance >= 0.071 & distance <= 0.13) {
			move1.TurnL();
			move1.Stop();
			//puts the left side value into a float
			leftdistance = ultrasonic.distance();
			move1.TurnLback();
			move1.Stop();
			System.out.println("leftdistance is " + leftdistance);
			move1.TurnR();
			move1.Stop();
			//puts the right side value into a float
			rightdistance = ultrasonic.distance();
			move1.TurnRback();
			move1.Stop();
			System.out.println("the rightdistance is " + rightdistance);
			// IF left distance is bigger than right. Turn left.
			if (leftdistance > rightdistance) {
				move1.Reverse(60);
				move1.Stop();
				Delay.msDelay(500);
				move1.TurnL();
				move1.Stop();
				Delay.msDelay(500);
				System.out.println("I will turn left because right side is blocked");
			} // And if the right side distance is bigger then turn right.
			else if (rightdistance > leftdistance) {
				move1.Reverse(60);
				move1.Stop();
				Delay.msDelay(500);
				move1.TurnR();				
				move1.Stop();
				Delay.msDelay(500);
				System.out.println("I will turn right because left side is blocked");
			} else {
				move1.Reverse(60);
				move1.Stop();
				Delay.msDelay(500);
			}
		}//close sensor so it doesn't interfere with color sensor.
		
		}while (true);
		
	}

}