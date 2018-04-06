package buisness.util.datastructures.dashboard.provider;
import java.util.ArrayList;
import java.util.List;
/**
 *This class compare row of Data grid of Dashboard>>Provider or Dashboard>>Location
 *This class implements Comparable<ProviderLocationGrid> 
 * @author Sachin.Gawade
 * Date 1 March 2016 
 */

public class ProviderLocationGrid implements Comparable<ProviderLocationGrid> 
{
	private List<ProviderLocationGridRow> rows;
	
	/**
	 * ProviderLocationGrid constructor
	 * It Initializes rows to type ArrayList<>()
	 */
	public ProviderLocationGrid()
	{
		rows = new ArrayList<>();	 
	}
 
	/**
	 * This method is used for adding the rows in ProviderLocationGridRow
	 * @param name: Provider or Location name
	 * @param exceeding: Exceeding count
	 * @param below: Below count
	 */
	public void addPopupLocationGridcountRow1(String name,String exceeding,String below)
	{
	
		rows.add(new ProviderLocationGridRow(name, exceeding, below));
		}
	
	@Override
	/**
	 * This method is uset to compare two grids of same data type<p>
	 * @param target Passed UI Grid<p>
	 * @return 0(for match),-1(for mismatch)
	 */
	public int compareTo(ProviderLocationGrid target) throws NullPointerException
	{
		{
             
			if(target == null)
				throw new NullPointerException("Target object is null");
		ProviderLocationGridRow sourceRow;
		ProviderLocationGridRow targetRow;
		for(int i=0;i<this.rows.size();i++)
		{
			sourceRow = this.rows.get(i);
			targetRow = target.rows.get(i);
			if(sourceRow.compareTo(targetRow) != 0)
			{
				return -1;
			}
			
		}	return 0;
	
	}

	}
}
