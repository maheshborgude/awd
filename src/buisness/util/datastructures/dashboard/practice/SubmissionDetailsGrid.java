package buisness.util.datastructures.dashboard.practice;
import java.util.ArrayList;

/**
 * This class is used to compare current row with Target row
 * This class compare row of Data row of Submission Details >> Dashboards >> Practice
 *   >>PQRS Submission Details
 * This class extends ArrayList<SubmissionDetailsGridRow>
 * This class implements Comparable<SubmissionDetailsGrid>
 * @author rakesh.kulkarni
 * Date 16/03/2016
 */
public class SubmissionDetailsGrid extends ArrayList<SubmissionDetailsGridRow> implements Comparable<SubmissionDetailsGrid>
{

	/**
	 * This method calls parameterized constructor of Provider and store value in rows list
	 * @param ProviderName
	 * @param Npi
	 * @param Tin
	 * @param DrcfStatus
	 */
	public void add(String ProviderName, String Npi, String Tin, String DrcfStatus)
	{
		add(new SubmissionDetailsGridRow(ProviderName,  Npi,  Tin,  DrcfStatus));
	}
	@Override
	public int compareTo(SubmissionDetailsGrid target)
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			SubmissionDetailsGridRow sourceRow;
			SubmissionDetailsGridRow targetRow;
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


