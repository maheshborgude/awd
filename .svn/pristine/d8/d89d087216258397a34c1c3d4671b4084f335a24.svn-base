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
 * Date 09/3/2016
 */
public class ProviderSubmissionGrid extends ArrayList<ProviderSubmissionGridRow> implements Comparable<ProviderSubmissionGrid>
{
	/**
	 * This method calls parameterized constructor of Provider and store value in rows list 
	 * @param ProviderName
	 * @param ReportingOption
	 * @param DRCFStatus
	 * @param SubmissionStatus
	 */
	public void add(String ProviderName, String ReportingOption, String DRCFStatus, String SubmissionStatus)
	{
		add(new ProviderSubmissionGridRow( ProviderName, ReportingOption, DRCFStatus, SubmissionStatus));
	}
	@Override
	public int compareTo(ProviderSubmissionGrid target) 
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			ProviderSubmissionGridRow sourceRow;
			ProviderSubmissionGridRow targetRow;
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


