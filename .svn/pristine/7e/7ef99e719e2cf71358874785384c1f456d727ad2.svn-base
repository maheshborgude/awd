package buisness.util.datastructures.administration.location;

import java.util.ArrayList;
import java.util.List;


/**
 * This class is used for holding or stores  all rows in the grid
 *  
 * @author nilesh.patil
 *create date 12 Jan 2016
 */


public class LocationGrid implements Comparable<LocationGrid> 
{
	private List<LocationGridrow> rows;
	
	
	public LocationGrid()
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
	public void addPopupLocationGridcountRow1(String locationname,String City,String State,String postalcode,String Inactive)
	{
	
		rows.add(new LocationGridrow(locationname, City, State, postalcode, Inactive));
		}

	
	@Override
	public int compareTo(LocationGrid target) throws NullPointerException
	{

		{
             
			if(target == null)
				throw new NullPointerException("Target object is null");
		LocationGridrow sourceRow;
		LocationGridrow targetRow;
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
