package pack;

import lejos.hardware.Audio;
import lejos.hardware.BrickFinder;
import lejos.hardware.Keys;
import lejos.hardware.Sound;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;


public class runclass {

	public static void main(String[] args) {
		
			//Color reference sheet
			//RED = 0
			//GREEN = 1
			//BLUE = 2
			//YELLOW = 3
			//MAGENTA = 4
			//ORANGE = 5
			//WHITE = 6
			//BLACK = 7
			
			//Start of code.
			//Declaring objects
			EV3 ev3 = (EV3) BrickFinder.getLocal();
			TextLCD lcd = ev3.getTextLCD();
			Keys keys = ev3.getKeys();
			Audio audio = ev3.getAudio();
			
			//Creating required objects for constructors
			Movement move = new Movement();
			StoppingFactor stopper = new StoppingFactor();
			
			//Creating objects of sensors with the earlier created objects
			UltrasonicDistance ultrasonic = new UltrasonicDistance(move, stopper);
			Color color = new Color(move, stopper);
			
			System.out.println("Press a key to start");
			keys.waitForAnyPress();
				
			
			//THREADING CODE ULTRASONICSENSOR
			Thread ultrasens = new Thread(ultrasonic);			
			//THREADING CODE COLOR
			Thread colorthread = new Thread(color);
			//THREADING CODE MOVEMENT			
			Thread motors = new Thread(new MovementStatic());
			motors.start();
			ultrasens.start();
			colorthread.start();
			}
	}


