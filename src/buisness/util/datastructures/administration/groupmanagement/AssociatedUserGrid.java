package buisness.util.datastructures.administration.groupmanagement;
import java.util.ArrayList;
import java.util.List;
/**
 * This class is used to compare source Grid with Target Grid
 * @author rakesh.kulkarni
 * Date 29/1/2015
 */
public class AssociatedUserGrid implements Comparable<AssociatedUserGrid>
{
	private List<AssociatedUsersRow> rows;
	/**
	 * Default constructor to create objects
	 * 	
	 */
	public AssociatedUserGrid()
	{
		rows = new ArrayList<AssociatedUsersRow>();
	}
	/**
	 * This method calls parameterized constructor of PracticeRow and store value in rows list 
	 * @param groupName
	 * @param GroupID
	 */
	public void add(String name, String firstName, String lastName, String practiceID, String PracticeName, String inactive)
	{
		rows.add(new AssociatedUsersRow(name, firstName, lastName, practiceID, PracticeName, inactive));
	}
	@Override
	public int compareTo(AssociatedUserGrid target) 
	{

		if(target == null)
			return -1;
		if(this.rows.size()==target.rows.size() )
		{
			AssociatedUsersRow sourceRow;
			AssociatedUsersRow targetRow;
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


