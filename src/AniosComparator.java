import java.util.Comparator;

public class AniosComparator implements Comparator <Serie>{

	@Override
	public int compare(Serie a1, Serie a2) {
		
		
		
		return a1.getAnioEmision()-a2.getAnioEmision();
	}
	
	
	

}
