package buisness.util.datastructures.Submission.pqrssubmission;
import java.util.ArrayList;
import java.util.List;
/**
 * This class is used to compare source Grid with Target Grid
 *This class compare row of Data grid of PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone
 *    >>Select Provider tab
 * This class extends ArrayList<SelectProviderRow>
 * This class implements Comparable<SelectProviderGrid>
 * @author rakesh.kulkarni
 * Date 05/02/2016
 */
public class SelectProviderGrid extends ArrayList<SelectProviderGridRow> implements Comparable<SelectProviderGrid>
{
	/**
	 * This method calls parameterized constructor of Provider and store value in rows list 
	 * @param name
	 * @param emil
	 * @param npi
	 * @param reportingType
	 */
	public void add(String name, String emil, String npi, String reportingType)
	{
		add(new SelectProviderGridRow( name, emil, npi, reportingType));
	}
	@Override
	public int compareTo(SelectProviderGrid target) 
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			SelectProviderGridRow sourceRow;
			SelectProviderGridRow targetRow;
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


