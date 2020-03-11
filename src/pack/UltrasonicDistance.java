package pack;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;

//!!!!INSTEAD OF creating movement object, we now EXTEND movement and IMPLEMENT runnable!!!!
public class UltrasonicDistance implements Runnable {

	
	Ultrasonic1 ultrasonic;
	//Initializing StoppingFactor for constructor
	StoppingFactor stopper;
	
	public UltrasonicDistance(StoppingFactor s){
		stopper = s;
	}
	
	public UltrasonicDistance() {
		
	}
	
	public float measure() {
		//declaring 
			Brick b = BrickFinder.getDefault();
			EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S4);
			//enabling the sensor
			us.enable();
				
			ultrasonic = new Ultrasonic1(us.getDistanceMode());
				
			//I've removed the below line because now we extend to Movement (FEEL FREE TO REMOVE THIS IF WORKS)
			//Movement move1 = new Movement();

			Delay.msDelay(2);
			//scans in front of the robot and puts it into float value
				
			float distance = ultrasonic.distance();
			System.out.println(distance);
			return distance;
	}

	public void run() {
		
		//I've removed the below line because now we extend to Movement (FEEL FREE TO REMOVE THIS IF WORKS)
		//Movement move1 = new Movement();

		Delay.msDelay(2);
		//scans in front of the robot and puts it into float value
		
		/*while stop isn't true, ultrasonic will keep scanning and moving
		so currently when colorsensor senses green, it closes its sensor AND this sensor+movement
		Might not need movementstatic anymore!!(?)*/
		while(!stopper.stop) {
		measure();
		Delay.msDelay(500);

		//!!!!UNFINISHED, WONT WORK YET!! FIGURE OUT LOGIC MOVEMENT WISE FOR ULTRASENSOR!!!!
		//The code below needs to be redone completely to match what we want, just left remainders of previous
		
		} // The robot will check both sides when the distance hits these conditions
		}
		
	}