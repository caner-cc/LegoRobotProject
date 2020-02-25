package pack;



import lejos.hardware.sensor.SensorMode;
import lejos.robotics.SampleProvider;
import lejos.robotics.filter.AbstractFilter;


public class Ultrasonic1 extends AbstractFilter {
	
		float[] sample;
		
		public Ultrasonic1(SampleProvider source) {
			super(source);
			sample = new float[sampleSize];
		}
		
		

		public void Ultrasonic(SampleProvider sampleProvider) {
			
		}



		public float distance() {
			super.fetchSample(sample, 0);
		return sample[0];
			
		}
}
