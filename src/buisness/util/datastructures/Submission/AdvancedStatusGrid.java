package buisness.util.datastructures.Submission;
import java.util.ArrayList;
/**
 * This class is used to compare source Grid with Target Grid<p>
 * This class compare data in form of grid i.e database grid with UI grid <p> 
 * This class compare row of Data grid of Advanced Status grid<p>
 * This class extends ArrayList and implements Comparable interface <p>
 * @author rakesh.kulkarni
 * Updated by Sachin Gawade
 * Date 10/02/2016
 */

public class AdvancedStatusGrid extends ArrayList<AdvancedStatusGridRow> implements Comparable<AdvancedStatusGrid>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This method adds data in row of AdvancedStatusGridRow grid
	 * @param measure: measure number
	 * @param eligible: eligible count of measure
	 * @param met: met count of measure
	 * @param notMet: not met count of measure
	 * @param notApplicable: not applicable count of measure
	 * @param exclusion: exclusion count of measure
	 */
	public void add(String measure, String eligible, String met, String notMet, String notApplicable, String exclusion)
	{
		this.add(new AdvancedStatusGridRow( measure,  eligible,  met,  notMet,  notApplicable,  exclusion));
	}
	@Override
	/**
	 * This method is used to compare two rows<p>
	 * Returns 0 if both rows are same<p>
	 * Returns -1 if both rows are not same
	 */
	public int compareTo(AdvancedStatusGrid target) 
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			AdvancedStatusGridRow sourceRow;
			AdvancedStatusGridRow targetRow;
			for(int i=0;i<this.size();i++)
			{
				sourceRow = get(i);
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


