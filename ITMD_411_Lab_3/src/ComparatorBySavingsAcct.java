import java.util.Comparator;

public class ComparatorBySavingsAcct implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		
		// Use compareTo() to compare strings
		int result = o1.getSavingsAcct().compareTo(o2.getSavingsAcct());
		return result;
	}
	
	

}
