package buisness.util.datastructures.pqrsSubmission;
import java.util.ArrayList;
/**
 * This class is used to compare source Grid with Target Grid
 *This class compare row of Data grid of PQRS Submission >> Submission 2015 >> ManageProviderProfile Milestone 
 *  >>Tax Identification Number 
 *  This class implement  List<TaxIdentificationNumberRow>
 *  This class Extends 
 * @author rakesh.kulkarni
 * Date 10/02/2016
 */
public class TaxIdentificationNumberGrid extends ArrayList<TaxIdentificationNumberGridRow> implements Comparable<TaxIdentificationNumberGrid>
{
	/**
	 * This method calls parameterized constructor of Provider and store value in rows list 
	 * @param npi
	 * @param startDate
	 * @param endDate
	 */
	public void add(String npi, String startDate, String endDate)
	{
		add(new TaxIdentificationNumberGridRow( npi, startDate, endDate));
	}
	@Override
	public int compareTo(TaxIdentificationNumberGrid target) 
	{

		if(target == null)
			return -1;
		if(this.size()==target.size() )
		{
			TaxIdentificationNumberGridRow sourceRow;
			TaxIdentificationNumberGridRow targetRow;
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


