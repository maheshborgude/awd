package buisness.util.datastructures.Submission.pqrssubmission;
import java.util.ArrayList;
/**
 * This class is used to compare source Grid with Target Grid
 *This class compare row of Data grid of PQRS Submission >> Submission 2015 >> Report PQRS Measures Milestone 
 *           >>PQRS Advanced Status popup<p>
 *This class compare popup that are open after click on  ELIGIBLE, MET, NOT MET, NOT APPLICABLE,EXCLUSION count of 
 *          PQRS Submission >> Submission 2015 >> Report PQRS Measures Milestone >>PQRS Advanced Status popup<p>
 * same grid is open once click on ELIGIBLE, MET, NOT MET, NOT APPLICABLE,EXCLUSION count
 * This class extends ArrayList<PqrsAdvancedStatusPopupRow>
 * This class implements Comparable<PqrsAdvancedStatusPopupGrid>
 * @author rakesh.kulkarni
 * Date 11/02/2016
 */
public class PqrsAdvancedStatusPopupGrid extends ArrayList<PqrsAdvancedStatusPopupGridRow> implements Comparable<PqrsAdvancedStatusPopupGrid>
{
	/**
	 * This method calls parameterized constructor of PqrsAdvancedStatusPopupRow and store value in rows list 
	 * @param name
	 * @param mrn
	 * @param gender
	 * @param dateOfSurgery
	 * @param dateofBirth
	 */
	public void add(String name, String mrn, String gender, String dateOfSurgery, String dateofBirth)
	{
		this.add(new PqrsAdvancedStatusPopupGridRow(name, mrn, gender, dateOfSurgery, dateofBirth));
	}
	@Override
	public int compareTo(PqrsAdvancedStatusPopupGrid target) 
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			PqrsAdvancedStatusPopupGridRow sourceRow;
			PqrsAdvancedStatusPopupGridRow targetRow;
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


