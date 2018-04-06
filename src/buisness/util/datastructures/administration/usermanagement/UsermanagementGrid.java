package buisness.util.datastructures.administration.usermanagement;

import java.util.ArrayList;
import java.util.List;


/**
 * This class is used for holding or stores  all rows in the grid
 *  
 * @author nilesh.patil
 *create date 12 Jan 2016
 */


public class UsermanagementGrid implements Comparable<UsermanagementGrid> 
{
	private List<UsermangementGridRow> rows;
	
	
	public UsermanagementGrid()
	{
		rows = new ArrayList<>();
		 
	}
 
	/**
	 * 	//TODO: parameter description
	 * this method is used for  adding the rows 
	 * @param locationname
	 * @param City
	 * @param State
	 * @param postalcode
	 * @param Inactive
	 */
	public void addPopupuserGridcountRow1(String firstname,String middlename,String lastname,String practiceid,String practicename,String loginame,String inactive)
	{
	
		rows.add(new UsermangementGridRow(firstname,middlename,lastname,practiceid,practicename,loginame,inactive));
		}

	
	@Override
	public int compareTo(UsermanagementGrid target) throws NullPointerException
	{

		{
             
			if(target == null)
				throw new NullPointerException("Target object is null");
		UsermangementGridRow sourceRow;
		UsermangementGridRow targetRow;
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
