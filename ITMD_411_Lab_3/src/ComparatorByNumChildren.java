import java.util.Comparator;

public class ComparatorByNumChildren implements Comparator<BankRecords>{
	
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		return o1.getChildren()-o2.getChildren();
	}
}
