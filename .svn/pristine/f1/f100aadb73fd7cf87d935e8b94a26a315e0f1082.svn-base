package buisness.util.datastructures.rpc.resetpracticekey;
import java.util.ArrayList;
/**
 * This class is used to compare source Grid with Target Grid
 *This class compare row of Data grid of Advanced Status popup grid<p>
 * @author rakesh.kulkarni
 * Updated by Sachin Gawade
 * Date 11/02/2016
 */
@SuppressWarnings("serial")
public class ResetPracticeKeyGrid extends ArrayList<ResetPracticeKeyGridRow> implements Comparable<ResetPracticeKeyGrid>
{
	/**	//PracticeID	PracticeName	RegistrationKeyInUse	LastAccessTime ResetPracticeKeyGridRow
	 * This method adds data in row of AdvancedStatusPopupGridRow grid
	 * @param practiceID: practiceID of practice
	 * @param practiceName: practiceName of practice
	 * @param registrationKeyInUse: registrationKeyInUse of practice
	 * @param lastAccessTime: lastAccessTime of practice
	 */
	public void add(String practiceID, String practiceName, String registrationKeyInUse, String lastAccessTime)
	{
		this.add(new ResetPracticeKeyGridRow( practiceID, practiceName, registrationKeyInUse, lastAccessTime));
	}
	@Override
	/**
	 * This method is used to compare two rows<p>
	 * Returns 0 if both rows are same<p>
	 * Returns -1 if both rows are not same
	 */
	public int compareTo(ResetPracticeKeyGrid target) 
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			ResetPracticeKeyGridRow sourceRow;
			ResetPracticeKeyGridRow targetRow;
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


