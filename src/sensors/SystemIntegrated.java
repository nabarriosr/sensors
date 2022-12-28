package sensors;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import sensors.Monitor;
import sensors.Sensor;


public class SystemIntegrated {
	static Monitor monitor = new Monitor();
	static Sensor sensor1 = new Sensor();
	static Sensor sensor2 = new Sensor();
	static Sensor sensor3 = new Sensor();
	static Sensor sensor4 = new Sensor();

	public static void main(String[] parametro) {		
		try {
			monitor.Main();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Timer timer1 = new Timer();
		Timer timer2 = new Timer();
        timer1.scheduleAtFixedRate(new LaunchSignals(), 0, 500);
        timer2.scheduleAtFixedRate(new monitorTest(), 0, 1001);
        
	}
	
	static class LaunchSignals extends TimerTask {
        public void run() {
        	monitor.createRegisterMeasure(1, sensor1.generateSignal());
        	monitor.createRegisterMeasure(2, sensor2.generateSignal());
        	monitor.createRegisterMeasure(3, sensor3.generateSignal());
        	monitor.createRegisterMeasure(4, sensor4.generateSignal());
        }
	}
	
	static class monitorTest extends TimerTask {
        public void run() {
        	 monitor.check();
        }
	
	}
}