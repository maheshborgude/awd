package buisness.util.datastructures.Submission;
import java.util.ArrayList;
/**
 * This class is used to compare source Grid with Target Grid
 *This class compare row of Data grid of Advanced Status popup grid<p>
 * @author rakesh.kulkarni
 * Updated by Sachin Gawade
 * Date 11/02/2016
 */
@SuppressWarnings("serial")
public class AdvancedStatusPopupGrid extends ArrayList<AdvancedStatusPopupGridRow> implements Comparable<AdvancedStatusPopupGrid>
{
	/**
	 * This method adds data in row of AdvancedStatusPopupGridRow grid
	 * @param name: name of patient
	 * @param mrn: mrn of patient
	 * @param gender: gender of patient
	 * @param dateOfVisit: date of visit of patient
	 * @param dateofBirth: date of birth of patient
	 */
	public void add(String name, String mrn, String gender, String dateOfVisit, String dateofBirth)
	{
		this.add(new AdvancedStatusPopupGridRow(name, mrn, gender, dateOfVisit, dateofBirth));
	}
	@Override
	/**
	 * This method is used to compare two rows<p>
	 * Returns 0 if both rows are same<p>
	 * Returns -1 if both rows are not same
	 */
	public int compareTo(AdvancedStatusPopupGrid target) 
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			AdvancedStatusPopupGridRow sourceRow;
			AdvancedStatusPopupGridRow targetRow;
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


