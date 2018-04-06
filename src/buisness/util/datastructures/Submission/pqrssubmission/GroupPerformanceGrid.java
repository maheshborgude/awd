package buisness.util.datastructures.Submission.pqrssubmission;
import java.util.ArrayList;
/**
 * This class is used to compare source Grid with Target Grid
 *This class compare row of Data grid of PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone 
 *  >>Tax Identification Number 
 *  This class implement  List<TaxIdentificationNumberRow>
 *  This class Extends 
 * @author rakesh.kulkarni
 * Date 04/03/2016
 */
public class GroupPerformanceGrid extends ArrayList<GroupPerformanceGridRow> implements Comparable<GroupPerformanceGrid>
{
	/**	
	 * This method calls parameterized constructor of Provider and store value in rows list 
	 * @param GroupDenominator
	 * @param GroupNumerator
	 * @param GroupMedicare
	 */
	public void add(String GroupDenominator, String GroupNumerator, String GroupMedicare)
	{
		add(new GroupPerformanceGridRow( GroupDenominator, GroupNumerator, GroupMedicare));
	}
	@Override
	public int compareTo(GroupPerformanceGrid target) 
	{
		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			GroupPerformanceGridRow sourceRow;
			GroupPerformanceGridRow targetRow;
			for(int i=0;i<this.size();i++)
			{
				sourceRow = this.get(i);
				targetRow = target.get(i);			
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


