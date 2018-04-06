package configuration;
import java.util.Comparator;
import java.util.List;


//Class that extends Comparator
public class ColumnComparator implements Comparator{
	int columnToSort;
	
	public ColumnComparator(int columnToSort) 
	{
		this.columnToSort = columnToSort;
	}
	
	public ColumnComparator() 
	{
		
	}
	
	//overriding compare method
	public int compare(Object o1, Object o2) {
		String[] row1 = (String[]) o1;
		String[] row2 = (String[]) o2;
		//compare the columns to sort
		return row1[columnToSort].compareTo(row2[columnToSort]);
	}
	//overidinng method for list<String>
	 public int compare(List<String> o1, List<String> o2)
	 {
	        String firstString_o1 = o1.get(0);
	        String firstString_o2 = o2.get(0);
	        return firstString_o1.compareTo(firstString_o2); 
    }
}	