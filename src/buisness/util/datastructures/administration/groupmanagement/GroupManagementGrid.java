package buisness.util.datastructures.administration.groupmanagement;
import java.util.ArrayList;
import java.util.List;
/**
 * This class is used to compare source Grid with Target Grid
 * @author rakesh.kulkarni
 * Date 29/1/2015
 */
public class GroupManagementGrid implements Comparable<GroupManagementGrid>
{
	private List<GroupManagementRow> rows;
	/**
	 * Default constructor to create objects
	 * 	
	 */
	public GroupManagementGrid()
	{
		rows = new ArrayList<GroupManagementRow>();
	}
	/**
	 * This method calls parameterized constructor of PracticeRow and store value in rows list 
	 * @param groupName
	 * @param GroupID
	 */
	public void add(String groupName, String GroupID)
	{
		rows.add(new GroupManagementRow(groupName, GroupID));
	}
	@Override
	public int compareTo(GroupManagementGrid target) 
	{

		if(target == null)
			return -1;
		if(this.rows.size()==target.rows.size() )
		{
			GroupManagementRow sourceRow;
			GroupManagementRow targetRow;
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


