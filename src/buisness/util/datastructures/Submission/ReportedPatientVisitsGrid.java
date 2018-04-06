package buisness.util.datastructures.Submission;
import java.util.ArrayList;
/**
 * This class is used to compare source Grid with Target Grid<p>
 *This class compare row of Reported Patient Visits grid<p>
 * @author Sachin.Gawade
 * Date 15/02/2016
 */
@SuppressWarnings("serial")
public class ReportedPatientVisitsGrid extends ArrayList<ReportedPatientVisitsGridRow> implements Comparable<ReportedPatientVisitsGrid>
{
	/**
	 * This method adds data in row of ReportedPatientVisitsGridRow grid 
	 * @param firstname: first name of patient
	 * @param lastname: last name of patient
	 * @param gender: gender of patient
	 * @param dateofbirth: date of visit of patient
	 * @param mrn: mrn of patient
	 * @param dateofvisit: date of visit of patient
	 * @param reportedmeasures: reported measures for patient visit
	 */
	public void add(String firstname, String lastname, String gender, String dateofbirth, String mrn, String dateofvisit, String reportedmeasures)
	{
		this.add(new ReportedPatientVisitsGridRow(firstname,lastname,gender,dateofbirth,mrn,dateofvisit,reportedmeasures));
	}
	@Override
	public int compareTo(ReportedPatientVisitsGrid target) 
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			ReportedPatientVisitsGridRow sourceRow;
			ReportedPatientVisitsGridRow targetRow;
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


