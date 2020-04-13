import java.util.Comparator;

public class ComparatorByNumCars implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		
		// Use compareTo() to compare strings
		int result = o1.getCar().compareTo(o2.getCar());
		return result;
	}

}
