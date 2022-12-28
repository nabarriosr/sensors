package sensors;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Monitor {
	static ArrayList<Double> register1LastMeasure = new ArrayList<Double>();
	static ArrayList<Double> register1AllMeasure = new ArrayList<Double>();
	static ArrayList<Double> register2LastMeasure = new ArrayList<Double>();
	static ArrayList<Double> register2AllMeasure = new ArrayList<Double>();
	static ArrayList<Double> register3LastMeasure = new ArrayList<Double>();
	static ArrayList<Double> register3AllMeasure = new ArrayList<Double>();
	static ArrayList<Double> register4LastMeasure = new ArrayList<Double>();
	static ArrayList<Double> register4AllMeasure = new ArrayList<Double>();
	static ArrayList<Object> registerChecks = new ArrayList<Object>();
	
	static double parameterS;
	static double parameterM;
	
	
	public void Main() {
		try (Scanner keyboard = new Scanner(System.in)) {
			System.out.println("Please insert Parameter S:");
			parameterS = keyboard.nextDouble();
			System.out.println("Please insert Parameter M:");
			parameterM =  keyboard.nextDouble();
		} catch(Exception e) {
			System.out.println("Problems reading the inputs, try again using coma ',' separator");
		}		
	}
	
	
	
	void createRegisterMeasure(int sensorIndex, double value) {
		switch(sensorIndex) {
		  case 1:
			  register1LastMeasure.add(value);
			  register1AllMeasure.add(value);
		    break;
		  case 2:
			  register2LastMeasure.add(value);
			  register2AllMeasure.add(value);
		    break;
		  case 3:
			  register3LastMeasure.add(value);
			  register3AllMeasure.add(value);
		    break;
		  case 4:
			  register4LastMeasure.add(value);
			  register4AllMeasure.add(value);
		    break;
		}
	}
	
	static void createRegisterCheck(Object check) {
		registerChecks.add(check);
	}
	
	
	static void resetLastMeasure() {
		register1LastMeasure.clear();
		register2LastMeasure.clear();
		register3LastMeasure.clear();
		register4LastMeasure.clear();
	}
	
	static List<Object> checkProblem(double input1, double input2, double input3, double input4) {
		double average = (input1 + input2 + input3 + input4)/4;
		double[] listInputs = {input1, input2, input3, input4};
		double dMax = listInputs[0];
		double dMin = listInputs[0];
		double diff;
		boolean check;
		for (int i = 1; i < 4; i++) {  
			dMax = Double.max(listInputs[i], dMax);
			dMin = Double.min(listInputs[i], dMin);
		}
		diff = dMax - dMin;
		check = parameterM < average && parameterS > diff;
		if(check == false) {
			System.out.println("Anomaly: Average " + average + "and Diff " + diff);
		}
		return Arrays.asList(average, diff, check);
	}
	
	static void showParameters() {
		System.out.println("Parameter S: " + parameterS);
		System.out.println("Parameter M: " + parameterM);
	}
	
	static ArrayList<Double> getAllRegister(int sensorIndex) {
		switch(sensorIndex) {
		  case 1:
			  return register1AllMeasure;
		  case 2:
			  return register2AllMeasure;
		  case 3:
			  return register3AllMeasure;
		  case 4:
			  return register4AllMeasure;
		}
		return register1AllMeasure;
	}
	
	static ArrayList<Double> getLastRegister(int sensorIndex) {
		switch(sensorIndex) {
		  case 1:
			  return register1LastMeasure;
		  case 2:
			  return register2LastMeasure;
		  case 3:
			  return register3LastMeasure;
		  case 4:
			  return register4LastMeasure;
		}
		return register1LastMeasure;
	}
	
	void check() {
		double[] listLength = {getLastRegister(1).size(), getLastRegister(2).size(), getLastRegister(3).size(), getLastRegister(4).size()};
		double dMin = listLength[0];
		for (int i = 1; i < 4; i++) {
			dMin = Double.min(listLength[i], dMin);
		}
		int j = 0;
		while(j < dMin) {
			Object checkObj = checkProblem(getLastRegister(1).get(j),getLastRegister(1).get(j), getLastRegister(1).get(j), getLastRegister(1).get(j));
			createRegisterCheck(checkObj);
			j++;
		}
		resetLastMeasure();		
	}
}


