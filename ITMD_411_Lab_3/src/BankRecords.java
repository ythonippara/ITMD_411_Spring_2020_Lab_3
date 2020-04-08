/**
 * This program performs data analysis on bank-Detail.csv
 * and prints the result to bankrecords.txt.
 * 
 * @author Yulia Thonippara (A20411313)
 * Created for ITMD 411 Spring 2020
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankRecords extends Client {
	// Set up static objects for IO processing

	// Array of BankRecords objects
	//static BankRecords robjs[] = new BankRecords[600];
	
	// Code optimization
	// Use readData() to determine # of records, then use size()
	static BankRecords robjs[];
	
	// ArrayList to hold spreadsheet rows & columns
	static ArrayList<List<String>> array = new ArrayList<>();
	
	// Instance fields
	private String id;
	private int age;
	private String sex;
	private String region;
	private double income;
	private String married;
	private int children;
	private String car;
	private String save_acct;
	private String current_acct;
	private String mortgage;
	private String pep;
	
	@Override
	public void readData() {
		
	BufferedReader br = null;
		
		// Initialize reader object and set file path to root of project
		try {
			br = new BufferedReader(new FileReader(new File("bank-Detail.csv")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line;
		
		// Read each record in .csv file
		try {
			while ((line = br.readLine()) != null) {
				// Parse each record in .csv file by a comma (,)
				// into a list stored in the ArrayList -> Arrays
				array.add(Arrays.asList(line.split(",")));
				// System.out.println(line); // test readData()
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		processData();  // Call function for processing record data
	} // End readData()
	
	@Override
	public void processData() {
		
		robjs = new BankRecords[array.size()]; 
		
		// Create index for array while iterating through ArrayList
		int idx=0;
		
		// Create for each loop to cycle through ArrayList of values 
		// and PASS that data into your record objects' setters 
		for (List<String> rowData: array) {
			// Initialize array of objects
			robjs[idx] = new BankRecords();
			// Call setters below and populate them item by item
			robjs[idx].setId(rowData.get(0).substring(2)); // Get 1st column, remove "id" characters
			robjs[idx].setAge(Integer.parseInt(rowData.get(1))); // Get 2nd column
			robjs[idx].setSex(rowData.get(2)); // Get 3rd column
			robjs[idx].setRegion(rowData.get(3)); // Get 4th column
			robjs[idx].setIncome(Double.parseDouble(rowData.get(4))); // Get 5th column
			robjs[idx].setMortgage(rowData.get(10)); // Get 11th column
			idx++;
		}
		
		// printData();  // Call function to print objects held in memory
	} // End processData()
	
	@Override
	public void printData() {
		
		// 1. Set appropriate headings for displaying first 25 records
		System.out.println("ID\t\tAGE\t\tSEX\t\tREGION\t\t\tINCOME\t\t\tMORTGAGE");
		
		// 2. Create for loop and print each record objects instance data
		for (int i=0; i < 25 ; i++){
			// 3. Within for loop use appropriate formatting techniques to print
			//   out record detail  
			String s = String.format("%s\t\t%d\t\t%s\t\t%-8s\t\t$%-8.2f\t\t%s", robjs[i].getId(), robjs[i].getAge(), 
					robjs[i].getSex(), robjs[i].getRegion(), robjs[i].getIncome(), robjs[i].getMortgage());
			System.out.println(s);
		}
	} // End printData()

	// Getters & setters for instance fields
	public static BankRecords[] getRobjs() {
		return robjs;
	}

	public static void setRobjs(BankRecords[] robjs) {
		BankRecords.robjs = robjs;
	}

	public static ArrayList<List<String>> getArray() {
		return array;
	}

	public static void setArray(ArrayList<List<String>> array) {
		BankRecords.array = array;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getSave_acct() {
		return save_acct;
	}

	public void setSave_acct(String save_acct) {
		this.save_acct = save_acct;
	}

	public String getCurrent_acct() {
		return current_acct;
	}

	public void setCurrent_acct(String current_acct) {
		this.current_acct = current_acct;
	}

	public String getMortgage() {
		return mortgage;
	}

	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	public String getPep() {
		return pep;
	}

	public void setPep(String pep) {
		this.pep = pep;
	}
} // End class BankRecords