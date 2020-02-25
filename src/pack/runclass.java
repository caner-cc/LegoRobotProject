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
			Movement move = new Movement();	
			
			System.out.println("Press a key to start");
			keys.waitForAnyPress();
				
			
			//THREADING CODE ULTRASONICSENSOR
			Thread ultrasens = new Thread(new UltrasonicDistance());
			ultrasens.start();			
			
			//THREADING CODE COLOR
			Thread colorthread = new Thread(new Color());
			colorthread.start();
	    
			//THREADING CODE MOVEMENT			
			Thread motors = new Thread(new MovementStatic());
			motors.start();		
			
		
			}
	}


