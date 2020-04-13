import java.util.Comparator;

public class ComparatorByRegion implements Comparator<BankRecords> {
	
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		
		// Compare regions
		int result = o1.getRegion().compareTo(o2.getRegion());
		return result;
	}
} // End ComparatorByRegion
