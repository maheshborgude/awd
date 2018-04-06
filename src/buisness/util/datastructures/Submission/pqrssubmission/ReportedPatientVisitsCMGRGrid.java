package buisness.util.datastructures.Submission.pqrssubmission;
import java.util.ArrayList;
import java.util.List;
/**
 * This class is used to compare source Grid with Target Grid
 *This class compare row of Data grid of PQRS Submission >> Submission 2015 >> Report PQRS Measures Milestone
 *    >>Reported Patient Visits 
 *This class extends ArrayList<ReportedPatientVisitsRow>
 *This class implements implements Comparable<ReportedPatientVisitsGrid>
 * @author rakesh.kulkarni
 * Date 08/02/2016
 */
public class ReportedPatientVisitsCMGRGrid extends ArrayList<ReportedPatientVisitsCMGRGridRow> implements Comparable<ReportedPatientVisitsCMGRGrid>
{
	/**
	 * This method calls parameterized constructor of ReportedPatientVisitsGrid and store value in rows list 
	 * @param firstName
	 * @param lastName
	 * @param grnder
	 * @param dateOfBirth
	 * @param mrn
	 * @param medicare
	 * @param dateOfSurgery
	 * @param operativeEye
	 */
	public void add(String firstName, String lastName, String grnder, String dateOfBirth, String mrn, String medicare, String dateOfSurgery, String operativeEye)
	{
		this.add(new ReportedPatientVisitsCMGRGridRow(firstName,lastName, grnder, dateOfBirth, mrn, medicare, dateOfSurgery, operativeEye));
	}
	@Override
	public int compareTo(ReportedPatientVisitsCMGRGrid target) 
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			ReportedPatientVisitsCMGRGridRow sourceRow;
			ReportedPatientVisitsCMGRGridRow targetRow;
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


