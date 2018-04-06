package buisness.util.datastructures.dashboard.location;

import java.util.ArrayList;
import java.util.List;


/**
 * This class is used for holding or stores  all rows in the grid
 *  
 * @author nilesh.patil
 *create date 3 FEB 2016
 */


public class LocationGrid implements Comparable<LocationGrid> 
{
	private List<LocationGridRow> rows;
	
	
	public LocationGrid()
	{
		rows = new ArrayList<>();
		 
	}
 
	/**
	 * 	//TODO: parameter description
	 * this method is used for  adding the rows 
	 * @param location
	 * @param exceeding
	 * @param below
	 */
	public void addPopupLocationGridcountRow1(String location,String exceeding,String below)
	{
	
		rows.add(new LocationGridRow(location, exceeding, below));
		}

	
	@Override
	public int compareTo(LocationGrid target) throws NullPointerException
	{

		{
             
			if(target == null)
				throw new NullPointerException("Target object is null");
		LocationGridRow sourceRow;
		LocationGridRow targetRow;
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
