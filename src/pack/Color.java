package pack;

import lejos.hardware.Audio;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

public class Color implements Runnable {
	
	//Initializing movement & stoppingfactor for constructor
	Movement move;
	StoppingFactor stopper;
	
	public Color(Movement m, StoppingFactor s) {
		move = m;
		stopper = s;
	}
	
	public void run(){
		
		int colorId = -1;		
		EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S1);
		SensorMode color = colorSensor.getColorIDMode();
			
		
		do
		{
			colorSensor.getColorID();
			colorId = colorSensor.getColorID();	
			
			if (colorId == 7) {
			System.out.println("black");
			Sound.beepSequenceUp();
		
			}else if (colorId == 0) {
			System.out.println("red");		
			Sound.beepSequenceUp();
			
			}else if (colorId == -1) {
			System.out.println("none");}
			
		}while (colorId != 1);
		//end if green
		System.out.println("Green has been reached, ending colorsensing");
		colorSensor.close();
		//When green has been reacher, StoppingFactor's value stop becomes true and should end ultrasonic
		stopper.stop = true;
	}

}
