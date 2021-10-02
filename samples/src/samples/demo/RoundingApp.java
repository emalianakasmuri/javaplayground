package samples.demo;

import java.text.DecimalFormat;

public class RoundingApp {
	
	/**
	 * This program calculate progress percentage
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Dummy data declaration
		int marks = 73;
		int total = 150;
		
		// Calculate percentage
		double progressRate = (double)marks/total;
		double progressPencentage =  progressRate * 100.00;
		
		// Print result
		DecimalFormat df = new DecimalFormat("###");		
		int percentage = Integer.parseInt(df.format(progressPencentage));
		System.out.println(percentage);
		
	}

}
