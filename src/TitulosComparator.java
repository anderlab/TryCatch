import java.util.Comparator;

public class TitulosComparator implements Comparator <Serie>{

	
	
	
	
	@Override
	public int compare(Serie t1, Serie t2) {
		
		return t1.getTitulo().compareToIgnoreCase(t2.getTitulo());
	}
	
	

}
