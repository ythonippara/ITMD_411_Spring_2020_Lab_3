import java.util.Comparator;

class ComparatorByMortgage implements Comparator<BankRecords> {

	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		
		// Use compareTo() to compare strings
		int result = o1.getMortgage().compareTo(o2.getMortgage());
		return result;
	}

}
