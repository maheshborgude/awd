package buisness.util.datastructures.administration.practice;
import java.util.ArrayList;
import java.util.List;
/**
 * This class is used to compare source Grid with Target Grid
 * @author rakesh.kulkarni
 * Date 13/1/2015
 */
public class PracticeGrid implements Comparable<PracticeGrid>
{
	private List<PracticeRow> rows;
	/**
	 * Default constructor to create objects
	 * 	
	 */
	public PracticeGrid()
	{
		rows = new ArrayList<PracticeRow>();
	}
	/**
	 * This method calls parameterized constructor of PracticeRow and store value in rows list 
	 * 
	 */
	public void add(String practiceID, String practiceName, String npi, String inactive)
	{
		rows.add(new PracticeRow(practiceID, practiceName, npi, inactive));
	}
	@Override
	public int compareTo(PracticeGrid target) 
	{

		if(target == null)
			return -1;
		if(this.rows.size()==target.rows.size() )
		{
			PracticeRow sourceRow;
			PracticeRow targetRow;
			for(int i=0;i<this.rows.size();i++)
			{
				sourceRow = this.rows.get(i);
				targetRow = target.rows.get(i);			
				if(sourceRow.compareTo(targetRow) != 0)
				{
					return -1;
				}
			}	
			return 0;	
		}
		return -1;
	}
}


