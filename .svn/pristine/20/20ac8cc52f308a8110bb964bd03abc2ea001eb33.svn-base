package buisness.util.datastructures.administration.groupmanagement;
import java.util.ArrayList;
import java.util.List;
/**
 * This class is used to compare source Grid with Target Grid
 * @author rakesh.kulkarni
 * Date 29/1/2015
 */
public class AuthorizedUsersGroupsGrid implements Comparable<AuthorizedUsersGroupsGrid>
{
	private List<AuthorizedUsersGroupsRow> rows;
	/**
	 * Default constructor to create objects
	 * 	
	 */
	public AuthorizedUsersGroupsGrid()
	{
		rows = new ArrayList<AuthorizedUsersGroupsRow>();
	}
	/**
	 * This method calls parameterized constructor of PracticeRow and store value in rows list 
	 * @param groupName
	 * @param GroupID
	 */
	public void add(String name, String firstName, String lastName, String practiceID, String PracticeName,String group,String inactive)
	{
		rows.add(new AuthorizedUsersGroupsRow(name, firstName, lastName, practiceID, PracticeName, group,inactive));
	}
	@Override
	public int compareTo(AuthorizedUsersGroupsGrid target) 
	{

		if(target == null)
			return -1;
		if(this.rows.size()==target.rows.size() )
		{
			AuthorizedUsersGroupsRow sourceRow;
			AuthorizedUsersGroupsRow targetRow;
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


