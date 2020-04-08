import java.util.Comparator;

public class LocationComparator implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords arg0, BankRecords arg1) {
		
		// Compare regions
		int result = arg0.getRegion().compareTo(arg1.getRegion());
		return result;
	}

} // End LocationComparator
