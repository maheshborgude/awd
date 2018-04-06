package buisness.util.datastructures.dashboard.practice;
import java.util.ArrayList;

/**
 * This class is used to compare current row with Target row
 * This class compare row of Data row of Submission Details >> Dashboards >> Practice
 *   >>PQRS Submission Details
 * This class extends ArrayList<SubmissionDetailsGridRow>
 * This class implements Comparable<SubmissionDetailsGrid>
 * @author rakesh.kulkarni
 * Date 21/03/2016
 */
public class PracticeLocationPopUpGrid extends ArrayList<PracticeLocationPopUpGridRow> implements Comparable<PracticeLocationPopUpGrid>
{
	/**
	 * This method calls parameterized constructor of Provider and store value in rows list
	 * @param LocationName : Name of Locatiom
	 * @param Qualified : Name of Qualified
	 * @param Met : Count of Met
	 * @param NotMet :  Count of Not Met
	 * @param Performance : Count of Performance
	 * @param RegistryBenchmark : RegistryBenchmark for Location
	 */
	public void add(String LocationName, String Qualified, String Met, String NotMet,String Performance,String RegistryBenchmark)
	{
		add(new PracticeLocationPopUpGridRow( LocationName,  Qualified,  Met,  NotMet, Performance, RegistryBenchmark));
	}
	@Override
	public int compareTo(PracticeLocationPopUpGrid target)
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			PracticeLocationPopUpGridRow sourceRow;
			PracticeLocationPopUpGridRow targetRow;
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


