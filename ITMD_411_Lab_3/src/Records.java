/**
 * This program performs data analysis on bank-Detail.csv
 * and prints the result to bankrecords.txt.
 * 
 * @author Yulia Thonippara (A20411313)
 * Created for ITMD 411 Spring 2020
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Records extends BankRecords {
	
	//create formatted object to write output directly to console & file
	static FileWriter fw = null;
	
	public Records() {
		try {
			fw = new FileWriter("bankrecords.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void AverageComparator() {
		
		Arrays.sort(robjs, new ComparatorBySex());

		// set up needed variables to gather counts & income by sex 
		// to determine average income by sex
		
		int maleCount = 0, femaleCount = 0;
		double maleIncome = 0, femaleIncome = 0;
		
		for (int i = 0; i < robjs.length; i++)
			if (robjs[i].getSex().equals("FEMALE")) {
				++femaleCount;
				femaleIncome += robjs[i].getIncome();
			}  
			else if (robjs[i].getSex().equals("MALE")) {
				++maleCount;
				maleIncome += robjs[i].getIncome();
			}
			 
		// display resulting averages to console and to file
		System.out.printf("Average income for Females: $%.2f", (femaleIncome/femaleCount));
		System.out.printf("\nAverage income for Males: $%.2f",(maleIncome/maleCount));

		try {
			fw.write("The Results of Data Analysis\n");
			fw.write("\nAverage income for Females: $" + (femaleIncome/femaleCount));
			fw.write("\nAverage income for Males: $" + (maleIncome/maleCount));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // End AverageComparator()
	
	public static void FemalesComparator() {
		
		Arrays.sort(robjs, new ComparatorBySex());

		// set up needed variables to gather counts & income by sex 
		// to determine average income by sex
		
		int totalFemaleCount = 0;
		int femaleCount = 0;
		int mortgage, savingsAcct;
		
		for (int i = 0; i < robjs.length; i++)
			if (robjs[i].getSex().contentEquals("FEMALE")) {
				++totalFemaleCount;
				/**for (int j = 0; j < robjs.length; j++)
					if (robjs[i].getMortgage().equals("YES") && robjs[i].getSave_acct().equals("YES"))
						++femaleCount;**/
		}
		
		// display resulting averages to console and to file
				System.out.printf("\nNumber of Females with mortgage and savings accounts: %d", totalFemaleCount);
		
	} // End FemalesComparator()
	
	/**public static void MalesComparator() {
		
		Arrays.sort(robjs, new SexComparator());

		// set up needed variables to gather counts & income by sex 
		// to determine average income by sex
		
		int totalMaleCount = 0;
		int maleCount = 0;
		int mortgage, savingsAcct;
		
		for (int i = 0; i < robjs.length; i++)
			if (robjs[i].getSex().equals("MALE")) {
				++totalMaleCount;
				for (int j = 0; j < robjs.length; j++)
					if (robjs[i].getMortgage().equals("YES") && robjs[i].getSave_acct().equals("YES"))
						++maleCount;
		} 
		
		// display resulting averages to console and to file
		System.out.printf("\nNumber of Females with Mortgage and Savings account: %d", totalFemaleCount); } **/ // End MalesComparator()

	public static void main(String[] args) {
		
		// Create Records object
		Records br = new Records();
		br.readData();

		// Call functions to perform analytics
		AverageComparator(); // Analyze average income per region
		FemalesComparator(); // Number of female mortgage and savings accounts 
		//MalesComparator(); // Counts of males with a car & 1 child per location

		// *** close out file object ***//

		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // End main()
	
} // End class Records
