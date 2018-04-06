package buisness.util.datastructures.dashboard.location;

import configuration.Setup;

/**
/** This Class is used in order to store location, exceeding, below from an row.<p>
 * This class implements Comparable interface.<p>
 * @author nilesh.patil
 * created date 3 FEB 2016
 *
 */

public class LocationGridRow implements Comparable<LocationGridRow> {

	
	private String	location;
	private String 	exceeding ;
	private String 	below;


	 LocationGridRow(String location,String exceeding,String below)
	{
		this.location = location;
		this.exceeding = exceeding; 
		this.below = below;
	}
	
	

	
	public String getLocation() {
		return location;
	}




	public String getExceeding() {
		return exceeding;
	}




	public String getBelow() {
		return below;
	}




	/**
	 * This method is used to compare the one object with target object or specified object <p>
	 * returns 0 if location, exceeding, below matches<p>
	 * returns 1 if location, exceeding, below not matches<p>
	 */
	@Override
	public int compareTo(LocationGridRow exactmatch) {
		
		if(this.location.compareToIgnoreCase(exactmatch.location)==0)
		{
			if(this.exceeding.compareToIgnoreCase(exactmatch.exceeding)==0)
			{
				if(this.below.compareToIgnoreCase(exactmatch.below)==0)
						{
							return 0;	
						}
					else
						{
							 Setup.log.debug("Data in locationname column does not match for "+exactmatch.location+" "+exactmatch.location);
							return 1;
						}
				}
					 else 
						{
							Setup.log.debug("Data in City column does not match for "+exactmatch.exceeding+" "+exactmatch.exceeding);
							return 1;	
						}
				}		
				     else 
				        {
					       Setup.log.debug("Data in State column does not match for "+exactmatch.below+" "+exactmatch.below);
					       return 1;	
				        }
		       }	 
			               
		          //return -1;
	}





