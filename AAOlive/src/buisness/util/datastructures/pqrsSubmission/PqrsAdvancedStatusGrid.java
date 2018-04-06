package buisness.util.datastructures.pqrsSubmission;
import java.util.ArrayList;
/**
 * This class is used to compare source Grid with Target Grid
 * This class compare data in form of grid i.e database grid with UI grid  
 * This class compare row of Data grid of PQRS Submission >> Submission 2015 >> 
 *   Report PQRS Measures Milestone >>PQRS Advanced Status
 * This class extends ArrayList and implements Comparable interface 
 * @author rakesh.kulkarni
 * Date 10/02/2016
 */
public class PqrsAdvancedStatusGrid extends ArrayList<PqrsAdvancedStatusGridRow> implements Comparable<PqrsAdvancedStatusGrid>
{
	/**
	 * This method calls parameterized constructor of PqrsAdvancedStatusRow and store value in rows list 
	 * @param measure
	 * @param eligible
	 * @param met
	 * @param notMet
	 * @param notApplicable
	 * @param exclusion
	 */
	public void add(String measure, String eligible, String met, String notMet, String notApplicable, String exclusion)
	{
		this.add(new PqrsAdvancedStatusGridRow( measure,  eligible,  met,  notMet,  notApplicable,  exclusion));
	}
	@Override
	public int compareTo(PqrsAdvancedStatusGrid target) 
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			PqrsAdvancedStatusGridRow sourceRow;
			PqrsAdvancedStatusGridRow targetRow;
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


